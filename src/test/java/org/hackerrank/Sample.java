package org.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Sample {

	// Complete the checkMagazine function below.
	static boolean checkMagazine(String[] magazine, String[] note) {

		Map<String, Integer> magazineOccurences = new HashMap<String, Integer>();
		Map<String, Integer> ransomOccurences = new HashMap<String, Integer>();

		for (String word : magazine) {
			if (!magazineOccurences.containsKey(word)) {
				magazineOccurences.put(word, 0);
			}
			magazineOccurences.put(word, magazineOccurences.get(word) + 1);
		}

		for (String word : note) {
			if (!ransomOccurences.containsKey(word)) {
				ransomOccurences.put(word, 0);
			}
			ransomOccurences.put(word, ransomOccurences.get(word) + 1);
		}

		for (String key : ransomOccurences.keySet()) {
			
			if (!magazineOccurences.containsKey(key)) {
				return false;
			}
			int needed = ransomOccurences.get(key);
			
			if (magazineOccurences.get(key) < needed) {
				return false;
			}
		}
		return true;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String[] mn = scanner.nextLine().split(" ");

		int m = Integer.parseInt(mn[0]);
		int n = Integer.parseInt(mn[1]);

		String[] magazine = new String[m];

		String[] magazineItems = scanner.nextLine().split(" ");
		// scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < m; i++) {
			String magazineItem = magazineItems[i];
			magazine[i] = magazineItem;

		}

		String[] note = new String[n];

		String[] noteItems = scanner.nextLine().split(" ");
		// scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			String noteItem = noteItems[i];
			note[i] = noteItem;

		}

		System.out.println(checkMagazine(magazine, note) ? "Yes" : "No");
		scanner.close();
	}
}
