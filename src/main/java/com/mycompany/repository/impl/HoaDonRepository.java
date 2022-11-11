/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.impl;

import com.mycompany.domainModel.HoaDon;
import com.mycompany.domainModel.KhachHang;
import com.mycompany.domainModel.NhanVien;
import com.mycompany.hibernateUtil.HibernateUtil;
import com.mycompany.repository.ICommonRepository;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Admin
 */
public class HoaDonRepository implements ICommonRepository<HoaDon, Boolean, String> {

    private static final Session session = HibernateUtil.getFactory().openSession();
    private String fromTable = "FROM HoaDon ";

    @Override
    public List<HoaDon> getAll() {
        String hql = fromTable + "WHERE trangThai = 0";
        Query query = session.createQuery(hql);
        List<HoaDon> hoaDons = query.getResultList();
        return hoaDons;
    }

    @Override
    public HoaDon getOne(String ma) {
        String hql = fromTable + "WHERE trangThai = 0 AND maHoaDon = :ma";
        Query query = session.createQuery(hql);
        query.setParameter("ma", ma);
        HoaDon hd = (HoaDon) query.getSingleResult();
        return hd;
    }

    @Override
    public Boolean add(HoaDon kh) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(kh);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();;
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean update(HoaDon kh, String ma) {
        String hql = "UPDATE " + fromTable + "SET nhanVien = :nhanVien, khachHang = :khachHang, ngayTao = :ngayTao, ngayThanhToan = :ngayThanhToan, "
                + "tongTien = :tongTien, hinhThucThanhToan = :hinhThucThanhToan, tienKhachdua = :tienKhachDua, ghiTru = :ghiTru "
                + "WHERE maHoaDon = :maHoaDon";
        Transaction transaction = null;
        int check = 0;
        try {
            transaction = session.beginTransaction();
            session.clear();
            Query query = session.createQuery(hql);
            query.setParameter("nhanVien", kh.getNhanVien());
            query.setParameter("khachHang", kh.getKhachHang());
            query.setParameter("ngayTao", kh.getNgayTao());
            query.setParameter("ngayThanhToan", kh.getNgayThanhToan());
            query.setParameter("tongTien", kh.getTongTien());
            query.setParameter("hinhThucThanhToan", kh.getHinhThucThanhToan());
            query.setParameter("tienKhachDua", kh.getTienKhachDua());
            query.setParameter("ghiTru", kh.getGhiChu());
            query.setParameter("maHoaDon", ma);
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
                + "WHERE maHoaDon = :maHoaDon";
        Transaction transaction = null;
        int check = 0;
        try {
            transaction = session.beginTransaction();
            session.clear();
            Query query = session.createQuery(hql);
            query.setParameter("maHoaDon", ma);
            check = query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return check > 0;
    }
    public static void main(String[] args) {
        NhanVien nv = new NhanVien();
        nv.setId("E26EFCD1-8F31-446A-B791-5A11F3ED0C2A");
        KhachHang kh = new KhachHang();
        kh.setId("09D9DF89-6F3E-4DD1-8B1E-55E1835F3CEC");
        HoaDon hd = new  HoaDon(null, "HD02", nv, kh, Date.valueOf("2022-11-11"),Date.valueOf("2022-11-11"), BigDecimal.valueOf(300000), "Tiền mặt", BigDecimal.valueOf(500000), "HIiii", 0);
        Boolean test = new HoaDonRepository().add(hd);
        System.out.println(test);
    }

}
