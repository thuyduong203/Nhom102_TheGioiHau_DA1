/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.service;

import java.util.List;


//O = Object
//B = boolean
//S = String
//O2 = Object2
public interface IHoaDonChiTiet<O,S,O2> {
    List<O> getAll();

    O getOne(S ma);

    S add(O kh);

    S update(O kh, O2 ma);

    S remove(O2 ma);
}
