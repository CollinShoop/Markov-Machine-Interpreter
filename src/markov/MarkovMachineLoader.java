package markov;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MarkovMachineLoader {

	public static final String epsilon = "~";
	private static final String REGEX_WHITEPSACE = "\\s+";

	public static MarkovMachine loadMachine(File file) throws FileNotFoundException {
		Scanner scanner = new Scanner(file);
		MarkovMachine mm = new MarkovMachine();
		String[] args = null;
		boolean nameLoaded = false;
		
		while (scanner.hasNextLine()) {
			String temp = scanner.nextLine().replaceAll(REGEX_WHITEPSACE, " ");
			
			// hot fix for skipping whitespace
			if (temp.equals("")) {
				continue;
			}
			// split the line by spaces
			args = temp.split(MarkovMachine.SPLIT_STRING);

			// check for name definition
			if (!nameLoaded && args.length == 1) {
				mm.setName(args[0]);
				nameLoaded = true;
			}
			else if (args.length > 0 && !args[0].startsWith(MarkovMachine.COMMENT_MARKER)) {
				// Parse the line as a Markov line
				if (args.length < 5) {
					System.err.println("Error[" + mm.size() + "]: line is missing arguments");
				}
				else {
					MarkovRule state = new MarkovRule(args[0], args[1], args[2], args[3], args[4]);
					if (state.getReplaceString().equals(epsilon)) {
						state.setReplaceString("");
					}
					if (state.getSearchString().equals(epsilon)) {
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
