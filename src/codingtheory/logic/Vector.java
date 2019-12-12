/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codingtheory.logic;

import java.util.Objects;

/**
 * @author tvari
 */
public class Vector implements Cloneable {

	private int[] array;
	private String arrayAsString;
	private int value;
	private long weight;

	//Vektoriaus kūrimas, gavus jo elementų masyvą
	public Vector(final int[] array) {
		this.array = array;
		this.arrayAsString = Util.joinArray(this.array);
		this.value = Integer.parseInt(this.arrayAsString, 2);
		this.weight = this.arrayAsString.chars().filter(ch -> ch == '1').count();
	}

	//Vektoriaus kūrimas gavus jo integer reikšmę, bei ilgį.
	public Vector(final int value, final int length) {
		this.array = Util.intToByteArray(value, length);
		this.arrayAsString = Util.joinArray(this.array);
		this.value = value;
		this.weight = this.arrayAsString.chars().filter(ch -> ch == '1').count();
	}

	//Vektoriaus kūrimas gavus jo dvejatainę eilutę
	public Vector(final String arrayAsString) {
		this.array = Util.intToByteArray(Integer.parseInt(arrayAsString, 2), arrayAsString.length());
		this.arrayAsString = arrayAsString;
		this.value = Integer.parseInt(arrayAsString, 2);
		this.weight = this.arrayAsString.chars().filter(ch -> ch == '1').count();
	}

	//Vektorių elementų sudėjimas
	public Vector addVector(final Vector vector) {
		int[] vectorArray = this.array.clone();
		for (int i = 0; i < vectorArray.length; i++) {
			vectorArray[i] = (vectorArray[i] + vector.getArray()[i]) % 2;
		}
		return new Vector(vectorArray);
	}

	//Prie vektoriaus elemento nurodytoje pozicijoje pridedamas 1
	public Vector addByteToVector(int position) {
		this.array[position] = (this.array[position] + 1) % 2;
		this.arrayAsString = Util.joinArray(this.array);
		this.value = Integer.parseInt(this.arrayAsString, 2);
		this.weight = this.arrayAsString.chars().filter(ch -> ch == '1').count();
		return this;
	}

	public int[] getArray() {
		return array;
	}

	public String getArrayAsString() {
		return arrayAsString;
	}

	public int getValue() {
		return value;
	}

	public long getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "arrayAsString=" + arrayAsString + ", value=" + value;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 67 * hash + Objects.hashCode(this.arrayAsString);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Vector other = (Vector) obj;
        return this.arrayAsString.equalsIgnoreCase(other.arrayAsString);
    }

}
