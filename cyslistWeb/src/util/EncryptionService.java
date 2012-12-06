package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

/**
 * Provides methods to encrypt strings and compare a raw string to an encrypted
 * version.
 * 
 * @author Tony
 * 
 */
public final class EncryptionService {

	private static final EncryptionService instance = new EncryptionService();

	public static EncryptionService getInstance() {
		return instance;
	}

	/**
	 * Encrypts the given string using SHA.
	 * 
	 * @param text
	 *            The string to encrypt.
	 * @return The encrypted value.
	 * @throws NoSuchAlgorithmException
	 */
	public String encrypt(String text) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA");
		md.update(text.getBytes());
		byte[] raw = md.digest();
		String hash = new BASE64Encoder().encode(raw);
		return hash;
	}

	/**
	 * Compares a raw string with an encryped string.
	 * 
	 * @param raw
	 *            The raw string.
	 * @param stored
	 *            The encrypted string.
	 * @return True if the encryped version of the raw string is the same as
	 *         given encrypted string.
	 * @throws NoSuchAlgorithmException
	 */
	public boolean comparePassword(String raw, String stored)
			throws NoSuchAlgorithmException {
		String hash = EncryptionService.getInstance().encrypt(raw);
		return hash.equals(stored);
	}
}
