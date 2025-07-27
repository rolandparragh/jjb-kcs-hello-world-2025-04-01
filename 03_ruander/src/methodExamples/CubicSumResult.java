package methodExamples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CubicSumResult {

	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		// Írjuk ki két szám négyzetösszegét
		twoNumberUserInput(getInputNumber("Egyik szám:"), getInputNumber("Másik szám:"));

	}// main

	

	private static int getInputNumber(String message) throws NumberFormatException, IOException {

		System.out.println(message);
		return Integer.parseInt(br.readLine());
	}// getInputNumber

	private static double calcPower(double numberOne, double numberTwo) {

		return (Math.pow(numberOne, 2) + Math.pow(numberTwo, 2));
	}// calPerimeter

	private static void twoNumberUserInput(int a, int b) throws NumberFormatException, IOException {

		System.out.println(calcPower(a, b));
	} // twoNumberUserInput

}// class
