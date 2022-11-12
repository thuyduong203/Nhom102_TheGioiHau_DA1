/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.mycompany.domainModel.KhuVuc;
import com.mycompany.repository.impl.KhuVucRepository;
import com.mycompany.service.ICommonService;
import com.mycompany.util.ThongBao;
import java.util.List;

/**
 *
 * @author Duongntt
 */
public class KhuVucService implements ICommonService<KhuVuc, String> {

    private KhuVucRepository khuVucRepo = new KhuVucRepository();
    private ThongBao thongBao = new ThongBao();

    @Override
    public List<KhuVuc> getAll() {
        return khuVucRepo.getAll();
    }

    @Override
    public KhuVuc getOne(String ma) {
        return khuVucRepo.getOne(ma);
    }

    @Override
    public String add(KhuVuc kh) {
        return thongBao.thongBaoADD(khuVucRepo.add(kh));
    }

    @Override
    public String update(KhuVuc kh, String ma) {
        return thongBao.thongBaoUPDATE(khuVucRepo.update(kh, ma));
    }

    @Override
    public String remove(String ma) {
        return thongBao.thongBaoDELETE(khuVucRepo.remove(ma));
    }

}
