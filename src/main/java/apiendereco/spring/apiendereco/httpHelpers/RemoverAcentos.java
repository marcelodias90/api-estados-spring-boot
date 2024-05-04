package apiendereco.spring.apiendereco.httpHelpers;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class RemoverAcentos {
    public static String remove(String value) {
        String normalizer = Normalizer.normalize(value, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(normalizer).replaceAll("");
    }
}
