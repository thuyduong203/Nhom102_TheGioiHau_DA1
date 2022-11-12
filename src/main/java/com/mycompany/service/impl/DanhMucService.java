/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.mycompany.domainModel.DanhMuc;
import com.mycompany.repository.ICommonRepository;
import com.mycompany.repository.impl.DanhMucRepository;
import com.mycompany.service.ICommonService;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DanhMucService implements ICommonService<DanhMuc, String> {

    private static ICommonRepository dmr = new DanhMucRepository();

    @Override
    public List<DanhMuc> getAll() {
        return dmr.getAll();
    }

    @Override
    public DanhMuc getOne(String ma) {
        return (DanhMuc) dmr.getOne(ma);
    }

    @Override
    public String add(DanhMuc kh) {
        if ((Boolean) dmr.add(kh)) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(DanhMuc kh, String ma) {
        if ((Boolean) dmr.update(kh,ma)) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public String remove(String ma) {
        if ((Boolean) dmr.remove(ma)) {
            return "Xoá thành công";
        } else {
            return "Xoá thất bại";
        }
    }
    public static void main(String[] args) {
//        DanhMuc loai = new DanhMuc();
//        loai.setIdDanhMuc("AA5EF128-4354-4917-9C5D-9E19B52F1C3F");
//        DanhMuc dm = new DanhMuc(null, loai, "DM04", "Nước uống có ga", 0);
//        String test = new DanhMucService().add(dm);
//        System.out.println(test);
        List<DanhMuc> danhMucs = new DanhMucService().getAll();
        for (DanhMuc danhMuc : danhMucs) {
            System.out.println(danhMuc.getIdDanhMuc()+" "+danhMuc.getLoai().getIdDanhMuc()+" "+danhMuc.getTenDanhMuc());
    }
    }

}
