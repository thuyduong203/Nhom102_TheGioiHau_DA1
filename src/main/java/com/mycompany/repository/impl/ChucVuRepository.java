/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.impl;

import com.mycompany.domainModel.ChucVu;
import com.mycompany.hibernateUtil.HibernateUtil;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.mycompany.repository.ICommonRepository;

/**
 *
 * @author Admin
 */
public class ChucVuRepository implements ICommonRepository<ChucVu, Boolean, String> {

    private static final Session session = HibernateUtil.getFactory().openSession();
    private String fromTable = "FROM ChucVu ";

    @Override
    public List<ChucVu> getAll() {
        String hql = fromTable +"WHERE trangThai = 0";
        Query query = session.createQuery(hql);
        List<ChucVu> chucVus = query.getResultList();
        return chucVus;
    }

    @Override
    public ChucVu getOne(String ma) {
        String hql = fromTable + "WHERE ma =:ma";
        Query query = session.createQuery(hql);
        query.setParameter("ma", ma);
        ChucVu cv = (ChucVu) query.getSingleResult();
        return cv;
    }

    @Override
    public Boolean add(ChucVu kh) {
        Transaction transaction = null;
        try {
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
    public Boolean update(ChucVu kh, String ma) {
        Transaction transaction = null;
        String hql = "UPDATE " + fromTable + "SET ten = :ten "
                + "WHERE ma = :ma";
        int check = 0;
        try {
            transaction = session.beginTransaction();
            session.clear();
            Query query = session.createQuery(hql);
            query.setParameter("ten", kh.getTen());
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
                + "WHERE ma = :ma";
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

}
