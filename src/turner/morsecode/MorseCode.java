package turner.morsecode;

import java.util.HashMap;

public class MorseCode {

	private char[] englishLetters = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
			'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
			'v', 'w', 'x', 'y', 'z' };
	private String[] morseLetters = { ".-", "-...", "-.-.", "-..", ".", "..-.",
			"--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---",
			".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
			"-.--", "--.." };

	private StringBuilder stringBuilder = new StringBuilder();

	public MorseCode() {
	}

	public String encode(String message) {

		HashMap<Character, String> map = new HashMap<Character, String>();

		message = message.toLowerCase();

		for (int i = 0; i < englishLetters.length; i++) {
			map.put(englishLetters[i], morseLetters[i]);
		}

		for (int i = 0; i < message.length(); i++) {
			if (message.charAt(i) == ' ') {
				stringBuilder.append("   ");
			} else if (i > 0) {
				stringBuilder.append(" ");
			}
			stringBuilder.append(map.get(message.charAt(i)));

		}

		return stringBuilder.toString();

	}

	public String decode(String code) {

		HashMap<String, Character> map = new HashMap<String, Character>();

		for (int i = 0; i < englishLetters.length; i++) {
			map.put(morseLetters[i], englishLetters[i]);
		}

		String[] codeArray = code.split("\\s+");

		for (int i = 0; i < codeArray.length; i++) {
			if (codeArray[i].equals("   ")) {
				stringBuilder.append(" ");
			}
			stringBuilder.append(map.get(codeArray[i]));
		}

		return stringBuilder.toString();
	}

}