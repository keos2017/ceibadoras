package co.com.ceiba.mobile.pruebadeingreso.base;

public class ConfigUtils {

    /**
     * 
     * @param enteredText
     * @return si el texto pasó correctamente por las validaciones
     */
    public static boolean validateString(String enteredText) {
        return enteredText != null &&
                !enteredText.isEmpty() &&
                !enteredText.equalsIgnoreCase("null") &&
                !enteredText.equalsIgnoreCase("0") &&
                !enteredText.equalsIgnoreCase("0.0");
    }
    
    /**
     * 
     * @param enteredText texto a validar y convertir
     * @return texto con la letra inicial mayúscula y el resto en minúscula
     */
    public static String putCapitalInitial(String enteredText) {

        if (validateString(enteredText)) {

            String textProcessed = enteredText.toLowerCase();
            char[] chapters = textProcessed.toCharArray();

            chapters[0] = Character.toUpperCase(chapters[0]);
            textProcessed = String.valueOf(chapters);

            return textProcessed;
        } else {
            return "Texto vacío";
        }
    }
}
