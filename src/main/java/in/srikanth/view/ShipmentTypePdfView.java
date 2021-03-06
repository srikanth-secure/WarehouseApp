package in.srikanth.view;

import java.awt.Color;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
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

		Font dateFont = new Font(Font.TIMES_ROMAN, 12, Font.NORMAL, Color.black);
		Paragraph datePara = new Paragraph(new Date().toString(), dateFont);
		datePara.setAlignment(Element.ALIGN_RIGHT);
		document.add(datePara);

		// create paragraph element
		Font titleFont = new Font(Font.TIMES_ROMAN, 22, Font.BOLD, new Color(82, 192, 247));
		Paragraph titlePara = new Paragraph("Shipment Type Data", titleFont);
		titlePara.setSpacingAfter(10.0f);
		titlePara.setAlignment(Element.ALIGN_CENTER);
		document.add(titlePara);// add element to document

		PdfPTable table = new PdfPTable(6);
		table.setSpacingBefore(4.0f);
		table.setTotalWidth(new float[] { 0.5f, 1.5f, 1.5f, 1.5f, 1.0f, 2.5f });

		Font tabHeadFont = new Font(Font.HELVETICA, 13, Font.NORMAL, Color.GRAY);
		table.addCell(new Phrase("Id", tabHeadFont));
		table.addCell(new Phrase("Mode", tabHeadFont));
		table.addCell(new Phrase("Code", tabHeadFont));
		table.addCell(new Phrase("Enabled", tabHeadFont));
		table.addCell(new Phrase("Grade", tabHeadFont));
		table.addCell(new Phrase("Description", tabHeadFont));

		Font tabBodyFont = new Font(Font.HELVETICA, 12, Font.NORMAL, Color.black);
		for (ShipmentType stype : list) {
			// table.addCell(uom.getId().toString());
			table.addCell(new Phrase(String.valueOf(stype.getId()), tabBodyFont));
			table.addCell(new Phrase(stype.getShipmentMode(), tabBodyFont));
			table.addCell(new Phrase(stype.getShipmentCode(), tabBodyFont));
			table.addCell(new Phrase(stype.getEnableShipment(), tabBodyFont));
			table.addCell(new Phrase(stype.getShipmentGrade(), tabBodyFont));
			table.addCell(new Phrase(stype.getDescription(), tabBodyFont));
		}
		document.add(table);
	}
}