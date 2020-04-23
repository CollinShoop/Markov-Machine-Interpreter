package com.cshoop.markov.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a single line of a program.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarkovRule {

	private String id;
	private String searchString;
	private String replaceString;
	private String successState;
	private String failState;

	public boolean isFinalState() {
		return successState.equals(failState) && successState.equals(id);
	}

	/**
	 * Replaces the first instance of search string with replace string. If no
	 * first instance is found then the resulting string is the same.
	 *
	 * @param input input string
	 * @return a new MarkovPair of the resulting successful or failure state and the output string
	 */
	public Result process(String input) {
		if (searchString.isEmpty()) {
			input = replaceString + input;
		} else if (input.contains(searchString)) {
			return new Result(input.replaceFirst(searchString, replaceString), successState);
		}
		return new Result(input, failState);
	}


}