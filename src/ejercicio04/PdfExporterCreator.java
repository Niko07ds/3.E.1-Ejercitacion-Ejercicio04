package ejercicio04;

/**
 * Creador concreto: produce exportadores a PDF.
 */
public class PdfExporterCreator extends ReportExporterCreator {

    @Override
    protected ReportExporter createExporter() {
        return new PdfReportExporter();
    }
}
