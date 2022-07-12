package com.activa.model;

public enum Subjects {
	MATEMATICAS(10,true),
	HISTORIA(8,true),
	FISICA(15,false),
	QUIMICA(12,false),
	LENGUA(6,true),
	GEOGRAFIA(11,false);
	
	private int credits;
	private boolean optionals;
	
	
	public int getCredits() {
		return credits;
	}


	public void setCredits(int credits) {
		this.credits = credits;
	}


	public boolean isOptionals() {
		return optionals;
	}


	public void setOptionals(boolean optionals) {
		this.optionals = optionals;
	}


	private Subjects(int credits, boolean optionals) {
		this.credits = credits;
		this.optionals = optionals;
	}
	
	
	
}
