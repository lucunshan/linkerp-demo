package com.yunzhijia.linkerp.util;

import java.util.Arrays;
import java.util.Collection;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SignUtils {
	private static Logger logger = LoggerFactory.getLogger(SignUtils.class);
	public static boolean checkSign(Collection<String> data, String sign) {
		String[] arr = data.toArray(new String[] {});
		return checkSign(sign, arr);
	}

	public static boolean checkSign(String sign, String... data) {
		String s = sign(data);
		logger.info("signinfo 1:{},2:{}",sign,s);
		if (StringUtils.equals(StringUtils.lowerCase(s), StringUtils.lowerCase(sign))) {
			return true;
		}
		return false;
	}

	public static String sign(String... data) {
		Arrays.sort(data);
		logger.info("sign data:{}",StringUtils.join(data,","));
		return DigestUtils.sha1Hex(StringUtils.join(data));
	}
}
