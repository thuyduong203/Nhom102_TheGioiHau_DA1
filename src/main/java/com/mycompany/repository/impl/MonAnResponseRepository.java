/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.impl;

import com.mycompany.customModel.MonAnResponse;
import com.mycompany.hibernateUtil.HibernateUtil;
import com.mycompany.repository.ICommonResponseRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class MonAnResponseRepository implements ICommonResponseRepository<MonAnResponse> {

    private static final Session session = HibernateUtil.getFactory().openSession();
    private String fromTable = " FROM MonAn MA WHERE trangThai = 1";

    @Override
    public List<MonAnResponse> getAll() {
        String hql = "SELECT new com.mycompany.customModel.MonAnResponse(MA.maMonAn,MA.tenMonAn,MA.donGia,MA.donViTinh,MA.loai.tenDanhMuc)" + fromTable;
        Query query = session.createQuery(hql);
        List<MonAnResponse> monAnResponses = query.getResultList();
        return monAnResponses;
    }

    public static void main(String[] args) {
        List<MonAnResponse> test = new MonAnResponseRepository().getAll();
        for (MonAnResponse monAnResponse : test) {
            System.out.println(test);
        }
    }

}
