package com.neptune.cbawrapper.utils;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class SequenceGenerator {

    private static final int MAX_NUMERIC = 9999;

    /**
     * Rules:
     * 0000 -> 0001 ... 9998 -> 9999
     * 9999 -> first alphanumeric code (000A)
     * Then base36 progression using 0-9 + A-Z
     * Always length = 4
     *
     * Examples:
     * 9998 -> 9999
     * 9999 -> 000A
     * 000A -> 000B
     * 000Z -> 0010
     * 0010 -> 0011
     * 1QB2 -> 1QB3
     * ZZZZ -> Exception
     */
    public String nextValue(String currentValue) {

        if (currentValue == null || currentValue.trim().isEmpty()) {
            return "0001";
        }

        currentValue = currentValue.trim().toUpperCase();

        // Pure numeric mode before 9999
        if (currentValue.matches("\\d{1,4}")) {
            int num = Integer.parseInt(currentValue);

            if (num < MAX_NUMERIC) {
                return String.format("%04d", num + 1);
            }

            // After 9999 begin mixed mode
            return "000A";
        }

        // Mixed alphanumeric mode
        if (currentValue.matches("[0-9A-Z]{4}")) {
            return incrementBase36(currentValue);
        }

        throw new IllegalArgumentException("Invalid input: " + currentValue);
    }

    public String incrementString(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be null or empty");
        }

        int length = input.length();
        String charset = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // Convert input to char array and process from right to left
        char[] chars = input.toUpperCase().toCharArray();
        boolean carry = true;

        for (int i = chars.length - 1; i >= 0 && carry; i--) {
            int currentIndex = charset.indexOf(chars[i]);

            if (currentIndex == -1) {
                throw new IllegalArgumentException("Invalid character in input: " + chars[i]);
            }

            int nextIndex = currentIndex + 1;

            if (nextIndex < charset.length()) {
                chars[i] = charset.charAt(nextIndex);
                carry = false;
            } else {
                // Wrap around back to '0' and carry over to next position
                chars[i] = '0';
            }
        }

        if (carry) {
            throw new IllegalArgumentException("Input has exceeded maximum value for length " + length);
        }

        return new String(chars);
    }

    private String incrementBase36(String value) {

        char[] arr = value.toCharArray();

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == '9') {
                arr[i] = 'A';
                return new String(arr);
            }

            if (arr[i] >= '0' && arr[i] <= '8') {
                arr[i]++;
                return new String(arr);
            }

            if (arr[i] >= 'A' && arr[i] <= 'Y') {
                arr[i]++;
                return new String(arr);
            }

            if (arr[i] == 'Z') {
                arr[i] = '0'; // carry over
            }
        }

        throw new RuntimeException("Maximum sequence reached: ZZZZ");
    }

    public String getValueAfter2NEP(String input) {
        System.out.println("input = " + input);

        if (input == null || !input.startsWith("2NEP")) {
            throw new IllegalArgumentException("Invalid input");
        }

        return input.substring(4);
    }
}
