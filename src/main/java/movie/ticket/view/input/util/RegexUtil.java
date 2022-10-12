package movie.ticket.view.input.util;

import java.util.regex.Pattern;

public class RegexUtil {

    public static final Pattern REGEX_NUMBER_FORM = Pattern.compile("^[0-9]$");

    private static final String END = "";

    public static boolean checkRegex(Pattern pattern, String form) {
        if (form.equals(END)) return true;
        return pattern.matcher(form).find();
    }
}
