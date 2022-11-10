/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.mycompany.customModel.KhachHangResponse;
import com.mycompany.repository.impl.KhachHangResponseRepository;
import com.mycompany.service.IKhachHangResponse;
import java.util.List;

/**
 *
 * @author Admin
 */
public class KhachHangResponseService implements IKhachHangResponse {

    private com.mycompany.repository.IKhachHangResponse khrr = new KhachHangResponseRepository();

    @Override
    public List<KhachHangResponse> getAll(int trangThai) {
        return khrr.getAll(trangThai);
    }

}
