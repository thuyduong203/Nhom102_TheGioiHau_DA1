/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.mycompany.customModel.MonAnResponse;
import com.mycompany.repository.ICommonResponseRepository;
import com.mycompany.repository.impl.MonAnResponseRepository;
import com.mycompany.service.ICommonResponseService;
import java.util.List;

/**
 *
 * @author Admin
 */
public class MonAnResponseService implements ICommonResponseService<MonAnResponse> {

    private final ICommonResponseRepository marr = new MonAnResponseRepository();

    @Override
    public List<MonAnResponse> getAll() {
        return marr.getAll();
    }

}
