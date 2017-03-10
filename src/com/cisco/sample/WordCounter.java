package com.cisco.sample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class WordCounter {

	public static void main(String args[]) {

		String fileName = "testwords.txt";

		Stream<String> stream = new BufferedReader(
				new InputStreamReader(ClassLoader.getSystemResourceAsStream(fileName))).lines();
		
		// holds the word and it count
		Map<String, Integer> wordCounter = new HashMap<String, Integer>();

		stream.forEach((line) -> {
			line = line.toLowerCase();
			StringTokenizer st = new StringTokenizer(line, "/,.: ");
			while (st.hasMoreTokens()) {
				String word = st.nextToken();
				if (wordCounter.containsKey(word) == true)
					wordCounter.put(word, wordCounter.get(word) + 1);
				else
					wordCounter.put(word, 1);

			}
		});

		for (Map.Entry<String, Integer> entry : wordCounter.entrySet()) {
			System.out.println(entry.getValue() + " " + entry.getKey());

		}

	}
}