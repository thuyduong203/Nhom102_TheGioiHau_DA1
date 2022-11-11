/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.repository;

import com.mycompany.domainModel.ChiTietComBo;
import java.util.List;

/**
 *
 * @author Admin
 */
//O2 với O3 là điều kiện để update với remove
//I la dieu kien de xoa
public interface IChiTietComBoRepository<O, B,I, O2, O3> {

    List<O> getAll();

    B add(O ctcb);

    B update(O chiTietComBo, O2 comBo,O3 monAn);

    B remove(O chiTietComBo, O2 comBo,O3 monAn);

}
