package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public final class EncryptionService {

	private static final EncryptionService instance = new EncryptionService();

	public static EncryptionService getInstance() {
		return instance;
	}

	public String encrypt(String text) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA");
		md.update(text.getBytes());
		byte[] raw = md.digest();
		String hash = new BASE64Encoder().encode(raw);
		return hash;
	}

	public boolean comparePassword(String raw, String stored)
			throws NoSuchAlgorithmException {
		String hash = EncryptionService.getInstance().encrypt(raw);
		return hash.equals(stored);
	}
}
