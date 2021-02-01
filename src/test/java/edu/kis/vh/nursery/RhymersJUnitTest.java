package edu.kis.vh.nursery;

import org.junit.Assert;
import org.junit.Test;

public class RhymersJUnitTest {

	@Test
	public void testCountIn() {
		final DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
		final int testValue = 4;
		rhymer.countIn(testValue);

		final int result = rhymer.peekaboo();
		Assert.assertEquals(testValue, result);
	}

	
	@Test
	public void testCallCheck() {
		final DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
		boolean result = rhymer.callCheck();
		Assert.assertEquals(true, result);

		rhymer.countIn(888);

		result = rhymer.callCheck();
		Assert.assertEquals(false, result);
	}

	@Test
	public void testIsFull() {
		final DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
		final int STACK_CAPACITY = 12;
		for (int i = 0; i < STACK_CAPACITY; i++) {
			final boolean result = rhymer.isFull();
			Assert.assertEquals(false, result);
			rhymer.countIn(888);
		}

		final boolean result = rhymer.isFull();
		Assert.assertEquals(true, result);
	}

	@Test
	public void testPeekaboo() {
		final DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();

		//! CORRECTION -1 to 0 
		final int EMPTY_STACK_VALUE = 0;

		int result = rhymer.peekaboo();
		Assert.assertEquals(EMPTY_STACK_VALUE, result);

		final int testValue = 4;
		rhymer.countIn(testValue);

		result = rhymer.peekaboo();
		Assert.assertEquals(testValue, result);
		result = rhymer.peekaboo();
		Assert.assertEquals(testValue, result);
	}

	@Test
	public void testCountOut() {
		final DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
		
		//! CORRECTION -1 to 0 
		final int EMPTY_STACK_VALUE = 0;

		int result = rhymer.countOut();
		Assert.assertEquals(EMPTY_STACK_VALUE, result);

		final int testValue = 4;
		rhymer.countIn(testValue);

		result = rhymer.countOut();
		Assert.assertEquals(testValue, result);
		result = rhymer.countOut();
		Assert.assertEquals(EMPTY_STACK_VALUE, result);
	}

	//! ADDED TESTS

	@Test
    public void testFIFORhymer(){
		DefaultCountingOutRhymer fifoRhymer = new FIFORhymer();
		
		//! CORRECTION -1 to 0 
        final int EMPTY_RHYMER_VALUE = 0;

        int result = fifoRhymer.countOut();
        Assert.assertEquals(result,EMPTY_RHYMER_VALUE);

        final int TEST_VALUE = 100;
        fifoRhymer.countIn(TEST_VALUE);
        result = fifoRhymer.countOut();
        Assert.assertEquals(result,TEST_VALUE);
    }

	@Test
    public void testHanoiRhymer(){
        DefaultCountingOutRhymer hanoiRhymer = new HanoiRhymer();

        int testValue = 10;
        hanoiRhymer.countIn(testValue);
        int result = hanoiRhymer.peekaboo();
		Assert.assertEquals(testValue,result);
		
        testValue = 0;
        hanoiRhymer.countIn(testValue);
        result = hanoiRhymer.peekaboo();
        Assert.assertEquals(testValue,result);

	}

}
