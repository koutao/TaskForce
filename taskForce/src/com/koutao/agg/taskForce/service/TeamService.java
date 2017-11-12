package com.koutao.agg.taskForce.service;

import com.koutao.agg.taskForce.domain.Commander;
import com.koutao.agg.taskForce.domain.Infantry;
import com.koutao.agg.taskForce.domain.Soldier;
import com.koutao.agg.taskForce.domain.SpecialTroops;
import com.koutao.agg.taskForce.domain.Status;
import com.koutao.agg.taskForce.domain.TeamException;

/**
 * 管理特遣队士兵
 */
public class TeamService {
	
	private static int counter = 1; //用于生成特遣队的成员ID
	private final int MAX_MEMBER = 5; //用于表示特遣队最大成员数
	private Infantry[] team = new Infantry[MAX_MEMBER]; //多态数组：用于保存特遣队成员
	private int total = 0; //用于记录特遣队中有效成员的人数
	
	//获取特遣队中有效成员的人
	public Infantry[] getTeam(){
		Infantry[] ins = new Infantry[total];
		for(int i = 0; i < ins.length;i++){
			ins[i] = team[i];
		}
		
		return ins;
	}
	
	//添加特遣队成员
	public void addMember(Soldier soldier) throws TeamException{
//		特遣队成员已满，无法添加
		if(total >= MAX_MEMBER)
			throw new TeamException("特遣队成员已满，无法添加");
		
//		该士兵是普通士兵，无法添加
		if(!(soldier instanceof Infantry))
			throw new TeamException("该士兵是普通士兵，无法添加");
		
//		该士兵已是特遣队员
//		该士兵正在休假，无法添加
		Infantry infantry = (Infantry)soldier;
		Status status = infantry.getStatus();
		switch(status){
			case BUSY:
				throw new TeamException("该士兵已是特遣队员");
			case VOCATION:
				throw new TeamException("该士兵正在休假，无法添加");
			default:
				break;
		}
		
//		该士兵已是特遣队员
		for(int i = 0; i < total; i++){
			if(infantry.getId() == team[i].getId()){
				throw new TeamException("该士兵已是特遣队员");
			}
		}
		
//		特遣队中只能有一名指挥官
//		特遣队中只能有两名特种兵
//		特遣队中只能有三名步兵
		int numOfcom = 0, numOfspt = 0, numOfinf = 0;
		for (int i = 0; i < total; i++) {
			if(team[i] instanceof Commander) numOfcom++;
			else if(team[i] instanceof SpecialTroops) numOfspt++;
			else if(team[i] instanceof Infantry) numOfinf++;
		}
		
		if(infantry instanceof Commander){
			if(numOfcom >= 1) throw new TeamException("特遣队中只能有一名指挥官");
		}else if(infantry instanceof SpecialTroops){
			if(numOfspt >= 2) throw new TeamException("特遣队中只能有两名特种兵");
		}else if(infantry instanceof Infantry){
			if(numOfinf >= 3) throw new TeamException("特遣队中只能有三名步兵");
		}
		
		
		//添加士兵到数组中
		infantry.setMemeberId(counter++);
		infantry.setStatus(Status.BUSY);
		team[total++] = infantry;
	}
	
	//删除特遣队成员
	public void removeMember(int memberId) throws TeamException{
		int i = 0;
		for (; i < total; i++) {
			if(team[i].getMemberId() == memberId){
				//进行覆盖操作
				team[i].setStatus(Status.FREE);
				
				for(int j = i + 1; j < total; j++){
					team[j - 1] = team[j];
				}
				
				break;
			}
		}
		
		if(i == total){
			throw new TeamException("特遣队中没有找到该成员！");
		}
		
		//数组中最后一个元素置为null
		team[--total] = null;
	}
	
	
	//测试方法
	public static void main(String[] args) {
		TeamService ts = new TeamService();
		
		NameListService nls = new NameListService();
		Soldier[] soldiers = nls.getAllSoldiers();
		System.out.println("-----------所有士兵----------");
		for(Soldier so : soldiers){
			System.out.println(so);
		}
		

		System.out.println("-----------特遣队士兵----------");
		try {
			ts.addMember(soldiers[11]);
			ts.addMember(soldiers[1]);
			ts.addMember(soldiers[9]);
		} catch (TeamException e) {
			System.err.println(e.getMessage());
		}
		
		try {
			ts.removeMember(3);
		} catch (TeamException e) {
			System.out.println(e.getMessage());
		}
		
		//测试获取
		Infantry[] inf = ts.getTeam();
		for(Infantry in : inf){
			System.out.println(in.getDetailsForTeam());
		}
	}

}

