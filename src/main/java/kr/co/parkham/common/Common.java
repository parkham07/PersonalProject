package kr.co.parkham.common;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Common {
    public static String getPrintStackTrace(Exception e) {
        StringWriter writer = new StringWriter();

        e.printStackTrace(new PrintWriter(writer));

        return writer.toString();
    }
}
