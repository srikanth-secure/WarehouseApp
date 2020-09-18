package in.srikanth.view;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.srikanth.model.ShipmentType;

public class ShipmentTypePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.addHeader("Content-Disposition", "attachment;filename=shipmentType.pdf");

		// reading data from model
		@SuppressWarnings("unchecked")
		List<ShipmentType> list = (List<ShipmentType>) model.get("list");

		// create paragraph element
		Font font = new Font(Font.TIMES_ROMAN, 22, Font.BOLD, new Color(82, 192, 247));
		Paragraph para = new Paragraph("Shipment Type Data", font);
		para.setSpacingAfter(10.0f);
		para.setAlignment(Element.ALIGN_CENTER);
		// add element to document
		document.add(para);

		PdfPTable table = new PdfPTable(6);
		table.addCell("Id");
		table.addCell("Mode");
		table.addCell("Code");
		table.addCell("Enabled");
		table.addCell("Grade");
		table.addCell("Description");
		for (ShipmentType stype : list) {
			// table.addCell(uom.getId().toString());
			table.addCell(String.valueOf(stype.getId()));
			table.addCell(stype.getShipmentCode());
			table.addCell(stype.getShipmentCode());
			table.addCell(stype.getEnableShipment());
			table.addCell(stype.getShipmentGrade());
			table.addCell(stype.getDescription());
		}
		document.add(table);
	}
}