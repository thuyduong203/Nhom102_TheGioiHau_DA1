/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.mycompany.domainModel.Ban;
import com.mycompany.domainModel.KhuVuc;
import com.mycompany.repository.impl.BanRepository;
import java.util.List;
import com.mycompany.repository.ICommonRepository;

/**
 *
 * @author Admin
 */
public class BanService implements com.mycompany.service.ICommonService<Ban, String> {

    private final ICommonRepository br = new BanRepository();

    @Override
    public List<Ban> getAll() {
        return br.getAll();
    }

    @Override
    public Ban getOne(String ma) {
        return (Ban) br.getOne(ma);
    }

    @Override
    public String add(Ban kh) {
        if ((Boolean) br.add(kh)) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(Ban kh, String ma) {
        if ((Boolean) br.update(kh, ma)) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public String remove(String ma) {
        if ((Boolean) br.remove(ma)) {
            return "Xoá thành công";
        } else {
            return "Xoá thất bại";
        }
    }
    
    public static void main(String[] args) {
        KhuVuc kv = new KhuVuc();
        kv.setIdKV("8E04689D-D3BD-42D9-82F6-71C99A4AF932");
        Ban b = new Ban(null, kv, 3, 10, 0);
        String test = new BanService().add(b);
        System.out.println(test);
        List<Ban> bans = new BanService().getAll();
        for (Ban ban : bans) {
            System.out.println(ban.toString());
        }
    }
    
}
