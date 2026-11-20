package ejercicio04;

/**
 * Se lanza cuando los datos financieros no superan la validación previa.
 */
public class InvalidReportDataException extends RuntimeException {

    public InvalidReportDataException(String message) {
        super(message);
    }
}
