package edu.unca.csci202;

/** 
 * An interface which represents what a Large Number Class should
 * be able to do. Extends Comparable.
 */
public interface LargeInteger extends Comparable<LargeInteger> {
	/**
	 * Returns the LargeInteger sum of this and the argument.
	 * 
	 * @param e LargeInteger - the number to be added to this element
	 * @return LargeInteger - sum of the two numbers
	 */
	public LargeInteger add(LargeInteger e);

	/**
	 * Returns the LargeInteger difference of this and the argument.
	 * 
	 * @param e LargeInteger - the number to be subtracted from this element
	 * @return LargeInteger - difference of the two numbers
	 */
	public LargeInteger subtract(LargeInteger e);

	/**
	 * Returns the negative of this LargeInteger.
	 * 
	 * @return LargeInteger - the negated LargeInteger
	 */
	public LargeInteger negate();

	/**
	 * Returns the absolute value of the LargeInteger
	 * 
	 * @return LargeInteger - the absolute value of the LargeInteger
	 */
	public LargeInteger abs();

	/**
	 * Returns the LargeInteger product of this and the argument.
	 * 
	 * @param e LargeInteger - the number multiplied by this LargeInteger
	 * @return LargeInteger - the product of the two numbers
	 */
	public LargeInteger multiply(LargeInteger e);

	/**
	 * Returns the LargeInteger that is the larger between this LargeInteger and the
	 * argument.
	 * 
	 * @param e LargeInteger - the number to compare this one to
	 * @return LargeInteger - the larger of the two BigIntegers
	 */
	public LargeInteger max(LargeInteger e);

	/**
	 * Returns the LargeInteger that is the smaller between this LargeInteger and
	 * the argument.
	 * 
	 * @param e LargeInteger - the number to compare this one to
	 * @return LargeInteger - the smaller of the two BigIntegers
	 */
	public LargeInteger min(LargeInteger e);

	/**
	 * Returns 0 if this LargeInteger equals 0, 1 if it’s positive, or -1 if it’s
	 * negative.
	 * 
	 * @return int - 0, 1, or -1 showing if this number is 0, positive, or negative
	 */
	public int signum();

}
