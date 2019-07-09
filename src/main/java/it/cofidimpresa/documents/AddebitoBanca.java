package it.cofidimpresa.documents;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.xwpf.usermodel.Borders;
import org.apache.poi.xwpf.usermodel.LineSpacingRule;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import it.cofidimpresa.data.FinanziamentiData;
import it.cofidimpresa.data.SociData;
import it.cofidimpresa.data.StateObjectData;

@PropertySource("classpath:application.properties") 
public class AddebitoBanca extends CommonDocument {

	@Value("${document.path}")
	private String pathDocument;
	
	public void createAddebitooBanca(Integer idSocio, Integer idFinanziamenti) {
		try {
			
			super.init(idSocio, idFinanziamenti);

			String fileName = pathDocument.concat("AddebitoBanca_").concat(socio.getImpresa().concat(".doc"));
			FileOutputStream out = new FileOutputStream(new File(pathDocument+fileName));

			super.setTestata();

			super.setDelibera();

			XWPFParagraph paragraph2 = document.createParagraph();
			paragraph2.setBorderBottom(Borders.BASIC_BLACK_DASHES);
			paragraph2.setBorderLeft(Borders.BASIC_BLACK_DASHES);
			paragraph2.setBorderRight(Borders.BASIC_BLACK_DASHES);
			paragraph2.setBorderTop(Borders.BASIC_BLACK_DASHES);

			XWPFRun run2 = paragraph2.createRun();
			run2.setBold(true);
			run2.setText(socio.getImpresa());
			run2.addBreak();

			XWPFParagraph paragraph3 = document.createParagraph();
			paragraph3.setBorderBottom(Borders.BASIC_BLACK_DASHES);
			paragraph3.setBorderLeft(Borders.BASIC_BLACK_DASHES);
			paragraph3.setBorderRight(Borders.BASIC_BLACK_DASHES);
			paragraph3.setBorderTop(Borders.BASIC_BLACK_DASHES);
			paragraph3.setSpacingAfterLines(2);
			paragraph3.setSpacingBeforeLines(2);
			paragraph3.setSpacingLineRule(LineSpacingRule.EXACT);
			XWPFRun run3 = paragraph3.createRun();
			run3.setBold(false);
			if (socio.getIdTipoSocieta() == 1) {
				setBodyDitta(socio, run3);
			} else {
				setBodyImpresa(socio, finanziamentiData, run3);
			}
			XWPFParagraph paragraph4 = document.createParagraph();
			paragraph4.setBorderBottom(Borders.BASIC_BLACK_DASHES);
			paragraph4.setBorderLeft(Borders.BASIC_BLACK_DASHES);
			paragraph4.setBorderRight(Borders.BASIC_BLACK_DASHES);
			paragraph4.setBorderTop(Borders.BASIC_BLACK_DASHES);
			paragraph4.setAlignment(ParagraphAlignment.CENTER);

			XWPFRun run4 = paragraph4.createRun();
			run4.setBold(true);
			run4.setText("Attività: ".concat(socio.getTipologiaMerceologica()));
			run4.addBreak();

			XWPFParagraph paragraph7 = document.createParagraph();
			paragraph7.setBorderBottom(Borders.BASIC_BLACK_DASHES);
			paragraph7.setBorderLeft(Borders.BASIC_BLACK_DASHES);
			paragraph7.setBorderRight(Borders.BASIC_BLACK_DASHES);
			paragraph7.setBorderTop(Borders.BASIC_BLACK_DASHES);
			paragraph7.setAlignment(ParagraphAlignment.CENTER);
			
			XWPFRun run7 = paragraph7.createRun();
			run7.setBold(true);
			run7.setText(" GARANZIA DEL ".concat(finanziamentiData.getPercentualeGaranzia()).concat("%"));
			run7.addBreak();

			XWPFParagraph paragraph5 = document.createParagraph();
			paragraph5.setBorderBottom(Borders.BASIC_BLACK_DASHES);
			paragraph5.setBorderLeft(Borders.BASIC_BLACK_DASHES);
			paragraph5.setBorderRight(Borders.BASIC_BLACK_DASHES);
			paragraph5.setBorderTop(Borders.BASIC_BLACK_DASHES);

			XWPFRun run5 = paragraph5.createRun();
			run5.setBold(true);
			run5.setText("Sull' importo di ".concat(Integer.toString(finanziamentiData.getImportoDeliberato()))
					.concat(",00 da restituire in ").concat(finanziamentiData.getRate()).concat(" mensili."));
			run5.addBreak();
			run5.addBreak();

			run5.setText("ISCRIZIONE");
			run5.addBreak();
			run5.addBreak();

			run5.setText("ISTRUTTORIA PRATICA");
			run5.addBreak();
			run5.addBreak();

			run5.setText("PERCENTUALE");
			run5.addBreak();
			run5.addBreak();

			run5.setText("Caserta il");
			run5.addBreak();

			XWPFParagraph paragraph8 = document.createParagraph();
			paragraph8.setBorderBottom(Borders.BASIC_BLACK_DASHES);
			paragraph8.setBorderLeft(Borders.BASIC_BLACK_DASHES);
			paragraph8.setBorderRight(Borders.BASIC_BLACK_DASHES);
			paragraph8.setBorderTop(Borders.BASIC_BLACK_DASHES);
			paragraph8.setAlignment(ParagraphAlignment.RIGHT);
			
			XWPFRun run8 = paragraph8.createRun();
			run8.setBold(true);
			run8.setText("IL DIRETTORE");
			run8.addBreak();
			run8.setText("FRANCESCO D'ARGENZIO");

			document.write(out);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setBodyImpresa(SociData socio, FinanziamentiData finanziamentiData, XWPFRun run3) {
		List<StateObjectData> qualitaTitolare = qualitaTitolareFacade.getQualitaTitolare(socio.getIdQualitaTitolare());
		run3.setText("CONFIDI IMPRESA in data ".concat(finanziamentiData.getDataApprovazioneConsiglio())
				.concat(" ha deliberato di concedere alla società ").concat(socio.getImpresa()).concat(" con sede in ")
				.concat(socio.getCittaSedeLegale()).concat(" (").concat(socio.getProvinciaSedeLegale()).concat(") ")
				.concat(socio.getIndirizzoSedeLegale()).concat(" cap ").concat(socio.getCapSedeLegale())
				.concat(", con partita iva ").concat(socio.getPartitaIva()).concat(", tel: ")
				.concat(socio.getTelefono()).concat(" cell: ").concat(socio.getMobile()));
		run3.addBreak();
		run3.addBreak();
		run3.setText(qualitaTitolare.get(0).getDescrizione());
		run3.addBreak();
		run3.addBreak();
		run3.setText(socio.getCognome().concat(" ").concat(socio.getNome()).concat(", C.F: ")
				.concat(socio.getCodiceFiscale()).concat(" nato a").concat(socio.getLuogoDiNascita()).concat(" il ")
				.concat(socio.getDataDiNascita()).concat(", residente in ").concat(socio.getCittaResidenza())
				.concat(" (").concat(socio.getProvinciaResidenza()).concat(") ").concat(socio.getIndirizzoResidenza())
				.concat(" cap ").concat(socio.getCapResidenza()));
		run3.addBreak();
	}

	private void setBodyDitta(SociData socio, XWPFRun run3) {
		run3.setText("C.F: ".concat(socio.getCodiceFiscale()).concat(" nato a").concat(socio.getLuogoDiNascita())
				.concat(" il ").concat(socio.getDataDiNascita()).concat(", residente in ")
				.concat(socio.getCittaResidenza()).concat(" (").concat(socio.getProvinciaResidenza()).concat(") ")
				.concat(socio.getIndirizzoResidenza()).concat(" cap ").concat(socio.getCapResidenza())
				.concat("in qualità di Titolare dell' Impresa Individuale ").concat(socio.getImpresa())
				.concat(" con partita iva ").concat(socio.getPartitaIva()).concat(" sede in ")
				.concat(socio.getCittaSedeLegale()).concat(" (").concat(socio.getProvinciaSedeLegale()).concat(") ")
				.concat(socio.getIndirizzoSedeLegale()).concat(" cap ").concat(socio.getCapSedeLegale())
				.concat(" tel: ").concat(socio.getTelefono()).concat(" cell: ").concat(socio.getMobile()));
		run3.addBreak();
	}

}
//
// System.out.println("---------- Text Write to File ------------");
//
// //Table 생성
// XWPFTable table = document.createTable();
// //row추가
// XWPFTableRow rowOne = table.getRow(0);
// rowOne.getCell(0).setText("Col One, Row One");
// rowOne.addNewTableCell().setText("Col Tow, Row One");
// rowOne.addNewTableCell().setText("Col Three, Row One");
// //row추가
// XWPFTableRow rowTow = table.createRow();
// rowTow.getCell(0).setText("Col One, Row Tow");
// rowTow.getCell(1).setText("Col Tow, Row Tow");
// rowTow.getCell(2).setText("Col Three, Row Tow");
// //row추가
// XWPFTableRow rowThree = table.createRow();
// rowThree.getCell(0).setText("Col One, Row Three");
// rowThree.getCell(1).setText("Col Tow, Row Three");
// rowThree.getCell(2).setText("Col Three, Row Three");
// System.out.println("---------- Create Table Success ------------");
//
// //Add Image
// XWPFParagraph imageParagraph = document.createParagraph();
// XWPFRun imageRun = imageParagraph.createRun();
// imageRun.addPicture(new FileInputStream("test.png"),
// XWPFDocument.PICTURE_TYPE_PNG,"test.png", Units.toEMU(300),
// Units.toEMU(300));
// System.out.println("---------- Create Image Success ------------");
//
// //Hyperlink
// XWPFParagraph hyperlink = document.createParagraph();
// String id =
// hyperlink.getDocument().getPackagePart().addExternalRelationship("http://niee.kr",
// XWPFRelation.HYPERLINK.getRelation()).getId();
// CTR ctr = CTR.Factory.newInstance();
// CTHyperlink ctHyperlink = hyperlink.getCTP().addNewHyperlink();
// ctHyperlink.setId(id);
//
// CTText ctText = CTText.Factory.newInstance();
// ctText.setStringValue("Hyper-Link TEST");
// ctr.setTArray(new CTText[]{ctText});
//
// //설정 하이퍼링크 스타일
// CTColor color = CTColor.Factory.newInstance();
// color.setVal("0000FF");
// CTRPr ctrPr = ctr.addNewRPr();
// ctrPr.setColor(color);
// ctrPr.addNewU().setVal(STUnderline.SINGLE);
//
// //글꼴 설정
// CTFonts fonts = ctrPr.isSetRFonts() ? ctrPr.getRFonts() :
// ctrPr.addNewRFonts();
// fonts.setAscii("마이크로소프트 雅黑");
// fonts.setEastAsia("마이크로소프트 雅黑");
// fonts.setHAnsi("마이크로소프트 雅黑");
//
// //글꼴 크기 설정
// CTHpsMeasure sz = ctrPr.isSetSz() ? ctrPr.getSz() : ctrPr.addNewSz();
// sz.setVal(new BigInteger("24"));
// ctHyperlink.setRArray(new CTR[]{ctr});
// hyperlink.setAlignment(ParagraphAlignment.LEFT);
// hyperlink.setVerticalAlignment(TextAlignment.CENTER);
// System.out.println("---------- Create Hyperlink Success ------------");
//
// //Font style
// XWPFParagraph fontStyle = document.createParagraph();
//
// //set Bold an Italic
// XWPFRun boldAnItalic = fontStyle.createRun();
// boldAnItalic.setBold(true);
// boldAnItalic.setItalic(true);
// boldAnItalic.setText("Bold an Italic");
// boldAnItalic.addBreak();
//
// //set Text Position
// XWPFRun textPosition = fontStyle.createRun();
// textPosition.setText("Set Text Position");
// textPosition.setTextPosition(100);
//
// //Set Strike through and font Size and Subscript
// XWPFRun otherStyle = fontStyle.createRun();
// otherStyle.setStrike(true);
// otherStyle.setFontSize(20);
// otherStyle.setSubscript(VerticalAlign.SUBSCRIPT);
// otherStyle.setText(" Set Strike through and font Size and Subscript");
// System.out.println("---------- Set Font Style ------------");
//
// //Set Alignment Paragraph
// XWPFParagraph alignment = document.createParagraph();
// //Alignment to Right
// alignment.setAlignment(ParagraphAlignment.RIGHT);
//
// XWPFRun alignRight = alignment.createRun();
// alignRight.setText("At tutorialspoint.com, we strive hard to " +
// "provide quality tutorials for self-learning " +
// "purpose in the domains of Academics, Information " +
// "Technology, Management and Computer Programming " +
// "Languages.");
//
// //Alignment to Center
// alignment = document.createParagraph();
// //Alignment to Right
// alignment.setAlignment(ParagraphAlignment.CENTER);
// XWPFRun alignCenter = alignment.createRun();
// alignCenter.setText("The endeavour started by Mohtashim, an AMU " +
// "alumni, who is the founder and the managing director " +
// "of Tutorials Point (I) Pvt. Ltd. He came up with the " +
// "website tutorialspoint.com in year 2006 with the help" +
// "of handpicked freelancers, with an array of tutorials" +
// " for computer programming languages. ");
// System.out.println("---------- Set Alignment ------------");
//
// //word 파일 저장
// document.write(out);
// out.close();
// System.out.println("---------- Save File Name : " + fileName + "
// ------------");
// System.out.println("---------- Word Create End ------------");
