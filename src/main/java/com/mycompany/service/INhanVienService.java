/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.service;

import com.mycompany.repository.*;
import com.mycompany.domainModel.NhanVien;
import java.util.List;

/**
 *
 * @author son45
 */
public interface INhanVienService {

    List<NhanVien> getUserAndPass(String user, String pass);
}
