package oop.stringCalculator;

public class StringCalculator {

    public static int calculate(String operands) {
        if(operands.isEmpty()) {
            return 0;
        }

        String[] split = operands.split(",");
        int accumulator = 0;
        for (int i=0; i< split.length; i++) {
            accumulator += Integer.valueOf(split[i]);
        }
        return accumulator;
    }

}
