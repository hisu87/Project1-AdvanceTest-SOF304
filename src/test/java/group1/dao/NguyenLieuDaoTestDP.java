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
import group1.util.Data;

public class NguyenLieuDaoTestDP {
        // TC01
        @Test
        public void TC01() throws Exception {
                Data.setExcelFile(
                                "D:\\FPT-Polytechnic\\SOF304-AdvanceTest\\PS33100-PhamVanHieu-NhomX-SOF304-AdvanceTest\\sof304.xlsx",
                                "Ingredients");
                NguyenLieuDAO dao = new NguyenLieuDAO();
                NguyenLieu nl = new NguyenLieu();
                // Input data
                String maNl = Data.getCellData(8, 4);
                String tenNl = Data.getCellData(9, 4);
                String soluong = Data.getCellData(10, 4);
                String gia = Data.getCellData(11, 4);
                String donvi = Data.getCellData(12, 4);
                // Expected
                String EmaNl = Data.getCellData(8, 5);
                String EtenNl = Data.getCellData(9, 5);
                String Esoluong = Data.getCellData(10, 5);
                String Egia = Data.getCellData(11, 5);
                String Edonvi = Data.getCellData(12, 5);
                // Set data
                nl.setMaNL(maNl);
                nl.setTenNL(tenNl);
                nl.setSoLuongCon(Float.parseFloat(soluong));
                nl.setGiaNL(Float.parseFloat(gia));
                nl.setDonViDoLuong(donvi);
                // Insert data
                dao.insert(nl);
                // Get data
                NguyenLieu NguyenLieu = dao.selectById(EmaNl);
                // Check data
                assertNotNull(NguyenLieu);
                assertEquals(EmaNl, NguyenLieu.getMaNL());
                assertEquals(EtenNl, NguyenLieu.getTenNL());
                assertEquals(Float.parseFloat(Esoluong), NguyenLieu.getSoLuongCon(), 0.1);
                assertEquals(Float.parseFloat(Egia), NguyenLieu.getGiaNL(), 0.1);
                assertEquals(Edonvi, NguyenLieu.getDonViDoLuong());
                // Delete data
                dao.delete(EmaNl);
        }

        @Test
        public void TC02() throws Exception {

                Data.setExcelFile(
                                "D:\\FPT-Polytechnic\\SOF304-AdvanceTest\\PS33100-PhamVanHieu-NhomX-SOF304-AdvanceTest\\sof304.xlsx",
                                "Ingredients");
                NguyenLieuDAO dao = new NguyenLieuDAO();
                NguyenLieu nl = new NguyenLieu();
                // Input data
                String maNl = Data.getCellData(12, 4);
                String tenNl = Data.getCellData(13, 4);
                String soluong = Data.getCellData(14, 4);
                String gia = Data.getCellData(15, 4);
                String donvi = Data.getCellData(16, 4);
                // Expected
                String EmaNl = Data.getCellData(12, 5);
                String EtenNl = Data.getCellData(13, 5);
                String Esoluong = Data.getCellData(14, 5);
                String Egia = Data.getCellData(15, 5);
                String Edonvi = Data.getCellData(16, 5);
                // Set data
                nl.setMaNL(maNl);
                nl.setTenNL(tenNl);
                nl.setSoLuongCon(Float.parseFloat(soluong));
                nl.setGiaNL(Float.parseFloat(gia));
                nl.setDonViDoLuong(donvi);
                // Insert data
                dao.insert(nl);
                // Get data
                NguyenLieu NguyenLieu = dao.selectById(EmaNl);
                // Check data
                assertNull(NguyenLieu);
        }

        @Test
        public void TC03() throws Exception {

                Data.setExcelFile(
                                "D:\\FPT-Polytechnic\\SOF304-AdvanceTest\\PS33100-PhamVanHieu-NhomX-SOF304-AdvanceTest\\sof304.xlsx",
                                "Ingredients");
                NguyenLieuDAO dao = new NguyenLieuDAO();
                NguyenLieu nl = new NguyenLieu();
                // Input data
                String maNl = Data.getCellData(8, 4);
                String tenNl = Data.getCellData(9, 4);
                String soluong = Data.getCellData(10, 4);
                String gia = Data.getCellData(11, 4);
                String donvi = Data.getCellData(12, 4);
                // Expected
                String EmaNl = Data.getCellData(18, 5);
                String EtenNl = Data.getCellData(19, 5);
                String Esoluong = Data.getCellData(20, 5);
                String Egia = Data.getCellData(21, 5);
                String Edonvi = Data.getCellData(22, 5);
                // Update data
                String updatemaNl = Data.getCellData(18, 4);
                String updatetenNl = Data.getCellData(19, 4);
                String updatesoluong = Data.getCellData(20, 4);
                String updategia = Data.getCellData(21, 4);
                String updatedonvi = Data.getCellData(22, 4);
                // Set data
                nl.setMaNL(maNl);
                nl.setTenNL(tenNl);
                nl.setSoLuongCon(Float.parseFloat(soluong));
                nl.setGiaNL(Float.parseFloat(gia));
                nl.setDonViDoLuong(donvi);
                // Insert data
                dao.insert(nl);
                // Update data
                nl.setMaNL(updatemaNl);
                nl.setTenNL(updatetenNl);
                nl.setSoLuongCon(Float.parseFloat(updatesoluong));
                nl.setGiaNL(Float.parseFloat(updategia));
                nl.setDonViDoLuong(updatedonvi);
                // Update data
                dao.update(nl);
                // Get data
                NguyenLieu NguyenLieu = dao.selectById(EmaNl);
                // Check data
                assertNotNull(NguyenLieu);
                assertEquals(EmaNl, NguyenLieu.getMaNL());
                assertEquals(EtenNl, NguyenLieu.getTenNL());
                assertEquals(Float.parseFloat(Esoluong), NguyenLieu.getSoLuongCon(), 0.1);
                assertEquals(Float.parseFloat(Egia), NguyenLieu.getGiaNL(), 0.1);
                assertEquals(Edonvi, NguyenLieu.getDonViDoLuong());
                // Delete data
                dao.delete(EmaNl);
        }

        @Test
        public void TC04() throws Exception {
                Data.setExcelFile(
                                "D:\\FPT-Polytechnic\\SOF304-AdvanceTest\\PS33100-PhamVanHieu-NhomX-SOF304-AdvanceTest\\sof304.xlsx",
                                "Ingredients");
                NguyenLieuDAO dao = new NguyenLieuDAO();
                NguyenLieu nl = new NguyenLieu();
                // Input data
                String maNl = Data.getCellData(8, 4);
                String tenNl = Data.getCellData(9, 4);
                String soluong = Data.getCellData(10, 4);
                String gia = Data.getCellData(11, 4);
                String donvi = Data.getCellData(12, 4);
                // Expected
                String EmaNl = Data.getCellData(23, 5);
                String EtenNl = Data.getCellData(24, 5);
                String Esoluong = Data.getCellData(25, 5);
                String Egia = Data.getCellData(26, 5);
                String Edonvi = Data.getCellData(27, 5);
                // Update data
                String updatemaNl = Data.getCellData(23, 4);
                String updatetenNl = Data.getCellData(24, 4);
                String updatesoluong = Data.getCellData(25, 4);
                String updategia = Data.getCellData(26, 4);
                String updatedonvi = Data.getCellData(27, 4);
                // Set data
                nl.setMaNL(maNl);
                nl.setTenNL(tenNl);
                nl.setSoLuongCon(Float.parseFloat(soluong));
                nl.setGiaNL(Float.parseFloat(gia));
                nl.setDonViDoLuong(donvi);
                // Insert data
                dao.insert(nl);
                // Update data
                nl.setMaNL(updatemaNl);
                nl.setTenNL(updatetenNl);
                nl.setSoLuongCon(Float.parseFloat(updatesoluong));
                nl.setGiaNL(Float.parseFloat(updategia));
                nl.setDonViDoLuong(updatedonvi);
                // Update data
                dao.update(nl);
                // Get data
                NguyenLieu NguyenLieu = dao.selectById(EmaNl);
                // Check data
                assertNotNull(NguyenLieu);
                assertEquals(EmaNl, NguyenLieu.getMaNL());
                assertEquals(EtenNl, NguyenLieu.getTenNL());
                assertEquals(Float.parseFloat(Esoluong), NguyenLieu.getSoLuongCon(), 0.1);
                assertEquals(Float.parseFloat(Egia), NguyenLieu.getGiaNL(), 0.1);
                assertEquals(Edonvi, NguyenLieu.getDonViDoLuong());
                // Delete data
                dao.delete(EmaNl);
        }

        @Test
        public void TC05() throws Exception {

                Data.setExcelFile(
                                "D:\\FPT-Polytechnic\\SOF304-AdvanceTest\\PS33100-PhamVanHieu-NhomX-SOF304-AdvanceTest\\sof304.xlsx",
                                "Ingredients");
                NguyenLieuDAO dao = new NguyenLieuDAO();
                NguyenLieu nl = new NguyenLieu();
                // Input data
                String maNl = Data.getCellData(8, 4);
                String tenNl = Data.getCellData(9, 4);
                String soluong = Data.getCellData(10, 4);
                String gia = Data.getCellData(11, 4);
                String donvi = Data.getCellData(12, 4);
                // Set data
                nl.setMaNL(maNl);
                nl.setTenNL(tenNl);
                nl.setSoLuongCon(Float.parseFloat(soluong));
                nl.setGiaNL(Float.parseFloat(gia));
                nl.setDonViDoLuong(donvi);
                // Insert data
                dao.insert(nl);
                // Delete data
                dao.delete(maNl);
                // Get data
                NguyenLieu NguyenLieu = dao.selectById(maNl);
                // Check data
                assertNull(NguyenLieu);

        }

        @Test
        public void TC06() throws Exception {

                Data.setExcelFile(
                                "D:\\FPT-Polytechnic\\SOF304-AdvanceTest\\PS33100-PhamVanHieu-NhomX-SOF304-AdvanceTest\\sof304.xlsx",
                                "Ingredients");
                NguyenLieuDAO dao = new NguyenLieuDAO();
                NguyenLieu nl = new NguyenLieu();
                // Input data
                String maNl = Data.getCellData(8, 4);
                String tenNl = Data.getCellData(9, 4);
                String soluong = Data.getCellData(10, 4);
                String gia = Data.getCellData(11, 4);
                String donvi = Data.getCellData(12, 4);
                // Expected
                String EmaNl = Data.getCellData(8, 5);
                String EtenNl = Data.getCellData(9, 5);
                String Esoluong = Data.getCellData(10, 5);
                String Egia = Data.getCellData(11, 5);
                String Edonvi = Data.getCellData(12, 5);
                // Set data
                nl.setMaNL(maNl);
                nl.setTenNL(tenNl);
                nl.setSoLuongCon(Float.parseFloat(soluong));
                nl.setGiaNL(Float.parseFloat(gia));
                nl.setDonViDoLuong(donvi);
                // Insert data
                dao.insert(nl);
                // Get data
                NguyenLieu NguyenLieu = dao.selectById(maNl);
                // Check data
                assertNotNull(NguyenLieu);
                assertEquals(EmaNl, NguyenLieu.getMaNL());
                assertEquals(EtenNl, NguyenLieu.getTenNL());
                assertEquals(Float.parseFloat(Esoluong), NguyenLieu.getSoLuongCon(), 0.1);
                assertEquals(Float.parseFloat(Egia), NguyenLieu.getGiaNL(), 0.1);
                assertEquals(Edonvi, NguyenLieu.getDonViDoLuong());
                // Delete data
                dao.delete(maNl);
        }

}
