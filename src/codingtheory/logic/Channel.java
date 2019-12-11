/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codingtheory.logic;

/**
 *
 * @author tvari
 */
public class Channel {
    private final double p;
    private final int q;
    
    public Channel(final double p) {
        this.p = p;
        this.q = 2;
    }
    // gražina klaidų vektoriu
    public int[] sendMessage(int[] word) {
        int[] failures = new int[word.length];
        for (int i = 0; i < word.length; i++) {
            if (Math.random() < p) {
                word[i] = (word[i]+1) % q;
                failures[i] = 1;
            }
        }
        return failures;
    }
}
