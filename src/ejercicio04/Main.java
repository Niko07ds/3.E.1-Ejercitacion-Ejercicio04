package ejercicio04;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println(" Exportadores de reportes financieros ");

        ReportData validData = new ReportData("Informe de octubre",
                Arrays.asList("Concepto", "Categoría", "Monto"))
                .addRow("Ventas, mostrador", "Ingresos", "15000.50")
                .addRow("Alquiler", "Gastos", "-4200")
                .addRow("Servicios", "Gastos", "-1350.75");

        ReportExporterCreator pdfCreator = new PdfExporterCreator();
        ReportExporterCreator csvCreator = new CsvExporterCreator();

        System.out.println("\n- Exportación a PDF -");
        System.out.println(pdfCreator.generateReport(validData));

        System.out.println("\n- Exportación a CSV -");
        System.out.println(csvCreator.generateReport(validData));

        // Datos inválidos: el monto no es numérico
        ReportData invalidData = new ReportData("Informe con error",
                Arrays.asList("Concepto", "Categoría", "Monto"))
                .addRow("Compra de insumos", "Gastos", "mil pesos");

        System.out.println("\n- Datos inválidos en PDF -");
        try {
            pdfCreator.generateReport(invalidData);
        } catch (InvalidReportDataException e) {
            System.out.println("Error de validación: " + e.getMessage());
        }

        System.out.println("\n- Los mismos datos en CSV (válidos para ese formato) -");
        System.out.println(csvCreator.generateReport(invalidData));
    }
}
