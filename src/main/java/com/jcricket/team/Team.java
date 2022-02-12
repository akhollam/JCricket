package com.jcricket.team;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Team {

	private String name;
	private List<Player> players;

	public Team(String name) {
		this.name = name;
		this.players = new LinkedList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public void addPlayer(Player player) {
		this.players.add(player);
	}

	public Player nextBaller() {
		return players.get(new Random().nextInt(11));
	}

	public Player nextBatsmen() {

		for (Player player : players) {
			if (!player.isPlayed()) {
				player.setPlayed(true);
				return player;
			}
		}

		return null;
	}

}
