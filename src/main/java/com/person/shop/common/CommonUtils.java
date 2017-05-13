package com.person.shop.common;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class CommonUtils {
	public static boolean isEmail(String email) {
		if(StringUtils.isEmpty(email)){
			return false;
		}
		if(Pattern.compile("^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$").matcher(email).matches()){
			return true;
		} else {
			return false;
		}
    }
}
