/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.mycompany.domainModel.ComBo;
import com.mycompany.domainModel.NhanVien;
import com.mycompany.repository.impl.ComBoRepository;
import com.mycompany.service.ICommon;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ComBoService implements ICommon<ComBo, String> {

    private final com.mycompany.repository.ICommon cbr = new ComBoRepository();

    @Override
    public List<ComBo> getAll() {
        return cbr.getAll();
    }

    @Override
    public ComBo getOne(String ma) {
        return (ComBo) cbr.getOne(ma);
    }

    @Override
    public String add(ComBo kh) {
        if ((Boolean) cbr.add(kh)) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(ComBo kh, String ma) {
        if ((Boolean) cbr.update(kh, ma)) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public String remove(String ma) {
        if ((Boolean) cbr.remove(ma)) {
            return "Xoá thành công";
        } else {
            return "Xoá thất bại";
        }
    }
    public static void main(String[] args) {
        NhanVien nv = new NhanVien();
        nv.setId("E26EFCD1-8F31-446A-B791-5A11F3ED0C2A");
        ComBo cb = new ComBo(null, nv, null, "aaaaaaa", "aa", BigDecimal.valueOf(200), 0);
//        String test = new ComBoService().update("CB001");
//        System.out.println(test);S
    }

}
