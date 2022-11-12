/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.mycompany.domainModel.KhuyenMai;
import com.mycompany.repository.impl.KhuyenMaiRepository;
import com.mycompany.service.ICommonService;
import com.mycompany.util.ThongBao;
import java.util.List;

/**
 *
 * @author Duongntt
 */
public class KhuyenMaiService implements ICommonService<KhuyenMai, String> {

    private KhuyenMaiRepository kmRepo = new KhuyenMaiRepository();
    private ThongBao thongBao = new ThongBao();

    @Override
    public List<KhuyenMai> getAll() {
        return kmRepo.getAll();
    }

    @Override
    public KhuyenMai getOne(String ma) {
        return kmRepo.getOne(ma);
    }

    @Override
    public String add(KhuyenMai kh) {
        return thongBao.thongBaoADD(kmRepo.add(kh));
    }

    @Override
    public String update(KhuyenMai kh, String ma) {
        return thongBao.thongBaoUPDATE(kmRepo.update(kh, ma));
    }

    @Override
    public String remove(String ma) {
        return thongBao.thongBaoDELETE(kmRepo.remove(ma));
    }

}
