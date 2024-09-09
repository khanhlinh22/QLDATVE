/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.repositories.impl;

import com.dv.pojo.ChuyenXe;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.dv.repositoties.ChuyenXeRepository;
import java.util.ArrayList;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

/**
 *
 * @author ADMIN
 */
@Repository
@Transactional
@PropertySource("classpath:configs.properties")

public class ChuyenXeRepositoryImpl implements ChuyenXeRepository{
    
    
    @Autowired
    private Environment env;

    @Autowired
    private LocalSessionFactoryBean factory;
        
    @Override
    public List<ChuyenXe> getChuyenXes(Map<String, String> params) {
          Session s = this.factory.getObject().openSession();
            CriteriaBuilder b = s.getCriteriaBuilder();//Muốn lấy điều kiện
            CriteriaQuery<ChuyenXe> q = b.createQuery(ChuyenXe.class);//Tạo những lệnh truy vấn đến bảng nào

            Root r = q.from(ChuyenXe.class);//Muốn lấy trường (column)
            q.select(r);
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                predicates.add(b.like(r.get("ten"), "%" + kw + "%")); //1% đầu tiên là format, %% đầu cuối tiếp theo là để phân biệt  %% trong sql
            }
            
            String tuyenXeId = params.get("tuyenXeId");
            if (tuyenXeId != null && !tuyenXeId.isEmpty()) {
                predicates.add(b.equal(r.get("TuyenXeId"), Integer.valueOf(tuyenXeId)));
            }
            q.where(predicates.toArray(Predicate[]::new));
            

            q.orderBy(b.desc(r.get("id")));
            Query query = s.createQuery(q);

            String p = params.get("page");
            if (p != null && !p.isEmpty()) {
                int pageSize = Integer.parseInt(env.getProperty("chuyenXe.pageSize"));
                int start = (Integer.parseInt(p) - 1) * pageSize;
                query.setFirstResult(start);
                query.setMaxResults(pageSize);
            }
            List<ChuyenXe> chuyenXes = query.getResultList();
            return chuyenXes;
    }

    @Override
    public void addOrUpdate(ChuyenXe cx ) {
        Session s = this.factory.getObject().getCurrentSession();
            if (cx.getId() != 0) {
                s.update(cx);
            } else {
                s.save(cx);
            }
    }

    @Override
    public ChuyenXe getChuyenXeByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteChuyenXe(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
