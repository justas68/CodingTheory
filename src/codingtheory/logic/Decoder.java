/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codingtheory.logic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
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
		int wordCount = (int) Math.pow(2, k);
		for (int i = 0; i < wordCount; i++) {
			codeWords.add(matrixG.multiplicationByVector(Util.intToByteArray(i, k)));
		}

		// gaunam visas galimas skaičių kombinacijas.
		List<Vector> allCombinations = IntStream.range(0, (int) Math.pow(2, n)).boxed()
				.map(number -> new Vector(number, n))
				//Išimam jau panaudotus žodžius
				.filter(vector -> !codeWords.stream().map(Vector::getArrayAsString).collect(Collectors.toList()).contains(vector.getArrayAsString()))
				.collect(Collectors.toList());

		List<Vector> cosetLeaders = new ArrayList<>();
		//Prie klasės lyderių pridedam vektoriu iš 0
		cosetLeaders.add(codeWords.get(0));
		for (int i = 0; i < Math.pow(2, n - k) - 1; i++) {
			//Gauna viena standartinės lentelės eilutę
			List<Vector> cosetRow = getCosetRow(allCombinations, codeWords);
			//Vectoriu paverčia į eilutę iš 0 ir 1
			List<String> cosetRowVectors = cosetRow.stream().map(Vector::getArrayAsString).collect(Collectors.toList());
			//Iš galimų visų kombinacijų išma panaudotas šioje eilutėje
			allCombinations.removeAll(allCombinations.stream()
					.filter(vector -> cosetRowVectors.contains(vector.getArrayAsString())).collect(Collectors.toList()));
			//prideda šios klasės lyderį prie lyderių sąrašo
			cosetLeaders.add(cosetRow.get(0));
		}

		//Sudaro sindromų ir svorio Map
		this.syndromeWeightMap = getSyndromeWeightMap(cosetLeaders, this.matrixH);

	}

	//Priima užkoduoda vektoriu, jį dekoduoja ir grąžina
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
		//atkerpame pirmus k bitų ir gražinam
		return new Vector(vector.getArrayAsString().substring(0, matrixG.getRows()));
	}

	//Sudaro ir gražina standartinės lentelės eilutę.
	private List<Vector> getCosetRow(List<Vector> allCombinations, List<Vector> codeWords) {
		//Suranda galima klasės lyderį su mažiausiu svoriu
		Vector cosetLeader = allCombinations.stream().min(Comparator.comparingLong(Vector::getWeight)).orElse(null);
		return codeWords.stream()
				.map(codeWord -> codeWord.addVector(cosetLeader))
				.collect(Collectors.toList());
	}

	//Priima klasių lyderių sąrašą, bet kontrolinę matricją, gražina Sindromų ir svorio Map.
	private Map<String, Long> getSyndromeWeightMap(List<Vector> cosetLeaders, Matrix matrixH) {
		//Klasių lyderių transponuotus vektorius sudaugina su kontroline matrica,
		// sandaugos rezultą ir klasės lyderio svorį sudeda į Map<"vektorius", "klasės lyderio svoris">
		return cosetLeaders.stream().collect(Collectors.toMap(
				leader -> matrixH.multiplicationByVectorT(leader.getArray()).getArrayAsString(),
				Vector::getWeight));
	}
}
