package com.cshoop.markov.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents an result of applying MarkovRule to an input string
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

	private String line;
	private String stateId;

}