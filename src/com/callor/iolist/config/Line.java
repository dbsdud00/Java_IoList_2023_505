package com.callor.iolist.config;

public class Line {
	public static String dLine() {
		return dLine(70);
	}
	public static String dLine(int length) {
		return "=".repeat(length);
	}
	public static String sLine() {
		return sLine(70);
	}
	public static String sLine(int length) {
		return "-".repeat(length);
	}
}
