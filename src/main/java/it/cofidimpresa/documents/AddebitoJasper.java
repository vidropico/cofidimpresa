package it.cofidimpresa.documents;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import it.cofidimpresa.data.SociData;
import it.cofidimpresa.data.StateObjectData;
import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.Exporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

@PropertySource("classpath:application.properties")
public class AddebitoJasper extends CommonDocument {
	private static final Logger logger = Logger.getLogger(AddebitoJasper.class);
	
	@Value("${document.path}")
	private String pathDocument;
	
	@Value("${document.template.jasper}")
	private String pathTemplate;
	
	public String createAddebito(Integer idSocio, Integer idFinanziamenti) {
		try {
			super.init(idSocio, idFinanziamenti);
			String fileTemplate = pathTemplate+"AddebitoBancaA4.jrxml";
			String imageTestata ="_ui/images/ImgTestata.jpg";
			String imagePieDiLista = "_ui/images/ImagePieDiLista.png";
			logger.debug("******* Path template Jasper ******");
			logger.debug(fileTemplate);

			JasperDesign jd =JRXmlLoader.load(fileTemplate);
	       
		    HashMap params = new HashMap();
		    params.put("imageTestata", imageTestata);
	        params.put("data_Delibera", "Delibera del ".concat(finanziamentiData.getDataApprovazioneConsiglio()));
	        params.put("azienda",socio.getImpresa());
	        if (socio.getIdTipoSocieta() == 1) {
				params.put("parte_uno", setBodyDitta(socio));
			} else {
				params.put("parte_uno", setBodyImpresa(socio));
				params.put("titolare", setQualitaTitolare(socio));
				params.put("dati_titolare", setDatiTitolare(socio));
			}
	        
	        params.put("attivita", "ATTIVITA': ".concat(socio.getTipologiaMerceologica()));
			params.put("garanzia"," GARANZIA DEL ".concat(finanziamentiData.getPercentualeGaranzia()).concat("%"));
			
			params.put("sommario_uno","ISCRIZIONE ".concat(Double.toString(socio.getImportoQuote())));
			params.put("sommario_due","ISTRUTTORIA PRATICA ".concat(Double.toString(finanziamentiData.getCostoIstruttoria())));
			params.put("sommario_tre","PERCENTUALE ".concat(finanziamentiData.getCosti()));
						
			params.put("parte_finanziaria","Sull' importo di ".concat(Integer.toString(finanziamentiData.getImportoDeliberato()))
					.concat(",00 da restituire in ").concat(finanziamentiData.getRateRichieste()).concat(" mensili."));
			params.put("imagePieDiLista", imagePieDiLista);
			
	        JasperReport jr=JasperCompileManager.compileReport(jd);
	        JRDataSource jEmptyDataSource = new JREmptyDataSource();
	        JasperPrint jp=JasperFillManager.fillReport(jr, params, jEmptyDataSource);

	        JRDocxExporter exporter = new JRDocxExporter(DefaultJasperReportsContext.getInstance());
	        exporter.setExporterInput(new SimpleExporterInput(jp));

	        String fileName = pathDocument.concat("Addebito_").concat(socio.getImpresa().concat(".docx"));
	        
	        File exportReportFile = new File(fileName);
	        logger.debug("******* File Generato ******");
	        logger.debug(fileName);
	        
	        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(exportReportFile));

	        exporter.exportReport();
	        return fileName;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Si è verificato un errore nella generazione del documento");
		}
	}

	private String setBodyImpresa(SociData socio) {
		
		String result = ("CONFIDI IMPRESA in data ".concat(finanziamentiData.getDataApprovazioneConsiglio())
				.concat(" ha deliberato di concedere alla società  ").concat(socio.getImpresa()).concat(" con sede in ")
				.concat(socio.getCittaSedeLegale()).concat(" (").concat(socio.getProvinciaSedeLegale()).concat(") ")
				.concat(socio.getIndirizzoSedeLegale()).concat(" cap ").concat(socio.getCapSedeLegale())
				.concat(", con partita iva ").concat(socio.getPartitaIva()).concat(", tel: ")
				.concat(socio.getTelefono()).concat(" cell: ").concat(socio.getMobile()));
		return result;
	}

	private String setQualitaTitolare(SociData socio) {
		List<StateObjectData> qualitaTitolare = qualitaTitolareFacade.getQualitaTitolare(socio.getIdQualitaTitolare());
		return qualitaTitolare.get(0).getDescrizione();
	}	
	
	private String setDatiTitolare(SociData socio) {
		
		String result=socio.getCognome().concat(" ").concat(socio.getNome()).concat(", C.F: ")
				.concat(socio.getCodiceFiscaleTitolare()).concat(" nato a").concat(socio.getLuogoDiNascita()).concat(" il ")
				.concat(socio.getDataDiNascita()).concat(", residente in ").concat(socio.getCittaResidenza())
				.concat(" (").concat(socio.getProvinciaResidenza()).concat(") ").concat(socio.getIndirizzoResidenza())
				.concat(" cap ").concat(socio.getCapResidenza());
		return result;
	}

	private String setBodyDitta(SociData socio) {
		String result="C.F: ".concat(socio.getCodiceFiscale()).concat(" nato a").concat(socio.getLuogoDiNascita())
				.concat(" il ").concat(socio.getDataDiNascita()).concat(", residente in ")
				.concat(socio.getCittaResidenza()).concat(" (").concat(socio.getProvinciaResidenza()).concat(") ")
				.concat(socio.getIndirizzoResidenza()).concat(" cap ").concat(socio.getCapResidenza())
				.concat("in qualità  di Titolare dell' Impresa Individuale ").concat(socio.getImpresa())
				.concat(" con partita iva ").concat(socio.getPartitaIva()).concat(" sede in ")
				.concat(socio.getCittaSedeLegale()).concat(" (").concat(socio.getProvinciaSedeLegale()).concat(") ")
				.concat(socio.getIndirizzoSedeLegale()).concat(" cap ").concat(socio.getCapSedeLegale())
				.concat(" tel: ").concat(socio.getTelefono()).concat(" cell: ").concat(socio.getMobile());
		return result;
	}

}
