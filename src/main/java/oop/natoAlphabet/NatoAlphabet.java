package oop.natoAlphabet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class NatoAlphabet {

  public static final String DELIMITER = "-";
  private static HashMap<String, String> encodingAlphabet = createAlphabet();
  private static HashMap<String, String> decodingAlphabet = reverseAlphabet();

  public static String encode(String input) {
    validateInputToEncode(input);
    return Arrays.stream(input.split(""))
        .map(c -> encodingAlphabet.get(c))
        .collect(Collectors.joining(DELIMITER));
  }

  private static void validateInputToEncode(String input) {
    if (input.isEmpty()) {
      throw new RuntimeException("\"\" input outside NATO alphabet");
    }
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      String letter = encodingAlphabet.get(String.valueOf(c));
      if (letter == null) {
        throw new RuntimeException("\""+c+"\" input outside NATO alphabet");
      }
    }
  }

  private static HashMap<String, String> createAlphabet() {
    HashMap<String, String> alphabet = new HashMap<>();
    alphabet.put("a", "alpha");
    alphabet.put("b", "bravo");
    alphabet.put("c", "charlie");
    alphabet.put("d", "delta");
    alphabet.put("e", "echo");
    alphabet.put("f", "foxtrot");
    alphabet.put("g", "golf");
    alphabet.put("h", "hotel");
    alphabet.put("i", "india");
    alphabet.put("j", "juliet");
    alphabet.put("k", "kilo");
    alphabet.put("l", "lima");
    alphabet.put("m", "mike");
    alphabet.put("n", "november");
    alphabet.put("o", "oscar");
    alphabet.put("p", "papa");
    alphabet.put("q", "quebec");
    alphabet.put("r", "romeo");
    alphabet.put("s", "sierra");
    alphabet.put("t", "tango");
    alphabet.put("u", "uniform");
    alphabet.put("v", "victor");
    alphabet.put("w", "whisky");
    alphabet.put("x", "x-ray");
    alphabet.put("y", "yankee");
    alphabet.put("z", "zulu");
    alphabet.put("1", "one");
    alphabet.put("2", "two");
    alphabet.put("3", "three");
    alphabet.put("4", "four");
    alphabet.put("5", "five");
    alphabet.put("6", "six");
    alphabet.put("7", "seven");
    alphabet.put("8", "eight");
    alphabet.put("9", "nine");
    alphabet.put("0", "zero");
    alphabet.put(" ", "null");
    return alphabet;
  }

  private static HashMap<String, String> reverseAlphabet() {
    HashMap<String, String> myNewHashMap = new HashMap<>();
    for(Map.Entry<String, String> entry : encodingAlphabet.entrySet()){
      myNewHashMap.put(entry.getValue(), entry.getKey());
    }
    return myNewHashMap;
  }

  public static String decode(String input) {
    return Arrays.stream(input.split(DELIMITER))
        .map(c -> decodingAlphabet.get(c))
        .collect(Collectors.joining());
  }
}
