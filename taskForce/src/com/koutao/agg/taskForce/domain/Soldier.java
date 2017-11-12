package com.koutao.agg.taskForce.domain;

/**
 * 普通士兵
 */
public class Soldier {

	private int id;
	private String name;
	private int age;
	private double fighting; // 用于描述士兵的战斗力

	public Soldier(int id, String name, int age, double fighting) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.fighting = fighting;
	}

	public Soldier() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getFighting() {
		return fighting;
	}

	public void setFighting(double fighting) {
		this.fighting = fighting;
	}

	public String getDetails(){
		return id + "\t" + name + "\t" + age + "\t" + fighting;
	}

	@Override
	public String toString() {
		return getDetails();
	}

}
