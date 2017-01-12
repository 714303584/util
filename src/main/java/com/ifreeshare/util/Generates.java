package com.ifreeshare.util;

import java.util.Random;
import java.util.UUID;

/**
 * Automatic generated
 * @author zhuss
 */
public class Generates {
	
	
	public static final 	char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
		'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
		'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	
	
	/**
	 * Generate a random password
	 *
	 * @param pwd_len
	 *            The total length of the generated password
	 * @return The password string
	 */
	public static String genRandomNum(int pwd_len) {
		// 35 because the array is starting from 0, 26 letters +10 numbers
		final int maxNum = 62;
		int i; // The generated random number
		int count = 0; // The length of the generated password
		StringBuffer pwd = new StringBuffer("");
		Random r = new Random();
		while (count < pwd_len) {
			// Generate a random number, take absolute value, to prevent the
			// generation of negative numbers,
			i = Math.abs(r.nextInt(maxNum)); // The maximum number generated is
												// 36-1
			if (i >= 0 && i < str.length) {
				pwd.append(str[i]);
				count++;
			}
		}
		return pwd.toString();
	}
	
	
	
	public static String getUuid(){
		return UUID.randomUUID().toString();
	}
	
	public static void main(String[] args) {
		System.out.println(genRandomNum(15));
	}
	

}
