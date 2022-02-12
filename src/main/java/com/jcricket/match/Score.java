package com.jcricket.match;

public final class Score {

	private final String batsmen;
	private final String baller;
	private final int over;
	private final int ball;
	
	public Score(String batsmen, String baller, int over, int ball) {
		super();
		this.batsmen = batsmen;
		this.baller = baller;
		this.over = over;
		this.ball = ball;
	}

	public String getBatsmen() {
		return batsmen;
	}

	public String getBaller() {
		return baller;
	}

	public int getOver() {
		return over;
	}

	public int getBall() {
		return ball;
	}

}
