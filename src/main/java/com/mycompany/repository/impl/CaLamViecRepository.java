/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.impl;

import com.mycompany.domainModel.CaLamViec;
import com.mycompany.domainModel.NhanVien;
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
public class CaLamViecRepository implements ICommonRepository<CaLamViec, Boolean, String> {

    @Override
    public List<CaLamViec> getAll() {
        List<CaLamViec> listCaLamViec = new ArrayList<>();
        try ( Session session = HibernateUtil.getFactory().openSession()) {
            Query query = session.createQuery("FROM CaLamViec");
            listCaLamViec = query.getResultList();
        }
        return listCaLamViec;
    }

    @Override
    public CaLamViec getOne(String id) {
        CaLamViec caLamViec = new CaLamViec();
        try ( Session session = HibernateUtil.getFactory().openSession()) {
            Query query = session.createQuery("FROM CaLamViec WHERE id = :id");
            query.setParameter("id", id);
            caLamViec = (CaLamViec) query.getSingleResult();
        } finally {
            return caLamViec;
        }
    }

    @Override
    public Boolean add(CaLamViec kh) {
        boolean isAdd = false;
        try ( Session session = HibernateUtil.getFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            try {
                session.save(kh);
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
    public Boolean update(CaLamViec caLamViec, String id) {
        int check = 0;
        try ( Session session = HibernateUtil.getFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            try {
                Query query = session.createQuery("UPDATE CaLamViec SET nhanVien = :nv,"
                        + "thoiGianBD = :tgianBD, thoiGianKT = :tgianKT,"
                        + "tienDauCa = :tienDauCa, tienMatTaiQuan = :tienMatTaiQuan,"
                        + "tienNhoThuHo = :tienNhoThuHo, ghiChu = :ghiChu"
                        + " WHERE id = :id");
                query.setParameter("nv", caLamViec.getNhanVien());
                query.setParameter("tgianBD", caLamViec.getThoiGianBD());
                query.setParameter("tgianKT", caLamViec.getThoiGianKT());
                query.setParameter("tienDauCa", caLamViec.getTienDauCa());
                query.setParameter("tienMatTaiQuan", caLamViec.getTienMatTaiQuan());
                query.setParameter("tienNhoThuHo", caLamViec.getTienNhoThuHo());
                query.setParameter("ghiChu", caLamViec.getGhiChu());
                query.setParameter("id", id);
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
    public Boolean remove(String id) {
        int check = 0;
        try ( Session session = HibernateUtil.getFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            try {
                Query query = session.createQuery("DELETE FROM CaLamViec WHERE id = :id");
                query.setParameter("id", id);
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
//        CaLamViec caLamViec = new CaLamViecRepository().getOne("fds");
//        System.out.println(caLamViec);
//        NhanVien nhanVien = new NhanVien();
//        nhanVien.setId("00CAC64D-603B-452F-A68F-CD1A041D2EC7");
//        CaLamViec caLamViec = new CaLamViec();
//        caLamViec.setGhiChu("ghi chusrtghnjkmedrfgtyhuijk");
//        caLamViec.setNhanVien(nhanVien);
//        caLamViec.setThoiGianBD(Date.valueOf("2003-11-29"));
//        caLamViec.setThoiGianKT(Date.valueOf("2003-11-29"));
//        caLamViec.setTienDauCa(BigDecimal.valueOf(100));
//        caLamViec.setTienMatTaiQuan(BigDecimal.valueOf(500));
//        caLamViec.setTienNhoThuHo(BigDecimal.valueOf(200));
//        boolean aadd = new CaLamViecRepository().update(caLamViec, "683E3266-FB37-46C7-9635-B0867B84D5EB");
//        System.out.println(aadd);

        boolean remove = new CaLamViecRepository().remove("683E3266-FB37-46C7-9635-B0867B84D5EB");
        System.out.println(remove);
        List<CaLamViec> list = new CaLamViecRepository().getAll();
        for (CaLamViec caLamViec1 : list) {
            System.out.println(caLamViec1.toString());
        }
    }

}
