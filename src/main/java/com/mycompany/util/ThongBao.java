/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.util;

/**
 *
 * @author Duongntt
 */
public class ThongBao {

    public String thongBaoADD(boolean isAdd) {
        if (isAdd) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    public String thongBaoUPDATE(boolean isUpdate) {
        if (isUpdate) {
            return "Cập nhật thành công";
        } else {
            return "Cập nhật thất bại";
        }
    }

    public String thongBaoDELETE(boolean isDelete) {
        if (isDelete) {
            return "Xoá thành công";
        } else {
            return "Xoá thất bại";
        }
    }
}
