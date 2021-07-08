package com.interfile.assessment.services;

import org.springframework.stereotype.Service;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.interfile.assessment.entity.Account;
import com.interfile.assessment.entity.Bills;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.Path;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
public class UtilService {
	public void processXML(File file) {
		try {
			Account account = new Account();
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
			doc.getDocumentElement().normalize();
			NodeList nodeList = doc.getElementsByTagName("statement");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Element statementNode = (Element) nodeList.item(i);
				account.setId(Integer.parseInt(statementNode.getAttribute("id").substring(18)));
				for (int k = 0; k < statementNode.getChildNodes().getLength(); k++) {
					if ("account".equals(statementNode.getChildNodes().item(k).getNodeName())) {
						Element accountElement = (Element) statementNode.getChildNodes().item(k);
						account.setAccountNumber(accountElement.getElementsByTagName("accountNumber").item(0).getTextContent());
						account.setAccountHolder(accountElement.getElementsByTagName("accountHolderName").item(0).getTextContent());
						account.setAccountHolderIdNumber(accountElement.getElementsByTagName("accountHolderIDNumber").item(0).getTextContent());
						for (int u = 0; u < accountElement.getChildNodes().getLength(); u++) {
							Node childNode = accountElement.getChildNodes().item(u);
							if ("accountHolderDetails".equals(childNode.getNodeName())) {
								for (int g = 0; g < childNode.getChildNodes().getLength(); g++) {
									if ("contactDetails".equals(childNode.getChildNodes().item(g).getNodeName())) {
										Element contactDetails = (Element)childNode.getChildNodes().item(g);
										account.setMobileNumber(contactDetails.getElementsByTagName("mobile").item(0).getTextContent());
										account.setHomeNumber(contactDetails.getElementsByTagName("home").item(0).getTextContent());
										account.setWorkNumber(contactDetails.getElementsByTagName("work").item(0).getTextContent());
										new AccountService().create(account);
									}
									if ("addressDetails".equals(childNode.getChildNodes().item(g).getNodeName())) {
//										System.out.println("=================addressDetails");
//										Node addressNode = childNode.getChildNodes().item(g);
//										Element address = (Element)addressNode.getChildNodes().item(i);
//										System.out.println("====================" + address.getElementsByTagName("line1").item(0).getTextContent());
									}
								}
							}
							if ("bills".equals(childNode.getNodeName())) {
								for (int o = 0; o < childNode.getChildNodes().getLength(); o++) {
									if ("bill".equals(childNode.getChildNodes().item(o).getNodeName())) {
										Bills bills = new Bills();
										Element bill = (Element)childNode.getChildNodes().item(o);
										bills.setBillDate(bill.getElementsByTagName("billDate").item(0).getTextContent());
										bills.setPeriod(bill.getElementsByTagName("period").item(0).getTextContent());
										bills.setCharges(bill.getElementsByTagName("charges").item(0).getTextContent());
										bills.setOutstanding(bill.getElementsByTagName("outstanding").item(0).getTextContent());
										bills.setDueDate(bill.getElementsByTagName("dueDate").item(0).getTextContent());
										bills.setAccount(account);
//										new BillsService().create(bills);
									}
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void generatePDF() {
		com.itextpdf.text.Document document = new com.itextpdf.text.Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream("C:/Users/Christopher/Downloads/iTextTable.pdf"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		document.open();

		PdfPTable table = new PdfPTable(3);
		addTableHeader(table);
		addRows(table);
		try {
			addCustomRows(table);
		} catch (BadElementException | URISyntaxException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			document.add(table);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		document.close();
	}

	private void addTableHeader(PdfPTable table) {
		Stream.of("column header 1", "column header 2", "column header 3").forEach(columnTitle -> {
			PdfPCell header = new PdfPCell();
			header.setBackgroundColor(BaseColor.LIGHT_GRAY);
			header.setBorderWidth(2);
			header.setPhrase(new Phrase(columnTitle));
			table.addCell(header);
		});
	}

	private void addRows(PdfPTable table) {
		table.addCell("row 1, col 1");
		table.addCell("row 1, col 2");
		table.addCell("row 1, col 3");
	}

	private void addCustomRows(PdfPTable table) throws URISyntaxException, BadElementException, IOException {
		java.nio.file.Path path = Paths.get(ClassLoader.getSystemResource("Java_logo.png").toURI());
		Image img = Image.getInstance(path.toAbsolutePath().toString());
		img.scalePercent(10);

		PdfPCell imageCell = new PdfPCell(img);
		table.addCell(imageCell);

		PdfPCell horizontalAlignCell = new PdfPCell(new Phrase("row 2, col 2"));
		horizontalAlignCell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
		table.addCell(horizontalAlignCell);

		PdfPCell verticalAlignCell = new PdfPCell(new Phrase("row 2, col 3"));
		verticalAlignCell.setVerticalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
		table.addCell(verticalAlignCell);
	}
}
