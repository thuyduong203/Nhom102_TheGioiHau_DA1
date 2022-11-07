/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hibernateUtil;

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
    private final static SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();
        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "12123");
        properties.put(Environment.SHOW_SQL, true);
        conf.setProperties(properties);
//        conf.addAnnotatedClass(ChucVu.class);
//        conf.addAnnotatedClass(DongSP.class);
//        conf.addAnnotatedClass(ChiTietSP.class);
//        conf.addAnnotatedClass(MauSac.class);
//        conf.addAnnotatedClass(SanPham.class);
//        conf.addAnnotatedClass(NSX.class);
//        conf.addAnnotatedClass(CuaHang.class);
//        conf.addAnnotatedClass(GioHang.class);
//        conf.addAnnotatedClass(GioHangChiTiet.class);
//        conf.addAnnotatedClass(HoaDon.class);
//        conf.addAnnotatedClass(HoaDonChiTiet.class);
//        conf.addAnnotatedClass(KhachHang.class);
//        conf.addAnnotatedClass(NhanVien.class);
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);
    }

    public static SessionFactory getSSFactory() {
        return FACTORY;
    }

    public static void main(String[] args) {
        System.out.println(getSSFactory());
    }
}
