/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.impl;

import com.mycompany.domainModel.ChucVu;
import com.mycompany.domainModel.NhanVien;
import com.mycompany.hibernateUtil.HibernateUtil;
import com.mycompany.repository.ICommonRepository;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Duongntt
 */
public class NhanVienRepository implements ICommonRepository<NhanVien, Boolean, String> {

    @Override
    public List<NhanVien> getAll() {
        //tajo lisst
        List<NhanVien> lisstNV = new ArrayList<>();
        //mowr ss
        try ( Session session = HibernateUtil.getFactory().openSession()) {
            Query query = session.createQuery("FROM NhanVien");
            lisstNV = query.getResultList();
        }
        return lisstNV;
    }

    @Override
    public NhanVien getOne(String ma) {
        try ( Session session = HibernateUtil.getFactory().openSession()) {
            Query query = session.createQuery("FROM NhanVien WHERE ma = :maNV");
            query.setParameter("maNV", ma);
            NhanVien nv = (NhanVien) query.getSingleResult();
            return nv;
        }
    }

    @Override
    public Boolean add(NhanVien nv) {
        boolean isAdd = false;
        try ( Session session = HibernateUtil.getFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            try {
                session.save(nv);
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
    public Boolean update(NhanVien nv, String ma) {
        int check = 0;
        try ( Session session = HibernateUtil.getFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            try {
                Query query = session.createQuery("UPDATE NhanVien SET chucVu = :chucVuNV,"
                        + " ho = :hoNV, tenDem = :tenDemNV, ten = :tenNV,"
                        + "gioiTinh = :gioiTinhNV, soDienThoai = :sdtNV, ngaySinh = :ngaySinhNV,"
                        + "diaChi = :diaChiNV, matKhau = :matKhauNV, trangThai = :trangThaiNV"
                        + " WHERE ma = :maNV");
                query.setParameter("chucVuNV", nv.getChucVu());
                query.setParameter("hoNV", nv.getHo());
                query.setParameter("tenDemNV", nv.getTenDem());
                query.setParameter("tenNV", nv.getTen());
                query.setParameter("gioiTinhNV", nv.getGioiTinh());
                query.setParameter("sdtNV", nv.getSoDienThoai());
                query.setParameter("ngaySinhNV", nv.getNgaySinh());
                query.setParameter("diaChiNV", nv.getDiaChi());
                query.setParameter("matKhauNV", nv.getMatKhau());
                query.setParameter("trangThaiNV", nv.getTrangThai());
                query.setParameter("maNV", ma);
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
                Query query = session.createQuery("DELETE FROM NhanVien WHERE ma = :maNV");
                query.setParameter("maNV", ma);
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
//        ChucVu chucVu = new ChucVu();
//        chucVu.setId("4FBC3358-868B-4CC6-A3DD-821199DF8EE3");
//        NhanVien nhanVien = new NhanVien();
//        nhanVien.setChucVu(chucVu);
//        nhanVien.setDiaChi("d");
//        nhanVien.setGioiTinh("nM");
//        nhanVien.setHo("họ");
//        nhanVien.setMa("NV2");
//        nhanVien.setMatKhau("123");
//        nhanVien.setNgaySinh(Date.valueOf("2003-11-29"));
//        nhanVien.setSoDienThoai("5678");
//        nhanVien.setTen("Tên");
//        nhanVien.setTenDem("tên đệm");
//        nhanVien.setTrangThai(1);
        NhanVien add = new NhanVienRepository().getOne("NV02");
        System.out.println(add);
    }
}
