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

/**
 *
 * @author son45
 */
@Entity
@Table(name = "ComBo")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ComBo {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "IdComBo", columnDefinition = "uniqueidentifier", nullable = false)
    private String id;

    @ManyToOne
    @JoinColumn(name = "IdNV", nullable = false)
    private NhanVien nhanVien;

    @Column(name = "MaCB", nullable = false)
    private String maCB;

    @Column(name = "TenCB", nullable = false)
    private String tenCB;

    @Column(name = "HinhAnh")
    private String hinhAnh;

    @Column(name = "DonGia", nullable = false)
    private BigDecimal donGia;

    @Column(name = "TrangThai")
    private Integer trangThai;

//    @OneToMany(mappedBy = "comBo", fetch = FetchType.LAZY)
//    private List<ChiTietComBo> listCTCB;
//    
//    @OneToMany(mappedBy = "comBo", fetch = FetchType.LAZY)
//    private List<HoaDonChiTiet> listHDCT;
    public Object[] toDataRow() {
        return new Object[]{maCB, tenCB, donGia,};
    }
}
