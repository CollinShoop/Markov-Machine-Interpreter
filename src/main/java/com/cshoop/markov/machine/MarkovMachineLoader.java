package com.cshoop.markov.machine;

import com.cshoop.markov.model.MarkovRule;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MarkovMachineLoader {

	public static final String TOKEN_EMPTY = "~";

	private static final String REGEX_WHITESPACE = "\\s+";

	public static MarkovMachine loadMachine(File file) throws FileNotFoundException {
		Scanner scanner = new Scanner(file);
		MarkovMachine mm = new MarkovMachine();
		boolean nameLoaded = false;
		
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine().replaceAll(REGEX_WHITESPACE, " ").trim();

			if (line.isEmpty()) {
				continue;
			}

			String[] lineWords = line.split(MarkovMachine.SPLIT_STRING);

			// check for name definition
			if (!nameLoaded && lineWords.length == 1) {
				mm.setName(line);
				nameLoaded = true;
			}
			else if (lineWords.length > 0 && !lineWords[0].startsWith(MarkovMachine.COMMENT_MARKER)) {
				// Parse the line as a Markov line
				if (lineWords.length < 5) {
					System.err.println("Error[" + mm.size() + "]: line is missing arguments");
				}
				else {
					MarkovRule state = new MarkovRule(lineWords[0], lineWords[1], lineWords[2], lineWords[3], lineWords[4]);
					if (state.getReplaceString().equals(TOKEN_EMPTY)) {
						state.setReplaceString("");
					}
					if (state.getSearchString().equals(TOKEN_EMPTY)) {
						state.setSearchString("");
					}
					mm.addState(state);
				}
			}
		}
		scanner.close();

		return mm;
	}

}
