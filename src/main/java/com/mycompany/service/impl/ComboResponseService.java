/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.mycompany.customModel.ComboResponse;
import com.mycompany.repository.ICommonResponseRepository;
import com.mycompany.repository.impl.ComboResponseRepository;
import com.mycompany.service.ICommonResponseService;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ComboResponseService implements ICommonResponseService<ComboResponse> {

    private final ICommonResponseRepository cbrr = new ComboResponseRepository();

    @Override
    public List<ComboResponse> getAll() {
        return cbrr.getAll();
    }

}
