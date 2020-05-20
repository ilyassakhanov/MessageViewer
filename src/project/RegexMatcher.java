package project;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * A class that contains tools for filtering data from a standalone message
* */
abstract class RegexMatcher {
    /**
     * The difference between this method and previous one is that this one returns a group zero  from regex match
     * @param data a standalone message
     * @param regex a matching regex string
     * */
    String getInfo(String data, String regex) throws Exception {

        Pattern checkRegex = Pattern.compile(regex);
        Matcher regexMatcher = checkRegex.matcher(data);
        while (regexMatcher.find()) {
            if (regexMatcher.group().length() != 0) {
                return regexMatcher.group().trim();
            }
        }
        throw new Exception();
    }
    /**
     * The difference between this method and previous one is that this one returns a first group from regex match
     * @param data a standalone message
     * @param regex a matching regex string
     * */
    String getInfoGroup(String data, String regex) throws Exception {
        Pattern checkRegex = Pattern.compile(regex);
        Matcher regexMatcher = checkRegex.matcher(data);
        while (regexMatcher.find()) {
            if (regexMatcher.group().length() != 0) {
                return regexMatcher.group(1);
            }
        }
        throw new Exception();
    }
}