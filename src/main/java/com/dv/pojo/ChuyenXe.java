/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "chuyen_xe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChuyenXe.findAll", query = "SELECT c FROM ChuyenXe c"),
    @NamedQuery(name = "ChuyenXe.findById", query = "SELECT c FROM ChuyenXe c WHERE c.id = :id"),
    @NamedQuery(name = "ChuyenXe.findByNgayGioKhoiHanh", query = "SELECT c FROM ChuyenXe c WHERE c.ngayGioKhoiHanh = :ngayGioKhoiHanh"),
    @NamedQuery(name = "ChuyenXe.findByGiaVe", query = "SELECT c FROM ChuyenXe c WHERE c.giaVe = :giaVe"),
    @NamedQuery(name = "ChuyenXe.findBySoCho", query = "SELECT c FROM ChuyenXe c WHERE c.soCho = :soCho"),
    @NamedQuery(name = "ChuyenXe.findByTrangThai", query = "SELECT c FROM ChuyenXe c WHERE c.trangThai = :trangThai")})
public class ChuyenXe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ngay_gio_khoi_hanh")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayGioKhoiHanh;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "gia_ve")
    private BigDecimal giaVe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "so_cho")
    private int soCho;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "trang_thai")
    private String trangThai;
    @OneToMany(mappedBy = "chuyenXeDvId")
    private Set<DatVe> datVeSet;
    @OneToMany(mappedBy = "chuyenXeId")
    private Set<LichTrinh> lichTrinhSet;
    @JoinColumn(name = "tai_xe_id", referencedColumnName = "id")
    @ManyToOne
    private TaiXe taiXeId;
    @JoinColumn(name = "tuyen_xe_id", referencedColumnName = "id")
    @ManyToOne
    private TuyenXe tuyenXeId;
    @JoinColumn(name = "xe_id", referencedColumnName = "id")
    @ManyToOne
    private Xe xeId;

    public ChuyenXe() {
    }

    public ChuyenXe(Integer id) {
        this.id = id;
    }

    public ChuyenXe(Integer id, BigDecimal giaVe, int soCho, String trangThai) {
        this.id = id;
        this.giaVe = giaVe;
        this.soCho = soCho;
        this.trangThai = trangThai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getNgayGioKhoiHanh() {
        return ngayGioKhoiHanh;
    }

    public void setNgayGioKhoiHanh(Date ngayGioKhoiHanh) {
        this.ngayGioKhoiHanh = ngayGioKhoiHanh;
    }

    public BigDecimal getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(BigDecimal giaVe) {
        this.giaVe = giaVe;
    }

    public int getSoCho() {
        return soCho;
    }

    public void setSoCho(int soCho) {
        this.soCho = soCho;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @XmlTransient
    public Set<DatVe> getDatVeSet() {
        return datVeSet;
    }

    public void setDatVeSet(Set<DatVe> datVeSet) {
        this.datVeSet = datVeSet;
    }

    @XmlTransient
    public Set<LichTrinh> getLichTrinhSet() {
        return lichTrinhSet;
    }

    public void setLichTrinhSet(Set<LichTrinh> lichTrinhSet) {
        this.lichTrinhSet = lichTrinhSet;
    }

    public TaiXe getTaiXeId() {
        return taiXeId;
    }

    public void setTaiXeId(TaiXe taiXeId) {
        this.taiXeId = taiXeId;
    }

    public TuyenXe getTuyenXeId() {
        return tuyenXeId;
    }

    public void setTuyenXeId(TuyenXe tuyenXeId) {
        this.tuyenXeId = tuyenXeId;
    }

    public Xe getXeId() {
        return xeId;
    }

    public void setXeId(Xe xeId) {
        this.xeId = xeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChuyenXe)) {
            return false;
        }
        ChuyenXe other = (ChuyenXe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dv.pojo.ChuyenXe[ id=" + id + " ]";
    }
    
}
