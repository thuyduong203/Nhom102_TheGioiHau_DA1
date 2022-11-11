/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.service;

import java.util.List;

/**
 *
 * @author Admin
 */
public interface IChiTietComBoService<O, S, I, O2, O3> {

    List<O> getAll();

    S add(O ctcb);

    S update(O chiTietComBo, O2 comBo, O3 monAn);

    S remove(O chiTietComBo, O2 comBo, O3 monAn);
}
