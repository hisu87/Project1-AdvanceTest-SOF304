package group1.dao;

import group1.entity.NhanVien;
import group1.util.Data;
import group1.utils.xJDBC;

import org.testng.annotations.Test;

import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.BeforeMethod;

public class NhanVienDAOTestDP {

    private NhanVienDAO nhanVienDAO;

    // TC01: Thêm nhân viên mới
    @Test
    public void testAddNewEmployee() throws Exception {
        Data.setExcelFile(
                "D:\\FPT-Polytechnic\\SOF304-AdvanceTest\\PS33100-PhamVanHieu-NhomX-SOF304-AdvanceTest\\sof304.xlsx",
                "Employee");
        NhanVienDAO dao = new NhanVienDAO();
        NhanVien nv = new NhanVien();
        // Input data
        String maNV = Data.getCellData(8, 4);
        String hoTen = Data.getCellData(9, 4);
        String matKhau = Data.getCellData(10, 4);
        String vaitro = Data.getCellData(11, 4);
        int tuoi = Integer.parseInt(Data.getCellData(12, 4));
        String gioiTinh = Data.getCellData(13, 4);
        String sdt = Data.getCellData(14, 4);
        String diaChi = Data.getCellData(15, 4);
        // Expected
        String EmaNV = Data.getCellData(8, 5);
        String EhoTen = Data.getCellData(9, 5);
        String EmatKhau = Data.getCellData(10, 5);
        String Evaitro = Data.getCellData(11, 5);
        int Etuoi = Integer.parseInt(Data.getCellData(12, 5));
        String EgioiTinh = Data.getCellData(13, 5);
        String Esdt = Data.getCellData(14, 5);
        String EdiaChi = Data.getCellData(15, 5);
        // Set data
        nv.setMaNV(maNV);
        nv.setHoTen(hoTen);
        nv.setMatKhau(matKhau);
        nv.setVaitro(vaitro);
        nv.setTuoi(tuoi);
        nv.setGioiTinh(gioiTinh);
        nv.setSdt(sdt);
        nv.setDiaChi(diaChi);
        // Insert data
        dao.insert(nv);
        // Get data
        NhanVien nhanVien = dao.selectById(EmaNV);
        // Check data
        Assertions.assertEquals(nhanVien.getMaNV(), EmaNV);
        Assertions.assertEquals(nhanVien.getHoTen(), EhoTen);
        Assertions.assertEquals(nhanVien.getMatKhau(), EmatKhau);
        Assertions.assertEquals(nhanVien.getVaitro(), Evaitro);
        Assertions.assertEquals(nhanVien.getTuoi(), Etuoi);
        Assertions.assertEquals(nhanVien.getGioiTinh(), EgioiTinh);
        Assertions.assertEquals(nhanVien.getSdt(), Esdt);
        Assertions.assertEquals(nhanVien.getDiaChi(), EdiaChi);
        // Delete data
        dao.delete(EmaNV);
    }

    // TC02: Thêm nhân viên với thông tin không hợp lệ
    @Test
    public void testAddEmployeeWithInvalidInformation() throws Exception {

        Data.setExcelFile(
                "D:\\FPT-Polytechnic\\SOF304-AdvanceTest\\PS33100-PhamVanHieu-NhomX-SOF304-AdvanceTest\\sof304.xlsx",
                "Employee");
        NhanVienDAO dao = new NhanVienDAO();
        NhanVien nv = new NhanVien();
        // Input data
        String maNV = Data.getCellData(15, 4);
        String hoTen = Data.getCellData(16, 4);
        String matKhau = Data.getCellData(17, 4);
        String vaitro = Data.getCellData(18, 4);
        int tuoi = Integer.parseInt(Data.getCellData(19, 4));
        String gioiTinh = Data.getCellData(20, 4);
        String sdt = Data.getCellData(21, 4);
        String diaChi = Data.getCellData(22, 4);
        // Expected
        String EmaNV = Data.getCellData(15, 5);
        String EhoTen = Data.getCellData(16, 5);
        String EmatKhau = Data.getCellData(17, 5);
        String Evaitro = Data.getCellData(18, 5);
        int Etuoi = Integer.parseInt(Data.getCellData(19, 5));
        String EgioiTinh = Data.getCellData(20, 5);
        String Esdt = Data.getCellData(21, 5);
        String EdiaChi = Data.getCellData(22, 5);
        // Set data
        nv.setMaNV(maNV);
        nv.setHoTen(hoTen);
        nv.setMatKhau(matKhau);
        nv.setVaitro(vaitro);
        nv.setTuoi(tuoi);
        nv.setGioiTinh(gioiTinh);
        nv.setSdt(sdt);
        nv.setDiaChi(diaChi);
        // Insert data
        dao.insert(nv);
        // Get data
        NhanVien nhanVien = dao.selectById(EmaNV);
        // Check data
        assertNull(nhanVien);

    }

    // TC03: Sửa thông tin nhân viên
    @Test
    public void testUpdateEmployeeInformation() throws Exception {

        Data.setExcelFile(
                "D:\\FPT-Polytechnic\\SOF304-AdvanceTest\\PS33100-PhamVanHieu-NhomX-SOF304-AdvanceTest\\sof304.xlsx",
                "Employee");
        NhanVienDAO dao = new NhanVienDAO();
        NhanVien nv = new NhanVien();
        // Input insert data
        String maNV = Data.getCellData(8, 4);
        String hoTen = Data.getCellData(9, 4);
        String matKhau = Data.getCellData(10, 4);
        String vaitro = Data.getCellData(11, 4);
        int tuoi = Integer.parseInt(Data.getCellData(12, 4));
        String gioiTinh = Data.getCellData(13, 4);
        String sdt = Data.getCellData(14, 4);
        String diaChi = Data.getCellData(15, 4);
        // Expected
        String EmaNV = Data.getCellData(24, 5);
        String EhoTen = Data.getCellData(25, 5);
        String EmatKhau = Data.getCellData(26, 5);
        String Evaitro = Data.getCellData(27, 5);
        int Etuoi = Integer.parseInt(Data.getCellData(28, 5));
        String EgioiTinh = Data.getCellData(29, 5);
        String Esdt = Data.getCellData(30, 5);
        String EdiaChi = Data.getCellData(31, 5);
        // Set data
        nv.setMaNV(maNV);
        nv.setHoTen(hoTen);
        nv.setMatKhau(matKhau);
        nv.setVaitro(vaitro);
        nv.setTuoi(tuoi);
        nv.setGioiTinh(gioiTinh);
        nv.setSdt(sdt);
        nv.setDiaChi(diaChi);
        // Insert data
        dao.insert(nv);
        // Update data
        String UmaNV = Data.getCellData(24, 4);
        String UhoTen = Data.getCellData(25, 4);
        String UmatKhau = Data.getCellData(26, 4);
        String Uvaitro = Data.getCellData(27, 4);
        int Utuoi = Integer.parseInt(Data.getCellData(28, 4));
        String UgioiTinh = Data.getCellData(29, 4);
        String Usdt = Data.getCellData(30, 4);
        String UdiaChi = Data.getCellData(31, 4);
        // Set update data
        NhanVien unv = new NhanVien();
        unv.setMaNV(UmaNV);
        unv.setHoTen(UhoTen);
        unv.setMatKhau(UmatKhau);
        unv.setVaitro(Uvaitro);
        unv.setTuoi(Utuoi);
        unv.setGioiTinh(UgioiTinh);
        unv.setSdt(Usdt);
        unv.setDiaChi(UdiaChi);
        // Update
        dao.update(unv);
        // Get data
        NhanVien nhanVien = dao.selectById(UmaNV);

        // Check data
        Assertions.assertEquals(nhanVien.getMaNV(), EmaNV);
        Assertions.assertEquals(nhanVien.getHoTen(), EhoTen);
        Assertions.assertEquals(nhanVien.getMatKhau(), EmatKhau);
        Assertions.assertEquals(nhanVien.getVaitro(), Evaitro);
        Assertions.assertEquals(nhanVien.getTuoi(), Etuoi);
        Assertions.assertEquals(nhanVien.getGioiTinh(), EgioiTinh);
        Assertions.assertEquals(nhanVien.getSdt(), Esdt);
        Assertions.assertEquals(nhanVien.getDiaChi(), EdiaChi);
        // Delete data
        dao.delete(EmaNV);

    }

    // TC04: Sửa thông tin nhân viên không hợp lệ
    @Test
    public void testUpdateEmployeeWithInvalidInformation() throws Exception {

        Data.setExcelFile(
                "D:\\FPT-Polytechnic\\SOF304-AdvanceTest\\PS33100-PhamVanHieu-NhomX-SOF304-AdvanceTest\\sof304.xlsx",
                "Employee");
        NhanVienDAO dao = new NhanVienDAO();
        NhanVien nv = new NhanVien();
        // Input insert data
        String maNV = Data.getCellData(8, 4);
        String hoTen = Data.getCellData(9, 4);
        String matKhau = Data.getCellData(10, 4);
        String vaitro = Data.getCellData(11, 4);
        int tuoi = Integer.parseInt(Data.getCellData(12, 4));
        String gioiTinh = Data.getCellData(13, 4);
        String sdt = Data.getCellData(14, 4);
        String diaChi = Data.getCellData(15, 4);
        // Expected
        String EmaNV = Data.getCellData(31, 5);
        String EhoTen = Data.getCellData(22, 5);
        String EmatKhau = Data.getCellData(33, 5);
        String Evaitro = Data.getCellData(34, 5);
        int Etuoi = Integer.parseInt(Data.getCellData(34, 5));
        String EgioiTinh = Data.getCellData(36, 5);
        String Esdt = Data.getCellData(37, 5);
        String EdiaChi = Data.getCellData(38, 5);
        // Set data
        nv.setMaNV(maNV);
        nv.setHoTen(hoTen);
        nv.setMatKhau(matKhau);
        nv.setVaitro(vaitro);
        nv.setTuoi(tuoi);
        nv.setGioiTinh(gioiTinh);
        nv.setSdt(sdt);
        nv.setDiaChi(diaChi);
        // Insert data
        dao.insert(nv);
        // Update data
        String UmaNV = Data.getCellData(31, 4);
        String UhoTen = Data.getCellData(32, 4);
        String UmatKhau = Data.getCellData(33, 4);
        String Uvaitro = Data.getCellData(34, 4);
        int Utuoi = Integer.parseInt(Data.getCellData(35, 4));
        String UgioiTinh = Data.getCellData(36, 4);
        String Usdt = Data.getCellData(37, 4);
        String UdiaChi = Data.getCellData(38, 4);
        // Set update data
        NhanVien unv = new NhanVien();
        unv.setMaNV(UmaNV);
        unv.setHoTen(UhoTen);
        unv.setMatKhau(UmatKhau);
        unv.setVaitro(Uvaitro);
        unv.setTuoi(Utuoi);
        unv.setGioiTinh(UgioiTinh);
        unv.setSdt(Usdt);
        unv.setDiaChi(UdiaChi);
        // Update
        dao.update(unv);
        // Get data
        NhanVien nhanVien = dao.selectById(UmaNV);

        // Check data
        assertNull(nhanVien);
        // Delete data
        dao.delete(EmaNV);

    }

    // TC05: Xóa nhân viên
    @Test
    public void testDeleteEmployee() throws Exception {

        Data.setExcelFile(
                "D:\\FPT-Polytechnic\\SOF304-AdvanceTest\\PS33100-PhamVanHieu-NhomX-SOF304-AdvanceTest\\sof304.xlsx",
                "Employee");
        NhanVienDAO dao = new NhanVienDAO();
        NhanVien nv = new NhanVien();
        // Input insert data
        String maNV = Data.getCellData(8, 4);
        String hoTen = Data.getCellData(9, 4);
        String matKhau = Data.getCellData(10, 4);
        String vaitro = Data.getCellData(11, 4);
        int tuoi = Integer.parseInt(Data.getCellData(12, 4));
        String gioiTinh = Data.getCellData(13, 4);
        String sdt = Data.getCellData(14, 4);
        String diaChi = Data.getCellData(15, 4);

        // Set data
        nv.setMaNV(maNV);
        nv.setHoTen(hoTen);
        nv.setMatKhau(matKhau);
        nv.setVaitro(vaitro);
        nv.setTuoi(tuoi);
        nv.setGioiTinh(gioiTinh);
        nv.setSdt(sdt);
        nv.setDiaChi(diaChi);
        // Insert data
        dao.insert(nv);

        // Delete data
        dao.delete(maNV);

        // Get data
        NhanVien nhanVien = dao.selectById(maNV);
        assertNull(nhanVien);

    }

}
