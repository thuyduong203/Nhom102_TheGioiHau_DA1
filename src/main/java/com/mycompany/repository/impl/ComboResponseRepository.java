/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.impl;

import com.mycompany.customModel.ComboResponse;
import com.mycompany.hibernateUtil.HibernateUtil;
import com.mycompany.repository.ICommonResponseRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class ComboResponseRepository implements ICommonResponseRepository<ComboResponse> {

    private static final Session session = HibernateUtil.getFactory().openSession();
    private String fromTable = " FROM ComBo CB ";

    @Override
    public List<ComboResponse> getAll() {
        String hql = "SELECT new com.mycompany.customModel.ComboResponse(CB.maCB,CB.tenCB,CB.donGia)" + fromTable;
        Query query = session.createQuery(hql);
        List<ComboResponse> comboResponses = query.getResultList();
        return comboResponses;
    }
    public static void main(String[] args) {
        List<ComboResponse> comboResponses = new ComboResponseRepository().getAll();
        for (ComboResponse comboResponse : comboResponses) {
            System.out.println(comboResponse.toString());
        }
    }

}
