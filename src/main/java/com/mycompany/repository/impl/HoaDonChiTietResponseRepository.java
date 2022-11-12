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
public class HoaDonChiTietResponseRepository implements IHoaDonChiTietResponseRepository<HoaDonChiTietResponse,HoaDon> {

    private static final Session session = HibernateUtil.getFactory().openSession();
    private String fromTable = " FROM HoaDonChiTiet HDCT ";

    @Override
    public List<HoaDonChiTietResponse> getAll(HoaDon hd) {
        String hql = "SELECT new com.mycompany.customModel.HoaDonChiTietResponse(HDCT.monAn.maMonAn,HDCT.monAn.tenMonAn,HDCT.soLuongMonAn,HDCT.donGiaMonAn)"
                + fromTable +"WHERE hoaDon = :hoaDon";
        Query query = session.createQuery(hql);
        query.setParameter("hoaDon", hd);
        List<HoaDonChiTietResponse> hoaDonChiTietResponses = query.getResultList();
        return hoaDonChiTietResponses;
    }
//    public static void main(String[] args) {
//        List<HoaDonChiTietResponse> chiTietResponses = new HoaDonChiTietResponseRepository().getAll();
//        for (HoaDonChiTietResponse chiTietResponse : chiTietResponses) {
//            System.out.println(chiTietResponse);
//        }
//    }

}
