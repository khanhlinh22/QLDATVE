package com.dv.pojo;

import com.dv.pojo.DatVe;
import com.dv.pojo.LichTrinh;
import com.dv.pojo.TaiXe;
import com.dv.pojo.TuyenXe;
import com.dv.pojo.Xe;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-09-01T21:12:16")
@StaticMetamodel(ChuyenXe.class)
public class ChuyenXe_ { 

    public static volatile SingularAttribute<ChuyenXe, Xe> xeId;
    public static volatile SingularAttribute<ChuyenXe, BigDecimal> giaVe;
    public static volatile SetAttribute<ChuyenXe, DatVe> datVeSet;
    public static volatile SingularAttribute<ChuyenXe, String> trangThai;
    public static volatile SingularAttribute<ChuyenXe, Integer> soCho;
    public static volatile SingularAttribute<ChuyenXe, TuyenXe> tuyenXeId;
    public static volatile SetAttribute<ChuyenXe, LichTrinh> lichTrinhSet;
    public static volatile SingularAttribute<ChuyenXe, Integer> id;
    public static volatile SingularAttribute<ChuyenXe, Date> ngayGioKhoiHanh;
    public static volatile SingularAttribute<ChuyenXe, TaiXe> taiXeId;

}