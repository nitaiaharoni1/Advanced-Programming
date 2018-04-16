package files;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Streams {
	/**
	 * Read from an InputStream until a quote character (") is found, then read
	 * until another quote character is found and return the bytes in between the
	 * two quotes. If no quote character was found return null, if only one, return
	 * the bytes from the quote to the end of the stream.
	 * 
	 * @param in
	 * @return A list containing the bytes between the first occurrence of a quote
	 *         character and the second.
	 */
	public static List<Byte> getQuoted(InputStream in) throws IOException {
		int c = 0;
		List<Byte> list = new ArrayList<>();
		while (c != '"') {
			if (c == -1)
				return null;
			c = (byte) in.read();
		}
		do {
			c = in.read();
			if (c == -1 || c == '"') {
				return list;
			}
			list.add((byte) c);
		} while (c != '"' && c != -1);
		return list;
	}

	/**
	 * Read from the input until a specific string is read, return the string read
	 * up to (not including) the endMark.
	 * 
	 * @param in
	 *            the Reader to read from
	 * @param endMark
	 *            the string indicating to stop reading.
	 * @return The string read up to (not including) the endMark (if the endMark is
	 *         not found, return up to the end of the stream).
	 */
	public static String readUntil(Reader in, String endMark) throws IOException {
		char c = 0;
		StringBuilder s = new StringBuilder();
		while (c != -1) {
			c = (char) in.read();
			s.append(c);
			if(s.indexOf(endMark)>=0) {
				s = s.delete(s.indexOf(endMark), s.length());
				return s.toString();
			}
		}
		return s.toString();
	}

	/**
	 * Copy bytes from input to output, ignoring all occurrences of badByte.
	 * 
	 * @param in
	 * @param out
	 * @param badByte
	 */
	public static void filterOut(InputStream in, OutputStream out, byte badByte) throws IOException {
		int c = in.read();
		while(c != -1) {
			if( ((byte)c) != badByte) {
				out.write(c);
			}
			c = in.read();
		}
		out.flush();
	}

	/**
	 * Read a 48-bit (unsigned) integer from the stream and return it. The number is
	 * represented as five bytes, with the most-significant byte first. If the
	 * stream ends before 5 bytes are read, return -1.
	 * 
	 * @param in
	 * @return the number read from the stream
	 */
	public static long readNumber(InputStream in) throws IOException {
		long c = (long) in.read();
		long result = 0;
		for (int i = 0; i < 6; i++) {
			if(i<4 && c == -1) return -1;
			if(c == -1) {
				break;
			}
			c = (c <<56)>>>56;
			result |= c << (32 - 8*i);
			c = (long) in.read();
		}
		return result;
	}
}
