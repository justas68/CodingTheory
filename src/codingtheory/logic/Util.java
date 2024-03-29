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

	// metodas priima žinutę dvejatainiu formatu, kanalą, bei kodavimo ir dekodavimo objektus, kuriais pasinaudodamas
	// persiunčia žinutę kanalu prieš tai ją užkodaves. Persiuntus kanalu atokoduoja ir grąžina binarinę eilutę.
	public static String sendMessageWithEncoding(final String message,
										  Matrix matrix, Encoder encoder, Channel channel, Decoder decoder) {
		int sentBytes = 0;
		String messageToSend = message;
		//Patikrinam žinutės ilgį, jeigu trūkstą simbolių pridedam '0', prieš grąžinant rezultatą juos nukirpsime
		int appendedZeroes = messageToSend.length() % matrix.getRows();
		if (appendedZeroes != 0) {
			appendedZeroes = matrix.getRows() - appendedZeroes;
			messageToSend += repeatString("0", appendedZeroes);
		}
		int bytesToSend = messageToSend.length();
		String decodedMessage = "";
		//Siunčia bitus atsikirpdamas po reikiamą dydį
		//Užkoduoja -> Siunčia į kanalą -> Dekoduoja
		while (sentBytes < bytesToSend) {
			String batch = messageToSend.substring(sentBytes, sentBytes + matrix.getRows());
			Vector vectorToSend = new Vector(batch);
			int[] bytesArray = vectorToSend.getArray();
			int[] encodedArray = encoder.encode(bytesArray).getArray();
			channel.sendMessage(encodedArray);
			Vector decodedVector = decoder.decodeVector(new Vector(encodedArray));
			decodedMessage += decodedVector.getArrayAsString();
			sentBytes += matrix.getRows();
		}
		return decodedMessage.substring(0, decodedMessage.length() - appendedZeroes);
	}

	//Metodas priima žinutę pavertą į dvejatainį formatą, kanalą ir skaičiu, kuris nusako į kokias dalis skaidyti siunčiamą eilutę
	public static String sendMessageWithNoEncoding(final String message, Channel channel, int batchSize) {
		int sentBytes = 0;
		String receivedMessage = "";
		String messageToSend = message;
		//Patikrinam žinutės ilgį, jeigu trūkstą simbolių pridedam '0', prieš grąžinant rezultatą juos nukirpsime
		int appendedZeroes = messageToSend.length() % batchSize;
		if (appendedZeroes != 0) {
			appendedZeroes = batchSize - appendedZeroes;
			messageToSend += repeatString("0", appendedZeroes);
		}
		int bytesToSend = messageToSend.length();
		while (sentBytes < bytesToSend) {
			String batch = messageToSend.substring(sentBytes, sentBytes + batchSize);
			Vector vectorToSend = new Vector(batch);
			int[] bytesArray = vectorToSend.getArray();
			channel.sendMessage(bytesArray);
			receivedMessage += (new Vector(bytesArray)).getArrayAsString();
			sentBytes += batchSize;
		}
		return receivedMessage.substring(0, receivedMessage.length() - appendedZeroes);
	}

	private static String repeatString(String stringToRepeat, int n) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < n; i++) {
			s.append(stringToRepeat);
		}
		return s.toString();
	}

}
