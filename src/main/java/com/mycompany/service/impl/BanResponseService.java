/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.mycompany.customModel.BanResponse;
import com.mycompany.repository.ICommonResponseRepository;
import com.mycompany.repository.impl.BanResponseRepository;
import com.mycompany.service.ICommonResponseService;
import java.util.List;

/**
 *
 * @author Admin
 */
public class BanResponseService implements ICommonResponseService<BanResponse> {

    private final ICommonResponseRepository brr = new BanResponseRepository();

    @Override
    public List<BanResponse> getAll() {
        return brr.getAll();
    }

}
