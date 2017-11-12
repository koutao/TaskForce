package com.koutao.agg.taskForce.service;

import static com.koutao.agg.taskForce.service.Data.COMMANDER;
import static com.koutao.agg.taskForce.service.Data.GRENADE;
import static com.koutao.agg.taskForce.service.Data.INFANTRY;
import static com.koutao.agg.taskForce.service.Data.PISTOL;
import static com.koutao.agg.taskForce.service.Data.RIFLE;
import static com.koutao.agg.taskForce.service.Data.SOLDIERS;
import static com.koutao.agg.taskForce.service.Data.SPECIALTROOPS;
import static com.koutao.agg.taskForce.service.Data.WEAPONS;

import com.koutao.agg.taskForce.domain.Commander;
import com.koutao.agg.taskForce.domain.Grenade;
import com.koutao.agg.taskForce.domain.Infantry;
import com.koutao.agg.taskForce.domain.Pistol;
import com.koutao.agg.taskForce.domain.Rifle;
import com.koutao.agg.taskForce.domain.Soldier;
import com.koutao.agg.taskForce.domain.SpecialTroops;
import com.koutao.agg.taskForce.domain.TeamException;
import com.koutao.agg.taskForce.domain.Weapon;

/**
 * 管理部队中所有士兵
 */
public class NameListService {
	
	private Soldier[] soldiers;
	
	public NameListService(){
		
		soldiers = new Soldier[SOLDIERS.length];
		
		for (int i = 0; i < soldiers.length; i++) {
			
			Soldier soldier = null;
			
			//如何获取数据并创建，相应的对象
			int type = Integer.parseInt(SOLDIERS[i][0]);
			
			int id = Integer.parseInt(SOLDIERS[i][1]);
			String name = SOLDIERS[i][2];
			int age = Integer.parseInt(SOLDIERS[i][3]);
			double fighting = Double.parseDouble(SOLDIERS[i][4]);
			
			
			Weapon weapon = null;
			
			switch(type){
				case INFANTRY:
					weapon = createWeapon(i);
					soldier = new Infantry(id, name, age, fighting, weapon);
					break;
				case SPECIALTROOPS:
					weapon = createWeapon(i);
					soldier = new SpecialTroops(id, name, age, fighting, weapon, Double.parseDouble(SOLDIERS[i][5]));
					break;
				case COMMANDER:
					weapon = createWeapon(i);
					soldier = new Commander(id, name, age, fighting, weapon, Double.parseDouble(SOLDIERS[i][5]), Integer.parseInt(SOLDIERS[i][6]));
					break;
				default:
					soldier = new Soldier(id, name, age, fighting);
					break;
			}
			
			
			soldiers[i] = soldier;
			
		}
		
		
	}
	
	//通过Data类中的数据，构建相应武器对象
	public Weapon createWeapon(int i){
		Weapon weapon = null;
		
		int type = Integer.parseInt(WEAPONS[i][0]);
		
		switch(type){
			case PISTOL:
				weapon = new Pistol(WEAPONS[i][1], Double.parseDouble(WEAPONS[i][2]));
				break;
			case RIFLE:
				weapon = new Rifle(WEAPONS[i][1], Double.parseDouble(WEAPONS[i][2]));
				break;
			case GRENADE:
				weapon = new Grenade(WEAPONS[i][1], WEAPONS[i][2]);
			break;
		}
		
		return weapon;
	}
	
	
	//获取当前部队中所有的士兵
	public Soldier[] getAllSoldiers(){
		return soldiers;
	}
	
	//根据士兵ID获取指定士兵的对象
	public Soldier getSoldier(int id) throws TeamException{ //id: 士兵ID
		for(int i = 0; i < soldiers.length; i++){
			if(soldiers[i].getId() == id){
				return soldiers[i];
			}
		}
		
		throw new TeamException("没有找到指定的士兵！");
		
	}
	
	//测试方法
	public static void main(String[] args) {
		NameListService nls = new NameListService();
		
		Soldier[] soldier = nls.soldiers;
		
		for(int i = 0; i < soldier.length; i++){
			System.out.println(soldier[i]);
		}
	}

}
