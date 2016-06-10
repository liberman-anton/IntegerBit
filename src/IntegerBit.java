
public class IntegerBit {
	int number;
	public IntegerBit(int number){
		this.number = number;
	}
	/**
	 * 
	 * @param bits true - bit value = 1, false - bit value = 0
	 * array value at index i equals bit value at bit number i
	 * missing array values are zero bit values at the proper position 
	 */
	public IntegerBit(boolean[] bits){
		int lengthBits = bits.length;
		int number = 0;
		for(int i = 0; i < lengthBits; i++){
			if(bits[i] == true) 
				number = setBitValue(number, i, 1);
		}
		this.number = number;
	}	
	/**
	 * 
	 * @param nBit
	 * @param length
	 * @return integer value of the number part extracted from bit with number 
	 * nBit and amount of bits equaled to the given length
	 * example: number = 7; subValue(0, 2) = 3; subValue(1, 2) = 3
	 *                 0111
	 */
	public int subValue(int nBit, int length){
		int res = 0;
		int value = 0;
		for(int i = 0; i < length; i++){
			value = getBitValue(this.number, nBit + i);
			res = setBitValue(res, i, value);
		}
		return res;
	}
	/**
	 * comparing this.number with other number only part extracted according to the given mask
	 * comparing just bits matching 1 in the given mask
	 * @param otherNumber
	 * @param mask
	 * @return
	 */
	public int compareMask(int otherNumber, int mask){
		int j = 0;
		int res1 = 0;
		int res2 = 0;
		for(int i = 0; i < 32; i++){
			if(getBitValue(mask, i) == 1){
				res1 = setBitValue(res1, j, getBitValue(this.number, i));
				res2 = setBitValue(res2, j, getBitValue(otherNumber, i));
				j++;
			}
		}
		return res1 - res2;
	}
	/**
	 * 
	 * @param number
	 * @param nBit
	 * @return value of bit with number nBit for the given number
	 * if nBit < 0 or nBit >31 -> -1
	 * example: number = 5 (101), nBit = 1 -> 0
	 */
	public static int getBitValue(int number, int nBit) {
		if(nBit<0 || nBit >31) return -1;
		number >>= nBit;
		return Math.abs(number%2);
	}
	/**
	 * sets at bit with number nBit the given bitValue
	 * @param number
	 * @param nBit
	 * @param bitValue
	 * @return number value after the setting bit value
	 * if nBit or bitValue has a wrong value it returns the same number value
	 */
	public static int setBitValue(int number, int nBit, int bitValue) {
		if(!checkBitNumber(nBit) || !checkBitValue(bitValue))
			return number;
		long mask = 1L << nBit;
		if(getBitValue(number, nBit) == bitValue)
			return number;
		return (int)(number ^ mask);		
	}
	private static boolean checkBitValue(int bitValue) {
		// TODO Auto-generated method stub
		return bitValue == 0 || bitValue == 1;
	}
	private static boolean checkBitNumber(int nBit) {
		// TODO Auto-generated method stub
		return nBit >= 0 && nBit <= 31;
	}
}