package com.dv.pojo;

import com.dv.pojo.ChuyenXe;
import com.dv.pojo.NguoiDung;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-09-01T21:12:16")
@StaticMetamodel(TaiXe.class)
public class TaiXe_ { 

    public static volatile SingularAttribute<TaiXe, NguoiDung> nguoiDungTxId;
    public static volatile SingularAttribute<TaiXe, Integer> id;
    public static volatile SingularAttribute<TaiXe, String> bangCap;
    public static volatile SetAttribute<TaiXe, ChuyenXe> chuyenXeSet;

}