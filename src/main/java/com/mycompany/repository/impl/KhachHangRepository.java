/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.impl;

import com.mycompany.domainModel.KhachHang;
import com.mycompany.hibernateUtil.HibernateUtil;
import java.sql.Date;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.mycompany.repository.ICommonRepository;

/**
 *
 * @author Admin
 */
public class KhachHangRepository implements ICommonRepository<KhachHang, Boolean, String> {

    private static final Session session = HibernateUtil.getFactory().openSession();
    private String fromTable = "FROM KhachHang ";

    @Override
    public List<KhachHang> getAll() {
        String hql = fromTable;
        Query query = session.createQuery(hql);
        List<KhachHang> khachHangs = query.getResultList();
        return khachHangs;
    }

    @Override
    public KhachHang getOne(String ma) {
        String hql = fromTable + "WHERE ma = :ma and trangThai = 0";
        Query query = session.createQuery(hql);
        KhachHang kh = (KhachHang) query.getSingleResult();
        return kh;
    }

    @Override
    public Boolean add(KhachHang kh) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(kh);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean update(KhachHang kh, String ma) {
        String hql = "UPDATE KhachHang SET ho = :ho, tenDem = :tenDem, ten = :ten, gioiTinh = :gioiTinh, ngaySinh = :ngaySinh, "
                + "sdt = :sdt, diaChi = :diaChi, thanhPho = :thanhPho, quocGia = :quocGia, trangThai = :trangThai "
                + "WHERE ma = :ma";
        int check = 0;
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.clear();
            Query query = session.createQuery(hql);
            query.setParameter("ho", kh.getHo());
            query.setParameter("tenDem", kh.getTenDem());
            query.setParameter("ten", kh.getTen());
            query.setParameter("gioiTinh", kh.getGioiTinh());
            query.setParameter("ngaySinh", kh.getNgaySinh());
            query.setParameter("sdt", kh.getSdt());
            query.setParameter("diaChi", kh.getDiaChi());
            query.setParameter("thanhPho", kh.getThanhPho());
            query.setParameter("quocGia", kh.getQuocGia());
            query.setParameter("trangThai", kh.getTrangThai());
            query.setParameter("ma", ma);
            check = query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public Boolean remove(String ma) {
        String hql = "UPDATE " + fromTable + "SET trangThai = 1"
                + "WHERE ma = :ma";
        int check = 0;
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery(hql);
            query.setParameter("ma", ma);
            check = query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return check > 0;
    }

}
