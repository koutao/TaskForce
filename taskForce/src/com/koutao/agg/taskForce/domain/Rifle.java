package com.koutao.agg.taskForce.domain;

/**
 * 描述步枪
 */
public class Rifle implements Weapon {

	private String model;
	private double size; // 描述步枪子弹尺寸 如：5.58毫米

	public Rifle(String model, double size) {
		this.model = model;
		this.size = size;
	}

	public Rifle() {
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	@Override
	public String getDescription() {
		return model + size;
	}

	@Override
	public String toString() {
		return model + "(" + size + "毫米)";
	}

}
