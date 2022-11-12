/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.domainModel;

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
@Table(name = "Chuc_Vu")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ChucVu {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "IdCV", columnDefinition = "uniqueidentifier", nullable = false)
    private String id;

    @Column(name = "MaCV", nullable = false)
    private String ma;

    @Column(name = "TenCV", nullable = false)
    private String ten;

    @Column(name = "TrangThai")
    private Integer trangThai;

//    @OneToMany(mappedBy = "chucVu", fetch = FetchType.LAZY)
//    private List<NhanVien> listNV;
    

    public Object[] toDataRow() {
        return new Object[]{ma, ten};
    }
}
