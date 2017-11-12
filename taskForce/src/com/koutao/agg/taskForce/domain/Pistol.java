package com.koutao.agg.taskForce.domain;

/**
 * 描述手枪
 */
public class Pistol implements Weapon {

	private String model;
	private double force;

	public Pistol(String model, double force) {
		this.model = model;
		this.force = force;
	}

	public Pistol() {
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getForce() {
		return force;
	}

	public void setForce(double force) {
		this.force = force;
	}

	@Override
	public String getDescription() {
		return model + force;
	}

	@Override
	public String toString() {
		return model + "(" + force + ")";
	}

}