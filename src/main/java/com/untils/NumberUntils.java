package com.untils;

public class NumberUntils {
	public static  boolean isNumm(String s){
		try {
			int temp=Integer.parseInt(s);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
