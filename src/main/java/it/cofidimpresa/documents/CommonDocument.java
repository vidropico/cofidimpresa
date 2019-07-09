package it.cofidimpresa.documents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.FontFamily;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.Borders;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import it.cofidimpresa.data.FinanziamentiData;
import it.cofidimpresa.data.SociData;
import it.cofidimpresa.facades.FinanziamentiFacade;
import it.cofidimpresa.facades.QualitaTitolareFacade;
import it.cofidimpresa.facades.SociFacade;

public class CommonDocument {
	private static final Logger logger = Logger.getLogger(CommonDocument.class);
	
	@Resource(name = "finanziamentiFacade")
	FinanziamentiFacade finanziamentiFacade;

	@Resource(name = "sociFacade")
	SociFacade sociFacade;

	@Resource(name = "qualitaTitolareFacade")
	QualitaTitolareFacade qualitaTitolareFacade;

	String rootPath = null;

	SociData socio = null;
	FinanziamentiData finanziamentiData= null;
	
	XWPFDocument document = null;
	
	XWPFParagraph paragraph = null;

	public void init(Integer idSocio, Integer idFinanziamenti) throws ParseException {
		document = new XWPFDocument(); 
		rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		logger.debug("*** Cerca socio per Documento ***");
		socio = sociFacade.dettaglioSocio(idSocio);
		logger.debug("*** Socio Id="+socio.getIdSoci()+" ***");
		finanziamentiData = finanziamentiFacade.getFinanziamentiById(idFinanziamenti);
		logger.debug("*** Finanziamento Id="+finanziamentiData.getIdFinanziamenti()+" ***");
	}
	
	public void setTestata() throws InvalidFormatException, FileNotFoundException, IOException {
		
		XWPFParagraph paragraph = document.createParagraph();
		paragraph.setBorderBottom(Borders.BASIC_BLACK_DASHES);
		paragraph.setBorderLeft(Borders.BASIC_BLACK_DASHES);
		paragraph.setBorderRight(Borders.BASIC_BLACK_DASHES);
		paragraph.setBorderTop(Borders.BASIC_BLACK_DASHES);
		paragraph.setAlignment(ParagraphAlignment.CENTER);

		XWPFRun run = paragraph.createRun();
		String imageTestata = rootPath + "_ui/images/ImgTestata.jpg";
		run.addPicture(new FileInputStream(imageTestata), XWPFDocument.PICTURE_TYPE_JPEG, "ImgTestata.jpg",
				Units.toEMU(350), Units.toEMU(100));
		run.addBreak();
	}
	
	public void setDelibera() {
		XWPFParagraph paragraph1 = document.createParagraph();
		paragraph1.setBorderBottom(Borders.BASIC_BLACK_DASHES);
		paragraph1.setBorderLeft(Borders.BASIC_BLACK_DASHES);
		paragraph1.setBorderRight(Borders.BASIC_BLACK_DASHES);
		paragraph1.setBorderTop(Borders.BASIC_BLACK_DASHES);
		paragraph1.setAlignment(ParagraphAlignment.RIGHT);

		XWPFRun run1 = paragraph1.createRun();
		run1.setBold(true);
		run1.setFontFamily(FontFamily.ROMAN.toString());
		run1.setText("Delibera del ".concat(finanziamentiData.getDataApprovazioneConsiglio()));
		run1.addBreak();
	}
}
