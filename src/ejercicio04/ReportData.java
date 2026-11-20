package ejercicio04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Datos del informe: título, encabezados y filas tabulares.
 * La última columna de cada fila representa el monto.
 */
public class ReportData {

    private final String title;
    private final List<String> headers;
    private final List<List<String>> rows = new ArrayList<>();

    public ReportData(String title, List<String> headers) {
        this.title = title;
        this.headers = headers;
    }

    public ReportData addRow(String... cells) {
        rows.add(Arrays.asList(cells));
        return this;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getHeaders() {
        return headers;
    }

    public List<List<String>> getRows() {
        return rows;
    }
}
