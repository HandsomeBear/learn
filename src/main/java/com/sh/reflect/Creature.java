package com.sh.reflect;

public class Creature {

	public int weight;
	private int color;
	
	@Override
	public String toString() {
		return "Creature [weight=" + weight + ", color=" + color + "]";
	}
	
	public Creature() {
		
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}
	
	public class InnerCreature {
		
	}
	
}
