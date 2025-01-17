package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;

public class Log {
    private static final DateTimeFormatter dateFormatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    public static void debug(String message) {
        String timestamp = LocalDateTime.now().format(dateFormatter);
        String threadName = Thread.currentThread().getName();
        System.out.println("[" + timestamp + "] [" + threadName + "] " + message);
    }

    public static void debug(String message, Object... args) {
        String timestamp = LocalDateTime.now().format(dateFormatter);
        String threadName = Thread.currentThread().getName();
        String formattedMessage = formatMessage(message, args);
        System.out.println("[" + timestamp + "] [" + threadName + "] " + formattedMessage);
    }

    private static String formatMessage(String message, Object... args) {
        for (Object arg : args) {
            String replacement = Matcher.quoteReplacement(arg != null ? arg.toString() : "null");
            message = message.replaceFirst("\\{\\}", replacement);
        }
        return message;
    }
}
