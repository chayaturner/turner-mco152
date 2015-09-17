package turner.morsecode;

public class MorseCode {

	private char[] englishLetters = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
			'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
			'v', 'w', 'x', 'y', 'z' };
	private String[] morseLetters = { ".-", "-...", "-.-.", "-..", ".", "..-.",
			"--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---",
			".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
			"-.--", "--.." };

	public String encode(String message) {

		message = message.toLowerCase();
		String[] encodedMsg = new String[message.length()];
		char[] messageArray = message.toCharArray();
		String encodedMsgString = "";

		for (int i = 0; i < encodedMsg.length; i++) {
			for (int j = 0; j < morseLetters.length; j++) {
				if (messageArray[i] == englishLetters[j]) {
					encodedMsg[i] = morseLetters[j] + " ";
				}
				if (messageArray[i] == ' ') {
					encodedMsg[i] = "   ";
				}
			}
		}

		for (int i = 0; i < encodedMsg.length; i++) {
			encodedMsgString = encodedMsgString + encodedMsg[i];
		}

		return encodedMsgString;

	}

	public String decode(String code) {

		String[] codeArray = code.split("\\s+");
		char[] decodedMsg = new char[codeArray.length];
		String decodedMsgString = "";

		for (int i = 0; i < codeArray.length; i++) {
			for (int j = 0; j < englishLetters.length; j++) {
				if (codeArray[i].equals(morseLetters[j])) {
					decodedMsg[i] = englishLetters[j];
				}
				if (codeArray[i].equals(" ")) {
					decodedMsg[i] = ' ';
				}
			}
		}

		for (int i = 0; i < decodedMsg.length; i++) {
			decodedMsgString = decodedMsgString + decodedMsg[i];
		}

		return decodedMsgString;

	}

}