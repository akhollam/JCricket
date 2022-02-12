package com.jcricket.match;

import com.jcricket.team.Outcome;

public class Over {

	public final Ball[] balls = new Ball[6];
	private Outcome outcome;

	public Over(int ball) {
		balls[ball] =  new Ball();
	}

	public Outcome getOutcome() {
		return outcome;
	}

	public void setOutcome(Outcome outcome) {
		this.outcome = outcome;
	}

}
