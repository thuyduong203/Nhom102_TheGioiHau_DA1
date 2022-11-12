/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.mycompany.domainModel.MonAn;
//import com.mycompany.repository.ICommon;
import com.mycompany.repository.ICommonRepository;
import com.mycompany.repository.impl.MonAnRepository;
import com.mycompany.util.ThongBao;
import java.util.List;

/**
 *
 * @author Admin
 */
public class MonAnService implements com.mycompany.service.ICommonService<MonAn, String> {

    private final ICommonRepository mar = new MonAnRepository();
    private ThongBao thongBao = new ThongBao();

    @Override
    public List<MonAn> getAll() {
        return mar.getAll();
    }

    @Override
    public MonAn getOne(String ma) {
        return (MonAn) mar.getOne(ma);
    }

    @Override
    public String add(MonAn kh) {
        return thongBao.thongBaoADD((Boolean) mar.add(kh));
    }

    @Override
    public String update(MonAn kh, String ma) {
        return thongBao.thongBaoUPDATE((Boolean) mar.update(kh, ma));
    }

    @Override
    public String remove(String ma) {
        return thongBao.thongBaoDELETE((Boolean) mar.remove(ma));
    }

    public static void main(String[] args) {
        List<MonAn> monAn = new MonAnService().getAll();
        for (MonAn monAn1 : monAn) {
            System.out.println(monAn1.getMaMonAn()+" "+monAn1.getTenMonAn()+" "+monAn1.getLoai().getTenDanhMuc());
        }
    }

}
