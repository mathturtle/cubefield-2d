/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package waldonsm.games.cubefield2D;

/**
 *
 * @author shawn
 */
/**
 * ScoreData stores the name and score of an entry in a single object
 * @author Shawn Waldon
 *
 */
public class ScoreData {
	private String name;
	private int score;

	/**
	 *
	 * @return the name of the high scorer
	 */
	public String getName() {
		return name;
	}

	/**
	 * sets the name of the high scorer to a new value
	 * @param name the new name for the high scorer
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 *
	 * @return the score of this high scorer
	 */
	public int getScore() {
		return score;
	}

	/**
	 * sets the score of this high scorer to a new value
	 * @param score the new value to set score to
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * creates a new ScoreData object with the name and score parameters
	 * @param name the name of the high scorer
	 * @param score the score that the high scorer achieved
	 */
	public ScoreData(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
}
