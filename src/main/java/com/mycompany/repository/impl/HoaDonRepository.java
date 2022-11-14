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
        String hql = fromTable;
        Query query = session.createQuery(hql);
        List<HoaDon> hoaDons = query.getResultList();
        return hoaDons;
    }

    @Override
    public HoaDon getOne(String ma) {
        String hql = fromTable + "WHERE maHoaDon = :ma";
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
        String hql = "UPDATE " + fromTable + "SET nhanVien = :nhanVien, khachHang = :khachHang,ban = :ban, ngayTao = :ngayTao, ngayThanhToan = :ngayThanhToan, "
                + "tongTien = :tongTien, ghiChu = :ghiTru, trangThai = :trangThai "
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
            query.setParameter("ghiTru", kh.getGhiChu());
            query.setParameter("trangThai", kh.getTrangThai());
            query.setParameter("ban", kh.getBan());
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
        String hql = "UPDATE " + fromTable + "SET trangThai = 3"
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

//    public BigDecimal getTongTien1HD(HoaDon hoaDon) {
//        BigDecimal tongHD = BigDecimal.valueOf(0);
//        try ( Session session = HibernateUtil.getFactory().openSession()) {
//            String hql = "SELECT ((SUM(hdct.SoLuongMonAn * hdct.DonGiaMonAn)) + (SUM(hdct.SoLuongCombo * hdct.DonGiaCombo))) \n"
//                    + "FROM Hoa_Don_Chi_Tiet hdct WHERE hdct.IdHD = :idHoaDon";
//            Query query = session.createQuery(hql);
//            query.setParameter("idHoaDon", hoaDon.getId());
//          
//        } finally {
//            return tongHD;
//        }
//    }
    public static void main(String[] args) {
        NhanVien nv = new NhanVien();
        nv.setId("E26EFCD1-8F31-446A-B791-5A11F3ED0C2A");
//        KhachHang kh = new KhachHang();
//        kh.setId("09D9DF89-6F3E-4DD1-8B1E-55E1835F3CEC");
        // HoaDon hd = new  HoaDon(null, "HD02", nv, kh, Date.valueOf("2022-11-11"),Date.valueOf("2022-11-11"), BigDecimal.valueOf(300000), "Tiền mặt", BigDecimal.valueOf(500000), "HIiii", 0);

        HoaDon hoaDon = new HoaDonRepository().getOne("HD5");
        hoaDon.setTrangThai(3);
        Boolean test = new HoaDonRepository().update(hoaDon, "HD5");
        System.out.println(test);
    }
}
