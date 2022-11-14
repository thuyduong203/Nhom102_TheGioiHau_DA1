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

@Table(name = "Khu_Vuc")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class KhuVuc {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "IdKhuVuc", columnDefinition = "uniqueidentifier", nullable = false)
    private String idKV;

    @Column(name = "MaKhuVuc", nullable = false)
    private String maKV;

    @Column(name = "TenKhuVuc", nullable = false)
    private String tenKV;

    @Column(name = "TrangThai")
    private Integer trangThai;

    public Object[] toDataRow() {
        return new Object[]{maKV, tenKV, (trangThai == 0 ? "Còn sử dụng" : "Không còn sd")};
    }
}
