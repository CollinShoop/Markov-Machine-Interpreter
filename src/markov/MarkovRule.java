package markov;

/**
 * Represents a single line of a Markov string replacement program.
 * 
 * @author Collin
 */
public class MarkovRule {

	private String id, searchString, replaceString, successState, failState;
	private final boolean isFinalState;

	/**
	 * Creates a new Markov state with the given parameters
	 * 
	 * @param stateId label for this state
	 * @param searchString
	 * @param replaceString
	 * @param successState
	 * @param failState
	 */
	public MarkovRule(String stateId, String searchString, String replaceString, String successState,
			String failState) {
		this.id = stateId;
		this.searchString = searchString;
		this.replaceString = replaceString;
		this.successState = successState;
		this.failState = failState;

		isFinalState = this.successState.equals(this.failState) && this.successState.equals(stateId);
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

	/**
	 * @return whether or not this node is a final state
	 */
	public boolean isFinalState() {
		return isFinalState;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the searchString
	 */
	public String getSearchString() {
		return searchString;
	}

	/**
	 * @param searchString the searchString to set
	 */
	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	/**
	 * @return the replaceString
	 */
	public String getReplaceString() {
		return replaceString;
	}

	/**
	 * @param replaceString the replaceString to set
	 */
	public void setReplaceString(String replaceString) {
		this.replaceString = replaceString;
	}

	/**
	 * @return the successState
	 */
	public String getSuccessState() {
		return successState;
	}

	/**
	 * @param successState the successState to set
	 */
	public void setSuccessState(String successState) {
		this.successState = successState;
	}

	/**
	 * @return the failState
	 */
	public String getFailState() {
		return failState;
	}

	/**
	 * @param failState the failState to set
	 */
	public void setFailState(String failState) {
		this.failState = failState;
	}

}