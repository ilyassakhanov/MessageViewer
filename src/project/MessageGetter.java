package project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A constructor that is ment to deal with dividing a whole text file into separate object
 */
public class MessageGetter {
    /**
     * @param file  that has all the user messages
     * @return ArrayList that that has the messages divided
     * @throws IOException if file is not found
     * */
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
