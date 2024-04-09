package group1.dao;

import org.testng.Assert;
import org.testng.annotations.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ThongKeDAOTest {

    @Test
    public void TC01() {
        // Test case TC01
        // Implement test case for Xem doanh thu theo ngày

        // Input
        Date Ngay = new Date(2021 - 10 - 10);
        ThongKeDAO instance = new ThongKeDAO();
        List<Object[]> result = instance.getDoanhThuDay(Ngay);
        assertNotNull(result);
        if (result != null) {
            for (Object[] row : result) {
                System.out.println(Arrays.toString(row));
            }
        }
    }

    @Test
    public void TC02() {
        // Test case TC02
        // TODO: Implement test case for Xem doanh thu theo các tháng trong năm

        // Input
        int nam = 2021;
        ThongKeDAO instance = new ThongKeDAO();
        List<Object[]> result = instance.getDoanhThuMonth(nam);
        assertNotNull(result);
        for (Object[] row : result) {
            System.out.println(Arrays.toString(row));
        }

    }

    @Test
    public void TC03() {
        // Test case TC03
        // TODO: Implement test case for Xem doanh thu theo năm
        ThongKeDAO instance = new ThongKeDAO();
        List<Object[]> result = instance.getDoanhThuYear();
        assertNotNull(result);
        for (Object[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }

    @Test
    public void TC04() {
        // Test case TC04
        // TODO: Implement test case for Xem doanh thu theo khoảng ngày
        // Input
        Date NgayBatDau = new Date(2021 - 10 - 10);
        Date NgayKetThuc = new Date(2021 - 10 - 20);
        ThongKeDAO instance = new ThongKeDAO();
        List<Object[]> result = instance.getDoanhThuDateRange(NgayBatDau, NgayKetThuc);
        assertNotNull(result);
        for (Object[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }

    @Test
    public void TC05() {
        // Test case TC05
        // TODO: Implement test case for Xem doanh thu theo khoảng ngày (ngày không đúng
        // định dạng)
        // Input
        Date NgayBatDau = new Date(2021 - 13 - 10);
        Date NgayKetThuc = new Date(2029 - 15 - 44);
        // Output
        ArrayList expected = new ArrayList<>();
        ThongKeDAO instance = new ThongKeDAO();
        List<Object[]> result = instance.getDoanhThuDateRange(NgayBatDau, NgayKetThuc);
        assertEquals(result, expected);
        for (Object[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }

    @Test
    public void TC06() {
        // Test case TC06
        // TODO: Implement test case for Xem doanh thu theo các tháng trong năm (năm
        // không đúng định dạng)
        // Vì năm không đúng định dạng và không cho nhập năm trực tiếp nên kết quả trả
        // về sẽ là mảng rỗng hoặc lỗi
        // Input
        int nam = 20212;
        // Output
        ArrayList<Object[]> expected = new ArrayList<>();
        ThongKeDAO instance = new ThongKeDAO();
        List<Object[]> result = instance.getDoanhThuMonth(nam);
        assertEquals(result, expected);
        for (Object[] row : result) {
            System.out.println(Arrays.toString(row));
        }

    }

    @Test
    public void TC07() {
        // Test case TC07
        // TODO: Implement test case for Xem doanh thu theo khoảng ngày (Ngày bắt đầu
        // đúng định dạng, ngày kết thúc sai định dạng)

        // Input
        Date NgayBatDau = new Date(2021 - 10 - 10);
        Date NgayKetThuc = new Date(202299 - 15 - 33);

        // Output
        ArrayList<Object[]> expected = new ArrayList<>();

        ThongKeDAO instance = new ThongKeDAO();
        List<Object[]> result = instance.getDoanhThuDateRange(NgayBatDau, NgayKetThuc);
        assertEquals(result, expected);
        for (Object[] row : result) {
            System.out.println(Arrays.toString(row));
        }

    }

    @Test
    public void TC08() {
        // Test case TC08
        // TODO: Implement test case for Xem doanh thu theo khoảng ngày (Ngày bắt đầu
        // sai định dạng, ngày kết thúc đúng định dạng)
        // Input
        Date NgayBatDau = new Date(20221 - 100 - 101);
        Date NgayKetThuc = new Date(2021 - 10 - 10);
        // Output
        ArrayList<Object[]> expected = new ArrayList<>();
        ThongKeDAO instance = new ThongKeDAO();
        List<Object[]> result = instance.getDoanhThuDateRange(NgayBatDau, NgayKetThuc);
        assertEquals(result, expected);
        for (Object[] row : result) {
            System.out.println(Arrays.toString(row));
        }

    }

    @Test
    public void TC09() {
        // Test case TC09
        // TODO: Implement test case for Xem doanh thu theo khoảng ngày (Ngày bắt đầu và
        // kết thúc đều sai định dạng)
        // Input
        Date NgayBatDau = new Date(20221 - 100 - 101);
        Date NgayKetThuc = new Date(20212 - 101 - 103);
        // Output
        ArrayList<Object[]> expected = new ArrayList<>();
        ThongKeDAO instance = new ThongKeDAO();
        List<Object[]> result = instance.getDoanhThuDateRange(NgayBatDau, NgayKetThuc);
        assertEquals(result, expected);
        for (Object[] row : result) {
            System.out.println(Arrays.toString(row));
        }

    }
    @Test
    public void testGetDoanhThuYear() {
        ThongKeDAO thongKeDAO = new ThongKeDAO();
        List<Object[]> result = thongKeDAO.getDoanhThuYear();
        Assert.assertNotNull(result);
        for (Object[] row : result) {
            System.out.println(Arrays.toString(row));
        }
        Assert.assertFalse(result.isEmpty());
        // Add more assertions to validate the result
    }

    @Test
    public void testGetDoanhThuMonth() {
        ThongKeDAO thongKeDAO = new ThongKeDAO();
        int nam = 2022; // Replace with a valid year
        List<Object[]> result = thongKeDAO.getDoanhThuMonth(nam);
        Assert.assertNotNull(result);
        Assert.assertFalse(result.isEmpty());
        // Add more assertions to validate the result
    }

    @Test
    public void testGetDoanhThuDay() {
        ThongKeDAO thongKeDAO = new ThongKeDAO();
        Date ngay = new Date(2021-07-26); // Replace with a valid date
        List<Object[]> result = thongKeDAO.getDoanhThuDay(ngay);
        Assert.assertNotNull(result);
        
        Assert.assertFalse(result.isEmpty());
        // Add more assertions to validate the result
    }

    @Test
    public void testGetDoanhThuDateRange() {
        ThongKeDAO thongKeDAO = new ThongKeDAO();
        Date ngay1 = new Date(2023-07-26); // Replace with a valid date
        Date ngay2 = new Date(2023-11-11); // Replace with a valid date
        List<Object[]> result = thongKeDAO.getDoanhThuDateRange(ngay1, ngay2);
        Assert.assertNotNull(result);
        Assert.assertFalse(result.isEmpty());
        // Add more assertions to validate the result
    }
}