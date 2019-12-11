/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codingtheory.logic;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author tvari
 */
public class Decoder {
    private final Matrix matrixG;
    private final Matrix matrixH;
    private final Map<String, Long> syndromeWeightMap;
    
    public Decoder(final Matrix matrixG) {
        this.matrixG = matrixG;
        this.matrixH = matrixG.getParityCheckMatrix();
        int n = matrixG.getColumns();
        int k = matrixG.getRows();
        List<Vector> codeWords = new ArrayList<>();

        // sugeneruojame visus galimus kodo žodžius. Jų yra 2^n
        int wordCount = (int)Math.pow(2, k);
        for (int i = 0; i < wordCount; i++) {
            codeWords.add(matrixG.multiplicationByVector(intToByteArray(i, k)));
        }
        
        // gaunam visas galimas skaičių kombinacijas. iškart išimam jau panaudotas
        List<Vector> allCombinations = IntStream.range(0, (int)Math.pow(2, n)).boxed()
                .map(number -> new Vector(number, n)).filter(vector -> {
                    return  !codeWords.stream().map(Vector::getArrayAsString).collect(Collectors.toList()).contains(vector.getArrayAsString());        
                })
                .collect(Collectors.toList());

        //paimam visus klasiu lyderius
        List<Vector> cosetLeaders = new ArrayList<>();
        cosetLeaders.add(codeWords.get(0));
        for (int i = 0; i < Math.pow(2,n-k) - 1; i++) {
            List<Vector> cosetRow = getCosetRow(allCombinations, codeWords);
            List<String> cosetRowVectors = cosetRow.stream().map(Vector::getArrayAsString).collect(Collectors.toList());
            allCombinations.removeAll(allCombinations.stream()
                    .filter(vector -> cosetRowVectors.contains(vector.getArrayAsString())).collect(Collectors.toList()));
            cosetLeaders.add(cosetRow.get(0));
        }

        this.syndromeWeightMap = getSyndromeWeightMap(cosetLeaders, this.matrixH);
        
    }
    
    public Vector decodeVector(Vector vector) {
    //dauginam gautą vektorių(transponuotą) iš H
    Vector syndromeV = this.matrixH.multiplicationByVectorT(vector.getArray());

    //žiūrime, kokį svorį sindromas atitinka
    Long w = this.syndromeWeightMap.get(syndromeV.getArrayAsString());

    //pradinė e pozicija - pats pirmas bitas
    int ePos = 0;
    Long lastW;

    //kai svoris bus lygus nuliui, būsime dekodavę
    while (w != 0) {
        lastW = w;
        vector = vector.addByteToVector(ePos);
        Vector syndrome = this.matrixH.multiplicationByVectorT(vector.getArray());
        w = this.syndromeWeightMap.get(syndrome.getArrayAsString());

        //jei svoris nemažėja, grąžinam tą pakeistą bitą atgal
        if (w >= lastW) {
            vector = vector.addByteToVector(ePos);
            w = lastW;
        }
        ePos++;
    }
    //atkerpame pirmus k bitų - jie yra mūsų dekoduotas žodis
    return new Vector(vector.getArrayAsString().substring(0, matrixG.getRows()));
}


    private List<Vector> getCosetRow(List<Vector> allCombinations, List<Vector> codeWords) {
        Vector cosetLeader = allCombinations.stream().sorted(Comparator.comparingLong(Vector::getWeight)).findFirst().orElse(null);
        return codeWords.stream()
                .map(codeWord -> codeWord.addVector(cosetLeader))
                .collect(Collectors.toList());
    }
    
    private Map<String, Long> getSyndromeWeightMap(List<Vector> cosetLeaders, Matrix matrixH) {
        return cosetLeaders.stream().collect(Collectors.toMap(
                   leader -> matrixH.multiplicationByVectorT(leader.getArray()).getArrayAsString(), 
                   leader -> leader.getWeight()));
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
}
