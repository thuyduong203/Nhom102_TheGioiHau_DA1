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
//O = Object
//S = String
public interface ICommonService<O,S> {

    List<O> getAll();

    O getOne(S ma);

    S add(O kh);

    S update(O kh, S ma);

    S remove(S ma);
}
