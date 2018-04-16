/**
 * 
 */
package hangman;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

/**
 * @author nitai
 *
 */
public class AsciiPictureTest {

	AsciiPicture pic;
	AsciiPicture picBlank;
	AsciiPicture top;


	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		char[][] picture = { 
				   "  _________      ".toCharArray(),
				   " |         |     ".toCharArray(),
				   " |         M     ".toCharArray(),
				   " |         0     ".toCharArray(),
				   " |        {o}    ".toCharArray(),
				   " |        | |    ".toCharArray(),
				   " |               ".toCharArray(),
				   " |               ".toCharArray()
				   };
		
		char[][] pictureTop = { 
				   "  _________      ".toCharArray(),
				   " |         |     ".toCharArray(),
				   " |         |     ".toCharArray(),
				   " |         0     ".toCharArray(),
				   " |        /|\\    ".toCharArray(),
				   " |        / \\    ".toCharArray(),
				   " |               ".toCharArray(),
				   " |               ".toCharArray()
				   };
		

		
		this.pic = new AsciiPicture(picture[0].length, picture.length, 0, 0, picture);
		this.top = new AsciiPicture(4, 4, 10, 3, pictureTop);

		this.picBlank = new AsciiPicture(picture[0].length, picture.length, ' ');


	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link hangman.AsciiPicture#get(int, int)}.
	 */
	@Test
	public void testGet() {
		char c = pic.get(11,2);
		assertEquals("Error in AsciiPicture in Get() function", c, 'M');
	}

	/**
	 * Test method for {@link hangman.AsciiPicture#set(int, int, char)}.
	 */
	@Test
	public void testSet() {
		pic.set(11, 2, '|');
		assertEquals("Error in AsciiPicture in Set() function", pic.get(11,2), '|');
	}

	/**
	 * Test method for {@link hangman.AsciiPicture#AsciiPicture(int, int, int, int, char[][])}.
	 */
	@Test
	public void testAsciiPictureIntIntIntIntCharArrayArray() {
		assertNotNull("Error in AsciiPicture in AsciiPicture()-long function", pic);
	}

	/**
	 * Test method for {@link hangman.AsciiPicture#AsciiPicture(int, int, char)}.
	 */
	@Test
	public void testAsciiPictureIntIntChar() {
		assertNotNull("Error in AsciiPicture in AsciiPicture()-short function", picBlank);
	}

	/**
	 * Test method for {@link hangman.AsciiPicture#overlay(hangman.AsciiPicture, int, int, char)}.
	 */
	@Test
	public void testOverlay() {
		picBlank.overlay(top, -5, -5, ' ');
		picBlank.overlay(top, 20, 20, ' ');


		}

	/**
	 * Test method for {@link hangman.AsciiPicture#print(java.io.PrintStream)}.
	 * @throws IOException 
	 */
	@Test
	public void testPrint() throws IOException {
		picBlank.print(System.out);
	}

}
