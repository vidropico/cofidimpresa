package it.cofidimpresa.documents;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.xwpf.usermodel.Borders;
import org.apache.poi.xwpf.usermodel.LineSpacingRule;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import it.cofidimpresa.controller.DocumentController;
import it.cofidimpresa.data.FinanziamentiData;
import it.cofidimpresa.data.SociData;
import it.cofidimpresa.data.StateObjectData;

@PropertySource("classpath:application.properties")
public class DomandaBanca extends CommonDocument {
	private static final Logger logger = Logger.getLogger(DomandaBanca.class);
	
	@Value("${document.path}")
	private String pathDocument;
	
	public void createDomandaBanca(Integer idSocio, Integer idFinanziamenti) {
		try {
			logger.debug("*** createDomandaBanca ***");
			super.init(idSocio, idFinanziamenti);
			
			String fileName = pathDocument.concat("DomandaBanca_").concat(socio.getImpresa().concat(".doc"));
			FileOutputStream out = new FileOutputStream(new File(fileName));

			super.setTestata();

			XWPFParagraph paragraph = document.createParagraph();
			paragraph.setBorderBottom(Borders.BASIC_BLACK_DASHES);
			paragraph.setBorderLeft(Borders.BASIC_BLACK_DASHES);
			paragraph.setBorderRight(Borders.BASIC_BLACK_DASHES);
			paragraph.setBorderTop(Borders.BASIC_BLACK_DASHES);
			paragraph.setAlignment(ParagraphAlignment.RIGHT);

			XWPFRun run = paragraph.createRun();
			run.setBold(true);
			run.setText("Spett.Le Banca di Credito Coop");
			run.addBreak();
			run.setText("BCC Casagiove");
			run.addBreak();

			XWPFParagraph paragraph3 = document.createParagraph();
			paragraph3.setBorderBottom(Borders.BASIC_BLACK_DASHES);
			paragraph3.setBorderLeft(Borders.BASIC_BLACK_DASHES);
			paragraph3.setBorderRight(Borders.BASIC_BLACK_DASHES);
			paragraph3.setBorderTop(Borders.BASIC_BLACK_DASHES);
			paragraph3.setSpacingLineRule(LineSpacingRule.valueOf(2));
			
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
			run4.setText(" GARANZIA DEL ".concat(finanziamentiData.getPercentualeGaranzia()).concat("%"));
			run4.addBreak();

			XWPFParagraph paragraph5 = document.createParagraph();
			paragraph5.setBorderBottom(Borders.BASIC_BLACK_DASHES);
			paragraph5.setBorderLeft(Borders.BASIC_BLACK_DASHES);
			paragraph5.setBorderRight(Borders.BASIC_BLACK_DASHES);
			paragraph5.setBorderTop(Borders.BASIC_BLACK_DASHES);

			XWPFRun run5 = paragraph5.createRun();
			run5.setText(
					"al finanziamento che codesta Banca di Credito Coop BCC Casagiove vorrà concedere, dell'importo di "
							.concat(Integer.toString(finanziamentiData.getImportoDeliberato()))
							.concat(",00 da rimborsare in n.").concat(finanziamentiData.getRate()).concat(" mensili."));
			run5.addBreak();
			run5.setText(
					"Sul finanziamento saranno addebitati a favore di CONFIDI IMPRESA sul c/c 1963 gli importi come indicato in allegato.");
			run5.addBreak();
			run5.addBreak();

			run5.setText("Caserta il");
			run5.addBreak();

			XWPFParagraph paragraph6 = document.createParagraph();
			paragraph6.setBorderBottom(Borders.BASIC_BLACK_DASHES);
			paragraph6.setBorderLeft(Borders.BASIC_BLACK_DASHES);
			paragraph6.setBorderRight(Borders.BASIC_BLACK_DASHES);
			paragraph6.setBorderTop(Borders.BASIC_BLACK_DASHES);
			paragraph6.setAlignment(ParagraphAlignment.RIGHT);

			XWPFRun run6 = paragraph6.createRun();
			run6.setBold(true);
			run6.setText("IL DIRETTORE");
			run6.addBreak();
			run6.setText("FRANCESCO D'ARGENZIO");
			
			document.write(out);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.debug("*** end createDomandaBanca ***");
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
		run3.setText("Attività: ".concat(socio.getTipologiaMerceologica()));
		run3.addBreak();
		run3.addBreak();
		run3.setText(qualitaTitolare.get(0).getDescrizione().concat(": ").concat(socio.getCognome()).concat(" ")
				.concat(socio.getNome()).concat(", C.F: ").concat(socio.getCodiceFiscale()).concat(" nato a")
				.concat(socio.getLuogoDiNascita()).concat(" il ").concat(socio.getDataDiNascita())
				.concat(", residente in ").concat(socio.getCittaResidenza()).concat(" (")
				.concat(socio.getProvinciaResidenza()).concat(") ").concat(socio.getIndirizzoResidenza())
				.concat(" cap ").concat(socio.getCapResidenza()));
		run3.addBreak();
	}

	private void setBodyDitta(SociData socio, XWPFRun run3) {
		run3.setText("CONFIDI IMPRESA in data ".concat(finanziamentiData.getDataApprovazioneConsiglio())
				.concat(" ha deliberato di concedere alla ditta ").concat(socio.getImpresa()).concat(" con sede in ")
				.concat(socio.getCittaSedeLegale()).concat(" (").concat(socio.getProvinciaSedeLegale()).concat(") ")
				.concat(socio.getIndirizzoSedeLegale()).concat(" cap ").concat(socio.getCapSedeLegale())
				.concat(", con partita iva ").concat(socio.getPartitaIva()).concat(", tel: ")
				.concat(socio.getTelefono()).concat(" cell: ").concat(socio.getMobile()));
		run3.addBreak();
		run3.addBreak();
		run3.setText(socio.getTipologiaMerceologica());
		run3.addBreak();
		run3.addBreak();
		run3.setText("TITOLARE: ".concat(socio.getCognome()).concat(" ").concat(socio.getNome()).concat(", C.F: ")
				.concat(socio.getCodiceFiscale()).concat(" nato a").concat(socio.getLuogoDiNascita()).concat(" il ")
				.concat(socio.getDataDiNascita()).concat(", residente in ").concat(socio.getCittaResidenza())
				.concat(" (").concat(socio.getProvinciaResidenza()).concat(") ").concat(socio.getIndirizzoResidenza())
				.concat(" cap ").concat(socio.getCapResidenza()));
		run3.addBreak();
	}
}
