package group1.dao;

import org.hamcrest.Matcher;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import group1.util.Data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ThongKeDAOTestDP {

    @Test
    public void TC01() throws Exception {
        // Test case TC01
        // Implement test case for Xem doanh thu theo ngày
        // Implement test case for viewing revenue by date

        ThongKeDAO instance = new ThongKeDAO();
        Data.setExcelFile(
                "D:\\FPT-Polytechnic\\SOF304-AdvanceTest\\PS33100-PhamVanHieu-NhomX-SOF304-AdvanceTest\\sof304.xlsx",
                "Revenue");
        String date = Data.getCellData(8, 4);
        System.out.println(date);
        String item1 = Data.getCellData(8, 5);
        String item2 = Data.getCellData(9, 5);
        String item3 = Data.getCellData(10, 5);
        System.out.println(item1 + " " + item2 + " " + item3);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy - MM - dd"); // Fix: Modify the date format
        Date sdate = dateFormat.parse(date);
        List<Object[]> result = instance.getDoanhThuDay(sdate);
        if (result.size() <= 4) {
            System.out.println("Success");
            String result1 = result.get(0)[0].toString();
            String result2 = result.get(0)[1].toString();
            String result3 = result.get(0)[2].toString();
            for (Object[] row : result) {
                System.out.println(Arrays.toString(row));

            }

            assertEquals(item1, result1);
            assertEquals(item2, result2);
            assertEquals(item3, result3);

        } else {
            for (Object[] row : result) {
                System.out.println(Arrays.toString(row));
            }
            System.out.println("Fail");
            // fail("Not enough data in the result list.");
        }
    }

    @Test
    public void TC02() throws Exception {
        // Test case TC02
        // TODO: Implement test case for Xem doanh thu theo các tháng trong năm
        ThongKeDAO instance = new ThongKeDAO();
        Data.setExcelFile(
                "D:\\FPT-Polytechnic\\SOF304-AdvanceTest\\PS33100-PhamVanHieu-NhomX-SOF304-AdvanceTest\\sof304.xlsx",
                "Revenue");
        String date = Data.getCellData(11, 4);
        System.out.println("Date:" + date);
        // int snam = 0;
        int snam = Integer.parseInt(date); // Initialize snam with a default value
        System.out.println("snam:" + snam);
        String item1 = Data.getCellData(11, 5);
        String item2 = Data.getCellData(12, 5);
        String item3 = Data.getCellData(13, 5);
        List<Object[]> result = instance.getDoanhThuMonth(snam);
        result.size();
        if (result.size() <= 6) {
            System.out.println("Success");
            String result1 = result.get(0)[0].toString();
            String result2 = result.get(0)[1].toString();
            String result3 = result.get(0)[2].toString();
            for (Object[] row : result) {
                System.out.println(Arrays.toString(row));
            }
            assertEquals(item1, result1);
            assertEquals(item2, result2);
            assertEquals(item3, result3);
        } else {
            for (Object[] row : result) {
                System.out.println(Arrays.toString(row));
            }
            System.out.println("Fail");
            // fail("Not enough data in the result list.");
        }
        for (Object[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }

    @Test
    public void TC03() throws Exception {
        ThongKeDAO instance = new ThongKeDAO();
        List<Object[]> result = instance.getDoanhThuYear();
        assertNotNull(result);
        for (Object[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }

    @Test
    public void TC04() throws Exception {
        // Test case TC04
        // TODO: Implement test case for Xem doanh thu theo khoảng ngày
        // Input
        Data.setExcelFile(
                "D:\\FPT-Polytechnic\\SOF304-AdvanceTest\\PS33100-PhamVanHieu-NhomX-SOF304-AdvanceTest\\sof304.xlsx",
                "Revenue");
        String date1 = Data.getCellData(16, 4);
        String date2 = Data.getCellData(17, 4);
        String item1 = Data.getCellData(16, 5);
        String item2 = Data.getCellData(17, 5);
        String item3 = Data.getCellData(18, 5);
        System.out.println(date1 + " " + date2);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy - MM - dd"); // Fix: Modify the date format
        Date NgayBatDau = dateFormat.parse(date1);
        Date NgayKetThuc = dateFormat.parse(date2);
        System.out.println(NgayBatDau + " " + NgayKetThuc);
        // Output
        ThongKeDAO instance = new ThongKeDAO();
        List<Object[]> result = instance.getDoanhThuDateRange(NgayBatDau,NgayKetThuc);
        result.size();
        if (result.size() <= 7) {
            System.out.println("Success");
            String result1 = result.get(0)[0].toString();
            String result2 = result.get(0)[1].toString();
            String result3 = result.get(0)[2].toString();
            for (Object[] row : result) {
                System.out.println(Arrays.toString(row));
            }
            assertEquals(item1, result1);
            assertEquals(item2, result2);
            assertEquals(item3, result3);
        } else {
            for (Object[] row : result) {
                System.out.println(Arrays.toString(row));
            }
            System.out.println("Fail");
            // fail("Not enough data in the result list.");
        }
        for (Object[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }

    @Test
    public void TC05() throws Exception {
        // Test case TC05
        // TODO: Implement test case for Viewing revenue by date range (invalid date
        // format)
        // Input
    	Data.setExcelFile(
                "D:\\FPT-Polytechnic\\SOF304-AdvanceTest\\PS33100-PhamVanHieu-NhomX-SOF304-AdvanceTest\\sof304.xlsx",
                "Revenue");
        String date1 = Data.getCellData(19, 4);
        String date2 = Data.getCellData(20, 4);
        System.out.println(date1 + " " + date2);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy - MM - dd"); // Fix: Modify the date format
        Date NgayBatDau = dateFormat.parse(date1);
        Date NgayKetThuc = dateFormat.parse(date2);
        System.out.println(NgayBatDau + " " + NgayKetThuc);
        // Output
        ThongKeDAO instance = new ThongKeDAO();
        List<Object[]> result = instance.getDoanhThuDateRange(NgayBatDau,NgayKetThuc);
        result.size();
        if (result.size() <= 0) {
            System.out.println("Success");
            String result1 = result.get(0)[0].toString();
            String result2 = result.get(0)[1].toString();
            String result3 = result.get(0)[2].toString();
        } else {
            System.out.println("Fail");
            // fail("Not enough data in the result list.");
        }
    }

    @Test
    public void TC06() throws Exception {
        // Test case TC06
        // TODO: Implement test case for Xem doanh thu theo các tháng trong năm (năm
        // không đúng định dạng)
        // Vì năm không đúng định dạng và không cho nhập năm trực tiếp nên kết quả trả
        // về sẽ là mảng rỗng hoặc lỗi
        // Input
    	Data.setExcelFile(
                "D:\\FPT-Polytechnic\\SOF304-AdvanceTest\\PS33100-PhamVanHieu-NhomX-SOF304-AdvanceTest\\sof304.xlsx",
                "Revenue");
        String date1 = Data.getCellData(19, 4);
        String date2 = Data.getCellData(20, 4);
        System.out.println(date1 + " " + date2);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy - MM - dd"); // Fix: Modify the date format
        Date NgayBatDau = dateFormat.parse(date1);
        Date NgayKetThuc = dateFormat.parse(date2);
        System.out.println(NgayBatDau + " " + NgayKetThuc);
        // Output
        ThongKeDAO instance = new ThongKeDAO();
        List<Object[]> result = instance.getDoanhThuDateRange(NgayBatDau,NgayKetThuc);
        result.size();
        if (result.size() <= 0) {
            System.out.println("Success");
            String result1 = result.get(0)[0].toString();
            String result2 = result.get(0)[1].toString();
            String result3 = result.get(0)[2].toString();
        } else {
            System.out.println("Fail");
            // fail("Not enough data in the result list.");
        }
    }

    @Test
    public void TC07() throws Exception {
        // Test case TC07
        // TODO: Implement test case for Xem doanh thu theo khoảng ngày (Ngày bắt đầu
        // đúng định dạng, ngày kết thúc sai định dạng)

        // Input
    	Data.setExcelFile(
                "D:\\FPT-Polytechnic\\SOF304-AdvanceTest\\PS33100-PhamVanHieu-NhomX-SOF304-AdvanceTest\\sof304.xlsx",
                "Revenue");
        String date1 = Data.getCellData(19, 4);
        String date2 = Data.getCellData(20, 4);
        System.out.println(date1 + " " + date2);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy - MM - dd"); // Fix: Modify the date format
        Date NgayBatDau = dateFormat.parse(date1);
        Date NgayKetThuc = dateFormat.parse(date2);
        System.out.println(NgayBatDau + " " + NgayKetThuc);
        // Output
        ThongKeDAO instance = new ThongKeDAO();
        List<Object[]> result = instance.getDoanhThuDateRange(NgayBatDau,NgayKetThuc);
        result.size();
        if (result.size() <= 0) {
            System.out.println("Success");
            String result1 = result.get(0)[0].toString();
            String result2 = result.get(0)[1].toString();
            String result3 = result.get(0)[2].toString();
        } else {
            System.out.println("Fail");
            // fail("Not enough data in the result list.");
        }

    }

    @Test
    public void TC09() throws Exception {
        // Test case TC09
        // TODO: Implement test case for Xem doanh thu theo khoảng ngày (Ngày bắt đầu và
        // kết thúc đều sai định dạng)
        // Input
        Data.setExcelFile(
                "D:\\FPT-Polytechnic\\SOF304-AdvanceTest\\PS33100-PhamVanHieu-NhomX-SOF304-AdvanceTest\\sof304.xlsx",
                "Revenue");
        String date1 = Data.getCellData(14, 4);
        String date2 = Data.getCellData(15, 4);
        System.out.println(date1 + " " + date2);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy - MM - dd"); // Fix: Modify the date format
        Date NgayBatDau = dateFormat.parse(date1);
        Date NgayKetThuc = dateFormat.parse(date2);
        System.out.println(NgayBatDau + " " + NgayKetThuc);
        // Output
        ArrayList<Object[]> expected = new ArrayList<>();
        ThongKeDAO instance = new ThongKeDAO();
        List<Object[]> result = instance.getDoanhThuDateRange(NgayBatDau, NgayKetThuc);
        assertEquals(result, expected);
        for (Object[] row : result) {
            System.out.println(Arrays.toString(row));
        }

    }
//
//    @Test
//    public void testGetDoanhThuYear() {
//        ThongKeDAO thongKeDAO = new ThongKeDAO();
//        List<Object[]> result = thongKeDAO.getDoanhThuYear();
//        Assert.assertNotNull(result);
//        for (Object[] row : result) {
//            System.out.println(Arrays.toString(row));
//        }
//        Assert.assertFalse(result.isEmpty());
//        // Add more assertions to validate the result
//    }
//
//    @Test
//    public void testGetDoanhThuMonth() {
//        ThongKeDAO thongKeDAO = new ThongKeDAO();
//        int nam = 2022; // Replace with a valid year
//        List<Object[]> result = thongKeDAO.getDoanhThuMonth(nam);
//        Assert.assertNotNull(result);
//        Assert.assertTrue(result.isEmpty());
//        // Add more assertions to validate the result
//    }
//
//    @Test
//    public void testGetDoanhThuDay() {
//        ThongKeDAO thongKeDAO = new ThongKeDAO();
//        Date ngay = new Date(2021 - 07 - 26); // Replace with a valid date
//        List<Object[]> result = thongKeDAO.getDoanhThuDay(ngay);
//        Assert.assertNotNull(result);
//
//        Assert.assertTrue(result.isEmpty());
//        // Add more assertions to validate the result
//    }
//
//    @Test
//    public void testGetDoanhThuDateRange() {
//        ThongKeDAO thongKeDAO = new ThongKeDAO();
//        Date ngay1 = new Date(2023 - 07 - 26); // Replace with a valid date
//        Date ngay2 = new Date(2023 - 11 - 11); // Replace with a valid date
//        List<Object[]> result = thongKeDAO.getDoanhThuDateRange(ngay1, ngay2);
//        Assert.assertNotNull(result);
//        Assert.assertTrue(result.isEmpty());
//        // Add more assertions to validate the result
//    }
}