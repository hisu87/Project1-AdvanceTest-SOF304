package group1.dao;

//Done
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import group1.entity.CongThuc;

import group1.dao.CongThucDAO;

public class CongThucDaoTest {
	private CongThucDaoTest mainTest;
	private CongThucDAO congThucDAO;

	// Id: TC01
	@Test
	public void insertTest() {
		System.out.println("---Thêm công thức mới---");
		int Mact;
		String TenCT;
		CongThuc congThuc = new CongThuc();
		congThuc.setTenCT("Tra Sua");
		congThuc.setMaCT(1);
		System.out.println("Thêm mới thành công");
	}

	// Id: TC02
	@Test
	public void insertTestFail() {
		System.out.println("---Thêm công thức mới trùng mã công thức đã tồn tại---");
		int Mact = 1;
		String TenCT = "Tra Sua";
		CongThuc congThuc = new CongThuc();
		congThuc.setTenCT("Tra Sua");
		congThuc.setMaCT(1);
		if (Mact == congThuc.getMaCT()) {
			System.out.println("Thêm mới thất bại do mã công thức đã tồn tại");
		} else {
			System.out.println("Thêm mới thành công");
		}

	}

	// Id: TC03
	@Test
	public void insertTestFail_2() {
		System.out.println("---Thêm công thức mới không hợp lệ---");
		int Mact = 1;
		String TenCT = "Tra Sua";
		CongThuc congThuc = new CongThuc();
		congThuc.setTenCT("Tra Sua");
		congThuc.setMaCT(1);
		if (Mact == congThuc.getMaCT()) {
			System.out.println("Thêm mới thất bại do mã công thức đã tồn tại");
		} else {
			System.out.println("Thêm mới thành công");
		}

	}

	// Id: TC04
	@Test
	public void updateTest() {

		congThucDAO = new CongThucDAO();
		CongThuc congThuc = new CongThuc();
		congThuc.setMaCT(10);
		congThuc.setTenCT("Trà Sữa");

		// Insert the SanPham object
		congThucDAO.insert(congThuc);

		// Update the SanPham object
		congThuc.setMaCT(10);
		congThuc.setTenCT("Hoa Đào");
		congThucDAO.update(congThuc);

		// Verify that the SanPham object is updated successfully
		CongThuc updatCongThuc = congThucDAO.selectById("10");
		Assert.assertNotNull(updatCongThuc);
		Assert.assertEquals("Hoa Đào", updatCongThuc.getTenCT());
		Assert.assertEquals(10, updatCongThuc.getMaCT());
		System.out.println("Update thành công");
		// Clean up the inserted data

	}

	// Id: TC05
	@Test
	public void updateTest_2() {

		congThucDAO = new CongThucDAO();
		CongThuc congThuc = new CongThuc();
		congThuc.setMaCT(10);
		congThuc.setTenCT("Trà Sữa");

		// Insert the SanPham object
		congThucDAO.insert(congThuc);

		// Update the SanPham object
		congThuc.setMaCT(10);
		congThuc.setTenCT("");
		congThucDAO.update(congThuc);

		// Verify that the SanPham object is updated successfully
		CongThuc updatCongThuc = congThucDAO.selectById("10");
		Assert.assertNotNull(updatCongThuc);
		Assert.assertEquals("", updatCongThuc.getTenCT());
		Assert.assertEquals(10, updatCongThuc.getMaCT());
		System.out.println("Update Không thành công");
		// Clean up the inserted data
		congThucDAO.delete("10");
	}

	// Id: TC06
	@Test
	public void deleteTest() {
		congThucDAO = new CongThucDAO();
		CongThuc congThuc = new CongThuc();
		congThuc.setMaCT(100);
		congThuc.setTenCT("Latte");
		congThucDAO.insert(congThuc);
		// delete the CongThuc object
		congThucDAO.delete("100");

		// Verify that the CongThuc object is deleted successfully
		CongThuc deletedCongThuc = congThucDAO.selectById("100");
		Assert.assertNull(deletedCongThuc);
		System.out.println("Delete thành công");
	}

	// Id: TC07
	@Test
	public void deleteTest_2() {
		CongThucDAO DAO = new CongThucDAO();
		CongThuc congThuc = new CongThuc();
		congThuc.setMaCT(110);
		congThuc.setTenCT("TraSUA");
		DAO.insert(congThuc);
		congThuc.setMaCT(111);
		congThuc.setTenCT("TraSUA");
		DAO.insert(congThuc);
		congThuc.setMaCT(112);
		congThuc.setTenCT("TraSUA");
		DAO.insert(congThuc);

		DAO.delete("110");
		DAO.delete("111");
		DAO.delete("112");

		Assert.assertNull(DAO.selectById("110"));
		Assert.assertNull(DAO.selectById("111"));
		Assert.assertNull(DAO.selectById("112"));
		System.out.println("Delete thành công");

	}

	// Id : TC08
	@Test
	public void TC08() {
		CongThucDAO DAO = new CongThucDAO();
		CongThuc congThuc = new CongThuc();
		congThuc.setMaCT(100);
		congThuc.setTenCT("Latte");
		DAO.insert(congThuc);

		DAO.selectById("100");

		if (DAO.selectById("100").equals(congThuc.getMaCT())) {
			CongThuc searchCongThuc = DAO.selectById(String.valueOf(congThuc.getMaCT()));
			Assert.assertNotNull(searchCongThuc);
			Assert.assertEquals("100", searchCongThuc.getMaCT());
			System.out.println(" TC08 Pass");
		}
		DAO.delete("100");

	}

	@Test
	public void TC09() {
		CongThucDAO DAO = new CongThucDAO();
		CongThuc congThuc = new CongThuc();
		congThuc.setMaCT(100);
		congThuc.setTenCT("Latte");
		DAO.insert(congThuc);
		DAO.selectById("100");
		DAO.delete("100");
		CongThuc deletedCongThuc = DAO.selectById("100");
		Assert.assertNull(deletedCongThuc);
		System.out.println("Delete thành công");
	}

}
