package com.baljinder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String str1 = "I want a bike.";
        System.out.println(str1.matches("I want a bike."));

        String regEXp = "I want a \\w+.";
        System.out.println(str1.matches(regEXp));
        String str2 = "I want a ball.";
        System.out.println(str2.matches(regEXp));

        String regExp1 = "I want a (bike|ball).";
        System.out.println(str1.matches(regExp1));
        System.out.println(str2.matches(regExp1));

        String regExp3 = "I want a \\w+.";
        Pattern pattern = Pattern.compile(regExp3);
        Matcher matcher = pattern.matcher(str1);
        System.out.println(matcher.matches());

        matcher = pattern.matcher(str2);
        System.out.println(matcher.matches());

        String str4 = "Replace all blanks with underscores.";
        System.out.println(str4.replaceAll(" ", "_"));
        System.out.println(str4.replaceAll("\\s", "_"));

        String str5 = "zaaabccccccccdddefffg";
        System.out.println(str5.matches("[abcdefg]+"));
        System.out.println(str5.matches("[a-g]+"));

        System.out.println(str5.matches("^a{3}bc{8}d{3}ef{3}g$"));
        System.out.println(str5.replaceAll("^a{3}bc{8}d{3}ef{3}g$", "REPLACED"));

        String str7 = "abcd.135";
        System.out.println(str7.matches("^[A-z][a-z]+\\.\\d+$"));

        String str8 = "abcd.135uvqz.7tzik.999";
        Pattern pattern8 = Pattern.compile("[A-Za-z]+\\.(\\d+)");
        Matcher matcher8 = pattern8.matcher(str8);
        while(matcher8.find()) {
            System.out.println("Occurrence: " + matcher8.group(1));
        }

        String str9 = "abcd.135\tuvqz.7\ttzik.999\n";
        Pattern pattern9 = Pattern.compile("[A-Za-z]+\\.(\\d+)\\s");
        Matcher matcher9 = pattern9.matcher(str9);
        while(matcher9.find()) {
            System.out.println("Occurrence: " + matcher9.group(1));
        }

        String str10 = "abcd.135\tuvqz.7\ttzik.999\n";
        Pattern pattern10 = Pattern.compile("[A-Za-z]+\\.(\\d+)\\s");
        Matcher matcher10 = pattern10.matcher(str10);
        while(matcher10.find()) {
            System.out.println("Occurrence: start = " + matcher10.start(1) + " end = " + (matcher10.end(1) -1));
        }

        String str11 = "{0, 2}, {0, 5}, {1, 3}, {2, 4}";
        Pattern pattern11 = Pattern.compile("\\{(.+?)\\}");
        Matcher matcher11 = pattern11.matcher(str11);
        while(matcher11.find()) {
            System.out.println("Occurrence: " + matcher11.group(1));
        }
        System.out.println("*********************");

        String str11a = "{0, 2}, {0, 5}, {1, 3}, {2, 4} {x, y}, {6, 34}, {11, 12}";
        Pattern pattern11a = Pattern.compile("\\{(\\d+, \\d+)\\}");
        Matcher matcher11a = pattern11a.matcher(str11a);
        while(matcher11a.find()) {
            System.out.println("Occurrence: " + matcher11a.group(1));
        }

        String str12 = "11111";
        System.out.println(str12.matches("^\\d{5}$"));

        String str13 = "11111-1111";
        System.out.println(str13.matches("^\\d{5}-\\d{4}$"));

        System.out.println(str12.matches("^\\d{5}(-\\d{4})?$"));
        System.out.println(str13.matches("^\\d{5}(-\\d{4})?$"));
    }

}
