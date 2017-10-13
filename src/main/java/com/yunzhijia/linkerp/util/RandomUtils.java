package com.yunzhijia.linkerp.util;

import java.util.Random;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

public class RandomUtils {
	private static final String RAND_CHAR = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890";

	public static String randomKey(int len) {
		StringBuffer sb = new StringBuffer();
		Random rand = new Random();
		int l = RAND_CHAR.length();
		for (int i = 0; i < len; i++) {
			sb.append(RAND_CHAR.charAt(rand.nextInt(l) % l));
		}
		return sb.toString();
	}

	public static String mapKey(String hex) {
		if (hex == null) {
			return null;
		}
		Random rand = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < hex.length(); i++) {
			int n = Integer.parseInt(String.valueOf(hex.charAt(i)), 16);
			String a = StringUtils.substring(RAND_CHAR, n * 4, (n + 1) * 4);
			int l = a.length();
			sb.append(a.charAt(rand.nextInt(l) % l));
		}
		return sb.toString();
	}
	public static String uuidHex(){
		return StringUtils.replaceAll(UUID.randomUUID().toString(), "-", "");
	}
	public static String uuid(){
		return mapKey(uuidHex());
	}
	public static void main(String[] args) {
		System.err.println(uuid());
	}
}
