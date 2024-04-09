package group1.dao;

import group1.entity.HoaDon;
import group1.dao.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HoaDonDAOTest {

    @Test
    public void testInsert() {
        HoaDonDAO hoaDonDAO = new HoaDonDAO();
        HoaDon hoaDon = new HoaDon();
        // Set the properties of hoaDon object
        hoaDon.setMaHD("HD001");
        hoaDon.setMaNV("hisu");
        hoaDon.setNgayTao(new Date());
        hoaDon.setTrangThai(true);
        hoaDon.setTongCong(1000.0f);

        hoaDonDAO.insert(hoaDon);

        // Retrieve the inserted hoaDon object
        HoaDon insertedHoaDon = hoaDonDAO.selectById("hisu");

        Assert.assertNotNull(insertedHoaDon);

    }

//    @Test
//    public void testUpdate() {
//        HoaDonDAO hoaDonDAO = new HoaDonDAO();
//        HoaDon hoaDon = new HoaDon();
//        // Set the properties of hoaDon object
//        hoaDon.setMaHD("HD001");
//        hoaDon.setMaNV("NV002");
//        hoaDon.setNgayTao(new Date(04 - 02 - 2024));
//        hoaDon.setTrangThai(true);
//        hoaDon.setTongCong(2000000.0f);
//
//        hoaDonDAO.update(hoaDon);
//
//        // Retrieve the updated hoaDon object
//        HoaDon updatedHoaDon = hoaDonDAO.selectById("hisu");
//
//        Assert.assertNotNull(updatedHoaDon);
//        Assert.assertEquals("hisu", updatedHoaDon.getMaNV());
//        Assert.assertEquals(false, updatedHoaDon.isTrangThai());
//        Assert.assertEquals(2000.0f, updatedHoaDon.getTongCong(), 0.001);
//    }

    @Test
    public void testDelete() {
        HoaDonDAO hoaDonDAO = new HoaDonDAO();
        HoaDon hoaDon = new HoaDon();
        // Set the properties of hoaDon object
        hoaDon.setMaHD("HD12377");
        hoaDon.setMaNV("hisu");
        hoaDon.setNgayTao(new Date(04 - 02 - 2024));
        hoaDon.setTrangThai(true);
        hoaDon.setTongCong(2000000.0f);
        hoaDonDAO.insert(hoaDon);

        HoaDonChiTietDAO CT = new HoaDonChiTietDAO();
        List Expected = new ArrayList();
        CT.delete("HD12377");
        String maHD = "HD12377";

        hoaDonDAO.Delete_SQL_MAHD("HD12377");

        // Retrieve the deleted hoaDon object
        HoaDon deletedHoaDon = hoaDonDAO.selectById(maHD);

        Assert.assertNull(deletedHoaDon);
    }

    @Test
    public void testSelectById() {
        HoaDonDAO hoaDonDAO = new HoaDonDAO();
        String maHD = "hisu";

        HoaDon hoaDon = hoaDonDAO.selectById(maHD);

        Assert.assertNotNull(hoaDon);
        
    }

    @Test
    public void testSelectByKeyword() {
        HoaDonDAO hoaDonDAO = new HoaDonDAO();
        String keyword = "HD12311";

        List<HoaDon> hoaDonList = hoaDonDAO.selectByKeyword(keyword);

        Assert.assertNotNull(hoaDonList);
        // Assert the expected number of hoaDon objects based on the keyword
        Assert.assertEquals(1, hoaDonList.size());
    }

    @Test
    public void testSelectAll() {
        HoaDonDAO hoaDonDAO = new HoaDonDAO();

        List<HoaDon> hoaDonList = hoaDonDAO.selectAll();

        Assert.assertNotNull(hoaDonList);
        // Assert the expected number of hoaDon objects in the database
        Assert.assertEquals(20, hoaDonList.size());
    }

}