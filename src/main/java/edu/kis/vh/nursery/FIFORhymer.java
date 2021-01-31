package edu.kis.vh.nursery;

public class FIFORhymer extends DefaultCountingOutRhymer {

	private final DefaultCountingOutRhymer tempRhymer = new DefaultCountingOutRhymer();

	@Override
	public int countOut() {
		while (!callCheck())

		tempRhymer.countIn(super.countOut());

		int ret = tempRhymer.countOut();

		while (!tempRhymer.callCheck())

			countIn(tempRhymer.countOut());

		return ret;
	}
}
