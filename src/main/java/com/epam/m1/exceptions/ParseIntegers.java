package com.epam.m1.exceptions;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Complete the code, parse integers, calculate the sum of numbers in the WORDS, join strings with
 * space delimiter
 */
public class ParseIntegers {

    private static final Logger logger = Logger.getLogger(ParseIntegers.class.getName());

    private static final List<String> WORDS =
            Arrays.asList(
                    "JDK 17 has released on 14 September 2021 with 10 new features, 2 feature removals and 2 feature deprecations."
                            .split(" "));

    public static void main(String[] args) {
        // Logger sozlamalari
        logger.setLevel(Level.INFO);
        Handler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.INFO);
        logger.addHandler(consoleHandler);

        Iterator<String> words = WORDS.iterator();
        int sum = 0;
        StringBuilder justWords = new StringBuilder();
        while (words.hasNext()) {
            String next = words.next();
            try {
                int number = Integer.parseInt(next);
                // Raqamlarni hisoblash va sum'ga qo'shish
                sum += number;
            } catch (NumberFormatException e) {
                // Agar raqamga o'tkazib bo'lmagan bo'lsa, undan faqat so'z qismini qo'shib chiqish
                justWords.append(next).append(" ");
            }
        }

        // Loglarni chiqarish
        logger.info("Sum is " + sum);
        logger.info("Just words: " + justWords.toString().trim());
    }
}
