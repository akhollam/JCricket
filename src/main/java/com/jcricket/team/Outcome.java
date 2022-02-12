package com.jcricket.team;

public enum Outcome {

	ONE_RUN(1), TWO_RUN(2), FOUR_RUN(4), SIX_RUN(6), WIDE(1), NOBALL(1), CATCH_OUT(0), BOWLED_OUT(0), LBW_OUT(0);

	public int run;

	private Outcome(int run) {
		this.run = run;
	};

}
