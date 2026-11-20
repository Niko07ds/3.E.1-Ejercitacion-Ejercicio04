package ejercicio04;

/**
 * Creador concreto: produce exportadores a CSV.
 */
public class CsvExporterCreator extends ReportExporterCreator {

    @Override
    protected ReportExporter createExporter() {
        return new CsvReportExporter();
    }
}
