/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.repositories.impl;

import com.dv.pojo.TuyenXe;
import com.dv.repositoties.TuyenXeRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author ADMIN
 */
@Repository
@Transactional
@PropertySource("classpath:configs.properties")
public class TuyenXeRepositoryImpl implements TuyenXeRepository{

     @Autowired
    private Environment env;

    @Autowired
    private LocalSessionFactoryBean factory;
        
    @Override
    public List<TuyenXe> getTuyenXes(Map<String, String> params) {
//        Session s = this.factory.getObject().openSession();
//            CriteriaBuilder b = s.getCriteriaBuilder();//Muốn lấy điều kiện
//            CriteriaQuery<TuyenXe> q = b.createQuery(TuyenXe.class);//Tạo những lệnh truy vấn đến bảng nào
//
//            Root r = q.from(TuyenXe.class);//Muốn lấy trường (column)
//            q.select(r);
//            List<Predicate> predicates = new ArrayList<>();
//            String kw = params.get("kw");
//            if (kw != null && !kw.isEmpty()) {
//                predicates.add(b.like(r.get("ten"), "%" + kw + "%")); //1% đầu tiên là format, %% đầu cuối tiếp theo là để phân biệt  %% trong sql
//            }
//            
//            String hoatDongId = params.get("hoatDongId");
//            if (hoatDongId != null && !hoatDongId.isEmpty()) {
//                predicates.add(b.equal(r.get("HoatDongId"), Integer.valueOf(hoatDongId)));
//            }
//            q.where(predicates.toArray(Predicate[]::new));
//            
//
//            q.orderBy(b.desc(r.get("id")));
//            Query query = s.createQuery(q);
//
//            String p = params.get("page");
//            if (p != null && !p.isEmpty()) {
//                int pageSize = Integer.parseInt(env.getProperty("tuyenXe.pageSize"));
//                int start = (Integer.parseInt(p) - 1) * pageSize;
//                query.setFirstResult(start);
//                query.setMaxResults(pageSize);
//            }
//            List<TuyenXe> tuyenXes = query.getResultList();
//            return tuyenXes;
     Session s = this.factory.getObject().openSession();
    CriteriaBuilder b = s.getCriteriaBuilder();
    CriteriaQuery<TuyenXe> q = b.createQuery(TuyenXe.class);

    Root<TuyenXe> r = q.from(TuyenXe.class);
    q.select(r);
    List<Predicate> predicates = new ArrayList<>();

    // Xử lý tham số từ params để thêm điều kiện tìm kiếm
    String kw = params.get("kw");
    if (kw != null && !kw.isEmpty()) {
        predicates.add(b.like(r.get("ten"), "%" + kw + "%")); // Tìm kiếm theo tên
    }

    // Thêm các điều kiện vào truy vấn
    q.where(predicates.toArray(Predicate[]::new));
    
    // Thực hiện sắp xếp theo id giảm dần
    q.orderBy(b.desc(r.get("id")));
    
    Query<TuyenXe> query = s.createQuery(q);

    // Xử lý phân trang nếu có tham số trang
    String p = params.get("page");
    if (p != null && !p.isEmpty()) {
        int pageSize = Integer.parseInt(env.getProperty("tuyenXe.pageSize"));
        int start = (Integer.parseInt(p) - 1) * pageSize;
        query.setFirstResult(start);
        query.setMaxResults(pageSize);
    }

    // Thực thi truy vấn và trả kết quả
        List<TuyenXe> tuyenXes = query.getResultList();
        s.close(); // Đảm bảo đóng phiên làm việc để giải phóng tài nguyên
        return tuyenXes;
        
    }

    @Override
    public void addOrUpdate(TuyenXe tx) {
          Session s = this.factory.getObject().getCurrentSession();
            if (tx.getId() != null) {
                s.update(tx);
            } else {
                s.save(tx);
            }
    }

    @Override
    public TuyenXe getTuyenXeID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteTuyenXe(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
}
