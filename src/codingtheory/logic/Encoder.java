/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codingtheory.logic;

/**
 * @author tvari
 */
public class Encoder {
	private final Matrix generatingMatrix;

	public Encoder(final Matrix generatingMatrix) {
		this.generatingMatrix = generatingMatrix;
	}

	public Vector encode(final int[] message) {
		return generatingMatrix.multiplicationByVector(message);
	}
}
