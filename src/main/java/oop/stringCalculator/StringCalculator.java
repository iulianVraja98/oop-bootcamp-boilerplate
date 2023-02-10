package oop.stringCalculator;

public class StringCalculator {


    public int calculateSumOfNumbers(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        String[] numberArray = s.replace(",", "\n").split("\n");
        int sum = 0;
        for (String number : numberArray) {
            sum += Integer.parseInt(number);
        }

        return sum;
    }

}
