package ejercicio04;

import java.util.List;

/**
 * Producto concreto: exportador a CSV.
 * Reglas propias: encabezados completos, filas consistentes y sin saltos de línea.
 */
public class CsvReportExporter implements ReportExporter {

    @Override
    public void validate(ReportData data) {
        if (data.getHeaders().isEmpty()) {
            throw new InvalidReportDataException("CSV: el reporte necesita encabezados.");
        }
        for (List<String> row : data.getRows()) {
            if (row.size() != data.getHeaders().size()) {
                throw new InvalidReportDataException(
                        "CSV: una fila no coincide con la cantidad de encabezados.");
            }
            for (String cell : row) {
                if (cell == null || cell.contains("\n")) {
                    throw new InvalidReportDataException(
                            "CSV: las celdas no pueden ser nulas ni tener saltos de línea.");
                }
            }
        }
    }

    @Override
    public String export(ReportData data) {
        StringBuilder csv = new StringBuilder();
        csv.append(joinRow(data.getHeaders())).append("\n");
        for (List<String> row : data.getRows()) {
            csv.append(joinRow(row)).append("\n");
        }
        return csv.toString().trim();
    }

    // Escapa las celdas que contienen comas o comillas
    private String joinRow(List<String> cells) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < cells.size(); i++) {
            String cell = cells.get(i);
            if (cell.contains(",") || cell.contains("\"")) {
                cell = "\"" + cell.replace("\"", "\"\"") + "\"";
            }
            if (i > 0) {
                line.append(",");
            }
            line.append(cell);
        }
        return line.toString();
    }

    @Override
    public String getFormat() {
        return "CSV";
    }
}
