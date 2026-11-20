package ejercicio04;

import java.math.BigDecimal;
import java.util.List;

/**
 * Producto concreto: exportador a PDF (simulado como texto maquetado).
 * Reglas propias: título obligatorio y montos numéricos.
 */
public class PdfReportExporter implements ReportExporter {

    @Override
    public void validate(ReportData data) {
        if (data.getTitle() == null || data.getTitle().trim().isEmpty()) {
            throw new InvalidReportDataException("PDF: el reporte debe tener un título.");
        }
        if (data.getRows().isEmpty()) {
            throw new InvalidReportDataException("PDF: el reporte no tiene filas de datos.");
        }
        for (List<String> row : data.getRows()) {
            if (row.size() != data.getHeaders().size()) {
                throw new InvalidReportDataException(
                        "PDF: una fila no coincide con la cantidad de encabezados.");
            }
            String amount = row.get(row.size() - 1);
            try {
                new BigDecimal(amount);
            } catch (NumberFormatException e) {
                throw new InvalidReportDataException(
                        "PDF: el monto '" + amount + "' no es un número válido.");
            }
        }
    }

    @Override
    public String export(ReportData data) {
        StringBuilder page = new StringBuilder();
        page.append("%PDF-SIMULADO\n");
        page.append("  ").append(data.getTitle().toUpperCase()).append("\n");
        page.append("  ------------------------------------\n");
        page.append(formatRow(data.getHeaders()));
        for (List<String> row : data.getRows()) {
            page.append(formatRow(row));
        }
        page.append("%%EOF");
        return page.toString();
    }

    private String formatRow(List<String> cells) {
        StringBuilder line = new StringBuilder("  ");
        for (String cell : cells) {
            line.append(String.format("| %-18s ", cell));
        }
        return line.append("|\n").toString();
    }

    @Override
    public String getFormat() {
        return "PDF";
    }
}
