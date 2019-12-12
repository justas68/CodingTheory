/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codingtheory.logic;

import java.util.Collections;

/**
 * @author tvari
 */
public class Util {

	//Skaičiu paverčia į bitų masyvą
	public static int[] intToByteArray(int value, int length) {
		String bytes = Integer.toBinaryString(value);
		String missingZeroes = String.join("", Collections.nCopies(length - bytes.length(), "0"));
		String finalString = missingZeroes + bytes;
		int[] array = new int[length];
		for (int i = 0; i < finalString.length(); i++) {
			array[i] = Character.getNumericValue(finalString.charAt(i));
		}
		return array;
	}

	//Sujungia masyvo elementus į eilutę
	public static String joinArray(int[] array) {
		StringBuilder s = new StringBuilder();
		for (int item : array) {
			s.append(item);
		}
		return s.toString();
	}

}
