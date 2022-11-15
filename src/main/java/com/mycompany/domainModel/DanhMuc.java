/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.domainModel;

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

@Table(name = "Danh_Muc")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DanhMuc {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "IdDanhMuc", columnDefinition = "uniqueidentifier", nullable = false)
    private String idDanhMuc;

    @ManyToOne
    @JoinColumn(name = "idDanhMuc")
    private DanhMuc loai;

    @Column(name = "maDanhMuc", nullable = false)
    private String maDanhMuc;

    @Column(name = "TenDanhMuc", nullable = false)
    private String tenDanhMuc;

    @Column(name = "TrangThai")
    private Integer trangThai;

}
