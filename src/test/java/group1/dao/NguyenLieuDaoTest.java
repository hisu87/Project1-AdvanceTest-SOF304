package group1.dao;

import java.util.List;

import org.testng.annotations.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.testng.Assert.assertNotEquals;

import group1.entity.NguyenLieu;

public class NguyenLieuDaoTest {
        // TC01
        @Test
        public void TC01() {
                // Test case for inserting a new SanPham object
                NguyenLieuDAO nguyenLieuDAO = new NguyenLieuDAO();
                NguyenLieu nguyenLieu = new NguyenLieu();
                nguyenLieu.setMaNL("NL100");
                nguyenLieu.setTenNL("NL 100");
                nguyenLieu.setSoLuongCon(1.0f);
                nguyenLieu.setGiaNL(100.0f);
                nguyenLieu.setDonViDoLuong("ml");

                nguyenLieuDAO.insert(nguyenLieu);

                // Verify that the SanPham object is inserted successfully
                NguyenLieu insertedNguyenLieu = nguyenLieuDAO.selectById("NL100");
                assertNotNull(insertedNguyenLieu);
                assertEquals("NL 100", insertedNguyenLieu.getTenNL());
                assertEquals(1.0f, insertedNguyenLieu.getSoLuongCon(), 1.0f);
                assertEquals(100.0f, insertedNguyenLieu.getGiaNL(), 100.0f);
                assertEquals("ml", insertedNguyenLieu.getDonViDoLuong());

                // Clean up the inserted data
                nguyenLieuDAO.delete("NL100");
        }

        @Test
        public void TC02() {
                NguyenLieuDAO nguyenLieuDAO = new NguyenLieuDAO();
                NguyenLieu nguyenLieu = new NguyenLieu();
                nguyenLieu.setMaNL("NL100");
                nguyenLieu.setTenNL("");
                nguyenLieu.setSoLuongCon(1.0f);
                nguyenLieu.setGiaNL(100.0f);
                nguyenLieu.setDonViDoLuong("ml");

                int size = nguyenLieuDAO.selectAll().size();
                nguyenLieuDAO.insert(nguyenLieu);

                List<NguyenLieu> sanPhamList = nguyenLieuDAO.selectAll();
                assertEquals(size, sanPhamList.size());
                nguyenLieuDAO.delete("NL100");
                assertEquals(64, size);
                
        }

        @Test
        public void TC03() {
                NguyenLieuDAO nguyenLieuDAO = new NguyenLieuDAO();
                NguyenLieu nguyenLieu = new NguyenLieu();
                nguyenLieu.setMaNL("NL100");
                nguyenLieu.setTenNL("NL 100");
                nguyenLieu.setSoLuongCon(1.0f);
                nguyenLieu.setGiaNL(100.0f);
                nguyenLieu.setDonViDoLuong("ml");

                nguyenLieuDAO.insert(nguyenLieu);

                nguyenLieu.setMaNL("NL100");
                nguyenLieu.setTenNL("NL 2000");
                nguyenLieu.setSoLuongCon(12.0f);
                nguyenLieu.setGiaNL(102.0f);
                nguyenLieu.setDonViDoLuong("kg");

                nguyenLieuDAO.update(nguyenLieu);
                System.out.println(nguyenLieu.getTenNL());

                NguyenLieu updatedSanPham = nguyenLieuDAO.selectById("NL100");
                assertNotNull(updatedSanPham);
        }

        @Test
        public void TC04() {
                NguyenLieuDAO nguyenLieuDAO = new NguyenLieuDAO();
                NguyenLieu nguyenLieu = new NguyenLieu();
                nguyenLieu.setMaNL("NL100");
                nguyenLieu.setTenNL("NL 100");
                nguyenLieu.setSoLuongCon(1.0f);
                nguyenLieu.setGiaNL(100.0f);
                nguyenLieu.setDonViDoLuong("ml");

                nguyenLieuDAO.insert(nguyenLieu);
                int size = nguyenLieuDAO.selectAll().size();
                nguyenLieu.setMaNL("NL100");
                nguyenLieu.setTenNL("");
                nguyenLieu.setSoLuongCon(12.0f);
                nguyenLieu.setGiaNL(102.0f);
                nguyenLieu.setDonViDoLuong("kg");

                nguyenLieuDAO.update(nguyenLieu);

                List<NguyenLieu> sanPhamList = nguyenLieuDAO.selectAll();
                assertEquals(size, sanPhamList.size());

                nguyenLieuDAO.delete("NL100");
        }

        @Test
        public void TC05() {
                NguyenLieuDAO nguyenLieuDAO = new NguyenLieuDAO();
                NguyenLieu nguyenLieu = new NguyenLieu();
                nguyenLieu.setMaNL("NL100");
                nguyenLieu.setTenNL("NL 100");
                nguyenLieu.setSoLuongCon(1.0f);
                nguyenLieu.setGiaNL(100.0f);
                nguyenLieu.setDonViDoLuong("ml");
                nguyenLieuDAO.insert(nguyenLieu);

                nguyenLieuDAO.delete("NL100");

                NguyenLieu deleteNguyenLieu = nguyenLieuDAO.selectById("NL100");
                assertNull(deleteNguyenLieu);
        }

        @Test
        public void TC06() {
                NguyenLieuDAO DAO = new NguyenLieuDAO();
                NguyenLieu NL = new NguyenLieu();
                NL.setMaNL("NL100");
                NL.setTenNL("NL 100");
                NL.setSoLuongCon(1.0f);
                NL.setGiaNL(100.0f);
                NL.setDonViDoLuong("ml");
                DAO.insert(NL);
                NL.setMaNL("NL101");
                NL.setTenNL("NL 110");
                NL.setSoLuongCon(1.0f);
                NL.setGiaNL(100.0f);
                NL.setDonViDoLuong("ml");
                DAO.insert(NL);
                NL.setMaNL("NL102");
                NL.setTenNL("NL 120");
                NL.setSoLuongCon(1.0f);
                NL.setGiaNL(100.0f);
                NL.setDonViDoLuong("ml");
                DAO.insert(NL);
                int sizeBefore = DAO.selectAll().size();
                DAO.delete("NL100");
                DAO.delete("NL101");
                DAO.delete("NL102");
                int sizeAfter = DAO.selectAll().size();
                assertNotEquals(sizeBefore, sizeAfter);
        }

        @Test
        public void TC07() {
                NguyenLieuDAO nguyenLieuDAO = new NguyenLieuDAO();
                NguyenLieu nguyenLieu = new NguyenLieu();
                nguyenLieu.setMaNL("NL100");
                nguyenLieu.setTenNL("NL 100");
                nguyenLieu.setSoLuongCon(1.0f);
                nguyenLieu.setGiaNL(100.0f);
                nguyenLieu.setDonViDoLuong("ml");

                nguyenLieuDAO.insert(nguyenLieu);

                NguyenLieu searchNguyenLieu = nguyenLieuDAO.selectById("NL100");
                assertNotNull(searchNguyenLieu);
                assertEquals("NL100", searchNguyenLieu.getMaNL());
        }

        @Test
        public void TC08() {
                // Test case 8
        }
}
