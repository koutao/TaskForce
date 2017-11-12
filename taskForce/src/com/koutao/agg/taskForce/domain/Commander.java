package com.koutao.agg.taskForce.domain;

/**
 * 描述指挥官
 */
public class Commander extends SpecialTroops {

	private int commanderRating; // 描述指挥权限等级

	public Commander() {
	}

	public Commander(int id, String name, int age, double fighting,
			Weapon weapon, double field, int commanderRating) {
		super(id, name, age, fighting, weapon, field);
		this.commanderRating = commanderRating;
	}

	public int getCommanderRating() {
		return commanderRating;
	}

	public void setCommanderRating(int commanderRating) {
		this.commanderRating = commanderRating;
	}

	public String getDetailsForTeam() {
		return getMemberId() + "/" + getDetails() + "\t" + "指挥官" + "\t"
				+ getField() + "\t\t" + getCommanderRating() + "级\t";
	}

	@Override
	public String toString() {
		return getDetails() + "\t指挥官\t" + getStatus() + "\t" + getField()
				+ "\t  " + commanderRating + "级\t" + getWeapon();
	}

}
