/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.impl;

import com.mycompany.domainModel.ChiTietComBo;
import com.mycompany.domainModel.ComBo;
import com.mycompany.domainModel.MonAn;
import com.mycompany.hibernateUtil.HibernateUtil;
import com.mycompany.repository.IChiTietComBoRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Admin
 */
public class ChiTietComBoRepository implements IChiTietComBoRepository<ChiTietComBo, Boolean,Integer, ComBo, MonAn> {

    private static final Session session = HibernateUtil.getFactory().openSession();
    private String fromTable = "FROM ChiTietComBo ";

    @Override
    public List<ChiTietComBo> getAll() {
        Query query = session.createQuery(fromTable);
        List<ChiTietComBo> chiTietComBos = query.getResultList();
        return chiTietComBos;
    }

    @Override
    public Boolean add(ChiTietComBo ctcb) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(ctcb);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean update(ChiTietComBo chiTietComBo, ComBo comBo, MonAn monAn) {
        String hql = "UPDATE " + fromTable + "SET soLuongMonAn = :soLuongMonAn "
                + "WHERE comBo = :comBo AND monAn = :monAn";
        Transaction transaction = null;
        int check = 0;
        try {
            transaction = session.beginTransaction();
            session.clear();
            Query query = session.createQuery(hql);
            query.setParameter("soLuongMonAn", chiTietComBo.getSoLuongMonAn());
            query.setParameter("comBo", comBo);
            query.setParameter("monAn", monAn);
            query.setParameter("soLuongMonAn", chiTietComBo.getSoLuongMonAn());
            check = query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return check > 0;

    }

    @Override
    public Boolean remove(ChiTietComBo ctcb, ComBo comBo,MonAn monAn) {
        String hql = "DELETE " + fromTable
                + "WHERE comBo = :comBo AND monAn = :monAn and soLuongMonAn = :soLuongMonAn";
        Transaction transaction = null;
        int check = 0;
        try {
            transaction = session.beginTransaction();
            session.clear();
            Query query = session.createQuery(hql);
            query.setParameter("comBo", comBo);
            query.setParameter("monAn", monAn);
            query.setParameter("soLuongMonAn", ctcb.getSoLuongMonAn());
            check = query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return check > 0;
    }
    public static void main(String[] args) {
        MonAn ma = new MonAn();
        ma.setId("F140701F-1D94-49E6-97EC-46CDAB6D9EC6");
        ComBo comBo = new ComBo();
        comBo.setId("E791ED65-7819-44F0-BFF3-BEE9795F6E5D");
        ChiTietComBo ctcb = new ChiTietComBo(null, comBo, ma, 10);
        Boolean test = new ChiTietComBoRepository().update(ctcb,comBo,ma);
        System.out.println(test);
    }
}
