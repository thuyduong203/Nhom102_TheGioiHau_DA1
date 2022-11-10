/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.domainModel;

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

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "Ban")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Ban {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "IdBan", columnDefinition = "uniqueidentifier")
    private String id;

    @Column(name = "MaBan", nullable = false)
    private Integer maBan;

    @Column(name = "SoLuongChoNgoi", nullable = false)
    private Integer soLuongChoNgoi;

    @Column(name = "TrangThai", nullable = true)
    private Integer trangThai;

//    @OneToMany(mappedBy = "ban", fetch = FetchType.LAZY)
//    private List<HoaDonChiTiet> listHDC;
    public Object[] toDataRow() {
        return new Object[]{maBan, soLuongChoNgoi};
    }
}
