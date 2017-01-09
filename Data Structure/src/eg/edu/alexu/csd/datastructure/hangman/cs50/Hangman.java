package eg.edu.alexu.csd.datastructure.hangman.cs50;

import java.util.Random;

import eg.edu.alexu.csd.datastructure.hangman.IHangman;
/**
 *
 * @author Amr
 *
 */
public class Hangman implements IHangman {
	/**.
	 * size of the array used to save files
	 */
	private final int arraysizemagic = 1000;
	/**.
	 *Array used to save words used to play.
	 **/
	private String[] list = new String[arraysizemagic];
	/**.
	 *The word that is guessed
	 **/
	private String guessedword;
	/**.
	 *The charcters that should be revealed
	 **/
	private StringBuilder except = new StringBuilder("[^ ");
	/**.
	 *bunch of counters
	 **/
	private int ll, maxg = 1, guessnumber = 0, word;
	@Override
	public final void setDictionary(final String[] words) {
		// TODO Auto-generated method stub
		System.arraycopy(words, 0, list, 0, words.length);
		ll = words.length;
		for (int i = 0; i < ll; i++) {
			list[i] = list[i].toUpperCase();
		}
	}
	@Override
	public final String selectRandomSecretWord() {
		// TODO Auto-generated method stub
		Random rn = new Random();
		int i;
		if (ll > 0) {
			do {
				i = rn.nextInt(ll);
			} while (list[i].equals(null));
			word = i;
			guessedword =
					list[word].
					replaceAll(except.toString()
							+ "]", "-");
			return list[word];
		} else {
			return null;
		}
	}

	@Override
	public final String guess(final Character c) {
		// TODO Auto-generated method stub
		String g;
		if (list[word].equals(null)) {
			return null;
		}
		if (c == null) {
			g = guessedword;
		} else {
			char f = Character.toUpperCase(c);
			boolean right = false;
			for (int i = 0; i
					< list[word].length()
					&& !right; i++) {
				if (list[word].charAt(i) == f) {
					right = true;
				}
			}
			if (right) {
				except.append(f);
				guessedword =
						list[word].
						replaceAll(except.toString()
								+ "]", "-");
				g = guessedword;
			} else {
				guessedword =
						list[word].
						replaceAll(except.toString()
								+ "]", "-");
				g = guessedword;
				guessnumber++;
			}
		}
		if (guessnumber >= maxg) {
			g = null;
		}
		return g;
	}

	@Override
	public final void setMaxWrongGuesses(final Integer max) {
		// TODO Auto-generated method stub
		if (max == null) {
			maxg = 1;
		} else if (max > -1) {
			maxg = max;
		}
	}
}
