package group1.dao;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.beust.ah.A;

import group1.entity.CongThuc;
import group1.entity.SanPham;
import group1.util.Data;
import group1.dao.*;

import java.util.List;

public class SanPhamDaoTestDP {

    private SanPhamDao sanPhamDao = new SanPhamDao();

    @Test
    public void testInsert() throws Exception {
        // Test case for inserting a new SanPham object
        // input data
        Data.setExcelFile(
                "D:\\FPT-Polytechnic\\SOF304-AdvanceTest\\PS33100-PhamVanHieu-NhomX-SOF304-AdvanceTest\\sof304.xlsx",
                "Products");
        CongThuc ct = new CongThuc();
        CongThucDAO ctd = new CongThucDAO();
        SanPham sp = new SanPham();
        SanPhamDao spd = new SanPhamDao();
        String mact = Data.getCellData(8, 4);
        String tenct = Data.getCellData(9, 4);
        ct.setMaCT(Integer.parseInt(mact));
        ct.setTenCT(tenct);
        ctd.insert(ct);
        String masp = Data.getCellData(10, 4);
        String tensp = Data.getCellData(11, 4);
        String anh = Data.getCellData(12, 4);
        String gia = Data.getCellData(13, 4);
        String mact1 = Data.getCellData(14, 4);
        sp.setMaSP(masp);
        sp.setTenSP(tensp);
        sp.setAnh(anh);
        sp.setGia(Float.parseFloat(gia));
        sp.setMaCT(mact1);
        spd.insert(sp);
        // expected data
        String masp1 = Data.getCellData(10, 5);
        String tensp1 = Data.getCellData(11, 5);
        String anh1 = Data.getCellData(12, 5);
        String gia1 = Data.getCellData(13, 5);
        String mact2 = Data.getCellData(14, 5);
        // Verify that the SanPham object is inserted successfully
        SanPham insertedSanPham = sanPhamDao.selectById(masp1);
        Assert.assertNotNull(insertedSanPham);
        Assert.assertEquals(insertedSanPham.getTenSP(), tensp1);
        Assert.assertEquals(insertedSanPham.getAnh(), anh1);
        Assert.assertEquals(insertedSanPham.getGia(), Float.parseFloat(gia1), 0.0f);
        Assert.assertEquals(insertedSanPham.getMaCT(), mact2);
        // Clean up the inserted data
        sanPhamDao.delete(masp1);
    }

    @Test
    public void testUpdate() throws Exception {
        // Test case for updating an existing SanPham object
        Data.setExcelFile(
                "D:\\FPT-Polytechnic\\SOF304-AdvanceTest\\PS33100-PhamVanHieu-NhomX-SOF304-AdvanceTest\\sof304.xlsx",
                "Products");
        CongThuc ct = new CongThuc();
        CongThucDAO ctd = new CongThucDAO();
        SanPham sp = new SanPham();
        SanPhamDao spd = new SanPhamDao();
        String mact = Data.getCellData(42, 4);
        String tenct = Data.getCellData(43, 4);
        ct.setMaCT(Integer.parseInt(mact));
        ct.setTenCT(tenct);
        ctd.insert(ct);
        String masp = Data.getCellData(10, 4);
        String tensp = Data.getCellData(11, 4);
        String anh = Data.getCellData(12, 4);
        String gia = Data.getCellData(13, 4);
        String mact1 = Data.getCellData(14, 4);
        sp.setMaSP(masp);
        sp.setTenSP(tensp);
        sp.setAnh(anh);
        sp.setGia(Float.parseFloat(gia));
        sp.setMaCT(mact1);
        spd.insert(sp);
        // expected data
        String masp1 = Data.getCellData(22, 5);
        String tensp1 = Data.getCellData(23, 5);
        String anh1 = Data.getCellData(24, 5);
        String gia1 = Data.getCellData(25, 5);
        String mact2 = Data.getCellData(26, 5);
        // update sp
        String Umasp = Data.getCellData(27, 4);
        String Utensp = Data.getCellData(28, 4);
        String Uanh = Data.getCellData(29, 4);
        String Ugia = Data.getCellData(30, 4);
        String Umact1 = Data.getCellData(31, 4);
        sp.setMaSP(Umasp);
        sp.setTenSP(Utensp);
        sp.setAnh(Uanh);
        sp.setGia(Float.parseFloat(Ugia));
        sp.setMaCT(Umact1);
        spd.update(sp);
        // Clean up the inserted data
        sanPhamDao.delete(masp1);
    }

    @Test
    public void testDelete() throws Exception {
        // Test case for deleting an existing SanPham object
        Data.setExcelFile(
                "D:\\FPT-Polytechnic\\SOF304-AdvanceTest\\PS33100-PhamVanHieu-NhomX-SOF304-AdvanceTest\\sof304.xlsx",
                "Products");
        CongThuc ct = new CongThuc();
        CongThucDAO ctd = new CongThucDAO();
        SanPham sp = new SanPham();
        SanPhamDao spd = new SanPhamDao();
        String masp = Data.getCellData(32, 4);
        String tensp = Data.getCellData(33, 4);
        String anh = Data.getCellData(34, 4);
        String gia = Data.getCellData(35, 4);
        String mact1 = Data.getCellData(36, 4);
        sp.setMaSP(masp);
        sp.setTenSP(tensp);
        sp.setAnh(anh);
        sp.setGia(Float.parseFloat(gia));
        sp.setMaCT(mact1);
        spd.insert(sp);
        //
        sanPhamDao.delete(masp);
        // Verify that the SanPham object is deleted successfully
        SanPham deletedSanPham = sanPhamDao.selectById(masp);
        Assert.assertNull(deletedSanPham);
    }

    @Test
    public void testSelectById() throws Exception {

        Data.setExcelFile(
                "D:\\FPT-Polytechnic\\SOF304-AdvanceTest\\PS33100-PhamVanHieu-NhomX-SOF304-AdvanceTest\\sof304.xlsx",
                "Products");
        CongThuc ct = new CongThuc();
        CongThucDAO ctd = new CongThucDAO();
        SanPham sp = new SanPham();
        SanPhamDao spd = new SanPhamDao();
        String mact = Data.getCellData(42, 4);
        String tenct = Data.getCellData(43, 4);
        ct.setMaCT(Integer.parseInt(mact));
        ct.setTenCT(tenct);
        ctd.insert(ct);
        String masp = Data.getCellData(44, 4);
        String tensp = Data.getCellData(45, 4);
        String anh = Data.getCellData(46, 4);
        String gia = Data.getCellData(47, 4);
        String mact1 = Data.getCellData(48, 4);
        sp.setMaSP(masp);
        sp.setTenSP(tensp);
        sp.setAnh(anh);
        sp.setGia(Float.parseFloat(gia));
        sp.setMaCT(mact1);
        spd.insert(sp);
        // expected data
        String masp1 = Data.getCellData(44, 5);
        String tensp1 = Data.getCellData(45, 5);
        String anh1 = Data.getCellData(46, 5);
        String gia1 = Data.getCellData(47, 5);
        String mact2 = Data.getCellData(48, 5);
        // Verify that the SanPham object is find out successfully
        SanPham insertedSanPham = sanPhamDao.selectById(masp1);
        Assert.assertNotNull(insertedSanPham);
        Assert.assertEquals(insertedSanPham.getTenSP(), tensp1);
        Assert.assertEquals(insertedSanPham.getAnh(), anh1);
        Assert.assertEquals(insertedSanPham.getGia(), Float.parseFloat(gia1), 0.0f);
        Assert.assertEquals(insertedSanPham.getMaCT(), mact2);
        // Clean up the inserted data
        sanPhamDao.delete(masp1);

    }

    @Test
    public void testSelectAll() {
        // Test case for selecting all SanPham objects
        List<SanPham> sanPhamList = sanPhamDao.selectAll();

        // Verify that the list is not null and contains at least one SanPham object
        Assert.assertNotNull(sanPhamList);
        Assert.assertFalse(sanPhamList.isEmpty());
    }

    @Test
    public void testInsertInvalidSanPham() throws Exception {
        // Test case for inserting a new SanPham object with invalid information
        // Arrange
        Data.setExcelFile(
                "D:\\FPT-Polytechnic\\SOF304-AdvanceTest\\PS33100-PhamVanHieu-NhomX-SOF304-AdvanceTest\\sof304.xlsx",
                "Products");
        CongThuc ct = new CongThuc();
        CongThucDAO ctd = new CongThucDAO();
        SanPham sp = new SanPham();
        SanPhamDao spd = new SanPhamDao();
        String mact = Data.getCellData(15, 4);
        String tenct = Data.getCellData(16, 4);
        ct.setMaCT(Integer.parseInt(mact));
        ct.setTenCT(tenct);
        ctd.insert(ct);
        String masp = Data.getCellData(17, 4);
        String tensp = Data.getCellData(18, 4);
        String anh = Data.getCellData(19, 4);
        String gia = Data.getCellData(20, 4);
        String mact1 = Data.getCellData(21, 4);
        sp.setMaSP(masp);
        sp.setTenSP(tensp);
        sp.setAnh(anh);
        sp.setGia(Float.parseFloat(gia));
        sp.setMaCT(mact1);
        // Act
        int size = sanPhamDao.selectAll().size();
        spd.insert(sp);
        // Verify that the SanPham object is inserted successfully
        List<SanPham> sanPhamList = sanPhamDao.selectAll();
        Assert.assertEquals(size, sanPhamList.size());
        // Clean up the inserted data
        sanPhamDao.delete(masp);
    }

    @Test
    public void testUpdateinvalidSanPham() throws Exception {
        // Test case for updating an existing SanPham object
        // Arrange
        Data.setExcelFile(
                "D:\\FPT-Polytechnic\\SOF304-AdvanceTest\\PS33100-PhamVanHieu-NhomX-SOF304-AdvanceTest\\sof304.xlsx",
                "Products");
        CongThuc ct = new CongThuc();
        CongThucDAO ctd = new CongThucDAO();
        SanPham sp = new SanPham();
        SanPhamDao spd = new SanPhamDao();
        String masp = Data.getCellData(10, 4);
        String tensp = Data.getCellData(11, 4);
        String anh = Data.getCellData(12, 4);
        String gia = Data.getCellData(13, 4);
        String mact1 = Data.getCellData(14, 4);
        sp.setMaSP(masp);
        sp.setTenSP(tensp);
        sp.setAnh(anh);
        sp.setGia(Float.parseFloat(gia));
        sp.setMaCT(mact1);
        spd.insert(sp);
        // expected data
        String masp1 = Data.getCellData(22, 5);
        String tensp1 = Data.getCellData(23, 5);
        String anh1 = Data.getCellData(24, 5);
        String gia1 = Data.getCellData(25, 5);
        String mact2 = Data.getCellData(26, 5);
        // update invalid sp
        String Umasp = Data.getCellData(27, 4);
        String Utensp = Data.getCellData(28, 4);
        String Uanh = Data.getCellData(29, 4);
        String Ugia = Data.getCellData(30, 4);
        String Umact1 = Data.getCellData(31, 4);
        sp.setMaSP(Umasp);
        sp.setTenSP(Utensp);
        sp.setAnh(Uanh);
        sp.setGia(Float.parseFloat(Ugia));
        sp.setMaCT(Umact1);
        spd.update(sp);
        // Verify that the SanPham object update unsuccessfully
        SanPham insertedSanPham = sanPhamDao.selectById(masp1);
        Assert.assertNotNull(insertedSanPham);
        Assert.assertNotEquals(insertedSanPham.getTenSP(), Utensp);
        Assert.assertNotEquals(insertedSanPham.getAnh(), Uanh);
        Assert.assertNotEquals(insertedSanPham.getGia(), Float.parseFloat(Ugia), 0.0f);
        Assert.assertNotEquals(insertedSanPham.getMaCT(), Umact1);
        // Clean up the inserted data
        sanPhamDao.delete(Umact1);
    }
}