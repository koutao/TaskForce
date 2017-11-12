package com.koutao.agg.taskForce.domain;

/**
 * 描述手榴弹
 */
public class Grenade implements Weapon {

	private String type;
	private String name;

	public Grenade(String type, String name) {
		this.type = type;
		this.name = name;
	}

	public Grenade() {
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getDescription() {
		return type + name;
	}

	@Override
	public String toString() {
		return type + "(" + name + ")";
	}
}

