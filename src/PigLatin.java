
/**
 * Converts a string of words into Pig Latin.
 * @author Alex Wood
 * @date 7.22.2018
 */

import java.util.Scanner;

public class PigLatin {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String userAns = "y"; // input number from user
		String pigInput = "";

		System.out.println("----------------------------------------------------------");
		System.out.println("Welcome to Igpay Atinlay. Good Luck");

		do {
			pigInput = null;
			System.out.println("----------------------------------------------------------");
			System.out.println("What word would you like to use.");

			pigInput = scan.nextLine();

			sentenceCheck(pigInput);

			// HOW I RAN TESTS
			/*System.out.println("Test 1: \n#What're! you've! been. doing, Ronald.");
			sentenceCheck("#What're! you've! been. doing, Ronald.");

			System.out.println("Test 2");
			sentenceCheck("consonants have never been so troublesome");

			System.out.println("Test 3");
			sentenceCheck("the A@ll do order Excellent");

			System.out.println("Test 4");
			sentenceCheck("");

			System.out.println("Test 5");
			System.out.println("my email address is acwoody89@gmail.com");
			sentenceCheck("my email address is acwoody89@gmail.com");

			System.out.println("Test 5");
			System.out.println("my lynx is very good.");
			sentenceCheck("my lynx is very good.");*/
			
			// the all do order excellent
			System.out.println("----------------------------------------------------------");
			System.out.println("Would you like to continue? y/n");
			userAns = scan.nextLine();

		} while (userAns.equalsIgnoreCase("y"));

		System.out.println("This has been: ");
		System.out.println("----------------------------------------------------------");

		scan.close();
	}

	// FIRST METHOD FOR A SING WORD
	/*
	 * public static void vowelCheck(String word) { String vowelList = "aeiou";
	 * 
	 * String consHalf = ""; String vowelHalf = ""; String fullWord = ""; word =
	 * word.toLowerCase();
	 * 
	 * for (int i = 0; i <= word.length() - 1; i++) { // word.contains(("" +
	 * vowelList.indexOf(i)))
	 * 
	 * if (vowelList.contains(String.valueOf(word.charAt(0)))) { fullWord = word +
	 * "way"; System.out.println(fullWord); break; } else if
	 * (vowelList.contains(String.valueOf(word.charAt(i)))) { consHalf =
	 * (word.substring(0, i)); vowelHalf = (word.substring(i, word.length()));
	 * fullWord = vowelHalf + consHalf + "ay"; System.out.println(fullWord); break;
	 * } } }
	 */

	public static void sentenceCheck(String word) {
		word = word.toLowerCase();
		String[] sentence = word.split(" "); // removes the spaces and stores the individual strings
		String vowelList = "aeiou"; // comparative list of vowels
		String consHalf = ""; // tracks the string of consonants
		String vowelHalf = ""; // tracks the string of vowels
		String punct = ""; // tracks what punctuation the word has at the end
		boolean symCheck = false;
		boolean punctCheck = false;
		boolean noVowel = false;

		StringBuilder sb = new StringBuilder(); // trying out StringBuilder class

		if (word.length() > 0) {
			for (String test : sentence) {
				symCheck = symbolCheck(test);
				punctCheck = punctuationCheck(test);
				noVowel = noVowelCheck(test);
				punct = "";

				// checks against zero vowels
				for (int i = 0; i < test.length(); i++) {
					if (!noVowel) {
						sb.append(test);
						sb.append(" ");
						break;
						// checks if there is a vowel at index 0
					} else if (vowelList.contains(String.valueOf(test.charAt(0)))) {
						// checks if there are any symbols
						if (symCheck) {
							sb.append(test);
							sb.append(" ");
							break;
							// checks if there is any punctuation in the word ",!."
						} else if (punctCheck) {
							punct = "" + test.charAt(test.length() - 1);
							test.replace(punct, "");
							sb.append(test);
							sb.append("way");
							sb.append(punct);
							sb.append(" ");
							break;
							// no punctuation or symbols
						} else {
							sb.append(test);
							sb.append("way");
							sb.append(" ");
							break;
						}
						// checks for vowels at from 0 to (test.length() - 1)
					} else if (vowelList.contains("" + test.charAt(i))) {
						if (symCheck) {
							sb.append(test);
							sb.append(" ");
							break;
						} else if (punctCheck) {
							punct = "" + test.charAt(test.length() - 1);					// finds the punctuation and stores it
							test = test.replace(test.substring(test.length() - 1), "");		// finds the punctuation and removes it
							consHalf = (test.substring(0, i));								
							vowelHalf = (test.substring(i, test.length()));

							sb.append(vowelHalf);
							sb.append(consHalf);
							sb.append("ay");
							sb.append(punct);		// adds the punctuation back in
							sb.append(" ");
							break;
						} else {
							consHalf = (test.substring(0, i));
							vowelHalf = (test.substring(i, test.length()));
							sb.append(vowelHalf);
							sb.append(consHalf);
							sb.append("ay");
							sb.append(" ");
							break;
						}

					}
				}
			}
		} else {
			sb.append("No text entered. Please enter some text.");
		}
		System.out.println(sb);
	}

	/*
	 * checks each word for symbols, returns true if found
	 */
	public static boolean symbolCheck(String word) {
		String symbolList = "1234567890@#$%^&*()";
		boolean symCheck = false;

		for (int i = 0; i < word.length(); i++) {
			if (symbolList.contains(String.valueOf(word.charAt(i)))) {
				symCheck = true;
			}
		}
		return symCheck;
	}

	/*
	 * checks each word for punctuation(,.!), returns true if found
	 */
	public static boolean punctuationCheck(String word) {
		String punctList = ",.!";
		boolean punctCheck = false;
		for (int i = 0; i < word.length(); i++) {
			if (punctList.contains(String.valueOf(word.charAt(word.length() - 1)))) {
				punctCheck = true;
			}
		}
		return punctCheck;
	}

	/*
	 * checks for vowels in each word, returns true if found, false if there are none
	 */
	public static boolean noVowelCheck(String word) {
		String vowelList = "aeiouAEIOU";
		boolean vowelCheck = false;
		for (int i = 0; i < word.length(); i++) {
			if (vowelList.contains(String.valueOf(word.charAt(i)))) {
				vowelCheck = true;
			}
		}
		return vowelCheck;
	}
}