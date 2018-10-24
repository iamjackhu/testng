package com.jack.testng;

public class TestNgMain {
	
	private int value = 1;
	private static String staticValue = "Hello";
	
	public static int squre(int input) {
		return input * input;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public String getStaticValue() {
		return staticValue;
	}

}
