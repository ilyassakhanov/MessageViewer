package project ;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class RegexMatcher {
    String getInfo(String data, String regex) {

        Pattern checkRegex = Pattern.compile(regex);
        Matcher regexMatcher = checkRegex.matcher(data);
        while (regexMatcher.find()) {
            if (regexMatcher.group().length() != 0) {
                return regexMatcher.group().trim();
            }
        }
        return "The data was damaged";
    }
    String getInfoGroup(String data, String regex){
        Pattern checkRegex = Pattern.compile(regex);
        Matcher regexMatcher = checkRegex.matcher(data);
        while (regexMatcher.find()) {
            if (regexMatcher.group().length() != 0) {
                return regexMatcher.group(1);
            }
        }
        return "The data was damaged";
    }
}