/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.domainModel;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Nhan_Vien")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class NhanVien {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "IdNV", columnDefinition = "uniqueidentifier")
    private String id;

    @ManyToOne
    @JoinColumn(name = "IdCV", nullable = false)
    private ChucVu chucVu;

    @Column(name = "MaNV", nullable = false)
    private String ma;

    @Column(name = "ho", nullable = false)
    private String ho;

    @Column(name = "TenDem", nullable = false)
    private String tenDem;

    @Column(name = "Ten", nullable = false)
    private String ten;

    @Column(name = "GioiTinh", nullable = false)
    private String gioiTinh;

    @Column(name = "Sdt", nullable = false)
    private String soDienThoai;

    @Column(name = "Email")
    private String email;

    @Column(name = "NgaySinh", nullable = false)
    private Date ngaySinh;

    @Column(name = "DiaChi", nullable = false)
    private String diaChi;

    @Column(name = "MatKhau", nullable = false)
    private String matKhau;

    @Column(name = "TrangThai", nullable = false)
    private Integer trangThai;

//    @OneToMany(mappedBy = "nhanVien", fetch = FetchType.LAZY)
//    private List<KhuyenMai> listKM;
//    
//    @OneToMany(mappedBy = "nhanVien", fetch = FetchType.LAZY)
//    private List<ComBo> listCB;
//    
//    @OneToMany(mappedBy = "nhanVien", fetch = FetchType.LAZY)
//    private List<HoaDon> listHD;
//    @OneToMany(mappedBy = "nhanVien", fetch = FetchType.LAZY)
//    private List<CaLamViec> listCLV;
    public Object[] toDataRow() {
        return new Object[]{};
    }

}
