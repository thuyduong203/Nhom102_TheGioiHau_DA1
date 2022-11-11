/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.domainModel;

import java.math.BigDecimal;
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

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "Ca_Lam_Viec")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CaLamViec {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "IdCaLamviec", columnDefinition = "uniqueidentifier", nullable = false)
    private String id;

    @ManyToOne
    @JoinColumn(name = "IdNV", nullable = false)
    private NhanVien nhanVien;

    @Column(name = "TGianBD", nullable = false)
    private Date thoiGianBD;

    @Column(name = "TGianKT")
    private Date thoiGianKT;

    @Column(name = "TienDauCa")
    private BigDecimal tienDauCa;

    @Column(name = "TienMatTaiQuan", nullable = false)
    private BigDecimal tienMatTaiQuan;

    @Column(name = "TienNhoThuHo")
    private BigDecimal tienNhoThuHo;

    @Column(name = "GhiChu")
    private String ghiChu;

}
