/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.impl;

import com.mycompany.domainModel.Ban;
import com.mycompany.hibernateUtil.HibernateUtil;
import com.mycompany.repository.ICommon;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Admin
 */
public class BanRepository implements ICommon<Ban, Boolean, String> {

    private static final Session session = HibernateUtil.getFactory().openSession();
    private String fromTable = "FROM Ban ";

    @Override
    public List<Ban> getAll() {
        Query query = session.createQuery(fromTable);
        List<Ban> bans = query.getResultList();
        return bans;
    }

    @Override
    public Ban getOne(String ma) {
        String hql = fromTable + "WHERE maBan = :ma";
        Query query = session.createQuery(hql);
        query.setParameter("ma", Integer.valueOf(ma));
        Ban b = (Ban) query.getSingleResult();
        return b;
    }

    @Override
    public Boolean add(Ban kh) {
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
    public Boolean update(Ban kh, String ma) {
        String hql = "UPDATE " + fromTable + "SET soLuongChoNgoi = :soLuongChoNgoi "
                + "WHERE maBan = :ma";
        Transaction transaction = null;
        int check = 0;
        try {
            transaction = session.beginTransaction();
            session.clear();
            Query query = session.createQuery(hql);
            query.setParameter("soLuongChoNgoi", kh.getSoLuongChoNgoi());
            query.setParameter("ma", Integer.valueOf(ma));
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
        String hql = "DELETE " + fromTable
                + "WHERE maBan = :ma";
        Transaction transaction = null;
        int check = 0;
        try {
            transaction = session.beginTransaction();
            session.clear();
            Query query = session.createQuery(hql);
            query.setParameter("ma", Integer.valueOf(ma));
            check = query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return check > 0;
    }

}
