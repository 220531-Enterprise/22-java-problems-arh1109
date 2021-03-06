package com.revature.eval.java.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class EvaluationService {

	/**
	 * 
	 * ADD SOME DOCUMENTATION
	 * 
	 * 1.A Speed Converter - Convert to MilesPerHour
	 * 
	 * Write a method called toMilesPerHour that has 1 parameter of type double with
	 * the name kilometersPerHour. This method needs to return the rounded value of
	 * the calculation of type long.
	 * 
	 * If the parameter kilometersPerHour is less than 0, the method toMilesPerHour
	 * needs to return -1 to indicate an invalid value.
	 * 
	 * Otherwise if it is positive, calculate the value of miles per hour, round it
	 * and return it. For conversion and rounding use Math.round().
	 */
	static class SpeedConverter {

		public static long toMilesPerHour(double kilometersPerHour) {
			// TODO Write an implementation for this method declaration
			// check if the params km/hr is < 0 . Return -1
			if(kilometersPerHour < 0) {
				return -1;
			}
			
			// find out the formula to convert kph to mph
			double mph = Math.round((double)kilometersPerHour / 1.609);
			
			// return it!
			
			return (long)mph;
		}

		/**
		 * 1.B Speed Converter - Print Conversion
		 * 
		 * Write another method called printConversion with 1 parameter of type double
		 * with the name kilometersPerHour. This method needs to return a String and
		 * needs to calculate milesPerHour from the kilometersPerHour parameter.
		 * 
		 * The String should print in the format: "XX km/h = YY mi/h"
		 * 
		 * XX represents the original value kilometersPerHour. YY represents the rounded
		 * milesPerHour from the kilometersPerHour parameter.
		 * 
		 * If the parameter kilometersPerHour is < 0, then print the text "Invalid
		 * Value"
		 */
		public static String printConversion(double kilometersPerHour) {

			if(kilometersPerHour < 0) {
				return "Invalid Value";
			}
			// convert km/hr to mi/hr. 1km/hr = 0.621371 km/hr
			double conversionFactor = 0.621371;
			
			int roundedMiPerHr = (int)Math.round(conversionFactor * kilometersPerHour);
			
			
			
			return kilometersPerHour + " km/h = " + roundedMiPerHr + " mi/h";
		}
	}

	/**
	 * 2. MegaBytes and KiloBytes
	 * 
	 * Write a method called printMegaBytesAndKiloBytes that has 1 parameter of type
	 * int with the name kiloBytes.
	 * 
	 * The method should return a String and it needs to calculate the megabytes and
	 * remaining kilobytes from the kilobytes parameter.
	 * 
	 * Then it needs to print a message in the format "XX KB = YY MB and ZZ KB".
	 * 
	 * XX represents the original value kiloBytes. YY represents the calculated
	 * megabytes. ZZ represents the calculated remaining kilobytes.
	 * 
	 * For examples, when the parameter kiloBytes is 2500 it needs to print "2500 KB
	 * = 2 MB and 452 KB"
	 * 
	 * If the parameter kiloBytes is less than 0 then print the text "Invalid
	 * Value".
	 */
	public String printMegaBytesAndKiloBytes(int kiloBytes) {
		// if kiloBytes < 0 return invalid
		if(kiloBytes < 0) {
			return "Invalid Value";
		}
		
		int kbToMbConversionFactor = 1024;
		int megaBytes = kiloBytes / kbToMbConversionFactor;
		int remainingKbs = kiloBytes % kbToMbConversionFactor;
		
		return kiloBytes + " KB = " + megaBytes + " MB and " + remainingKbs + " KB";
	}

	/**
	 * 3. Barking Dog
	 * 
	 * We have a dog that loves to bark. We need to wake up if the dog is barking at
	 * night!
	 * 
	 * Write a method shouldWakeUp that has 2 parameters.
	 * 
	 * 1st parameter should be of type boolean and be named "barking". It represents
	 * if our dog is currently barking. 2nd parameter represents the hour of the day
	 * and is of type int with the name hourOfDay and has a valid range of 0-23.
	 * 
	 * We have to wake up if the dog is barking before 8 or after 22 hours, so in
	 * that case return true.
	 * 
	 * In all other cases return false.
	 * 
	 * If the hourOfDay parameter is less than 0 or greater than 23, return false.
	 */
	public boolean shouldWakeUp(boolean isBarking, int hourOfDay) {
		// TODO Write an implementation for this method declaration
		if(hourOfDay < 0 || hourOfDay > 23) {
			return false;
		}
		if((isBarking && hourOfDay < 8) || (isBarking && hourOfDay > 22)) {
			return true;
		}
		return false;
	}

	/**
	 * 4. DecimalComparator
	 * 
	 * Write a method areEqualByThreeDecimalPlaces with two parameters of type
	 * double.
	 * 
	 * The method should return boolean and it needs to return true if two double
	 * numbers are the same up to three decimal places.
	 * 
	 * Otherwise, return false;
	 */
	public boolean areEqualByThreeDecimalPlaces(double firstNum, double secondNum) {
		// TODO Write an implementation for this method declaration
		String firstNumStr = firstNum + "";
		String[] firstNumArr = firstNumStr.split("\\.");
		String secondNumStr = secondNum + "";
		String[] secondNumArr = secondNumStr.split("\\.");

		while(firstNumArr[1].length() < 3) {
			firstNumArr[1] += "0";
		}
		while(secondNumArr[1].length() < 3) {
			secondNumArr[1] += "0";
		}
		return firstNumArr[0].equals(secondNumArr[0]) 
				&& firstNumArr[1].substring(0,3).equals(secondNumArr[1].substring(0,3));
	}

	/**
	 * 5. Teen Number Checker
	 * 
	 * We'll say that a number is "teen" if it is in the range 13 -19 (inclusive).
	 * Write a method named hasTeen with 3 parameters of type int.
	 * 
	 * The method should return boolean and it needs to return true if ONE of the
	 * parameters is in range 13(inclusive) - 19 (inclusive). Otherwise return
	 * false.
	 */
	static class TeenNumberChecker {

		public static boolean hasTeen(int x, int y, int z) {
			// TODO Write an implementation for this method declaration
			return isTeen(x) || isTeen(y) || isTeen(z);
		}

		// We can initialize isTeen method first
		// Then pass the parameter to hasTeen method

		public static boolean isTeen(int number) {
			// TODO Write an implementation for this method declaration
			
			return number >= 13 && number <= 19;
		}
	}

	/**
	 * 6. Minutes To Years and Days Calculator
	 * 
	 * Write a method printYearsAndDays with parameter of type long named minutes.
	 * The method should not return anything (void) and it needs to calculate the
	 * years and days from the minutes parameter.
	 * 
	 * If the parameter is less than 0, print text "Invalid Value".
	 * 
	 * Otherwise, if the parameter is valid then it needs to print a message in the
	 * format "XX min = YY y and ZZ d".
	 * 
	 * XX represents the original value minutes. YY represents the calculated years.
	 * ZZ represents the calculated days.
	 */
	public String printYearsAndDays(long minutes) {
		// TODO Write an implementation for this method declaration
		if(minutes < 0) {
			return "Invalid Value";
		}
		long hours = minutes / 60;
		long days = hours / 24; 
		long years = days / 365;
		long daysFinal = days % 365;
		
		return minutes + " min = " + years + " y and " + daysFinal + " d";
	}

	/**
	 * 7. Number In Word
	 * 
	 * Write a method called printNumberInWord. The method has one parameter number
	 * which is the whole number. The method needs to print "ZERO", "ONE", "TWO",
	 * ... "NINE", "OTHER" if the int parameter number is 0, 1, 2, .... 9 or other
	 * for any other number including negative numbers. You can use if-else
	 * statement or switch statement whatever is easier for you.
	 */
	public String printNumberInWord(int number) {
		// TODO Write an implementation for this method declaration
		if(number == 0) return "ZERO";
		if(number == 1) return "ONE";
		if(number == 2) return "TWO";
		if(number == 3) return "THREE";
		if(number == 4) return "FOUR";
		if(number == 5) return "FIVE";
		if(number == 6) return "SIX";
		if(number == 7) return "SEVEN";
		if(number == 8) return "EIGHT";
		if(number == 9) return "NINE";
			return "OTHER";
	}

	/**
	 * 8. Greatest Common Divisor
	 * 
	 * Write a method named getGreatestCommonDivisor with two parameters of type int
	 * named first and second.
	 * 
	 * If one of the parameters is < 10, the method should return -1 to indicate an
	 * invalid value. The method should return the greatest common divisor of the
	 * two numbers (int).
	 * 
	 * The greatest common divisor is the largest positive integer that can fully
	 * divide each of the integers (i.e. without leaving a remainder).
	 * 
	 * For example 12 and 30: 12 can be divided by 1, 2, 3, 4, 6, 12 30 can be
	 * divided by 1, 2, 3, 5, 6, 10, 15, 30
	 * 
	 * The greatest common divisor is 6 since both 12 and 30 can be divided by 6,
	 * and there is no resulting remainder.
	 */
	public int getGreatestCommonDivisor(int first, int second) {
		// TODO Write an implementation for this method declaration
		if(first < 10 || second < 10) {
			return -1;
		}
		int closestSquareToFirst = (int) (Math.ceil(Math.sqrt((double)first)));
		int closestSquareToSecond = (int) (Math.ceil(Math.sqrt((double)second)));
		int lowerSquare = Math.max(closestSquareToFirst, closestSquareToSecond);
		
		int i = 1;
		int gcd = 1;
		
		while(i <= lowerSquare) {
			if(first % i == 0 && second % i == 0) {
				gcd = i;
			}
			
			i++;
		}
		
		
		return gcd;
	}

	/**
	 * 9. First and Last Digit Sum
	 * 
	 * Write a method named sumFirstAndLastDigit with one parameter of type int
	 * called number.
	 * 
	 * The method needs to find the first and the last digit of the parameter number
	 * passed to the method, using a loop and return the sum of the first and the
	 * last digit of that number.
	 * 
	 * If the number is negative then the method needs to return -1 to indicate an
	 * invalid value.
	 */
	public int sumFirstAndLastDigit(int num) {
		// TODO Write an implementation for this method declaration
		String numString = num + "";
		if(num < 0 ) {
			return -1;
		}
		String firstDigit = numString.charAt(0) + "";
		String secondDigit = numString.charAt(numString.length()-1) + "";
		return Integer.parseInt(firstDigit) + Integer.parseInt(secondDigit);
	}

	/**
	 * 10. Reverse String
	 * 
	 * Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 */
	public String reverse(String string) {
		// TODO Write an implementation for this method declaration
		String reversed = "";
		int j = string.length()-1;
		for(int i = 0; i < string.length(); i++) {
			reversed += string.charAt(j);
			j--;
		}
		return reversed;
	}

	/**
	 * 11. Acronyms
	 * 
	 * Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 */
	public String acronym(String phrase) {
		// TODO Write an implementation for this method declaration
		String[] splitStr = phrase.split("[ -\\.?!]");
		String acronym = "";
		for(String s : splitStr) {
			if(s.length() > 0) {
				acronym += s.charAt(0);
			}
		}
		
		return acronym.toUpperCase();
	}

	/**
	 * 12. Triangles
	 * 
	 * Determine if a triangle is equilateral, isosceles, or scalene. An equilateral
	 * triangle has all three sides the same length. An isosceles triangle has at
	 * least two sides the same length.
	 * 
	 * (It is sometimes specified as having exactly two sides the same length, but
	 * for the purposes of this exercise we'll say at least two.) A scalene triangle
	 * has all sides of different lengths.
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			// TODO Write an implementation for this method declaration
			return Double.compare(sideThree, sideOne)==0 
					&& Double.compare(sideTwo, sideOne)==0
					&& Double.compare(sideThree, sideTwo)==0;
		}

		public boolean isIsosceles() {
			// TODO Write an implementation for this method declaration
			int comparisons = 0;
			if(Double.compare(sideThree, sideOne)==0 ) {
				comparisons++;
			}
			if(Double.compare(sideTwo, sideOne)==0 ) {
				comparisons++;
			}
			if(Double.compare(sideThree, sideTwo)==0 ) {
				comparisons++;
			}
			
			return comparisons >= 1;
		}

		public boolean isScalene() {
			// TODO Write an implementation for this method declaration
			return !isIsosceles();
		}

	}

	/**
	 * 13. Scrabble Score
	 * 
	 * Given a word, compute the scrabble score for that word.
	 * OxyphenButazone
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; 
	 * D, G = 2; 
	 * B, C, M, P = 3; 
	 * F, H, V, W, Y = 4; 
	 * K = 5; 
	 * J, X = 8; 
	 * Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 */
	public int getScrabbleScore(String string) {
		// TODO Write an implementation for this method declaration
		string = string.toUpperCase();
		int score = 0;
		for(int i = 0; i < string.length(); i++) {
			score += mapLettersToInt(string.charAt(i));
		}
		return score;
		
	}
	
	public int mapLettersToInt(char c) {
		if(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == 'L' 
				|| c == 'N' || c == 'R' || c == 'S' || c == 'T' ) {
			return 1;
		}
		if(c == 'G' || c == 'D') {
			return 2;
		}
		if(c == 'C' || c == 'M' ||c == 'P' || c == 'B') {
			return 3;
		}
		if(c == 'F' || c == 'H' || c == 'V' || c == 'W' || c == 'Y' ) {
			return 4;
		}
		if(c == 'K') {
			return 5;
		}
		if(c == 'J' || c == 'X') {
			return 8;
		}
		if(c == 'Q' || c == 'Z') {
			return 10;
		}
		return 0;
	}

	/**
	 * 14. Clean the Phone Number
	 * 
	 * Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		string = string.replaceAll("[//( -//.//)]", "");
		String onlyNums = "";
		for(int i = 0 ; i < string.length(); i++) {
			if(Character.isDigit(string.charAt(i))) {
				onlyNums += string.charAt(i);
			}
			if(Character.isAlphabetic(string.charAt(i))) {
				throw new IllegalArgumentException();
			}
		}
		if(onlyNums.length() == 11 && onlyNums.charAt(0) == 1) {
			return onlyNums.substring(1);
		}
		if(onlyNums.length() >= 11) {
			throw new IllegalArgumentException();
		}
		
		return onlyNums;
	}

	/**
	 * 15. Recurring Word Counter
	 * 
	 * Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 */
	public Map<String, Integer> wordCount(String string) {
		// TODO Write an implementation for this method declaration
		String[] arr = string.split("[ ,\\n]");
		Map<String, Integer> hashMap = new HashMap<String, Integer>();
	
		for(String s : arr) {
			if(s.equals("")) {
				continue;
			}
			if(hashMap.get(s) != null) {
				hashMap.put(s, hashMap.get(s)+1);
			} else {	// we are initially putting val into db
				hashMap.put(s, 1);
			}
		}
		return hashMap;
	}

	/**
	 * 16. Armstrong Number
	 * 
	 * An Armstrong number is a number that is the sum of its own digits each raised
	 * to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 */
	public boolean isArmstrongNumber(int input) {
		String inputString = input + "";
		int digits = inputString.length();
		int total = 0;
		for(int i = 0; i < digits; i++) {
			total += Math.pow(Integer.parseInt("" + inputString.charAt(i)), digits);
		}
		return total == input;
	}

	/**
	 * 17. Prime Factors
	 * 
	 * Compute the prime factors of a given natural number. A prime number is only
	 * evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		// TODO Write an implementation for this method declaration
		HashSet<Long> factorSet = new HashSet<>();
		for(long i = 2; i <= l; i++) {
			if(l % i == 0) {
				factorSet.add(i);
			}
		}
		
		
		factorSet.removeIf(e -> !isPrime(e));
		
		
		List<Long> myInts = new ArrayList<>();
		boolean touched = true;
		while(l > 1 && touched) {
			touched = false;
			for(long f : factorSet) {
				if(l % f == 0) {
					myInts.add(f);
					l = l / f;
					touched = true;
				}
			}
			if(!touched) {
				Collections.sort(myInts);
				return myInts;
			}
		}
		Collections.sort(myInts);
		return myInts;
	}
	
	public boolean isPrime(long factor) {
		for(int i = 2; i < factor; i++) {
			if(factor % i == 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 18. Calculate Nth Prime
	 * 
	 * Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 */
	public int calculateNthPrime(int k) {
		// TODO Write an implementation for this method declaration
		if(k <= 0) {
			throw new IllegalArgumentException();
		}
		int j = 2;
		while(k >= 1) {
			if(isPrime(j)) {
				k--;
			} 
			j++;
			
		}
		return j-1;
	}

	/**
	 * 19. Pangram
	 * 
	 * Determine if a sentence is a pangram. A pangram (Greek: ?????? ????????????, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 */
	public boolean isPangram(String string) {
		// TODO Write an implementation for this method declaration
		string = string.toUpperCase();
		string = String.join("", string.split(" "));
		HashSet<Character> actual = new HashSet<>();
		for(int i = 0; i < string.length(); i++) {
			actual.add(string.charAt(i));
		}
		return actual.size() == 26;
	}
	
	public void populateAlphabet(HashSet<Character> alphabet) {
		for(int i = 65; i <= 90; i++) {
			alphabet.add((char) i);
		}
		
	}

	/**
	 * 20. Sum of Multiples 
	 * 
	 * Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 */
	public int getSumOfMultiples(int i, int[] set) {
		HashSet<Integer> mySet = new HashSet<>();
		int z = 1;		// iterator counter
		int multiple = 0;
		for(int j = 0; j < set.length; j++) {
			multiple = set[j];
			z = 1;
			while(z*multiple < i) {
				mySet.add(z *  multiple);
				z++;
			}
		}
		int total = 0;
		for(int y : mySet) {
			total += y;
		}
		return total;
	}
	
	/**
	 * 21. Three Magic Numbers
	 * 
	 * You work at a casino in Las Vegas.  Your job is to program a slot machine to
	 * return 3 random numbers using the java.util.Random class.
	 * 
	 * Write a method to return an int array of 3 random numbers between 1 - 100.
	 * Generate the 3 random numbers (1 - 100 inclusive) using the java.util.Random class.
	 */
	
	public int[] threeLuckyNumbers() {
		
		int i = 0;
		int[] randomArr = new int[3];
		while(i < 3) {
			Random rand = new Random();
			randomArr[i] = rand.nextInt(99) + 1;
			i++;
		}
		return randomArr;
	}
	
	/*
	 * 22. Easy Guessing Game
	 * 
	 * Create a program to generate a number between the given range:
	 * int x = minimum
	 * iny y = maximum (inclusive)
	 * 
	 * You must use the Math.random class to generate a random number between x and y.
	 */
	
	public int guessingGame(int x, int y) {
		int range = Math.abs(x - y);
		int lower = Math.min(x,  y);
		
		return (int)(Math.floor((Math.random()*range)+1+lower));
	}
}
