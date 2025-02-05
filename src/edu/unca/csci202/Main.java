package edu.unca.csci202;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Random;

/**
 * Provides class to test the ArrayLargeInteger class, later referred to as
 * "ALI" against the BigInteger class, later referred to as "BI", and then
 * utilizes an object of Main to administer these tests. This class provides
 * methods to test the run time of each of the methods that ArrayLargeInteger
 * and BigInteger share.
 * 
 * @author Kati Provence
 */
public class Main {

	private File aliData;
	private File biData;
	private FileWriter myAli;
	private FileWriter myBi;
	private Random ran;

	/**
	 * Creates a Main Object, and then calls its run method, which creates random
	 * numbers used to build identical ArrayLargeInteger and BigInteger objects.
	 * Then tests each of the methods the two share to ensure that the results are
	 * equal and that ArrayLargeInteger is performing as expected.
	 * 
	 * Then initializes a number of ArrayLargeInteger and BigInteger objects of
	 * increasingly larger sizes with identical parameters to be used by the Main
	 * Object. It runs the methods that ArrayLargeInteger and BigInteger share for
	 * increasingly large numbers and report the average time. The methods tested
	 * are the constructor, add, subtract, multiply, negate, abs, max, min, signum,
	 * equals, compareTo, toString.
	 * 
	 * @param args
	 * @throws IOException because of the use of a FileWriter
	 */
	public static void main(String[] args) throws IOException {
		Main myTester = new Main();

		myTester.run(true);
		myTester.run(false);

		// Testing ArrayLargeInteger with varying num sizes
		/*
		 * 1 digit
		 * 
		 * 1000 digits
		 * 
		 * 2000 digits
		 * 
		 * 3000 digits
		 * 
		 * 4000 digits
		 * 
		 * 5000 digits
		 * 
		 * 6000 digits
		 */

		System.out.println("\nCreating LargeIntegers");
		myTester.writeALI("Constructor\n");
		myTester.writeBI("Constructor\n");
		String builder;
		long start, end;
		// 1 digit
		builder = myTester.givenLengthValue(1);
		start = System.nanoTime();
		ArrayLargeInteger t1 = new ArrayLargeInteger(builder);
		end = System.nanoTime();
		System.out.println("ArrayLargeInteger with 1 digit took " + (end - start));
		myTester.writeALI((end - start) + "\n");

		start = System.nanoTime();
		BigInteger b1 = new BigInteger(builder);
		end = System.nanoTime();
		System.out.println("BigInteger with 1 digits took " + (end - start));
		myTester.writeBI((end - start) + "\n");

		// 1000 digits
		builder = myTester.givenLengthValue(1000);
		start = System.nanoTime();
		ArrayLargeInteger t2 = new ArrayLargeInteger(builder);
		end = System.nanoTime();
		System.out.println("ArrayLargeInteger with 1000 digits took " + (end - start));
		myTester.writeALI((end - start) + "\n");

		start = System.nanoTime();
		BigInteger b2 = new BigInteger(builder);
		end = System.nanoTime();
		System.out.println("BigInteger with 1000 digits took " + (end - start));
		myTester.writeBI((end - start) + "\n");

		// 2000 digits
		builder = myTester.givenLengthValue(2000);
		start = System.nanoTime();
		ArrayLargeInteger t3 = new ArrayLargeInteger(builder);
		end = System.nanoTime();
		System.out.println("ArrayLargeInteger with 2000 digits took " + (end - start));
		myTester.writeALI((end - start) + "\n");

		start = System.nanoTime();
		BigInteger b3 = new BigInteger(builder);
		end = System.nanoTime();
		System.out.println("BigInteger with 2000 digits took " + (end - start));
		myTester.writeBI((end - start) + "\n");

		// 3000 digits
		builder = myTester.givenLengthValue(3000);
		start = System.nanoTime();
		ArrayLargeInteger t4 = new ArrayLargeInteger(builder);
		end = System.nanoTime();
		System.out.println("ArrayLargeInteger with 3000 digits took " + (end - start));
		myTester.writeALI((end - start) + "\n");

		start = System.nanoTime();
		BigInteger b4 = new BigInteger(builder);
		end = System.nanoTime();
		System.out.println("BigInteger with 3000 digits took " + (end - start));
		myTester.writeBI((end - start) + "\n");

		// 4000 digits
		builder = myTester.givenLengthValue(4000);
		start = System.nanoTime();
		ArrayLargeInteger t5 = new ArrayLargeInteger(builder);
		end = System.nanoTime();
		System.out.println("ArrayLargeInteger with 4000 digits took " + (end - start));
		myTester.writeALI((end - start) + "\n");

		start = System.nanoTime();
		BigInteger b5 = new BigInteger(builder);
		end = System.nanoTime();
		System.out.println("BigInteger with 4000 digits took " + (end - start));
		myTester.writeBI((end - start) + "\n");

		// 5000 digits
		builder = myTester.givenLengthValue(5000);
		ArrayLargeInteger t6 = new ArrayLargeInteger(builder);
		end = System.nanoTime();
		System.out.println("ArrayLargeInteger with 5000 digits took " + (end - start));
		myTester.writeALI((end - start) + "\n");

		BigInteger b6 = new BigInteger(builder);
		end = System.nanoTime();
		System.out.println("BigInteger with 5000 digits took " + (end - start));
		myTester.writeBI((end - start) + "\n");

		// 6000 digits
		builder = myTester.givenLengthValue(6000);
//		System.out.println("DEBUG the length of the builder is: " +builder.length());
		start = System.nanoTime();
		ArrayLargeInteger t7 = new ArrayLargeInteger(builder);
		end = System.nanoTime();
		System.out.println("ArrayLargeInteger with 6000 digits took " + (end - start));
		myTester.writeALI((end - start) + "\n");
//		System.out.println("DEBUG is the number the same as the builder: " +builder.equals(t7.toString()));
//		System.out.println(t7.toString().length());

		start = System.nanoTime();
		BigInteger b7 = new BigInteger(builder);
		end = System.nanoTime();
		System.out.println("BigInteger with 6000 digits took " + (end - start));
		myTester.writeBI((end - start) + "\n");

		//Alternate set of 7 numbers for multiplication, because it struggles at ~1000 digits
		builder = myTester.givenLengthValue(100);
		ArrayLargeInteger aliAlt2 = new ArrayLargeInteger(builder);
		BigInteger biAlt2 = new BigInteger(builder);
		builder = myTester.givenLengthValue(200);
		ArrayLargeInteger aliAlt3 = new ArrayLargeInteger(builder);
		BigInteger biAlt3 = new BigInteger(builder);
		builder = myTester.givenLengthValue(300);
		ArrayLargeInteger aliAlt4 = new ArrayLargeInteger(builder);
		BigInteger biAlt4 = new BigInteger(builder);
		builder = myTester.givenLengthValue(400);
		ArrayLargeInteger aliAlt5 = new ArrayLargeInteger(builder);
		BigInteger biAlt5 = new BigInteger(builder);
		builder = myTester.givenLengthValue(500);
		ArrayLargeInteger aliAlt6 = new ArrayLargeInteger(builder);
		BigInteger biAlt6 = new BigInteger(builder);
		builder = myTester.givenLengthValue(600);
		ArrayLargeInteger aliAlt7 = new ArrayLargeInteger(builder);
		BigInteger biAlt7 = new BigInteger(builder);
		
		// Add
		System.out.println("\nAddition");
		myTester.writeBoth("Addition\n");
		myTester.addTest(t1, t1);
		myTester.addTest(b1, b1);
		myTester.addTest(t2, t2);
		myTester.addTest(b2, b2);
		myTester.addTest(t3, t3);
		myTester.addTest(b3, b3);
		myTester.addTest(t4, t4);
		myTester.addTest(b4, b4);
		myTester.addTest(t5, t5);
		myTester.addTest(b5, b5);
		myTester.addTest(t6, t6);
		myTester.addTest(b6, b6);
		myTester.addTest(t7, t7);
		myTester.addTest(b7, b7);
		// Subtract
		System.out.println("\nSubtract");
		myTester.writeBoth("Subtraction\n");
		myTester.subtractTest(t1, t1);
		myTester.subtractTest(b1, b1);
		myTester.subtractTest(t2, t2);
		myTester.subtractTest(b2, b2);
		myTester.subtractTest(t3, t3);
		myTester.subtractTest(b3, b3);
		myTester.subtractTest(t4, t4);
		myTester.subtractTest(b4, b4);
		myTester.subtractTest(t5, t5);
		myTester.subtractTest(b5, b5);
		myTester.subtractTest(t6, t6);
		myTester.subtractTest(b6, b6);
		myTester.subtractTest(t7, t7);
		myTester.subtractTest(b7, b7);
		// Multiply - Uses alternate numbers because the others are too big
		System.out.println("\nMultiply");
		myTester.writeBoth("Multiplication\n");
		myTester.multiplyTest(t1, t1);
		myTester.multiplyTest(b1, b1);
		myTester.multiplyTest(aliAlt2, aliAlt2);
		myTester.multiplyTest(biAlt2, biAlt2);
		myTester.multiplyTest(aliAlt3, aliAlt3);
		myTester.multiplyTest(biAlt3, biAlt3);
		myTester.multiplyTest(aliAlt4, aliAlt4);
		myTester.multiplyTest(biAlt4, biAlt4);
		myTester.multiplyTest(aliAlt5, aliAlt5);
		myTester.multiplyTest(biAlt5, biAlt5);
		myTester.multiplyTest(aliAlt6, aliAlt6);
		myTester.multiplyTest(biAlt6, biAlt6);
		myTester.multiplyTest(aliAlt7, aliAlt7);
		myTester.multiplyTest(biAlt7, biAlt7);
		// Negate
		System.out.println("\nNegate");
		myTester.writeBoth("Negate\n");
		myTester.negateTest(t1);
		myTester.negateTest(b1);
		myTester.negateTest(t2);
		myTester.negateTest(b2);
		myTester.negateTest(t3);
		myTester.negateTest(b3);
		myTester.negateTest(t4);
		myTester.negateTest(b4);
		myTester.negateTest(t5);
		myTester.negateTest(b5);
		myTester.negateTest(t6);
		myTester.negateTest(b6);
		myTester.negateTest(t7);
		myTester.negateTest(b7);
		// Absolute Value
		System.out.println("\nAbsolute Value");
		myTester.writeBoth("Absolute Value\n");
		myTester.absTest(t1);
		myTester.absTest(b1);
		myTester.absTest(t2);
		myTester.absTest(b2);
		myTester.absTest(t3);
		myTester.absTest(b3);
		myTester.absTest(t4);
		myTester.absTest(b4);
		myTester.absTest(t5);
		myTester.absTest(b5);
		myTester.absTest(t6);
		myTester.absTest(b6);
		myTester.absTest(t7);
		myTester.absTest(b7);
		// Max
		System.out.println("\nMax");
		myTester.writeBoth("Max\n");
		myTester.maxTest(t1, t1);
		myTester.maxTest(b1, b1);
		myTester.maxTest(t2, t2);
		myTester.maxTest(b2, b2);
		myTester.maxTest(t3, t3);
		myTester.maxTest(b3, b3);
		myTester.maxTest(t4, t4);
		myTester.maxTest(b4, b4);
		myTester.maxTest(t5, t5);
		myTester.maxTest(b5, b5);
		myTester.maxTest(t6, t6);
		myTester.maxTest(b6, b6);
		myTester.maxTest(t7, t7);
		myTester.maxTest(b7, b7);
		// Min
		System.out.println("\nMin");
		myTester.writeBoth("Min\n");
		myTester.minTest(t1, t1);
		myTester.minTest(b1, b1);
		myTester.minTest(t2, t2);
		myTester.minTest(b2, b2);
		myTester.minTest(t3, t3);
		myTester.minTest(b3, b3);
		myTester.minTest(t4, t4);
		myTester.minTest(b4, b4);
		myTester.minTest(t5, t5);
		myTester.minTest(b5, b5);
		myTester.minTest(t6, t6);
		myTester.minTest(b6, b6);
		myTester.minTest(t7, t7);
		myTester.minTest(b7, b7);
		// Signum
		System.out.println("\nSignum");
		myTester.writeBoth("Signum\n");
		myTester.signumTest(t1);
		myTester.signumTest(b1);
		myTester.signumTest(t2);
		myTester.signumTest(b2);
		myTester.signumTest(t3);
		myTester.signumTest(b3);
		myTester.signumTest(t4);
		myTester.signumTest(b4);
		myTester.signumTest(t5);
		myTester.signumTest(b5);
		myTester.signumTest(t6);
		myTester.signumTest(b6);
		myTester.signumTest(t7);
		myTester.signumTest(b7);
		// Equals
		System.out.println("\nEquals");
		myTester.writeBoth("Equals\n");
		myTester.equalsTest(t1, t1);
		myTester.equalsTest(b1, b1);
		myTester.equalsTest(t2, t2);
		myTester.equalsTest(b2, b2);
		myTester.equalsTest(t3, t3);
		myTester.equalsTest(b3, b3);
		myTester.equalsTest(t4, t4);
		myTester.equalsTest(b4, b4);
		myTester.equalsTest(t5, t5);
		myTester.equalsTest(b5, b5);
		myTester.equalsTest(t6, t6);
		myTester.equalsTest(b6, b6);
		myTester.equalsTest(t7, t7);
		myTester.equalsTest(b7, b7);
		// toString
		System.out.println("\ntoString");
		myTester.writeBoth("toString\n");
		myTester.toStringTest(t1);
		myTester.toStringTest(b1);
		myTester.toStringTest(t2);
		myTester.toStringTest(b2);
		myTester.toStringTest(t3);
		myTester.toStringTest(b3);
		myTester.toStringTest(t4);
		myTester.toStringTest(b4);
		myTester.toStringTest(t5);
		myTester.toStringTest(b5);
		myTester.toStringTest(t6);
		myTester.toStringTest(b6);
		myTester.toStringTest(t7);
		myTester.toStringTest(b7);
		// CompareTo
		System.out.println("\ncompareTo");
		myTester.writeBoth("compareTo\n");
		myTester.compToTest(t1, t2);
		myTester.compToTest(b1, b2);
		myTester.compToTest(t2, t3);
		myTester.compToTest(b2, b3);
		myTester.compToTest(t3, t4);
		myTester.compToTest(b3, b4);
		myTester.compToTest(t4, t5);
		myTester.compToTest(b4, b5);
		myTester.compToTest(t5, t6);
		myTester.compToTest(b5, b6);
		myTester.compToTest(t6, t7);
		myTester.compToTest(b6, b7);
		myTester.compToTest(t7, t1);
		myTester.compToTest(b7, b1);

		myTester.wrapUp();
	}

	/**
	 * Initializes the Main object, and creates files and filewriters to store the
	 * run time information of BigInteger's methods and ArrayLargeInteger's methods.
	 * 
	 * @throws IOException because of the use of FileWriters
	 */
	public Main() throws IOException {
		ran = new Random();

		try {
			aliData = new File("..\\aliData.txt");
			biData = new File("..\\biData.txt");
		} catch (Exception e) {
		}
		myAli = new FileWriter("..\\aliData.txt");
		myBi = new FileWriter("..\\biData.txt");
	}

	/**
	 * Uses a loop to create identical ArrayLargeInteger and BigInteger objects.
	 * Then tests each of the methods the two share to ensure that the results are
	 * equal and that ArrayLargeInteger is performing as expected. If they are not
	 * equal, run() gives a print statement indicating which method failed the test
	 * and then terminates early.
	 * 
	 * @param wantLarge boolean - passed to makeValue to indicate if the numbers
	 *                  should be large or relatively smaller
	 */
	public void run(boolean wantLarge) {
		String builder1 = "";
		String builder2 = "";
		ArrayLargeInteger m1, m2;
		BigInteger t1, t2;

		// In a loop
		for (int i = 0; i < 40; i++) {
			System.out.println("Iteration " + (i + 1));
			// Make strings
			builder1 = makeValue(wantLarge);
			builder2 = makeValue(wantLarge);
		

			System.out.println(builder1 + " + " + builder2);
			// Make ALI and BI
			m1 = new ArrayLargeInteger(builder1);
			m2 = new ArrayLargeInteger(builder2);

			t1 = new BigInteger(builder1);
			t2 = new BigInteger(builder2);

			// Run the methods, convert results to strings
			String result1 = m1.add(m2).toString();
			String result2 = t1.add(t2).toString();

			// use String.equals to compare them.
			// If it's ever wrong exit the loop early
			if (!result1.equals(result2)) {
				System.out.println("They were NOT equal, something is wrong with ADDITION.");
				System.out.println("ALI returned " + result1 + " BI returned " + result2);
				return;
			}
			// Subtract
			System.out.println(builder1 + " - " + builder2);
			result2 = t1.subtract(t2).toString();
			result1 = m1.subtract(m2).toString();

			if (!result1.equals(result2)) {
				System.out.println("They were NOT equal, something is wrong with SUBTRACTION.");
				System.out.println("ALI returned " + result1 + " BI returned " + result2);
				return;
			}
			// Multiply
			System.out.println(builder1 + " * " + builder2);
			result1 = m1.multiply(m2).toString();
			result2 = t1.multiply(t2).toString();

			if (!result1.equals(result2)) {
				System.out.println("They were NOT equal, something is wrong with MULTIPLICATION.");
				System.out.println("ALI returned " + result1 + " BI returned " + result2);
				return;
			}
			// Negate
			System.out.println(builder1 + " negate");
			result1 = m1.negate().toString();
			result2 = t1.negate().toString();

			if (!result1.equals(result2)) {
				System.out.println("They were NOT equal, something is wrong with NEGATION.");
				System.out.println("ALI returned " + result1 + " BI returned " + result2);
				return;
			}
			// Absolute value
			System.out.println(builder1 + " abs");
			result1 = m1.abs().toString();
			result2 = t1.abs().toString();

			if (!result1.equals(result2)) {
				System.out.println("They were NOT equal, something is wrong with ABSOLUTE VALUE.");
				System.out.println("ALI returned " + result1 + " BI returned " + result2);
				return;
			}
			// Max
			System.out.println(builder1 + " max " + builder2);
			result2 = t1.max(t2).toString();
			result1 = m1.max(m2).toString();

			if (!result1.equals(result2)) {
				System.out.println("They were NOT equal, something is wrong with MAX.");
				System.out.println("ALI returned " + result1 + " BI returned " + result2);
				// Debugging, running it again
				m1.max(m2);

				return;
			}
			// Min
			System.out.println(builder1 + " min " + builder2);
			result2 = t1.min(t2).toString();
			result1 = m1.min(m2).toString();

			if (!result1.equals(result2)) {
				System.out.println("They were NOT equal, something is wrong with MIN.");
				System.out.println("ALI returned " + result1 + " BI returned " + result2);
				return;
			}
			// Signum
			System.out.println(builder1 + " signum");
			result1 = m1.signum() + "";
			result2 = t1.signum() + "";

			if (!result1.equals(result2)) {
				System.out.println("They were NOT equal, something is wrong with SIGNUM.");
				System.out.println("ALI returned " + result1 + " BI returned " + result2);
				return;
			}
			// Equals
			System.out.println(builder1 + " equals " + builder2);
			result2 = t1.equals(t2) + "";
			result1 = m1.equals(m2) + "";

			if (!result1.equals(result2)) {
				System.out.println("They were NOT equal, something is wrong with EQUALS.");
				System.out.println("ALI returned " + result1 + " BI returned " + result2);
				return;
			}

			System.out.println(builder1 + " equals " + builder1);
			result2 = t1.equals(t1) + "";
			result1 = m1.equals(m1) + "";

			if (!result1.equals(result2)) {
				System.out.println("They were NOT equal, something is wrong with EQUALS.");
				System.out.println("ALI returned " + result1 + " BI returned " + result2);
				return;
			}
			// toString
			System.out.println(builder1 + " toString");
			result1 = m1.toString();
			result2 = t1.toString();

			if (!result1.equals(result2)) {
				System.out.println("They were NOT equal, something is wrong with TO STRING.");
				System.out.println("ALI returned " + result1 + " BI returned " + result2);
				return;
			}
			// compareTo
			System.out.println(builder1 + " compareTo " + builder2);
			result2 = t1.compareTo(t2) + "";
			result1 = m1.compareTo(m2) + "";

			if (!result1.equals(result2)) {
				System.out.println("They were NOT equal, something is wrong with COMPARE TO.");
				System.out.println("ALI returned " + result1 + " BI returned " + result2);
				System.out.println("The numbers were " + builder1 + " and " + builder2);
				return;
			}
		}
		System.out.println("Every set of numbers tried ran correctly!");
	}

	/**
	 * Returns a string representing a randomly generated number.
	 * 
	 * @param wantLarge boolean - indicates if the generated number should be large
	 * @return String - a randomly generated number as a string
	 */
	private String makeValue(boolean wantLarge) {
		int maxSize = Integer.MAX_VALUE;
		String builder = "";

		// If it's large, generate an int as large as we can and
		// Concatenate it to the builder multiple times to make
		// A term that is "large enough"
		if (wantLarge) {
			for (int i = 0; i < 15; i++) {
				Integer ranNum = ran.nextInt(100, maxSize);
				builder += ranNum;
			}
		}
		// If it's not supposed to be that large, just
		// Make a relatively small number
		else {
			int ranNum = ran.nextInt(900);
			builder = ranNum + "";
		}

		// Chance to be negative
		if (ran.nextDouble() >= .5) {
			builder = "-" + builder;
		}

		return builder;
	}

	/**
	 * Returns a string representing a randomly generated number with the specified 
	 * number of digits.
	 * 
	 * @param len int - the specified number of digits
	 * @return String - a randomly generated number as a string
	 */
	public String givenLengthValue(int len) {
		String builder = "";
		for (int i = 0; i < len; i++) {
			int num = ran.nextInt(10); // Generate a single digit number
			builder += num;
		}

		// Chance to be negative
		if (ran.nextDouble() >= .5) {
			builder = "-" + builder;
		}
		return builder;
	}

	// *****************************************************
	// Methods for just ArrayLargeInteger implementation
	// *****************************************************
	/**
	 * Gets an average runtime of the ArrayLargeInteger implementation of .add(), by
	 * running the method three times and finding the average time of the three.
	 * 
	 * @param mine1 ArrayLargeInteger - the first term used in the method call
	 * @param mine2 ArrayLargeInteger - the second term used in the method call
	 */
	public void addTest(ArrayLargeInteger mine1, ArrayLargeInteger mine2) {
		long start, end, result = 0;
		// Test with the two given numbers 3 times, saving them to the respective lists
		for (int i = 1; i < 4; i++) {
			start = System.nanoTime();
			mine1.add(mine2);
			end = System.nanoTime();
			result += (end - start);
		}
		double avg = result / 3;
		System.out.println("ArrayLargeInteger took an average of " + avg);

		// Save to file
		try {
			myAli.write(avg + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Gets an average runtime of the ArrayLargeInteger implementation of
	 * .subtract(), by running the method three times and finding the average time
	 * of the three.
	 * 
	 * @param mine1 ArrayLargeInteger - the first term used in the method call
	 * @param mine2 ArrayLargeInteger - the second term used in the method call
	 */
	public void subtractTest(ArrayLargeInteger mine1, ArrayLargeInteger mine2) {
		long start, end, result = 0;
		// Test with the two given numbers 3 times, saving them to the respective lists
		for (int i = 1; i < 4; i++) {
			start = System.nanoTime();
			mine1.subtract(mine2);
			end = System.nanoTime();
			result += (end - start);

		}
		double avg = result / 3;
		System.out.println("ArrayLargeInteger took an average of " + avg);

		// Save to file
		try {
			myAli.write(avg + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets an average runtime of the ArrayLargeInteger implementation of
	 * .multiply(), by running the method three times and finding the average time
	 * of the three.
	 * 
	 * @param mine1 ArrayLargeInteger - the first term used in the method call
	 * @param mine2 ArrayLargeInteger - the second term used in the method call
	 */
	public void multiplyTest(ArrayLargeInteger mine1, ArrayLargeInteger mine2) {
		long start, end, result = 0;
		// Test with the two given numbers 3 times, saving them to the respective lists
		for (int i = 1; i < 4; i++) {
			start = System.nanoTime();
			mine1.multiply(mine2);
			end = System.nanoTime();
			result += (end - start);
		}
		double avg = result / 3;
		System.out.println("ArrayLargeInteger took an average of " + avg);

		// Save to file
		try {
			myAli.write(avg + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets an average runtime of the ArrayLargeInteger implementation of .negate(),
	 * by running the method three times and finding the average time of the three.
	 * 
	 * @param mine ArrayLargeInteger - the term used in the method call
	 */
	public void negateTest(ArrayLargeInteger mine) {
		long start, end, result = 0;
		// Test with the given number 3 times, saving them to the respective lists
		for (int i = 1; i < 4; i++) {
			start = System.nanoTime();
			mine.negate();
			end = System.nanoTime();
			result += (end - start);
		}
		double avg = result / 3;
		System.out.println("ArrayLargeInteger took an average of " + avg);

		// Save to file
		try {
			myAli.write(avg + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets an average runtime of the ArrayLargeInteger implementation of .abs(), by
	 * running the method three times and finding the average time of the three.
	 * 
	 * @param mine ArrayLargeInteger - the term used in the method call
	 */
	public void absTest(ArrayLargeInteger mine) {
		long start, end, result = 0;
		// Test with the given number 3 times, saving them to the respective lists
		for (int i = 1; i < 4; i++) {
			start = System.nanoTime();
			mine.abs();
			end = System.nanoTime();
			result += (end - start);
		}
		double avg = result / 3;
		System.out.println("ArrayLargeInteger took an average of " + avg);

		// Save to file
		try {
			myAli.write(avg + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets an average runtime of the ArrayLargeInteger implementation of .max(), by
	 * running the method three times and finding the average time of the three.
	 * 
	 * @param mine1 ArrayLargeInteger - the first term used in the method call
	 * @param mine2 ArrayLargeInteger - the second term used in the method call
	 */
	public void maxTest(ArrayLargeInteger mine1, ArrayLargeInteger mine2) {
		long start, end, result = 0;
		// Test with the two given numbers 3 times, saving them to the respective lists
		for (int i = 1; i < 4; i++) {
			start = System.nanoTime();
			mine1.max(mine2);
			end = System.nanoTime();
			result += (end - start);
		}
		double avg = result / 3;
		System.out.println("ArrayLargeInteger took an average of " + avg);

		// Save to file
		try {
			myAli.write(avg + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets an average runtime of the ArrayLargeInteger implementation of .min(), by
	 * running the method three times and finding the average time of the three.
	 * 
	 * @param mine1 ArrayLargeInteger - the first term used in the method call
	 * @param mine2 ArrayLargeInteger - the second term used in the method call
	 */
	public void minTest(ArrayLargeInteger mine1, ArrayLargeInteger mine2) {
		long start, end, result = 0;
		// Test with the two given numbers 3 times, saving them to the respective lists
		for (int i = 1; i < 4; i++) {
			start = System.nanoTime();
			mine1.min(mine2);
			end = System.nanoTime();
			result += (end - start);
		}
		double avg = result / 3;
		System.out.println("ArrayLargeInteger took an average of " + avg);

		// Save to file
		try {
			myAli.write(avg + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets an average runtime of the ArrayLargeInteger implementation of .signum(),
	 * by running the method three times and finding the average time of the three.
	 * 
	 * @param mine ArrayLargeInteger - the term used in the method call
	 */
	public void signumTest(ArrayLargeInteger mine) {
		long start, end, result = 0;
		// Test with the given number 3 times, saving them to the respective lists
		for (int i = 1; i < 4; i++) {
			start = System.nanoTime();
			mine.signum();
			end = System.nanoTime();
			result += (end - start);
		}
		double avg = result / 3;
		System.out.println("ArrayLargeInteger took an average of " + avg);

		// Save to file
		try {
			myAli.write(avg + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets an average runtime of the ArrayLargeInteger implementation of .equals(),
	 * by running the method three times and finding the average time of the three.
	 * 
	 * @param mine1 ArrayLargeInteger - the first term used in the method call
	 * @param mine2 ArrayLargeInteger - the second term used in the method call
	 */
	public void equalsTest(ArrayLargeInteger mine1, ArrayLargeInteger mine2) {
		long start, end, result = 0;
		// Test with the two given numbers 3 times, saving them to the respective lists
		for (int i = 1; i < 4; i++) {
			start = System.nanoTime();
			mine1.equals(mine2);
			end = System.nanoTime();
			result += (end - start);
		}
		double avg = result / 3;
		System.out.println("ArrayLargeInteger took an average of " + avg);

		// Save to file
		try {
			myAli.write(avg + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets an average runtime of the ArrayLargeInteger implementation of .equals(),
	 * by running the method three times and finding the average time of the three.
	 * 
	 * @param mine ArrayLargeInteger - the term used in the method call
	 */
	public void toStringTest(ArrayLargeInteger mine) {
		long start, end, result = 0;
		// Test with the given number 3 times, saving them to the respective lists
		for (int i = 1; i < 4; i++) {
			start = System.nanoTime();
			mine.toString();
			end = System.nanoTime();
			result += (end - start);
		}
		double avg = result / 3;
		System.out.println("ArrayLargeInteger took an average of " + avg);

		// Save to file
		try {
			myAli.write(avg + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets an average runtime of the ArrayLargeInteger implementation of
	 * .compareTo(), by running the method three times and finding the average time
	 * of the three.
	 * 
	 * @param mine1 ArrayLargeInteger - the first term used in the method call
	 * @param mine2 ArrayLargeInteger - the second term used in the method call
	 */
	public void compToTest(ArrayLargeInteger mine1, ArrayLargeInteger mine2) {
		long start, end, result = 0;
		// Test with the two given numbers 3 times, saving them to the respective lists
		for (int i = 1; i < 4; i++) {
			start = System.nanoTime();
			mine1.compareTo(mine2);
			end = System.nanoTime();
			result += (end - start);
		}
		double avg = result / 3;
		System.out.println("ArrayLargeInteger took an average of " + avg);

		// Save to file
		try {
			myAli.write(avg + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// *****************************************************
	// Methods for BigInteger implementation
	// *****************************************************
	/**
	 * Gets an average runtime of the BigInteger implementation of .add(), by
	 * running the method three times and finding the average time of the three.
	 * 
	 * @param theirs1 BigInteger - the first term used in the method call
	 * @param theirs2 BigInteger - the second term used in the method call
	 */
	public void addTest(BigInteger theirs1, BigInteger theirs2) {
		long start, end, result = 0;
		// Test with the two given numbers 3 times, saving them to the respective lists
		for (int i = 1; i < 4; i++) {
			start = System.nanoTime();
			theirs1.add(theirs2);
			end = System.nanoTime();
			result += (end - start);
		}
		double avg = result / 3;
		System.out.println("BigInteger took an average of " + avg);

		// Save to file
		try {
			myBi.write(avg + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets an average runtime of the BigInteger's implementation of .subtract(), by
	 * running the method three times and finding the average time of the three.
	 * 
	 * @param theirs1 BigInteger - the first term used in the method call
	 * @param theirs2 BigInteger - the second term used in the method call
	 */
	public void subtractTest(BigInteger theirs1, BigInteger theirs2) {
		long start, end, result = 0;
		// Test with the two given numbers 3 times, saving them to the respective lists
		for (int i = 1; i < 4; i++) {
			start = System.nanoTime();
			theirs1.subtract(theirs2);
			end = System.nanoTime();
			result += (end - start);

		}
		double avg = result / 3;
		System.out.println("BigInteger took an average of " + avg);

		// Save to file
		try {
			myBi.write(avg + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets an average runtime of the BigInteger implementation of .multiply(), by
	 * running the method three times and finding the average time of the three.
	 * 
	 * @param theirs1 BigInteger - the first term used in the method call
	 * @param theirs2 BigInteger - the second term used in the method call
	 */
	public void multiplyTest(BigInteger theirs1, BigInteger theirs2) {
		long start, end, result = 0;
		// Test with the two given numbers 3 times, saving them to the respective lists
		for (int i = 1; i < 4; i++) {
			start = System.nanoTime();
			theirs1.multiply(theirs2);
			end = System.nanoTime();
			result += (end - start);
		}
		double avg = result / 3;
		System.out.println("BigInteger took an average of " + avg);

		// Save to file
		try {
			myBi.write(avg + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets an average runtime of the BigInteger implementation of .negate(), by
	 * running the method three times and finding the average time of the three.
	 * 
	 * @param theirs BigInteger - the term used in the method call
	 */
	public void negateTest(BigInteger theirs) {
		long start, end, result = 0;
		// Test with the given number 3 times, saving them to the respective lists
		for (int i = 1; i < 4; i++) {
			start = System.nanoTime();
			theirs.negate();
			end = System.nanoTime();
			result += (end - start);
		}
		double avg = result / 3;
		System.out.println("BigInteger took an average of " + avg);

		// Save to file
		try {
			myBi.write(avg + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets an average runtime of the BigInteger implementation of .abs(), by
	 * running the method three times and finding the average time of the three.
	 * 
	 * @param theirs BigInteger - the term used in the method call
	 */
	public void absTest(BigInteger theirs) {
		long start, end, result = 0;
		// Test with the given number 3 times, saving them to the respective lists
		for (int i = 1; i < 4; i++) {
			start = System.nanoTime();
			theirs.abs();
			end = System.nanoTime();
			result += (end - start);
		}
		double avg = result / 3;
		System.out.println("BigInteger took an average of " + avg);

		// Save to file
		try {
			myBi.write(avg + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets an average runtime of the BigInteger implementation of .max(), by
	 * running the method three times and finding the average time of the three.
	 * 
	 * @param theirs1 BigInteger - the first term used in the method call
	 * @param theirs2 BigInteger - the second term used in the method call
	 */
	public void maxTest(BigInteger theirs1, BigInteger theirs2) {
		long start, end, result = 0;
		// Test with the two given numbers 3 times, saving them to the respective lists
		for (int i = 1; i < 4; i++) {
			start = System.nanoTime();
			theirs1.max(theirs2);
			end = System.nanoTime();
			result += (end - start);
		}
		double avg = result / 3;
		System.out.println("BigInteger took an average of " + avg);

		// Save to file
		try {
			myBi.write(avg + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets an average runtime of the BigInteger implementation of .min(), by
	 * running the method three times and finding the average time of the three.
	 * 
	 * @param theirs1 BigInteger - the first term used in the method call
	 * @param theirs2 BigInteger - the second term used in the method call
	 */
	public void minTest(BigInteger theirs1, BigInteger theirs2) {
		long start, end, result = 0;
		// Test with the two given numbers 3 times, saving them to the respective lists
		for (int i = 1; i < 4; i++) {
			start = System.nanoTime();
			theirs1.min(theirs2);
			end = System.nanoTime();
			result += (end - start);
		}
		double avg = result / 3;
		System.out.println("BigInteger took an average of " + avg);

		// Save to file
		try {
			myBi.write(avg + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets an average runtime of the BigInteger implementation of .signum(), by
	 * running the method three times and finding the average time of the three.
	 * 
	 * @param theirs BigInteger - the term used in the method call
	 */
	public void signumTest(BigInteger theirs) {
		long start, end, result = 0;
		// Test with the given number 3 times, saving them to the respective lists
		for (int i = 1; i < 4; i++) {
			start = System.nanoTime();
			theirs.signum();
			end = System.nanoTime();
			result += (end - start);
		}
		double avg = result / 3;
		System.out.println("BigInteger took an average of " + avg);

		// Save to file
		try {
			myBi.write(avg + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets an average runtime of the BigInteger implementation of .equals(), by
	 * running the method three times and finding the average time of the three.
	 * 
	 * @param theirs1 BigInteger - the first term used in the method call
	 * @param theirs2 BigInteger - the second term used in the method call
	 */
	public void equalsTest(BigInteger theirs1, BigInteger theirs2) {
		long start, end, result = 0;
		// Test with the two given numbers 3 times, saving them to the respective lists
		for (int i = 1; i < 4; i++) {
			start = System.nanoTime();
			theirs1.equals(theirs2);
			end = System.nanoTime();
			result += (end - start);
		}
		double avg = result / 3;
		System.out.println("BigInteger took an average of " + avg);

		// Save to file
		try {
			myBi.write(avg + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets an average runtime of the BigInteger implementation of .equals(), by
	 * running the method three times and finding the average time of the three.
	 * 
	 * @param theirs BigInteger - the term used in the method call
	 */
	public void toStringTest(BigInteger theirs) {
		long start, end, result = 0;
		// Test with the given number 3 times, saving them to the respective lists
		for (int i = 1; i < 4; i++) {
			start = System.nanoTime();
			theirs.toString();
			end = System.nanoTime();
			result += (end - start);
		}
		double avg = result / 3;
		System.out.println("BigInteger took an average of " + avg);

		// Save to file
		try {
			myBi.write(avg + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets an average runtime of the BigInteger implementation of .compareTo(), by
	 * running the method three times and finding the average time of the three.
	 * 
	 * @param theirs1 BigInteger - the first term used in the method call
	 * @param theirs2 BigInteger - the second term used in the method call
	 */
	public void compToTest(BigInteger theirs1, BigInteger theirs2) {
		long start, end, result = 0;
		// Test with the two given numbers 3 times, saving them to the respective lists
		for (int i = 1; i < 4; i++) {
			start = System.nanoTime();
			theirs2.compareTo(theirs2);
			end = System.nanoTime();
			result += (end - start);
		}
		double avg = result / 3;
		System.out.println("BigInteger took an average of " + avg);

		// Save to file
		try {
			myBi.write(avg + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Takes in a string and writes it to both files.
	 * 
	 * @param string String - phrase to write to both files
	 */
	private void writeBoth(String string) {
		try {
			myAli.write(string);
			myBi.write(string);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Writes the given string to the file holding the ArrayLargeInteger's
	 * information.
	 * 
	 * @param string String - phrase to write to aliData.txt
	 */
	private void writeALI(String string) {
		try {
			myAli.write(string);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Writes the given string to the file holding the BigInteger's information.
	 * 
	 * @param string String - phrase to write to biData.txt
	 */
	private void writeBI(String string) {
		try {
			myBi.write(string);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Closes both of the files that the Main Object writes to.
	 */
	private void wrapUp() {
		try {
			myAli.close();
			myBi.close();
		} catch (IOException e) {
			System.out.println("Unable to close files.");
			e.printStackTrace();
		}

	}

}
