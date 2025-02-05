package edu.unca.csci202;

import java.util.ArrayList;

/**
 * Utilizes an internal arrayList data structure to store a number of any size,
 * and provides mathematical methods such as add, subtract, multiply, and
 * equals. Each of the methods which perform an operation on the given
 * ArrayLargeInterger are intended to return a new integer after performing the
 * command, rather than modifying the object used to call it, so the value of an
 * ArrayLargeInteger object should not change.
 * 
 * @author Kati Provence
 */
public class ArrayLargeInteger implements LargeInteger {
	public ArrayList<Integer> number;
	private final int TEN; // "You might find it helpful to create constants ZERO in your class"
	private boolean isNegative;
	private final String STR;

	/**
	 * Creates the ArrayLargeInteger by stepping through each digit in the provided
	 * string and adding it to the list, if the first term is a negative sign, "-",
	 * it does not get added to the list, and rater just toggles a boolean
	 * indicating if the number is positive or negative. This is helpful for when
	 * addition, subtraction, or multiplication must be performed. This constructor
	 * also saves a string representation of the integer to be used in other methods
	 * such as toString.
	 * 
	 * @param s String - the number as represented by a String
	 */
	public ArrayLargeInteger(String s) {
		number = new ArrayList<Integer>();
		this.TEN = 10;
		isNegative = false; // Assume it isn't negative

		// Just in case a number is attempted to be made with leading zeros
		if (s.substring(0, 1).equals("-")) {
			s = s.substring(1); // if it is negative we'll trim the sign for now
			isNegative = true;
		}
		while (s.charAt(0) == '0' && s.length() > 1) {
			s = s.substring(1);
		}

		if (isNegative && !s.equals("0")) { // And then add it back before saving the value to STR
			s = "-" + s; // Only if the value is not just zero
		}

		STR = s; // Now that we've cleaned the number up, we can save it as our final display

		// Converting from string to individual elements of the arrayList
		int i = 0;
		while (i < s.length()) {
			String temp = s.substring(i, i + 1);

			if (temp.equals("-")) {
				i++;
				isNegative = true;
				continue;
			}
			int tempInt = Integer.parseInt(temp);
			number.add(tempInt);

			i++;
		}

		if (s.equals("0")) {
			isNegative = false;
		}

	}

	/**
	 * Rather than iterating through the list to check for equality, a string
	 * comparison works just as well. If two ArrayLargeInteger's have the same
	 * string, that means their constructor was identical, and they too are also
	 * identical, since no operartion should change the value of the object used to
	 * call it.
	 * 
	 * @param e LargeInteger - the number being examined for equality with this
	 *          instance
	 * @return boolean - indicating equality or inequality.
	 */
	public boolean equals(LargeInteger e) {
		// Couldn't I just compare their string versions?
		// Using the String.equals?

		String this1 = this.toString();
		String that1 = ((ArrayLargeInteger) e).toString();

		if (this1.equals(that1))
			return true;
		else
			return false;
	}

	/**
	 * Returns a string representation of the object's number. Since the value of an
	 * instance of ArrayLargeInteger should never change, this string can be
	 * provided by simply returning the original value used in the constructor of
	 * this instance.
	 */
	@Override
	public String toString() {
		return STR;
	}

	/**
	 * Returns the LargeInteger sum of this and the argument.
	 * 
	 * Calculates this by iterating backwards through each of the ArrayLists of
	 * numbers and finding their individual sum and using a builder string to track
	 * those results. Checks first for either parameter being zero, because there is
	 * no need for complex calculations if that is the case.
	 * 
	 * Utilizes the ArrayLargeInteger subtract() method when the add() method is
	 * called on numbers with opposite signs because the result of that is
	 * essentially subtraction.
	 * 
	 * @param e LargeInteger - the number to be added to this element
	 * @return LargeInteger - sum of the two numbers
	 */
	@Override
	public LargeInteger add(LargeInteger e) {
		// Cast the parameter so that I can use methods from this class on it
		ArrayLargeInteger castE = (ArrayLargeInteger) e;
		String builder = ""; // Begin to create a constructor for the result of this addition

		// If either of them equals 0, then the result is the same as the other
		// parameter
		if (this.toString().equals("0")) {
			builder = castE.toString();
			return new ArrayLargeInteger(builder);
		}
		if (castE.toString().equals("0")) {
			builder = this.toString();
			return new ArrayLargeInteger(builder);
		}

		// Get the other list so I can iterate through both
		ArrayList<Integer> other = ((ArrayLargeInteger) e).getList();

		// If they share a sign
		if ((this.isNegative && castE.isNegative()) || (!this.isNegative && !castE.isNegative())) {
			int t1Size = number.size() - 1;
			int t2Size = other.size() - 1;
			int carryOver = 0;
			int a;
			int b;

			// Add from the back of each one
			while (t1Size > -1 || t2Size > -1) {
				a = 0;
				b = 0;
				// While they still have numbers (accounts for the numbers being different
				// sizes)
				if (t1Size >= 0) {
					a = number.get(t1Size);
				}
				if (t2Size >= 0) {
					b = other.get(t2Size);
				}

				// add each single digit, factoring in any "carryOver" from the previous
				// iteration
				int result = a + b + carryOver;

				// Keep the last digit of that as the result in that place
				builder = (result % TEN) + builder;

				// Keep any left over as "carryOver"
				carryOver = result / TEN;

				// when the first one hits negative index, just let that num = 0
				// Until the other number also hits negative index, so that the builder str gets
				// filled
				t1Size--;
				t2Size--;
			}
			// If by the end we still have carryOver, just add it to the front
			if (carryOver != 0)
				builder = carryOver + builder;

			// Account for both negative
			if (this.isNegative && castE.isNegative()) {
				builder = "-" + builder;
			}
		}

		// If they don't share a sign, its essentially subtraction
		else {
			if (this.isNegative) {
				return castE.subtract(this.negate()); // They have to be negated and swapped
														// ex. -7 + 3 = 3 - 7
			} else if (castE.isNegative) {
				return this.subtract(castE.negate());
			}
		}
		return new ArrayLargeInteger(builder);
	}

	/**
	 * Returns the LargeInteger difference of this and the argument.
	 * 
	 * Calculates this by iterating backwards through each of the ArrayLists of
	 * numbers and finding their individual difference and using a builder string to
	 * track those results.
	 * 
	 * Utilizes the ArrayLargeInteger add() method when the subtract() method is
	 * called on numbers with opposite signs, or when both are negative because the
	 * result of that can be simplified into an addition problem.
	 * 
	 * @param e LargeInteger - the number to be subtracted from this element
	 * @return LargeInteger - difference of the two numbers
	 */
	@Override
	public LargeInteger subtract(LargeInteger e) {
		// Cast the parameter so that I can use methods from this class on it
		ArrayLargeInteger castE = (ArrayLargeInteger) e;
		LargeInteger temp = null; // Used so that leading zeroes can be trimmed later

		// If both are positive we can subtract them
		if ((!this.isNegative && !castE.isNegative())) {
			String builder = ""; // Begin to create a constructor for the result of this subtraction

			// For subtraction, we need to be able to designate the larger and smaller
			// terms
			ArrayLargeInteger term1 = (ArrayLargeInteger) this.max(e);
			ArrayLargeInteger term2 = (ArrayLargeInteger) this.min(e);

			ArrayList<Integer> num1 = term1.getList();
			ArrayList<Integer> num2 = term2.getList();

			int t1Size = num1.size() - 1;
			int t2Size = num2.size() - 1;
			int carryOver = 0; // In this case, carryOver represents when we needed to "borrow" from
								// the digit after this one in order to "have enough" for the subtraction
			int a;
			int b;

			// Start at the back of each number, and go until we've iterated through both
			while (t1Size > -1 || t2Size > -1) {
				a = 0;
				b = 0;
				// While they still have numbers (accounts for the numbers being different
				// sizes)
				if (t1Size >= 0) {
					a = num1.get(t1Size);
				}
				if (t2Size >= 0) {
					b = num2.get(t2Size);
				}
				// Do the math, factoring in any "debt" from the previous iteration
				int result = a - b - carryOver;

				// If the result is negative, we would've had to borrow from the next digit over
				if (result < 0 && t1Size > 0) {
					// Carryover = 1, and we save what would've been the result had we have borrowed
					carryOver = 1;
					result = TEN + result;
				}
				// If the result wasn't negative then there is no need to borrow, and carryOver
				// must be rest
				else {
					carryOver = 0;
				}
				builder = result + builder;

				// when the first one hits negative index, just let that num = 0
				// Until the other number also hits negative index
				t1Size--;
				t2Size--;

			}
			// There may be leading zeroes, the easiest way to get rid of them is to make
			// the return value now, which trims them in the constructor
			temp = new ArrayLargeInteger(builder);

			// If the param term was the larger num, then the result would actually be
			// negative
			if (!term1.equals(this))
				temp = ((ArrayLargeInteger) temp).negate();

		}
		// If they're not the same sign, then, the signs need to be simplified, which
		// ends up calling the add method
		if (!this.isNegative() && castE.isNegative()) // x - -y = x + y
			return this.add(castE.abs());

		if (this.isNegative() && !castE.isNegative()) // -x - y = -x + -y
			return this.add(castE.negate());

		if (this.isNegative && castE.isNegative()) { // -x - -y = -x + y
			return this.add(castE.negate());
		}

		return temp;
	}

	/**
	 * Returns the negative of this LargeInteger.
	 * 
	 * Creates a new ArrayLargeInteger that is the opposite sign of this
	 * ArrayLargeInteger. This is done by getting the string of the object this is
	 * called on and then either adding or removing the negative sign and then
	 * creating the new ArrayLargeInteger with the modified string.
	 * 
	 * @return LargeInteger - the negated LargeInteger
	 */
	@Override
	public LargeInteger negate() {

		String builder = STR;
		if (isNegative) {
			builder = builder.substring(1, builder.length());
		} else {
			builder = "-" + builder;
		}
		return new ArrayLargeInteger(builder);
	}

	/**
	 * Returns the absolute value of the LargeInteger
	 * 
	 * Creates a new ArrayLargeInteger that is the absolute value of this
	 * ArrayLargeInteger. This is done making a copy of this object's string and
	 * then removing the negative, if the value was negative, and creating a new
	 * ArrayLarge Integer to Return
	 * 
	 * @return LargeInteger - the absolute value of the LargeInteger
	 */
	@Override
	public LargeInteger abs() {
		String builder = STR;
		if (this.isNegative) {
			builder = builder.substring(1, builder.length());
		} // If it's not negative, we can return the builder as is
		return new ArrayLargeInteger(builder);
	}

	/**
	 * Returns the LargeInteger product of this and the argument.
	 * 
	 * Gets the arrayLists of the numbers, which is automatically the absolute value
	 * of both of them, then uses long multiplication to get the the result. And
	 * then factors in the signs of the original numbers to determine if the result
	 * should be negative or positive
	 * 
	 * @param e LargeInteger - the number multiplied by this LargeInteger
	 * @return LargeInteger - the product of the two numbers
	 */
	@Override
	public LargeInteger multiply(LargeInteger e) {
		// Cast the parameter so that I can use methods from this class on it
		ArrayLargeInteger castE = (ArrayLargeInteger) e;

		// If either number is zero, then the result is zero, and we don't need to go
		// any further
		if (this.toString().equals("0") || e.toString().equals("0"))
			return new ArrayLargeInteger("0");

		/*
		 * We will multiply by one digit from the second term with all of the digits of
		 * the first term and add the result to a running total ArrayLargeInteger, then
		 * doing the next line and adding it to the total and so on. When multiplying
		 * this way, for each digit of the second term the result is placed one position
		 * higher, this mimics long multiplication
		 */
		ArrayLargeInteger total = new ArrayLargeInteger("0");
		ArrayLargeInteger line;
		String builder = ""; // Begin to create a constructor for the result of this multiplication
		String addZeroes = ""; // Starts out with no zeroes to add
		int carryOver = 0;
		int a, b, result;

		// Get term 1 and 2
		// They're the absolute values of this and e, the lists don't hold negative
		// numbers, so they're fine as is
		ArrayList<Integer> term1 = this.getList();
		ArrayList<Integer> term2 = castE.getList();

		int ind1 = term1.size() - 1;
		int ind2 = term2.size() - 1;

		// Get back int of 2, multiply it to all the numbers in 1
		while (ind2 >= 0) {
			a = term2.get(ind2);
			// Reset reused terms
			builder = "" + addZeroes; // the string builder, don't forget to add the trailing zeroes
			carryOver = 0; // carryOver after the end of each line of multiplication
			ind1 = term1.size() - 1; // the index iterator for term1 so we can re-iterate through

			// Go over each number in the first term
			while (ind1 >= 0) {
				b = term1.get(ind1);
				// Do the math adding the carryOver
				result = a * b + carryOver;
				builder = (result % TEN) + builder; // Save the first digit to the builder, result will never be more
													// than 2 digits
													// 9*9+9 = 90
				carryOver = result / TEN; // Any extra is saved as carryOver

				ind1--;
			}
			// If by the end of the line there is still carryOver, add it to the front of
			// the builder string
			if (carryOver != 0) {
				builder = carryOver + builder;
			}
			// Create an ArrayLargeInteger representing this line, and add it to the running
			// total
			line = new ArrayLargeInteger(builder);
			total = (ArrayLargeInteger) total.add(line);

			ind2--;
			addZeroes += "0"; // For each iteration, another zero will have to be added to the back of the
								// string
		}

		// If the numbers were matching signs, the result is positive
		if ((this.isNegative() && castE.isNegative()) || (!this.isNegative() && !castE.isNegative())) {
			return total;
		} else // Otherwise the result is negative
			return total.negate();
	}

	/**
	 * Returns the LargeInteger that is the larger between this LargeInteger and the
	 * argument.
	 * 
	 * First checks if one is negative while the other is positive, because it is
	 * the quickest indication. If they are both the same sign, checks if one has
	 * more numbers, and thus is larger, because that is also relatively quick. If
	 * they are the same sign and size, we must iterate through each number starting
	 * at the beginning to find which one is greater.
	 * 
	 * @param e LargeInteger - the number to compare this one to
	 * @return LargeInteger - the larger of the two BigIntegers
	 */
	@Override
	public LargeInteger max(LargeInteger e) {
		ArrayLargeInteger other = (ArrayLargeInteger) e;
		ArrayList<Integer> otherNum = other.getList();

		// Check if one is negative and the other isn't
		if (!this.isNegative && other.isNegative())
			return (new ArrayLargeInteger(this.STR)); // Should I be making a new one to return?

		if (this.isNegative && !other.isNegative())
			return (new ArrayLargeInteger(other.toString()));

		// At this point they're either both negative or both positive
		// Check if one is a bigger size
		if (number.size() > otherNum.size()) {	//ex. -1111 > -2
			if (!this.isNegative)
				return (new ArrayLargeInteger(this.STR));
			else
				return (new ArrayLargeInteger(other.toString()));	// -2

		}
		if (number.size() < otherNum.size()) {
			if (!this.isNegative)
				return (new ArrayLargeInteger(other.toString()));
			else
				return (new ArrayLargeInteger(this.STR));
		}

		// At this point they're the same sign and size
		// Check which digit is larger
		for (int i = 0; i < number.size(); i++) {
			int a = number.get(i);
			int b = (int) otherNum.get(i);

			if (!this.isNegative) {
				// If one is bigger than the other at any point that's our larger number
				if (a > b)
					return (new ArrayLargeInteger(this.STR));
				if (a < b)
					return (new ArrayLargeInteger(other.toString()));
			} else {
				if (a < b)
					return (new ArrayLargeInteger(this.STR));
				if (a > b)
					return (new ArrayLargeInteger(other.toString()));
			}
			// If it's neither of these, then the two digits are the same, move down to the
			// next place
		}

		return this; // What should I return if they're equal?
	}

	/**
	 * Returns the LargeInteger that is the smaller between this LargeInteger and
	 * the argument.
	 * 
	 * First checks if one is negative while the other is positive, because it is
	 * the quickest indication. If they are both the same sign, checks if one has
	 * less numbers, and thus is smaller, because that is also relatively quick. If
	 * they are the same sign and size, we must iterate through each number starting
	 * at the beginning to find which one is smaller.
	 * 
	 * @param e LargeInteger - the number to compare this one to
	 * @return LargeInteger - the smaller of the two BigIntegers
	 */
	@Override
	public LargeInteger min(LargeInteger e) {
		ArrayLargeInteger other = (ArrayLargeInteger) e;
		ArrayList<Integer> otherNum = other.getList();

		// Check if one is negative and the other isn't
		if (!this.isNegative && other.isNegative)
			return new ArrayLargeInteger(e.toString());

		if (this.isNegative && !other.isNegative())
			return new ArrayLargeInteger(this.STR);

		// At this point they're both negative or positive
		// Check if one is a bigger size
		if (number.size() > otherNum.size()) {
			if (!this.isNegative)
				return new ArrayLargeInteger(e.toString());
			else
				return new ArrayLargeInteger(this.STR);
		}
		if (number.size() < otherNum.size()) {
			if (!this.isNegative)
				return new ArrayLargeInteger(this.STR);
			else
				return new ArrayLargeInteger(e.toString());
		}
		// At this point they're the same sign and size
		// Check which digit is larger
		for (int i = 0; i < number.size(); i++) {
			int a = number.get(i);
			int b = (int) otherNum.get(i);

			if (!this.isNegative) {
				// If one is smaller than the other at any point that's our smaller number
				if (a < b)
					return new ArrayLargeInteger(this.STR);
				if (a > b)
					return new ArrayLargeInteger(e.toString());
			} else { // Here the smaller number is actually the one further from zero, so the
						// "larger" the better
				if (a > b)
					return new ArrayLargeInteger(this.STR);
				if (a < b)
					return new ArrayLargeInteger(e.toString());
			}
		}

		return this; // What should I return if they're equal?
	}

	/**
	 * Returns 0 if this LargeInteger equals 0, 1 if it’s positive, or -1 if it’s
	 * negative. Uses the boolean isNegative to do this.
	 * 
	 * @return int - 0, 1, or -1 showing if this number is 0, positive, or negative
	 */
	@Override
	public int signum() {
		if (isNegative)
			return -1;
		if (this.toString().equals("0"))
			return 0;

		return 1;
	}

	/**
	 * Compares this instance with another LargeInteger, and determines if this one
	 * is greater than, equal to, or less than the other, returning 1, 0, -1
	 * respectively. Utilizes this class's equals method to check for equality, then
	 * using this class's max method to find the larger of the two LargeIntegers,
	 * and see if it is this instance's (returning 1) or the parameter (returning
	 * -1)
	 * 
	 * @param LargeInteger - the object to be compared
	 * @return int - a negative integer, zero, or a positive integer as this object
	 *         is less than, equal to, or greater than the specified object.
	 */
	@Override
	public int compareTo(LargeInteger o) {
		if (this.equals(o)) {
			return 0;
		}
		ArrayLargeInteger temp = (ArrayLargeInteger) this.max(o);
		if (temp.equals(this)) {
			return 1;
		}
		return -1;
	}

	/**
	 * Returns the arrayList of the ArrayLargeInteger, so that the numbers stored
	 * within can be iterated over and used.
	 * 
	 * @return ArrayList<Integer> - the integer numbers representing this
	 *         ArrayLargeInteger
	 */
	public ArrayList<Integer> getList() {
		return number;
	}

	/**
	 * Returns a boolean indicating if a number is negative (true) or negative
	 * (false).
	 * 
	 * @return boolean - true for negative numbers, false for positive numbers
	 */
	public boolean isNegative() {
		return isNegative;
	}

}
