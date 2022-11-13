/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hibernateUtil;

import com.mycompany.domainModel.Ban;
import com.mycompany.domainModel.ChiTietComBo;
import com.mycompany.domainModel.ChucVu;
import com.mycompany.domainModel.ComBo;
import com.mycompany.domainModel.DanhMuc;
import com.mycompany.domainModel.GiaoDich;
import com.mycompany.domainModel.HoaDon;
import com.mycompany.domainModel.HoaDonChiTiet;
import com.mycompany.domainModel.KhachHang;
import com.mycompany.domainModel.KhuVuc;
import com.mycompany.domainModel.KhuyenMai;
import com.mycompany.domainModel.KhuyenMaiChiTiet;
import com.mycompany.domainModel.MonAn;
import com.mycompany.domainModel.NhanVien;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Duongntt
 */
public class HibernateUtil {

    //khai báo ssF:
private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=DuAn1Nhom102");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "123123");
        properties.put(Environment.SHOW_SQL, "true");
//        properties.put(Environment.HBM2DDL_AUTO, "create"); // tu dong tao ra cac truong trong sql

        conf.setProperties(properties);

        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        conf.addAnnotatedClass(Ban.class);
        conf.addAnnotatedClass(ChiTietComBo.class);
        conf.addAnnotatedClass(ChucVu.class);
        conf.addAnnotatedClass(ComBo.class);
        conf.addAnnotatedClass(HoaDon.class);
        conf.addAnnotatedClass(HoaDonChiTiet.class);
        conf.addAnnotatedClass(KhachHang.class);
        conf.addAnnotatedClass(KhuyenMai.class);
        conf.addAnnotatedClass(KhuyenMaiChiTiet.class);
        conf.addAnnotatedClass(MonAn.class);
        conf.addAnnotatedClass(NhanVien.class);
        conf.addAnnotatedClass(KhuVuc.class);
        conf.addAnnotatedClass(DanhMuc.class);
        conf.addAnnotatedClass(GiaoDich.class);
        

        FACTORY = conf.buildSessionFactory(registry);
    }

    public static SessionFactory getFactory() {
        return FACTORY;
    }

    public static void main(String[] args) {
        getFactory();
    }
}
