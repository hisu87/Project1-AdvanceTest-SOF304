package group1.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
//Done
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import group1.entity.CongThuc;
import group1.util.Data;
import group1.dao.CongThucDAO;

public class CongThucDaoTestDP {
	private CongThucDaoTest mainTest;
	private CongThucDAO congThucDAO;

	// Id: TC01
	@Test
	public void insertTest() throws Exception {

		Data.setExcelFile(
				"D:\\FPT-Polytechnic\\SOF304-AdvanceTest\\PS33100-PhamVanHieu-NhomX-SOF304-AdvanceTest\\sof304.xlsx",
				"Recipe");
		// Input data
		String MaCT = Data.getCellData(8, 4);
		String TenCT = Data.getCellData(9, 4);
		CongThuc congThuc = new CongThuc();
		congThuc.setMaCT(Integer.parseInt(MaCT));
		congThuc.setTenCT(TenCT);
		congThucDAO = new CongThucDAO();
		congThucDAO.insert(congThuc);
		// Execute the code to test
		String Emact = Data.getCellData(8, 5);
		String EtenCT = Data.getCellData(9, 5);
		// Verify that the CongThuc object is inserted successfully
		CongThuc insertedCongThuc = congThucDAO.selectById(MaCT);
		Assert.assertNotNull(insertedCongThuc);
		Assert.assertEquals(EtenCT, insertedCongThuc.getTenCT());
		Assert.assertEquals(Integer.parseInt(Emact), insertedCongThuc.getMaCT());
		// Clean up the inserted data
		congThucDAO.delete(MaCT);
	}

	// Id: TC02
	@Test
	public void insertTestFail() throws Exception {

		Data.setExcelFile(
				"D:\\FPT-Polytechnic\\SOF304-AdvanceTest\\PS33100-PhamVanHieu-NhomX-SOF304-AdvanceTest\\sof304.xlsx",
				"Recipe");
		// Input data
		String MaCT = Data.getCellData(10, 4);
		String TenCT = Data.getCellData(11, 4);
		CongThuc congThuc = new CongThuc();
		congThuc.setMaCT(Integer.parseInt(MaCT));
		congThuc.setTenCT(TenCT);
		congThucDAO = new CongThucDAO();
		congThucDAO.insert(congThuc);
		congThuc = new CongThuc();
		congThuc = congThucDAO.selectById(MaCT);
		assertNull(congThuc);
	}

	// Id: TC03
	@Test
	public void updateTest() throws Exception {

		Data.setExcelFile(
				"D:\\FPT-Polytechnic\\SOF304-AdvanceTest\\PS33100-PhamVanHieu-NhomX-SOF304-AdvanceTest\\sof304.xlsx",
				"Recipe");
		// Input data
		congThucDAO = new CongThucDAO();
		String MaCT = Data.getCellData(8, 4);
		String TenCT = Data.getCellData(9, 4);
		// Update data
		String UMaCT = Data.getCellData(12, 4);
		String UTenCT = Data.getCellData(13, 4);
		System.out.println(UMaCT + UTenCT);
		// Expected
		String Emact = Data.getCellData(8, 5);
		String EtenCT = Data.getCellData(9, 5);
		CongThuc congThuc = new CongThuc();
		// insert
		congThuc.setMaCT(Integer.parseInt(MaCT));
		congThuc.setTenCT(TenCT);
		congThucDAO.insert(congThuc);
		// update
		CongThuc ct = new CongThuc();
		ct.setMaCT(Integer.parseInt(UMaCT));
		ct.setTenCT(UTenCT);
		congThucDAO.update(ct);

		// Expected the code to test

		congThuc = congThucDAO.selectById(MaCT);
		// Assert.assertNotNull(updated);
		Assert.assertEquals(EtenCT, congThuc.getTenCT());
		Assert.assertEquals(Integer.parseInt(Emact), congThuc.getMaCT());
		// Clean up the inserted data
		congThucDAO.delete(UMaCT);
	}

	// Id: TC04
	@Test
	public void updateTestFail() throws Exception {

		Data.setExcelFile(
				"D:\\FPT-Polytechnic\\SOF304-AdvanceTest\\PS33100-PhamVanHieu-NhomX-SOF304-AdvanceTest\\sof304.xlsx",
				"Recipe");
		// Input data
		String MaCT = Data.getCellData(8, 4);
		String TenCT = Data.getCellData(9, 4);
		// Update data
		String UMaCT = Data.getCellData(15, 4);
		String UTenCT = Data.getCellData(16, 4);
		CongThuc congThuc = new CongThuc();
		congThuc.setMaCT(Integer.parseInt(MaCT));
		congThuc.setTenCT(TenCT);
		congThucDAO = new CongThucDAO();
		congThucDAO.insert(congThuc);
		congThuc.setMaCT(Integer.parseInt(UMaCT));
		congThuc.setTenCT(UTenCT);
		congThucDAO.update(congThuc);
		// Expected the code to test
		String Emact = Data.getCellData(12, 5);
		String EtenCT = Data.getCellData(13, 5);
		CongThuc updated = congThucDAO.selectById(UMaCT);
		Assert.assertNotNull(updated);
		Assert.assertEquals(EtenCT, updated.getTenCT());
		Assert.assertEquals(Integer.parseInt(Emact), updated.getMaCT());
		// Clean up the inserted data
		congThucDAO.delete(UMaCT);

	}

	@Test
	public void testFind() throws Exception {

		Data.setExcelFile(
				"D:\\FPT-Polytechnic\\SOF304-AdvanceTest\\PS33100-PhamVanHieu-NhomX-SOF304-AdvanceTest\\sof304.xlsx",
				"Recipe");
		// Input data
		String MaCT = Data.getCellData(8, 4);
		String TenCT = Data.getCellData(9, 4);
		CongThuc congThuc = new CongThuc();
		// Expected
		String Emact = Data.getCellData(8, 5);
		String EtenCT = Data.getCellData(9, 5);

		congThuc.setMaCT(Integer.parseInt(MaCT));
		congThuc.setTenCT(TenCT);
		congThucDAO = new CongThucDAO();
		congThucDAO.insert(congThuc);
		CongThuc updated = congThucDAO.selectById(Emact);

		Assert.assertNotNull(updated);
		Assert.assertEquals(EtenCT, updated.getTenCT());
		Assert.assertEquals(Integer.parseInt(Emact), updated.getMaCT());
		// Clean up the inserted data
		congThucDAO.delete(MaCT);

	}

	// Id: TC06
	@Test
	public void deleteTest() throws Exception {

		Data.setExcelFile(
				"D:\\FPT-Polytechnic\\SOF304-AdvanceTest\\PS33100-PhamVanHieu-NhomX-SOF304-AdvanceTest\\sof304.xlsx",
				"Recipe");
		// Input data
		String MaCT = Data.getCellData(8, 4);
		String TenCT = Data.getCellData(9, 4);
		CongThuc congThuc = new CongThuc();
		congThuc.setMaCT(Integer.parseInt(MaCT));
		congThuc.setTenCT(TenCT);
		congThucDAO = new CongThucDAO();
		congThucDAO.insert(congThuc);
		congThucDAO.delete(MaCT);
		CongThuc deletedCongThuc = congThucDAO.selectById(MaCT);
		Assert.assertNull(deletedCongThuc);
		System.out.println("Delete thành công");

	}
}
