/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.mycompany.customModel.HoaDonResponse;
import com.mycompany.repository.ICommonResponseRepository;
import com.mycompany.repository.impl.HoaDonResponseRepository;
import com.mycompany.service.ICommonResponseService;
import java.util.List;

/**
 *
 * @author Admin
 */
public class HoaDonResponseService implements ICommonResponseService<HoaDonResponse> {

    private final ICommonResponseRepository hdrr = new HoaDonResponseRepository();

    @Override
    public List<HoaDonResponse> getAll() {
        return hdrr.getAll();
    }
    
}
