package ejercicio04;

/**
 * Creador abstracto: combina el método de fábrica con un método plantilla
 * que valida los datos y luego exporta.
 */
public abstract class ReportExporterCreator {

    // Método de fábrica
    protected abstract ReportExporter createExporter();

    // Método plantilla: crear -> validar -> exportar
    public final String generateReport(ReportData data) {
        ReportExporter exporter = createExporter();
        System.out.println("Generando reporte en formato " + exporter.getFormat() + "...");
        exporter.validate(data);
        System.out.println("Validación correcta.");
        return exporter.export(data);
    }
}
