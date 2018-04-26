package UnitTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class CodeTest {

    private final String[] SUFFIXES = {".xml", ".html", ".txt"};
    private final int MAX_FILE_SIZE = 80 * ((int) Math.pow(2, 10));


    public String solution(String s) {
        String[] lines = s.split("\n");
        DateFormat df = new SimpleDateFormat("mm.dd.yyyy");
        List<Date> results = new ArrayList<Date>();
        for (int i = 0; i < lines.length; i++) {
            String[] sections_line = lines[i].split(" ");

            for (String suffix : SUFFIXES) {
                if (sections_line[2].contains(suffix) && Integer.parseInt(sections_line[0]) < MAX_FILE_SIZE) {

                    Date date;
                    try {
                        date = df.parse(sections_line[1]);
                        results.add(date);
                    } catch (ParseException e) {
                        e.printStackTrace();
                        //use log here if possible
                    }
                }
            }
        }
        Collections.sort(results);
        return df.format(results.get(0));

    }

    public static void main(String args[]) {
        String test = "930 10.01.2000 SYSTEM.TXT \n"
                + "1000 23.04.1983 notes.xml";

        CodeTest t = new CodeTest();
        System.out.println(t.solution(test));


    }
}
