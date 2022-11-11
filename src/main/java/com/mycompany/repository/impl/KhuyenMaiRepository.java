/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.impl;

import com.mycompany.domainModel.KhuyenMai;
import com.mycompany.domainModel.NhanVien;
import com.mycompany.hibernateUtil.HibernateUtil;
import com.mycompany.repository.ICommonRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Duongntt
 */
public class KhuyenMaiRepository implements ICommonRepository<KhuyenMai, Boolean, String> {

    @Override
    public List<KhuyenMai> getAll() {
        List<KhuyenMai> listKM = new ArrayList<>();
        try ( Session session = HibernateUtil.getFactory().openSession()) {
            Query query = session.createQuery("FROM KhuyenMai");
            listKM = query.getResultList();
        }
        return listKM;
    }

    @Override
    public KhuyenMai getOne(String ma) {
        try ( Session session = HibernateUtil.getFactory().openSession()) {
            Query query = session.createQuery("FROM KhuyenMai WHERE maKhuyenMai = :maKM");
            query.setParameter("maKM", ma);
            KhuyenMai khuyenMai = (KhuyenMai) query.getSingleResult();
            return khuyenMai;
        }
    }

    @Override
    public Boolean add(KhuyenMai km) {
        boolean isAdd = false;
        try ( Session session = HibernateUtil.getFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            try {
                session.save(km);
                transaction.commit();
                isAdd = true;
            } catch (Exception e) {
                e.printStackTrace();
                transaction.rollback();
            }
        } finally {
            return isAdd;
        }
    }

    @Override
    public Boolean update(KhuyenMai km, String ma) {
        int check = 0;
        try ( Session session = HibernateUtil.getFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            try {
                Query query = session.createQuery("UPDATE KhuyenMai SET "
                        + "nhanVien = :nvTaoKM, tenKhuyenMai = :tenKM,"
                        + "loaiKhuyenMai = :loaiKM, ghiChu = :ghiChuKM,"
                        + "trangThai = :trangThaiKM WHERE maKhuyenMai = :maKM");
                query.setParameter("nvTaoKM", km.getNhanVien());
                query.setParameter("tenKM", km.getTenKhuyenMai());
                query.setParameter("loaiKM", km.getLoaiKhuyenMai());
                query.setParameter("ghiChuKM", km.getGhiChu());
                query.setParameter("trangThaiKM", km.getTrangThai());
                query.setParameter("maKM", ma);
                check = query.executeUpdate();
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
                transaction.rollback();
            }
        } finally {
            return check > 0;
        }
    }

    @Override
    public Boolean remove(String ma) {
        int check = 0;
        try ( Session session = HibernateUtil.getFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            try {
                Query query = session.createQuery("DELETE FROM KhuyenMai WHERE maKhuyenMai = :maKM");
                query.setParameter("maKM", ma);
                check = query.executeUpdate();
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
                transaction.rollback();
            }
        } finally {
            return check > 0;
        }
    }

    public static void main(String[] args) {
        NhanVien nhanVien = new NhanVien();
        nhanVien.setId("00CAC64D-603B-452F-A68F-CD1A041D2EC7");
        KhuyenMai khuyenMai = new KhuyenMai();
        khuyenMai.setGhiChu("ghi chú");
        khuyenMai.setLoaiKhuyenMai("loại km updateeee");
        khuyenMai.setMaKhuyenMai("KM1");
        khuyenMai.setNhanVien(nhanVien);
        khuyenMai.setTenKhuyenMai("khuyến mãi 1");
        khuyenMai.setTrangThai(1);
        boolean add = new KhuyenMaiRepository().add(khuyenMai);
        System.out.println(add);
//        KhuyenMai khuyenMai1 = new KhuyenMaiRepository().getOne("KM1");
//        System.out.println(khuyenMai1.toString());
    }
}
