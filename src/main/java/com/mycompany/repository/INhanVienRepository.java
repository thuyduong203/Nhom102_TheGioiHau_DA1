/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.repository;

import com.mycompany.domainModel.NhanVien;
import java.util.List;

/**
 *
 * @author son45
 */
public interface INhanVienRepository {

    List<NhanVien> getUserAndPass(String user, String pass);
}
