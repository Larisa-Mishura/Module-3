package com.mishura.util;

import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.DateTimeException;
import java.time.LocalDateTime;

public class UserInput {
    public static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    private final static Logger LOGGER = Logger.getLogger(UserInput.class);

    @SneakyThrows
    public static int menu(final String[] names, String message) {
        int userChoice = -1;
        do {
            System.out.println(message);
            for (int i = 0; i < names.length; i++) {
                System.out.println(i + "  " + names[i]);
            }
            final String line = READER.readLine();
            if (!StringUtils.isNumeric(line)) {
                continue;
            }
            userChoice = Integer.parseInt(line);
        } while (userChoice < 0 || userChoice > names.length);
        LOGGER.info("User choice: " + userChoice);
        return userChoice;
    }

    @SneakyThrows
    public static int getInt(final String option){
        String line;
        do{
            System.out.println(option);
            line = READER.readLine();

        } while (!StringUtils.isNumeric(line));
        LOGGER.info("User input: " + line);
        return Integer.parseInt(line);
    }

    @SneakyThrows
    public static double getDouble(final String option){
        String line;
        do{
            System.out.println(option);
            line = READER.readLine();

        } while (!NumberUtils.isCreatable(line));
        LOGGER.info("User input: " + line);
        return Double.parseDouble(line);
    }

    @SneakyThrows
    public static String getString(final String message){
        System.out.println(message);
        String line = READER.readLine();
        LOGGER.info("User input: " + line);
        return line;
    }


    @SneakyThrows
    public static LocalDateTime getDateAngTime() {
        LocalDateTime date = null;
        try{
            date = LocalDateTime.of(
                    UserInput.getInt("Enter year"),
                    UserInput.getInt("Enter month"),
                    UserInput.getInt("Enter day of month"),
                    UserInput.getInt("Enter hour"),
                    UserInput.getInt("Enter minute"));
            LOGGER.info("User input: " + date);
        } catch (DateTimeException e){
            System.out.println("Invalid value for date.");
            getDateAngTime();
        }
        return date;
    }
}

