/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.domainModel;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Hoa_Don")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class HoaDon {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "IdHD", columnDefinition = "uniqueidentifier", nullable = false)
    private String id;

    @Column(name = "MaHD", nullable = false)
    private String maHoaDon;

    @ManyToOne
    @JoinColumn(name = "IdNV", nullable = false)
    private NhanVien nhanVien;

    @ManyToOne
    @JoinColumn(name = "IdKH", nullable = true)
    private KhachHang khachHang;
    
    @ManyToOne
    @JoinColumn(name = "IdBan",nullable = false)
    private Ban ban;

    @Column(name = "NgayTao", nullable = false)
    private Date ngayTao;

    @Column(name = "NgayThanhToan")
    private Date ngayThanhToan;

    @Column(name = "TongTien")
    private BigDecimal tongTien;

    @Column(name = "GhiChu")
    private String ghiChu;

    @Column(name = "TrangThai")
    private Integer trangThai;

//    @OneToMany(mappedBy = "hoaDon", fetch = FetchType.LAZY)
//    private List<HoaDonChiTiet> listHDCT;
    public Object[] toDataRow() {
        return new Object[]{maHoaDon, nhanVien.getId(), khachHang.getId(), ngayTao, ngayThanhToan, tongTien, ghiChu};
    }
}
