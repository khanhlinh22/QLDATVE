package com.dv.pojo;

import com.dv.pojo.DatVe;
import com.dv.pojo.NguoiDung;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-09-01T21:12:16")
@StaticMetamodel(KhachHang.class)
public class KhachHang_ { 

    public static volatile SingularAttribute<KhachHang, String> thongTinThanhToan;
    public static volatile SetAttribute<KhachHang, DatVe> datVeSet;
    public static volatile SingularAttribute<KhachHang, NguoiDung> nguoiDungKhId;
    public static volatile SingularAttribute<KhachHang, Integer> id;

}