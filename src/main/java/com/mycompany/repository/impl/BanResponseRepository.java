/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.impl;

import com.mycompany.hibernateUtil.HibernateUtil;
import com.mycompany.repository.ICommonResponseRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class BanResponseRepository implements ICommonResponseRepository<BanResponseRepository> {

    private static final Session session = HibernateUtil.getFactory().openSession();
    private String fromTable = " FROM Ban B";

    @Override
    public List<BanResponseRepository> getAll() {
        String hql = "SELECT new com.mycompany.customModel.BanResponse(B.maBan,B.soLuongChoNgoi,B.kv.tenKV,B.trangThai)" + fromTable;
        Query query = session.createQuery(hql);
        List<BanResponseRepository> banResponses = query.getResultList();
        return banResponses;
    }

}
