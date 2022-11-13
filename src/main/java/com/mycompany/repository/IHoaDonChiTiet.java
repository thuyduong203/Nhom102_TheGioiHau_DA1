/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.repository;

import java.util.List;

/**
 *
 * @author Admin
 */
//O = Object
//B = boolean
//S = String
//O2 = Object2
public interface IHoaDonChiTiet<O, B, S, O2, O3, O4> {

    List<O> getAll();

    O getOneCombo(O2 hd, O3 combo);

    O getOneMonAn(O2 hd, O4 monAn);

    B add(O kh);

    B update(O kh, O2 ma);

    B remove(O2 ma);
}
