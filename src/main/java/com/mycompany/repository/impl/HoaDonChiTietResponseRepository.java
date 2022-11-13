/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.impl;

import com.mycompany.customModel.HoaDonChiTietResponse;
import com.mycompany.domainModel.HoaDon;
import com.mycompany.hibernateUtil.HibernateUtil;
import com.mycompany.repository.ICommonResponseRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import com.mycompany.repository.IHoaDonChiTietResponseRepository;

/**
 *
 * @author Admin
 */
public class HoaDonChiTietResponseRepository implements IHoaDonChiTietResponseRepository<HoaDonChiTietResponse, HoaDon> {

    private static final Session session = HibernateUtil.getFactory().openSession();
    private String fromTable = " FROM HoaDonChiTiet HDCT ";

    @Override
    public List<HoaDonChiTietResponse> getAll(HoaDon hd) {
        String hql = "SELECT new com.mycompany.customModel.HoaDonChiTietResponse(HDCT.monAn.maMonAn,HDCT.monAn.tenMonAn,"
                + "HDCT.donGiaMonAn,HDCT.comBo.maCB,HDCT.comBo.tenCB,HDCT.donGiaCombo)"
                + fromTable + "LEFT JOIN ComBo CB ON CB.id = HDCT.comBo";
//        String hql = "SELECT new com.mycompany.customModel.HoaDonResponse(HD.maHoaDon,KH.ma,HD.ngayTao,HD.ban.maBan,
//HD.trangThai,HD.ghiChu)"
//                + fromTable+"LEFT JOIN KhachHang KH ON KH.id = HD.khachHang";
        Query query = session.createQuery(hql);
//        query.setParameter("hoaDon", hd);
        List<HoaDonChiTietResponse> hoaDonChiTietResponses = query.getResultList();
        return hoaDonChiTietResponses;
    }

    public static void main(String[] args) {
        HoaDon hd = new HoaDon();
        hd.setId("7E52228F-F719-4E7D-9BCF-FB1F2DDAB7C4");
        List<HoaDonChiTietResponse> chiTietResponses = new HoaDonChiTietResponseRepository().getAll(hd);
        for (HoaDonChiTietResponse chiTietResponse : chiTietResponses) {
            System.out.println(chiTietResponse.toString());
        }
    }

}
