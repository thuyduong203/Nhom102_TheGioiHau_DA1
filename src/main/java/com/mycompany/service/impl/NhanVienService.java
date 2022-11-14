/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.mycompany.domainModel.ChucVu;
import com.mycompany.domainModel.NhanVien;
import com.mycompany.repository.impl.NhanVienRepository;
import com.mycompany.service.ICommonService;
import com.mycompany.service.INhanVienService;
import com.mycompany.util.ThongBao;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Duongntt
 */
public class NhanVienService implements ICommonService<NhanVien, String>, INhanVienService {

    private NhanVienRepository nvRepo = new NhanVienRepository();
    private ThongBao thongBao = new ThongBao();

    @Override
    public List<NhanVien> getAll() {
        return nvRepo.getAll();
    }

    @Override
    public NhanVien getOne(String ma) {
        return nvRepo.getOne(ma);
    }

    @Override
    public String add(NhanVien nv) {
        return thongBao.thongBaoADD(nvRepo.add(nv));
    }

    @Override
    public String update(NhanVien nv, String ma) {
        return thongBao.thongBaoUPDATE(nvRepo.update(nv, ma));
    }

    @Override
    public String remove(String ma) {
        return thongBao.thongBaoDELETE(nvRepo.remove(ma));
    }

    public static void main(String[] args) {
        ChucVu chucVu = new ChucVu();
        chucVu.setId("E965EFB2-67DA-4CD5-92F7-F8EA920821D5");
        NhanVien nhanVien = new NhanVien();
        nhanVien.setChucVu(chucVu);
        nhanVien.setDiaChi("a");
        nhanVien.setGioiTinh("b");
        nhanVien.setHo("a");
        nhanVien.setMa("NV2");
        nhanVien.setMatKhau("1234");
        nhanVien.setNgaySinh(Date.valueOf("2003-11-29"));
        nhanVien.setSoDienThoai("gfd");
        nhanVien.setTen("gfds");
        nhanVien.setTenDem("fdxs");
        nhanVien.setTrangThai(0);
        //System.out.println(new NhanVienService().remove("NV2"));
//        NhanVien nv = new NhanVienService().getOne("NV1");
//        System.out.println(nv.toString());
    }

    @Override
    public List<NhanVien> getUserAndPass(String user, String pass) {
        return nvRepo.getUserAndPass(user, pass);
    }
}
