package com.person.shop.common;

import static org.junit.Assert.*;

import org.junit.Test;

public class CommonUtilsTest {
	
	@Test
	public void test() {
		assertFalse(CommonUtils.isEmail(null));
		assertFalse(CommonUtils.isEmail(""));
		assertFalse(CommonUtils.isEmail("a"));
		assertFalse(CommonUtils.isEmail("a@"));
		assertFalse(CommonUtils.isEmail("a@c"));
		assertFalse(CommonUtils.isEmail("a@c."));
		assertFalse(CommonUtils.isEmail("a@c."));
		assertFalse(CommonUtils.isEmail("a.c.c"));
		assertFalse(CommonUtils.isEmail("a.c@c"));
		assertFalse(CommonUtils.isEmail("a@c2.c2"));
		assertTrue(CommonUtils.isEmail("a@c.c"));
		assertTrue(CommonUtils.isEmail("a.@c.c"));
		assertTrue(CommonUtils.isEmail("a2@c.c"));
		assertTrue(CommonUtils.isEmail("a@c2.c"));
	}
}
