/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.domainModel;

import java.math.BigDecimal;
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
@Table(name = "Hoa_Don_Chi_Tiet")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class HoaDonChiTiet {

      @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "IdHDCT", columnDefinition = "uniqueidentifier", nullable = false)
    private String id;
    
    @ManyToOne
    @JoinColumn(name = "IdBan", nullable = false)
    private Ban ban;
    
    @ManyToOne
    @JoinColumn(name = "IdMonAn")
    private MonAn monAn;
    
    @ManyToOne
    @JoinColumn(name = "IdHD", nullable = false)
    private HoaDon hoaDon;
    
    @ManyToOne
    @JoinColumn(name = "IdComBo")
    private ComBo comBo;
    
    @Column(name = "SoLuong",nullable = false)
    private Integer soLuong;
    
    @Column(name = "DonGia",nullable = false)
    private BigDecimal donGia;
    
}
