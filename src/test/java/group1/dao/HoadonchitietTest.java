package group1.dao;
//TO DO: Done
import org.apache.http.util.Asserts;
import org.junit.jupiter.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;

import group1.dao.ChiTietDonHangDAO;
import group1.dao.HoaDonChiTietDAO;
import group1.entity.ChiTietDonHang;
import group1.entity.HoaDonChiTiet;
import group1.entity.NhanVien;
import group1.dao.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class HoadonchitietTest {

    @Test
    public void TestCases01() {

        // TC01
        // thêm 1 sản phẩm vào hóa đơn
        // Đơn hàng đang được tạo gồm 1 sản phẩm
        ChiTietDonHang ChiTiet = new ChiTietDonHang();
        ChiTiet.setMaChiTietDH(100);
        ChiTiet.setMaHD("HD12324");
        ChiTiet.setTenSP("Trà Ô Long Dừa");
        ChiTiet.setSoLuong(2);
        ChiTiet.setGia(45000.0);
        // Assert
        ChiTietDonHangDAO DAO = new ChiTietDonHangDAO();

        int sizeBefore = DAO.selectAll().size();
        DAO.insert(ChiTiet);

        List<ChiTietDonHang> list = DAO.selectAll();
        Assert.assertNotEquals(list.size(), sizeBefore);
        System.out.println(list.size());
    }

    @Test
    public void Testcases02() {
        // thêm nhiều sản phẩm
        // Đơn hàng được tạo gồm nhiều sản phẩm
        ChiTietDonHangDAO DAO = new ChiTietDonHangDAO();
        ChiTietDonHang chitiet = new ChiTietDonHang();
        int sizeBefore = DAO.selectAll().size();
        chitiet.setMaChiTietDH(102);
        chitiet.setMaHD("HD12373");
        chitiet.setTenSP("Capuchino");
        chitiet.setSoLuong(3);
        chitiet.setGia(55000.0);
        DAO.insert(chitiet);

        ChiTietDonHang chitiet1 = new ChiTietDonHang();
        chitiet1.setMaChiTietDH(102);
        chitiet1.setMaHD("HD12373");
        chitiet1.setTenSP("Capuchino");
        chitiet1.setSoLuong(3);
        chitiet1.setGia(55000.0);
        DAO.insert(chitiet1);

        ChiTietDonHang chitiet3 = new ChiTietDonHang();
        chitiet3.setMaChiTietDH(102);
        chitiet3.setMaHD("HD12373");
        chitiet3.setTenSP("Capuchino");
        chitiet3.setSoLuong(3);
        chitiet3.setGia(55000.0);
        DAO.insert(chitiet3);

        List<ChiTietDonHang> list = DAO.selectAll();
        Assert.assertNotEquals(list.size(), sizeBefore);
        System.out.println(list.size());
    }

    @Test
    public void testDelete() {
        HoaDonChiTietDAO CT = new HoaDonChiTietDAO();
        List Expected = new ArrayList();
        CT.delete("HD12377");
        List<HoaDonChiTiet> list = CT.selectByMaHD("HD12377");
        Assertions.assertEquals(list, Expected);
    }

    @Test
    public void testcases4() {
        HoaDonChiTietDAO CT = new HoaDonChiTietDAO();
        List Expected = new ArrayList();
        CT.delete("HD12377");
        CT.delete("HD12378");
        List<HoaDonChiTiet> list = CT.selectByMaHD("HD12377");
        List<HoaDonChiTiet> list1 = CT.selectByMaHD("HD12378");
        Assertions.assertEquals(list, Expected);
        Assertions.assertEquals(list1, Expected);
    }

    @Test
    public void testCases5() {
        // Sua san pham
        ChiTietDonHangDAO DAO = new ChiTietDonHangDAO();
        ChiTietDonHang chitiet = new ChiTietDonHang();
        chitiet.setMaChiTietDH(102);
        chitiet.setMaHD("HD12373");
        chitiet.setTenSP("Capuchino");
        chitiet.setSoLuong(3);
        chitiet.setGia(55000.0);
        DAO.update(chitiet);
        List<ChiTietDonHang> updated = DAO.selectByDonHang("HD12373");
        if (!updated.isEmpty()) {
            Assert.assertEquals(updated.get(0).getTenSP(), "Capuchino");
        }
    }

    @Test
    public void testcases6() {
        // sữa nhiều sản phẩm
        ChiTietDonHangDAO DAO = new ChiTietDonHangDAO();
        int sizeBefore = DAO.selectAll().size();

        ChiTietDonHang chitiet1 = new ChiTietDonHang();
        chitiet1.setMaChiTietDH(102);
        chitiet1.setMaHD("HD12373");
        chitiet1.setTenSP("Capuchino");
        chitiet1.setSoLuong(3);
        chitiet1.setGia(55000.0);
        DAO.update(chitiet1);

        ChiTietDonHang chitiet2 = new ChiTietDonHang();
        chitiet2.setMaChiTietDH(102);
        chitiet2.setMaHD("HD12373");
        chitiet2.setTenSP("Capuchino");
        chitiet2.setSoLuong(3);
        chitiet2.setGia(55000.0);
        DAO.update(chitiet2);

        ChiTietDonHang chitiet3 = new ChiTietDonHang();
        chitiet3.setMaChiTietDH(102);
        chitiet3.setMaHD("HD12373");
        chitiet3.setTenSP("Capuchino");
        chitiet3.setSoLuong(3);
        chitiet3.setGia(55000.0);
        DAO.update(chitiet3);

        List<ChiTietDonHang> updated = DAO.selectByDonHang("HD12373");
        if (!updated.isEmpty()) {
            Assert.assertEquals(updated.get(0).getTenSP(), "Capuchino");
        }
        
    }

    @Test
    public void testcases7() {
        // tìm kiếm hóa đơn
        int hoadon = 25;
        ChiTietDonHangDAO DAO = new ChiTietDonHangDAO();
        List<ChiTietDonHang> list = DAO.selectAll();
        int out = list.size();
        Assert.assertEquals(out, hoadon);
        System.out.println(out);

    }

}