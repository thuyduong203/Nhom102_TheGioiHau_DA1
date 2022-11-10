/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.domainModel;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Mon_An")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MonAn {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "IdMonAn", columnDefinition = "uniqueidentifier", nullable = false)
    private String id;
    
    @Column(name = "MaMonAn", nullable = false)
    private String maMonAn;
    
    @Column(name = "TenMonAn", nullable = false)
    private String tenMonAn;
    
    @Column(name = "HinhAnh")
    private String hinhAnh;
    
    @Column(name = "DonGia", nullable = false)
    private BigDecimal donGia;
    
    @Column(name = "DonViTinh", nullable = false)
    private String donViTinh;
    
    @Column(name = "TrangThai")
    private Integer trangThai;
    
//    @OneToMany(mappedBy = "monAn", fetch = FetchType.LAZY)
//    private List<ChiTietComBo> listCTCB;
//    
//    @OneToMany(mappedBy = "monAn", fetch = FetchType.LAZY)
//    private List<HoaDonChiTiet> listHDCT;
    
    

}
