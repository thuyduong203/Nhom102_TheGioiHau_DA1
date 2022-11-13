/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.impl;

import com.mycompany.domainModel.ComBo;
import com.mycompany.domainModel.NhanVien;
import com.mycompany.hibernateUtil.HibernateUtil;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.mycompany.repository.ICommonRepository;

/**
 *
 * @author Admin
 */
public class ComBoRepository implements ICommonRepository<ComBo, Boolean, String> {

    private static final Session session = HibernateUtil.getFactory().openSession();
    private String fromTable = "FROM ComBo ";

    @Override
    public List<ComBo> getAll() {
        String hql = fromTable +"WHERE trangThai = 0";
        Query query = session.createQuery(hql);
        List<ComBo> comBos = query.getResultList();
        return comBos;
    }

    @Override
    public ComBo getOne(String ma) {
        String hql = fromTable + "WHERE maCB = :ma";
        Query query = session.createQuery(hql);
        query.setParameter("ma", ma);
        ComBo cb = (ComBo) query.getSingleResult();
        return cb;
    }

    @Override
    public Boolean add(ComBo kh) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(kh);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean update(ComBo kh, String ma) {
        Transaction transaction = null;
        String hql = "UPDATE " + fromTable + "SET nhanVien = :nhanVien, tenCB = :ten, hinhAnh = :hinhAnh, donGia = :donGia "
                + "WHERE maCB = :ma";
        int check = 0;
        try {
            transaction = session.beginTransaction();
            session.clear();
            Query query = session.createQuery(hql);
            query.setParameter("nhanVien", kh.getNhanVien());
            query.setParameter("ten", kh.getTenCB());
            query.setParameter("hinhAnh", kh.getHinhAnh());
            query.setParameter("donGia", kh.getDonGia());
            query.setParameter("ma", ma);
            check = query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public Boolean remove(String ma) {
        Transaction transaction = null;
        String hql = "UPDATE " + fromTable +"SET trangThai = 1"
                + "WHERE maCB = :ma";
        int check = 0;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery(hql);
            query.setParameter("ma", ma);
            check = query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
    public static void main(String[] args) {
        NhanVien nv = new NhanVien();
        nv.setId("E26EFCD1-8F31-446A-B791-5A11F3ED0C2A");
        ComBo cb = new ComBo(null, nv, null, "bbbb", "aa", BigDecimal.valueOf(200), 0);
        ComBo test = new ComBoRepository().getOne("CB01");
        System.out.println(test);
    }
}
