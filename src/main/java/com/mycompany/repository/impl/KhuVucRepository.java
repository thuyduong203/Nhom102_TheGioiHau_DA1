/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.impl;

import com.mycompany.domainModel.KhuVuc;
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
public class KhuVucRepository implements ICommonRepository<KhuVuc, Boolean, String> {

    @Override
    public List<KhuVuc> getAll() {
        List<KhuVuc> listKV = new ArrayList<>();
        try ( Session session = HibernateUtil.getFactory().openSession()) {
            Query query = session.createQuery("FROM KhuVuc WHERE trangThai = 0");
            listKV = query.getResultList();
        } finally {
            return listKV;
        }
    }

    @Override
    public KhuVuc getOne(String ma) {
        KhuVuc khuVuc = new KhuVuc();
        try ( Session session = HibernateUtil.getFactory().openSession()) {
            Query query = session.createQuery("FROM KhuVuc WHERE maKV = :ma");
            query.setParameter("ma", ma);
            khuVuc = (KhuVuc) query.getSingleResult();
        } finally {
            return khuVuc;
        }
    }

    @Override
    public Boolean add(KhuVuc kv) {
        boolean isAdd = false;
        try ( Session session = HibernateUtil.getFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            try {
                session.save(kv);
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
    public Boolean update(KhuVuc kh, String ma) {
        int check = 0;
        try ( Session session = HibernateUtil.getFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            try {
                Query query = session.createQuery("UPDATE KhuVuc SET "
                        + "tenKV = :tenKhuVuc, trangThai = :trangThaiKV "
                        + "WHERE maKV = :ma");
                query.setParameter("tenKhuVuc", kh.getTenKV());
                query.setParameter("trangThaiKV", kh.getTrangThai());
                query.setParameter("ma", ma);
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
                Query query = session.createQuery("DELETE FROM KhuVuc WHERE maKV = :ma");
                query.setParameter("ma", ma);
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
        KhuVuc khuVuc = new KhuVuc();
        khuVuc.setMaKV("KV1");
        khuVuc.setTenKV("Khu vực 12222");
        khuVuc.setTrangThai(1);
        boolean add = new KhuVucRepository().remove("KV1");
        System.out.println(add);
        List<KhuVuc> list = new KhuVucRepository().getAll();
        for (KhuVuc khuVuc1 : list) {
            System.out.println(khuVuc1.toString());
        }
        KhuVuc kv = new KhuVucRepository().getOne("KV1");
        System.out.println(kv.toString());
    }
}
