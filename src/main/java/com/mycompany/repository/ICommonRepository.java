/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.repository;

import com.mycompany.domainModel.KhachHang;
import java.util.List;

/**
 *
 * @author Admin
 */
//O = Object
//B = boolean
//S = String
//I = integer
public interface ICommonRepository<O, B, S> {

    List<O> getAll();

    O getOne(S ma);

    B add(O kh);

    B update(O kh, S ma);

    B remove(S ma);

}
