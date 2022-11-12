/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.mycompany.domainModel.ChucVu;
import com.mycompany.repository.impl.ChucVuRepository;
import java.util.List;
import com.mycompany.repository.ICommonRepository;

/**
 *
 * @author Admin
 */
public class ChucVuService implements com.mycompany.service.ICommonService<ChucVu, String> {

    private final ICommonRepository cvs = new ChucVuRepository();

    @Override
    public List<ChucVu> getAll() {
        return cvs.getAll();
    }

    @Override
    public ChucVu getOne(String ma) {
        return (ChucVu) cvs.getOne(ma);
    }

    @Override
    public String add(ChucVu kh) {
        if ((Boolean) cvs.add(kh)) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(ChucVu kh, String ma) {
        if ((Boolean) cvs.update(kh, ma)) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public String remove(String ma) {
        if ((Boolean) cvs.remove(ma)) {
            return "Xoá thành công";
        } else {
            return "Xoá thất bại";
        }
    }
    
}
