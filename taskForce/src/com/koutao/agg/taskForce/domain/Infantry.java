package com.koutao.agg.taskForce.domain;

/**
 * 描述步兵
 */
public class Infantry extends Soldier {

	private int memberId; // 成员ID：当步兵加入特遣队后分配的ID
	private Status status = Status.FREE; //

	private Weapon weapon;

	public Infantry() {
	}

	public Infantry(int id, String name, int age, double fighting, Weapon weapon) {
		super(id, name, age, fighting);
		this.weapon = weapon;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemeberId(int memberId) {
		this.memberId = memberId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public String getDetailsForTeam(){
		return getMemberId() + "/" + getDetails() + "\t" + "步兵";
	}
	
	@Override
	public String toString() {
		return getDetails() + "\t步兵\t" + status + "\t\t\t" + weapon;
	}

}

