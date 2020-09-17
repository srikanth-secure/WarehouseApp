package in.srikanth.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import in.srikanth.model.ShipmentType;

public class ShipmentTypeExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.addHeader("Content-Disposition", "attachment;filename=shipmenttyps.xls");
		@SuppressWarnings("unchecked")
		List<ShipmentType> list = (List<ShipmentType>) model.get("list");

		Sheet sheet = workbook.createSheet("ShipmentTyp");
		setHeader(sheet);
		setBody(sheet, list);
	}

	private void setHeader(Sheet sheet) {
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("MODE");
		row.createCell(2).setCellValue("CODE");
		row.createCell(3).setCellValue("ENABLED");
		row.createCell(4).setCellValue("GRADE");
		row.createCell(5).setCellValue("DESCRIPTION");
	}

	private void setBody(Sheet sheet, List<ShipmentType> list) {
		int rowNum = 1;
		for (ShipmentType shipmentType : list) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(shipmentType.getId());
			row.createCell(1).setCellValue(shipmentType.getShipmentMode());
			row.createCell(2).setCellValue(shipmentType.getShipmentCode());
			row.createCell(3).setCellValue(shipmentType.getEnableShipment());
			row.createCell(4).setCellValue(shipmentType.getShipmentGrade());
			row.createCell(5).setCellValue(shipmentType.getDescription());
		}
	}
}