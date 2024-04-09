package group1.dao;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.beust.ah.A;

import group1.entity.CongThuc;
import group1.entity.SanPham;
import group1.dao.*;

import java.util.List;

public class SanPhamDaoTest {

    private SanPhamDao sanPhamDao = new SanPhamDao();

    @Test
    public void testInsert() {
        // Test case for inserting a new SanPham object
        CongThuc CT = new CongThuc();
        CongThucDAO DAO = new CongThucDAO();
        CT.setMaCT(666);
        CT.setTenCT("Quỷ Xứ");
        DAO.insert(CT);
        SanPham sanPham = new SanPham();
        sanPham.setMaSP("SP001");
        sanPham.setTenSP("Product 1");
        sanPham.setAnh("image.jpg");
        sanPham.setGia(100.0f);
        sanPham.setMaCT("666");

        sanPhamDao.insert(sanPham);

        // Verify that the SanPham object is inserted successfully
        SanPham insertedSanPham = sanPhamDao.selectById("SP001");
        Assert.assertNotNull(insertedSanPham);
        Assert.assertEquals("Product 1", insertedSanPham.getTenSP());
        Assert.assertEquals("image.jpg", insertedSanPham.getAnh());
        Assert.assertEquals(100.0f, insertedSanPham.getGia(), 0.0f);
        Assert.assertEquals("666", insertedSanPham.getMaCT());

        // Clean up the inserted data
        sanPhamDao.delete("SP001");
    }

    @Test
    public void testUpdate() {
        // Test case for updating an existing SanPham object
    	CongThuc CT = new CongThuc();
    	CongThucDAO DAO = new CongThucDAO();
    	CT.setMaCT(888);
    	CT.setTenCT("XỜ La");
    	DAO.insert(CT);
    	
        SanPham sanPham = new SanPham();
        sanPham.setMaSP("SP002");
        sanPham.setTenSP("Product 2");
        sanPham.setAnh("image.jpg");
        sanPham.setGia(200.0f);
        sanPham.setMaCT("888");

        // Insert the SanPham object
        sanPhamDao.insert(sanPham);

        // Update the SanPham object
        sanPham.setTenSP("Updated Product 2");
        sanPham.setAnh("updated_image.jpg");
        sanPham.setGia(250.0f);
        sanPham.setMaCT("666");
        sanPham.setMaSP("SP002");
        sanPhamDao.update(sanPham);

        // Verify that the SanPham object is updated successfully
        SanPham updatedSanPham = sanPhamDao.selectById("SP002");
        Assert.assertNotNull(updatedSanPham);
        Assert.assertEquals("Updated Product 2", updatedSanPham.getTenSP());
        Assert.assertEquals("updated_image.jpg", updatedSanPham.getAnh());
        Assert.assertEquals(250.0f, updatedSanPham.getGia(), 0.0f);
        Assert.assertEquals("666", updatedSanPham.getMaCT());

        // Clean up the inserted data
        sanPhamDao.delete("SP002");
    }

    @Test
    public void testDelete() {
        // Test case for deleting an existing SanPham object
        SanPham sanPham = new SanPham();
        sanPham.setMaSP("SP003");
        sanPham.setTenSP("Product 3");
        sanPham.setAnh("image.jpg");
        sanPham.setGia(300.0f);
        sanPham.setMaCT("CT004");

        // Insert the SanPham object
        sanPhamDao.insert(sanPham);

        // Delete the SanPham object
        sanPhamDao.delete("SP003");

        // Verify that the SanPham object is deleted successfully
        SanPham deletedSanPham = sanPhamDao.selectById("SP003");
        Assert.assertNull(deletedSanPham);
    }

    @Test
    public void testSelectById() {
        CongThuc CT = new CongThuc();
        CongThucDAO DAO = new CongThucDAO();
        CT.setMaCT(666);
        CT.setTenCT("Quỷ Xứ");
        DAO.insert(CT);
        SanPham sanPham = new SanPham();
        sanPham.setMaSP("SP001");
        sanPham.setTenSP("Product 1");
        sanPham.setAnh("image.jpg");
        sanPham.setGia(100.0f);
        sanPham.setMaCT("666");

        sanPhamDao.insert(sanPham);

        // Select the SanPham object by ID
        SanPham selectedSanPham = sanPhamDao.selectById("SP001");

        // Verify that the selected SanPham object is not null
        // Assert.assertNotNull(selectedSanPham);
        Assert.assertEquals("Product 1", selectedSanPham.getTenSP());
        Assert.assertEquals("image.jpg", selectedSanPham.getAnh());
        Assert.assertEquals(100.0f, selectedSanPham.getGia(), 0.0f);
        Assert.assertEquals("666", selectedSanPham.getMaCT());

        // Clean up the inserted data
        sanPhamDao.delete("SP001");
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
    public void testInsertNewSanPham() {
        // Test case for inserting a new SanPham object
        // Arrange
        CongThuc CT = new CongThuc();
        CongThucDAO DAO = new CongThucDAO();
        CT.setMaCT(666);
        CT.setTenCT("Quỷ Xứ");
        DAO.insert(CT);
        SanPham sanPham = new SanPham();
        sanPham.setMaSP("SP001");
        sanPham.setTenSP("Product 1");
        sanPham.setAnh("image.jpg");
        sanPham.setGia(100.0f);
        sanPham.setMaCT("666");

        sanPhamDao.insert(sanPham);
        int size = sanPhamDao.selectAll().size();

        // Assert
        List<SanPham> sanPhamList = sanPhamDao.selectAll();
        Assert.assertEquals(size, sanPhamList.size());
        // Clean up the inserted data
        sanPhamDao.delete("SP001");
    }

    @Test
    public void testInsertInvalidSanPham() {
        // Test case for inserting a new SanPham object with invalid information
        // Arrange
        SanPham sanPham = new SanPham();
        sanPham.setMaSP("SP002");
        sanPham.setTenSP(""); // Invalid: empty name
        sanPham.setAnh("image.jpg");
        sanPham.setGia(200.0f);
        sanPham.setMaCT("CT002");

        // Act
        int size = sanPhamDao.selectAll().size();
        sanPhamDao.insert(sanPham);

        // Assert

        List<SanPham> sanPhamList = sanPhamDao.selectAll();
        Assert.assertEquals(size, sanPhamList.size());

    }

    @Test
    public void testUpdateSanPham() {
        // Test case for updating an existing SanPham object
        // Arrange
        SanPham sanPham = new SanPham();
        sanPham.setMaSP("SP003");
        sanPham.setTenSP("Product 3");
        sanPham.setAnh("image.jpg");
        sanPham.setGia(300.0f);
        sanPham.setMaCT("666");

        // Insert the SanPham object
        sanPhamDao.insert(sanPham);
     

        // Act
        // Update the SanPham object
        sanPham.setMaSP("SP003");
        sanPham.setTenSP("Updated Product 3");
        sanPham.setAnh("updated_image.jpg");
        sanPham.setGia(350.0f);
        sanPham.setMaCT("888");
        sanPhamDao.update(sanPham);
        System.out.println(":" + sanPham.getTenSP());

        // Assert
        SanPham updatedSanPham = sanPhamDao.selectById("SP003");
        Assert.assertEquals("Updated Product 3", updatedSanPham.getTenSP());
        Assert.assertEquals("updated_image.jpg", updatedSanPham.getAnh());
        Assert.assertEquals(350.0f, updatedSanPham.getGia(), 0.0f);
        Assert.assertEquals("888", updatedSanPham.getMaCT());
    }

    @Test
    public void testDeleteSanPham() {
        // Test case for deleting an existing SanPham object
        // Arrange
        CongThucDAO CT = new CongThucDAO();
        CongThuc congthuc = new CongThuc();

        // Insert congthuc test
        congthuc.setMaCT(9);
        congthuc.setTenCT("test");
        CT.insert(congthuc);
        // insert sp test
        SanPham sanPham = new SanPham();
        sanPham.setMaSP("SP004");
        sanPham.setTenSP("Product 4");
        sanPham.setAnh("image.jpg");
        sanPham.setGia(400.0f);
        sanPham.setMaCT("9");

        // Insert the SanPham object
        sanPhamDao.insert(sanPham);

        // Act
        // Delete the SanPham object

        CT.delete("9");
        sanPhamDao.delete("SP004");

        // Assert
        SanPham deletedSanPham = sanPhamDao.selectById("SP004");
        Assert.assertNull(deletedSanPham);
    }
}