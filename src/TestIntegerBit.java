import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestIntegerBit {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testIntegerBit() {
		boolean[] bits = {true,false,true};
		IntegerBit number = new IntegerBit(bits);
		assertEquals(5, number.number );
		boolean[] bits1 = {true,true,true,true,true,true,true,false};
		IntegerBit number1 = new IntegerBit(bits1);
		assertEquals(127, number1.number);
		boolean[] bits2 = {true,true,true,true,true,true,true,true,
				true,true,true,true,true,true,true,true,
				true,true,true,true,true,true,true,true,
				true,true,true,true,true,true,true,true};
		IntegerBit number2 = new IntegerBit(bits2);
		assertEquals(-1, number2.number);
	}
	@Test
	public void testSubValue(){
		IntegerBit number = new IntegerBit(7);
		assertEquals(3,number.subValue(0, 2));
		assertEquals(3,number.subValue(1, 2));
		assertEquals(7,number.subValue(0, 6));
		assertEquals(7,number.subValue(0, 32));		
	}
	@Test
	public void testCompareMask(){
		IntegerBit number = new IntegerBit(127);
		assertEquals(1, number.compareMask(0, 1));
		assertEquals(0, number.compareMask(1, 1));
		assertEquals(2, number.compareMask(1, 3));
		
	}

}
