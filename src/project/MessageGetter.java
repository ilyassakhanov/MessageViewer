package project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class MessageGetter {
    ArrayList getAll(File file) throws IOException {

        BufferedReader in = new BufferedReader(new FileReader(file));


        String str = "";
        ArrayList<String> allStrings = new ArrayList<String>();
        while (true) {
            String tmp = in.readLine();
            if (tmp == null) {
                break;
            } else if (tmp.isEmpty()) {
                if (!str.isEmpty()) {
                    allStrings.add(str);
                }
                str = "";
            } else {
                if (str.isEmpty()) {
                    str = tmp;
                } else {
                    str += "\n" + tmp;
                }
            }

        }
        if (!str.isEmpty()) {
            allStrings.add(str);
        }
        return allStrings;
    }
}
