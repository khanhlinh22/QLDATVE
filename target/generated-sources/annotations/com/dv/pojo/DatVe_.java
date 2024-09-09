package com.dv.pojo;

import com.dv.pojo.ChuyenXe;
import com.dv.pojo.KhachHang;
import com.dv.pojo.ThanhToan;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-09-01T21:12:16")
@StaticMetamodel(DatVe.class)
public class DatVe_ { 

    public static volatile SingularAttribute<DatVe, Integer> soChoDat;
    public static volatile SingularAttribute<DatVe, String> trangThai;
    public static volatile SingularAttribute<DatVe, KhachHang> khachHangId;
    public static volatile SingularAttribute<DatVe, Date> ngayDat;
    public static volatile SingularAttribute<DatVe, Integer> id;
    public static volatile SingularAttribute<DatVe, ChuyenXe> chuyenXeDvId;
    public static volatile SetAttribute<DatVe, ThanhToan> thanhToanSet;

}