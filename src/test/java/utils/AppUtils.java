package utils;

import org.apache.commons.lang3.StringUtils;

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

    /**
     * Formata o valor da String para evitar exceções do tipo NullPointerException.
     * @return - String formatada.
     */
    public static String formatarString(String value) {
        return (!StringUtils.defaultString(value).equals("null")) ? StringUtils.defaultString(value) : "";
    }
}
