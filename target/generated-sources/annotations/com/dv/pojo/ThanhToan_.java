package com.dv.pojo;

import com.dv.pojo.DatVe;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-09-01T21:12:16")
@StaticMetamodel(ThanhToan.class)
public class ThanhToan_ { 

    public static volatile SingularAttribute<ThanhToan, DatVe> datVeId;
    public static volatile SingularAttribute<ThanhToan, Date> ngayThanhToan;
    public static volatile SingularAttribute<ThanhToan, Integer> id;
    public static volatile SingularAttribute<ThanhToan, BigDecimal> soTien;
    public static volatile SingularAttribute<ThanhToan, String> hinhThucThanhToan;

}