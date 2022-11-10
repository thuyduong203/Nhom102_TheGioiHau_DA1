/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.impl;

import com.mycompany.customModel.KhachHangResponse;
import com.mycompany.hibernateUtil.HibernateUtil;
import com.mycompany.repository.IKhachHangResponse;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class KhachHangResponseRepository implements IKhachHangResponse {

    private static final Session session = HibernateUtil.getFactory().openSession();
    private String fromTable = " FROM KhachHang KH ";

    @Override
    public List<KhachHangResponse> getAll(int trangThai) {
        String hql = "SELECT new com.mycompany.customModel.KhachHangResponse(KH.ma,KH.ho,KH.gioiTinh,KH.ngaySinh,KH.sdt,KH.diaChi,KH.thanhPho,KH.quocGia)"
                + fromTable + "WHERE trangThai = :trangThai";
        Query query = session.createQuery(hql);
        query.setParameter("trangThai", trangThai);
        List<KhachHangResponse> khachHangResponses = query.getResultList();
        return khachHangResponses;
    }
    public static void main(String[] args) {
        List<KhachHangResponse> getAll = new KhachHangResponseRepository().getAll(0);
        for (KhachHangResponse khachHangResponse : getAll) {
            System.out.println(khachHangResponse.toString());
        }
    }

}
