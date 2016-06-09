package markov;

/**
 * Represents an result of applying a MarkovState to a string
 * 
 * @author Collin
 */
public class Result {

	private String line;
	private String stateId;

	public Result(String line, String stateId) {
		this.line = line;
		this.stateId = stateId;
	}

	/**
	 * @return the line
	 */
	public String getLine() {
		return line;
	}

	/**
	 * @param line the line to set
	 */
	public void setLine(String line) {
		this.line = line;
	}

	/**
	 * @return the stateId
	 */
	public String getStateId() {
		return stateId;
	}

	/**
	 * @param stateId the stateId to set
	 */
	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

}