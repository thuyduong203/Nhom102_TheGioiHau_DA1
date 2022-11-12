/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.repository;

import com.mycompany.customModel.KhachHangResponse;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IHoaDonChiTietResponseRepository<O,I> {

    List<O> getAll(I trangThai);
    
}
