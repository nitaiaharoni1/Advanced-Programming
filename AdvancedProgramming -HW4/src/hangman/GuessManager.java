/**
 * 
 */
package hangman;

/**
 * @author nitai
 *
 */
public class GuessManager implements GuessManagerContract {

	private final String word;
	private int badGuessesLeft;
	private StringBuilder hint;

	public GuessManager(String word, int badGuessesLeft) {
		this.word = word;
		this.badGuessesLeft = badGuessesLeft;
		//initialize hint as ____
		this.hint = new StringBuilder();
		for (int i = 0; i < word.length(); i++) {
			hint.append(NON_MATCH);
		}
	}

	@Override
	public int getBadGuessesLeft() {
		return this.badGuessesLeft;
	}

	@Override
	public String getCurrentHint() {
		return this.hint.toString();
	}

	@Override
	public GuessResponse getGuessResponse(char letter) {
		boolean guessStatus = false;
		//checks every character in the word if it is the same as - letter
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == letter) {
				//adds the letter to hint
				hint.setCharAt(i, letter);
				guessStatus = true;
			}
		}
		if (guessStatus == true) {
			//word is not found yet
			if(!word.equals(hint.toString())) return GuessResponse.GUESS_GOOD;
			//finished to guess all the characters
			else return GuessResponse.GUESS_WIN;
		} else {
			//bad guess but not finished
			if (badGuessesLeft > 0) {
				this.badGuessesLeft--;
				return GuessResponse.GUESS_BAD;
			} else
				//bad guess and no more guesses
				return GuessResponse.GUESS_LOSE;
		}
	}

}
