package com.koutao.agg.taskForce.domain;

/**
 * 描述特种兵
 */
public class SpecialTroops extends Infantry {

	private double field; // 描述野外生存能力指数

	public SpecialTroops() {
	}

	public SpecialTroops(int id, String name, int age, double fighting,
			Weapon weapon, double field) {
		super(id, name, age, fighting, weapon);
		this.field = field;
	}

	public double getField() {
		return field;
	}

	public void setField(double field) {
		this.field = field;
	}

	public String getDetailsForTeam(){
		return getMemberId() + "/" + getDetails() + "\t" + "特种兵" + "\t" + getField();
	}

	@Override
	public String toString() {
		return getDetails() + "\t特种兵\t" + getStatus() + "\t" + getField() + "\t\t" + getWeapon();
	}

}
