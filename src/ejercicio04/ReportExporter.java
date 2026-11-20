package ejercicio04;

/**
 * Producto: contrato común de los exportadores de reportes.
 */
public interface ReportExporter {

    // Validación previa de los datos financieros
    void validate(ReportData data);

    // Exportación efectiva en el formato correspondiente
    String export(ReportData data);

    String getFormat();
}
