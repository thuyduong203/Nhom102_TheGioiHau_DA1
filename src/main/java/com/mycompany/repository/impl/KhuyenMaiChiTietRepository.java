/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.impl;

import com.mycompany.domainModel.KhuyenMai;
import com.mycompany.domainModel.KhuyenMaiChiTiet;
import com.mycompany.domainModel.MonAn;
import com.mycompany.hibernateUtil.HibernateUtil;
import com.mycompany.repository.ICommonRepository;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Duongntt
 */
public class KhuyenMaiChiTietRepository implements ICommonRepository<KhuyenMaiChiTiet, Boolean, String> {

    @Override
    public List<KhuyenMaiChiTiet> getAll() {
        List<KhuyenMaiChiTiet> listKMCT = new ArrayList<>();
        try ( Session session = HibernateUtil.getFactory().openSession()) {
            Query query = session.createQuery("FROM KhuyenMaiChiTiet");
            listKMCT = query.getResultList();
        }
        return listKMCT;
    }

    @Override
    public KhuyenMaiChiTiet getOne(String ma) {
        KhuyenMaiChiTiet khuyenMaiChiTiet = new KhuyenMaiChiTiet();
        try ( Session session = HibernateUtil.getFactory().openSession()) {
            Query query = session.createQuery("FROM KhuyenMaiChiTiet");
        } finally {
            return khuyenMaiChiTiet;
        }
    }

    @Override
    public Boolean add(KhuyenMaiChiTiet kmct) {
        boolean isAdd = false;
        try ( Session session = HibernateUtil.getFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            try {
                session.save(kmct);
                transaction.commit();
                isAdd = true;
            } catch (Exception e) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally {
            return isAdd;
        }
    }

    @Override
    public Boolean update(KhuyenMaiChiTiet khuyenMaiChiTiet, String id) {
        int check = 0;
        try ( Session session = HibernateUtil.getFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            try {
                Query query = session.createQuery("UPDATE KhuyenMaiChiTiet SET monAn = :monAn,"
                        + "khuyenMai = :khuyenMai, thoiGianBatDau = :tgianBD,"
                        + "thoiGianKetThuc = :tgianKT, giaTriKhuyenMai = :gtriKM"
                        + " WHERE id = :idKMCT");
                query.setParameter("monAn", khuyenMaiChiTiet.getMonAn());
                query.setParameter("khuyenMai", khuyenMaiChiTiet.getKhuyenMai());
//                query.setParameter("tgianBD", khuyenMaiChiTiet.getThoiGianBatDau());
//                query.setParameter("tgianKT", khuyenMaiChiTiet.getThoiGianKetThuc());
//                query.setParameter("gtriKM", khuyenMaiChiTiet.getGiaTriKhuyenMai());
                query.setParameter("idKMCT", id);
                check = query.executeUpdate();
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally {
            return check > 0;
        }
    }

    @Override
    public Boolean remove(String id) {
        int check = 0;
        try ( Session session = HibernateUtil.getFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            try {
                Query query = session.createQuery("DELETE FROM KhuyenMaiChiTiet WHERE id = :id");
                query.setParameter("id", id);
                check = query.executeUpdate();
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally {
            return check > 0;
        }
    }

    public static void main(String[] args) {
//        List<KhuyenMaiChiTiet> list = new KhuyenMaiChiTietRepository().getAll();
//        for (KhuyenMaiChiTiet khuyenMaiChiTiet : list) {
//            System.out.println(khuyenMaiChiTiet.toString());
//        }
//        KhuyenMaiChiTiet khuyenMaiChiTiet = new KhuyenMaiChiTietRepository().getOne("dfghj");
//        System.out.println(khuyenMaiChiTiet.toString());
//        KhuyenMai khuyenMai = new KhuyenMai();
//        khuyenMai.setId("0D473A3E-3B37-4CC8-A75D-E5AB862E1DF3");
//        MonAn monAn = new MonAn();
//        monAn.setId("ABC304A9-8D7C-4FF9-A91A-DA47E16E70D2");
//        KhuyenMaiChiTiet khuyenMaiChiTiet = new KhuyenMaiChiTiet();
//        khuyenMaiChiTiet.setGiaTriKhuyenMai(BigDecimal.valueOf(10));
//        khuyenMaiChiTiet.setKhuyenMai(khuyenMai);
//        khuyenMaiChiTiet.setMonAn(monAn);
//        khuyenMaiChiTiet.setThoiGianBatDau(Date.valueOf("2003-11-29"));
//        khuyenMaiChiTiet.setThoiGianKetThuc(Date.valueOf("2004-11-30"));
//        boolean add = new KhuyenMaiChiTietRepository().remove("8537CDFD-5966-4343-805C-1E304CAD03A9");
//        System.out.println(add);
    }
}
