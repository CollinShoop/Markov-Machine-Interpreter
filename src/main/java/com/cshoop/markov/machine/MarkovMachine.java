package com.cshoop.markov.machine;

import com.cshoop.markov.model.MarkovRule;
import com.cshoop.markov.model.Result;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a Markov machine and can be used to process inputs
 * 
 * @author Collin
 */
@Data
public class MarkovMachine {

	public static final String SPLIT_STRING = "[ \t]";
	public static final String COMMENT_MARKER = "#";

	private String initialStateId = null;
	private Map<String, MarkovRule> states = new HashMap<>();
	private String name = null;

	/**
	 * Applies this Markov machine to the given input until there are no
	 * changes.
	 * 
	 * @param input input string
	 * @param debug whether or not to debug
	 * @return the resulting string is returned.
	 */
	public String process(String input, boolean debug) {
		MarkovRule state = states.get(initialStateId);
		if (state == null) {
			System.err.println("ERROR: No state with ID=" + initialStateId + "");
			System.err.println("Terminating machine.");
		} else {
			Result pair;
			while (!state.isFinalState()) {
				if (debug) {
					System.out.print("Debug: " + state.getId() + "(" + input + ") = ");
				}
				pair = state.process(input);
				input = pair.getLine();
				if (debug) {
					System.out.println(input);
				}
				state = states.get(pair.getStateId());
				if (state == null) {
					System.err.println("ERROR: No state with ID '" + pair.getStateId() + "'");
					System.err.println("Terminating program.");
					break;
				}
			}
		}
		return input;
	}

	/**
	 * Adds the given state to this machine. Will override any state with the
	 * same id.
	 * 
	 * @param state new unique MarkovState.
	 */
	public void addState(MarkovRule state) {
		if (states.isEmpty()) {
			setInitialStateId(state.getId());
		}
		states.put(state.getId(), state);
	}


	/**
	 * @return the number of states in this machine
	 */
	public int size() {
		return states.size();
	}

}
