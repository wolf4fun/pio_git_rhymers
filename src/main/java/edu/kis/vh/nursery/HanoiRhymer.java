package edu.kis.vh.nursery;

import edu.kis.vh.nursery.storage.IntStorage;

public class HanoiRhymer extends DefaultCountingOutRhymer {

	private int totalRejected = 0;

	public HanoiRhymer() {
        super();
    }

    public HanoiRhymer(final IntStorage intStorage) {
		super(intStorage);
	}

	public int reportRejected() {
		return totalRejected;
	}

	@Override
	public void countIn(final int in) {
		if (!callCheck() && in > peekaboo())
			totalRejected++;
		else
			super.countIn(in);
	}

}
