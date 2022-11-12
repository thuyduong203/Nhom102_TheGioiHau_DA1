/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.mycompany.domainModel.ComBo;
import com.mycompany.domainModel.NhanVien;
import com.mycompany.repository.impl.ComBoRepository;
import java.math.BigDecimal;
import java.util.List;
import com.mycompany.service.ICommonService;

/**
 *
 * @author Admin
 */
public class ComBoService implements ICommonService<ComBo, String> {

    private final com.mycompany.repository.ICommonRepository cbr = new ComBoRepository();

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
        List<ComBo> test = new ComBoService().getAll();
        for (ComBo comBo : test) {
            System.out.println(comBo.toString());
        }
    }

}
