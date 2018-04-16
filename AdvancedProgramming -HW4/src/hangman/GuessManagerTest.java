/**
 * 
 */
package hangman;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import hangman.GuessManagerContract.GuessResponse;
import junit.framework.Assert;

/**
 * @author nitai
 *
 */
public class GuessManagerTest {

	GuessManager gmt;
	
	@Before
	public void setUp() throws Exception {
		this.gmt = new GuessManager("checkchecktest",5);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link hangman.GuessManager#GuessManager(java.lang.String, int)}.
	 */
	@Test
	public void testGuessManager() {
		assertNotNull("Error in GuessManager in function GuessManager() - is null",gmt);
	}

	/**
	 * Test method for {@link hangman.GuessManager#getBadGuessesLeft()}.
	 */
	@Test
	public void testGetBadGuessesLeft() {
		gmt.getGuessResponse('a');
		gmt.getGuessResponse('x');
		gmt.getGuessResponse('y');
		assertEquals("Error in GuessManager in function getBadGuessesLeft()", gmt.getBadGuessesLeft(), 2);

		}

	/**
	 * Test method for {@link hangman.GuessManager#getCurrentHint()}.
	 */
	@Test
	public void testGetCurrentHint() {
		gmt.getGuessResponse('c');
		gmt.getGuessResponse('t');
		assertEquals("Error in GuessManager in function getCurrentHint()", "c__c_c__c_t__t", gmt.getCurrentHint());
	}

	/**
	 * Test method for {@link hangman.GuessManager#getGuessResponse(char)}.
	 */
	@Test
	public void testGetGuessResponse() {
		assertEquals(GuessResponse.GUESS_GOOD, gmt.getGuessResponse('c'));
		assertEquals(GuessResponse.GUESS_GOOD, gmt.getGuessResponse('h'));
		assertEquals(GuessResponse.GUESS_GOOD, gmt.getGuessResponse('e'));
		assertEquals(GuessResponse.GUESS_GOOD, gmt.getGuessResponse('k'));
		assertEquals("Error in GuessManager in function getGuessResponse() - GUESS_GOOD", GuessResponse.GUESS_GOOD, gmt.getGuessResponse('t'));
		assertEquals("Error in GuessManager in function getGuessResponse() - GUESS_WIN", GuessResponse.GUESS_WIN, gmt.getGuessResponse('s'));
		
		assertEquals(GuessResponse.GUESS_BAD, gmt.getGuessResponse('a'));
		assertEquals(GuessResponse.GUESS_BAD, gmt.getGuessResponse('a'));
		assertEquals(GuessResponse.GUESS_BAD, gmt.getGuessResponse('a'));
		assertEquals(GuessResponse.GUESS_BAD, gmt.getGuessResponse('a'));
		assertEquals("Error in GuessManager in function getGuessResponse() - GUESS_BAD", GuessResponse.GUESS_BAD, gmt.getGuessResponse('a'));
		assertEquals("Error in GuessManager in function getGuessResponse() - GUESS_LOSE", GuessResponse.GUESS_LOSE, gmt.getGuessResponse('a'));
	}

}
