package com.jcricket.team;

public class Player {

	private String name;
	private String age;
	private boolean played;
	private boolean out;
	private int run;

	public Player(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public boolean isPlayed() {
		return played;
	}

	public void setPlayed(boolean played) {
		this.played = played;
	}

	public boolean isOut() {
		return out;
	}

	public void setOut(boolean out) {
		this.out = out;
	}

	public void addRun(int run) {
		this.run += run;
	}

	public int getRun() {
		return run;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", age=" + age + "]";
	}

}
