package group1.dao;

import group1.entity.NhanVien;
import group1.utils.xJDBC;

import org.testng.annotations.Test;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.BeforeMethod;

public class NhanVienDAOTest {

    private NhanVienDAO nhanVienDAO;

    // TC01: Thêm nhân viên mới
    @Test
    public void testAddNewEmployee() {
        // 1. Người dùng có quyền thêm nhân viên
        // 2. Nhập thông tin nhân viên (Tên nhân viên, chức vụ, phòng ban, email, số
        // điện thoại)
        // 3. Nhân viên mới được thêm vào danh sách
        // 4. Danh sách nhân viên có thêm nhân viên mớ
        // 5. Click "Lưu"
        // TODO: Implement test case
        NhanVien nhanVien = new NhanVien();
        nhanVien.setMaNV("AB");
        nhanVien.setHoTen("Nguyen Van A");
        nhanVien.setMatKhau("123456");
        nhanVien.setVaitro("Quản lý");
        nhanVien.setTuoi(30);
        nhanVien.setGioiTinh("Nam");
        nhanVien.setSdt("0123456789");
        nhanVien.setDiaChi("Ha Noi");
        NhanVienDAO nhanVienDAO = new NhanVienDAO();
        int size = nhanVienDAO.selectAll().size();
        nhanVienDAO.insert(nhanVien);
        List<NhanVien> list = nhanVienDAO.selectAll();
        Assertions.assertNotEquals(list.size(), size);
        System.out.println(list.size());
    }

    // TC02: Thêm nhân viên với thông tin không hợp lệ
    @Test
    public void testAddEmployeeWithInvalidInformation() {
        // 1. Người dùng có quyền thêm nhân viên
        // 2. Nhập thông tin nhân viên không hợp lệ (ví dụ: tên nhân viên trống)
        // 3. Hiển thị thông báo lỗi
        // 4. Danh sách nhân viên không thay đổi
        // 5. Click "Lưu"
        // TODO: Implement test case
        NhanVien nhanVien = new NhanVien();
        nhanVien.setMaNV("NV08");
        nhanVien.setHoTen("");
        nhanVien.setMatKhau("123456");
        nhanVien.setVaitro("Quản lý");
        nhanVien.setTuoi(30);
        nhanVien.setGioiTinh("Nam");
        nhanVien.setSdt("0123456789");
        nhanVien.setDiaChi("Ha Noi");
        NhanVienDAO nhanVienDAO = new NhanVienDAO();
        int size = nhanVienDAO.selectAll().size();
        nhanVienDAO.insert(nhanVien);
        List<NhanVien> list = nhanVienDAO.selectAll();
        Assertions.assertEquals(size, list.size());
        System.out.println(list.size());
    }

    // TC03: Sửa thông tin nhân viên
    @Test
    public void testUpdateEmployeeInformation() {
        // 1. Người dùng có quyền sửa nhân viên
        // 2. Có nhân viên trong danh sách
        // 3. Chọn nhân viên
        // 4. Nhập thông tin nhân viên mới (Tên nhân viên mới, chức vụ mới, phòng ban
        // mới, email mới, số điện thoại mới)
        // 5. Thông tin nhân viên được cập nhật
        // 6. Danh sách nhân viên hiển thị thông tin nhân viên đã cập nhật
        // 7. Sửa thông tin nhân viên
        // 8. Click "Lưu"
        // TODO: Implement test case
        NhanVien nhanVien = new NhanVien();
        nhanVien.setMaNV("Hisu");
        nhanVien.setHoTen("Hieu");
        nhanVien.setMatKhau("123456");
        nhanVien.setVaitro("Quản lý");
        nhanVien.setTuoi(30);
        nhanVien.setGioiTinh("Nam");
        nhanVien.setSdt("0123456789");
        nhanVien.setDiaChi("Ha Noi");
        NhanVienDAO nhanVienDAO = new NhanVienDAO();
        nhanVienDAO.update(nhanVien);
        NhanVien nhanVienUpdated = nhanVienDAO.selectById("Hisu");
        Assertions.assertEquals(nhanVienUpdated.getHoTen(), "Hieu");

    }

    // TC04: Sửa thông tin nhân viên không hợp lệ
    @Test
    public void testUpdateEmployeeWithInvalidInformation() {
        // 1. Người dùng có quyền sửa nhân viên
        // 2. Có nhân viên trong danh sách
        // 3. Chọn nhân viên
        // 4. Nhập thông tin nhân viên không hợp lệ (ví dụ: tên nhân viên trống)
        // 5. Hiển thị thông báo lỗi
        // 6. Danh sách nhân viên không thay đổi
        // 7. Sửa thông tin nhân viên không hợp lệ
        // 8. Click "Lưu"
        // TODO: Implement test case
        NhanVien nhanVien = new NhanVien();
        nhanVien.setMaNV("NV07");
        nhanVien.setHoTen("");
        nhanVien.setMatKhau("123456");
        nhanVien.setVaitro("Quản lý");
        nhanVien.setTuoi(30);
        nhanVien.setGioiTinh("Nam");
        nhanVien.setSdt("0123456789");
        nhanVien.setDiaChi("Ha Noi");
        NhanVienDAO nhanVienDAO = new NhanVienDAO();
        nhanVienDAO.update(nhanVien);
        NhanVien nhanVienUpdated = nhanVienDAO.selectById("NV07");
        Assertions.assertNotEquals(nhanVienUpdated.getHoTen(), "");
    }

    // TC05: Xóa nhân viên
    @Test
    public void testDeleteEmployee() {
        // 1. Người dùng có quyền xóa nhân viên
        // 2. Có nhân viên trong danh sách
        // 3. Chọn nhân viên
        // 4. Nhập tên nhân viên
        // 5. Nhân viên được xóa khỏi danh sách
        // 6. Danh sách nhân viên không còn nhân viên đã xóa
        // 7. Click "Xóa"
        // TODO: Implement test case
        NhanVienDAO nhanVienDAO = new NhanVienDAO();
        int size = nhanVienDAO.selectAll().size();
        nhanVienDAO.delete("NV07");
        List<NhanVien> list = nhanVienDAO.selectAll();
        Assertions.assertNotEquals(list.size(), size);
        System.out.println(list.size());

    }

    // TC06: Xóa nhiều nhân viên
    @Test
    public void testDeleteMultipleEmployees() {
        // 1. Người dùng có quyền xóa nhân viên
        // 2. Có nhiều nhân viên trong danh sách
        // 3. Chọn nhiều nhân viên
        // 4. Nhập nhiều tên nhân viên
        // 5. Nhiều nhân viên được xóa khỏi danh sách
        // 6. Danh sách nhân viên không còn các nhân viên đã xóa
        // 7. Click "Xóa"
        // TODO: Implement test case
        NhanVienDAO nhanVienDAO = new NhanVienDAO();
        int size = nhanVienDAO.selectAll().size();
        nhanVienDAO.delete("NV01");
        nhanVienDAO.delete("NV02");
        nhanVienDAO.delete("NV03");
        List<NhanVien> list = nhanVienDAO.selectAll();
        Assertions.assertNotEquals(list.size(), size);
        System.out.println(list.size());
    }

    // TC07: Tìm nhân viên theo nhiều tiêu chí
    @Test
    public void testSearchEmployeesByCriteria() {
        // 1. Người dùng có quyền tìm kiếm nhân viên
        // 2. Nhập tên nhân viên hoặc mã nhân viên
        // 3. Tên nhân viên, chức vụ, phòng ban
        // 4. Danh sách nhân viên hiển thị các nhân viên符合tìm kiếm
        // 5. Click "Tìm kiếm"
        // TODO: Implement test case
        int QL = 4;
        NhanVienDAO nhanVienDAO = new NhanVienDAO();
        List<NhanVien> list = nhanVienDAO.selectByRole("Quản lý");
        int out = list.size();
        Assertions.assertEquals(QL, out);
        System.out.println(out);
    }
}
