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
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Khach_Hang")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class KhachHang {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "IdKH", columnDefinition = "uniqueidentifier", nullable = false)
    private String id;

    @Column(name = "MaKH", nullable = false)
    private String ma;

    @Column(name = "Ho")
    private String ho;

    @Column(name = "TenDem")
    private String tenDem;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "GioiTinh")
    private String gioiTinh;

    @Column(name = "NgaySinh")
    private Date ngaySinh;

    @Column(name = "Sdt")
    private String sdt;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "ThanhPho")
    private String thanhPho;

    @Column(name = "QuocGia")
    private String quocGia;

    @Column(name = "TrangThai")
    private Integer trangThai;

    public Object[] toDataRow(int stt) {
        return new Object[]{stt, ma, ho + " " + tenDem + " " + ten, gioiTinh, ngaySinh, sdt, diaChi, (trangThai == 0 ? "active" : "un active")};
    }
}
