/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.impl;

import com.mycompany.domainModel.GiaoDich;
import com.mycompany.hibernateUtil.HibernateUtil;
import com.mycompany.repository.ICommonRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author son45
 */
public class GiaoDichRepository implements ICommonRepository<GiaoDich, Boolean, String> {

    @Override
    public List<GiaoDich> getAll() {
        try ( Session session = HibernateUtil.getFactory().openSession()) {
            String hql = "FROM GiaoDich";
            Query query = session.createQuery(hql);
            List<GiaoDich> list = query.getResultList();
            return list;
        }
    }

    @Override
    public GiaoDich getOne(String ma) {
        try ( Session session = HibernateUtil.getFactory().openSession()) {
            String hql = "FROM GiaoDich WHERE idGiaoDich = :IdGiaoDich";
            Query query = session.createQuery(hql);
            query.setParameter("IdGiaoDich", ma);
            GiaoDich list = (GiaoDich) query.getSingleResult();
            return list;
        }
    }

    @Override
    public Boolean add(GiaoDich kh
    ) {
        try ( Session session = HibernateUtil.getFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.save(kh);
                transaction.commit();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                transaction.rollback();
                return false;
            }
        }
    }

    @Override
    public Boolean update(GiaoDich kh, String ma
    ) {
        try ( Session session = HibernateUtil.getFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            String hql = "UPDATE GiaoDich SET "
                    + " hoaDon = :Hoadon"
                    + " hinhThucThanhToan = :HinhThucThanhToan"
                    + " soTienThanhToan = SoTienThanhToan"
                    + " WHERE idGiaoDich = :IdGiaoDich";
            try {
                Query qr = session.createQuery(hql);
                qr.setParameter("Hoadon", kh.getHoaDon());
                qr.setParameter("HinhThucThanhToan", kh.getHinhThucThanhToan());
                qr.setParameter("SoTienThanhToan", kh.getSoTienThanhToan());
                qr.setParameter("IdGiaoDich", ma);
                transaction.commit();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                transaction.rollback();
                return false;
            }
        }
    }

    @Override
    public Boolean remove(String ma
    ) {
        try ( Session session = HibernateUtil.getFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            String hql = "DELETE GiaoDich"
                    + " WHERE idGiaoDich = :IdGiaoDich";
            try {
                Query qr = session.createQuery(hql);
                qr.setParameter("IdGiaoDich", ma);
                transaction.commit();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                transaction.rollback();
                return false;
            }
        }
    }

    public static void main(String[] args) {
        GiaoDich gd = new GiaoDich();
        GiaoDich d = new GiaoDichRepository().getOne(gd.getIdGiaoDich());
        System.out.println(d);
    }

}
