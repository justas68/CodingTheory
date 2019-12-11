/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codingtheory.logic;

import java.util.Collections;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tvari
 */
public class Vector implements Cloneable {
    
    private  int[] array;
    private  String arrayAsString;
    private  int value;
    private  long weight;
    
    public Vector(final int[] array) {
        this.array = array;
        this.arrayAsString = joinArray(this.array);
        this.value = Integer.parseInt(this.arrayAsString, 2);
        this.weight = this.arrayAsString.chars().filter(ch -> ch == '1').count();
    }
    
    public Vector(final int value, final int length) {
        this.array = intToByteArray(value, length);
        this.arrayAsString = joinArray(this.array);
        this.value = value;
        this.weight = this.arrayAsString.chars().filter(ch -> ch == '1').count();
    }
    
    public Vector(final String arrayAsString) {
        this.array = intToByteArray(Integer.parseInt(arrayAsString, 2), arrayAsString.length());
        this.arrayAsString = arrayAsString;
        this.value = Integer.parseInt(arrayAsString, 2);
        this.weight = this.arrayAsString.chars().filter(ch -> ch == '1').count();
    }
    
    public Vector addVector(final Vector vector) {
        int[] vectorArray = this.array.clone();
        for (int i = 0; i < vectorArray.length; i++) {
            vectorArray[i] = (vectorArray[i] + vector.getArray()[i]) % 2;
        }
        return new Vector(vectorArray);
    }
    
    public Vector addByteToVector(int position) {
        this.array[position] = (this.array[position] + 1) % 2;
        this.arrayAsString = joinArray(this.array);
        this.value = Integer.parseInt(this.arrayAsString, 2);
        this.weight = this.arrayAsString.chars().filter(ch -> ch == '1').count();
        return this;
    }
    private int[] intToByteArray(int value, int length) {
         String bytes = Integer.toBinaryString(value);
        String missingZeroes = String.join("", Collections.nCopies(length-bytes.length(), "0"));
        String finalString = missingZeroes + bytes;
        int[] array = new int[length];
        for (int i = 0; i < finalString.length(); i++) {
            array[i] = Character.getNumericValue(finalString.charAt(i));
        }
        return array;
    }
    
    private String joinArray(int[] array) {
        String s = "";
        for (int i = 0; i < array.length; i++) {
            s += Integer.toString(array[i]);
        }
        return s;
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
        if (!this.arrayAsString.equalsIgnoreCase(other.arrayAsString)) {
            return false;
        }
        return true;
    }
    
}
