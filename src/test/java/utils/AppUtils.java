package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AppUtils {
    /**
     * Obtém a data atual no formato "dd/MM/yyyy".
     * @return a data atual formatada como uma String.
     */
    public static String dataAtual() {
        LocalDate dataAtual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataAtual.format(formatter);
    }
}
