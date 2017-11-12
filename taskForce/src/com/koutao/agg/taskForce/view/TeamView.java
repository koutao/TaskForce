package com.koutao.agg.taskForce.view;

import com.koutao.agg.taskForce.domain.Infantry;
import com.koutao.agg.taskForce.domain.Soldier;
import com.koutao.agg.taskForce.domain.TeamException;
import com.koutao.agg.taskForce.service.NameListService;
import com.koutao.agg.taskForce.service.TeamService;

public class TeamView {
	
	private NameListService nls = new NameListService();//主要用于管理部队所有的士兵
	private TeamService ts = new TeamService(); //主要用于管理特遣队成员
	
	//主菜单控制方法
	public void enterMainMenu(){
		
		boolean loopFlag = true;
		char key = 0;
		
		do{
			
			//显示部队中所有成员的列表
			if(key != '1') listAllSoldiers();
			System.out.print("1-特遣队列表  2-添加特遣队成员 3-删除特遣队成员  4-退出     请选择(1-4):");
			key = TSUtility.readMenuSelection();
			
			switch(key){
				case '1':
					//特遣队列表
					getAllTeam();
					break;
				case '2':
					//添加特遣队成员
					addMember();
					break;
				case '3':
					//删除特遣队成员
					deleteMember();
					break;
				case '4':
					//退出
					System.out.print("确认是否退出(Y/N):");
					char c = TSUtility.readConfirmSelection();
					if(c == 'Y') loopFlag = false;
					break;
			}
		}while(loopFlag);
		
	}
	//删除特遣队成员
	public void deleteMember(){
		System.out.println("\n--------------------添加特遣队成员---------------------\b");
		System.out.print("请输入要删除的士兵TID：");
		int memberId = TSUtility.readInt();
		System.out.print("确认是否删除(Y/N)：");
		char key = TSUtility.readConfirmSelection();
		
		if(key == 'N') return; //
		
		try {
			ts.removeMember(memberId);
			System.out.println("删除成功");
		} catch (TeamException e) {
			System.err.println(e.getMessage());
		}
		
		TSUtility.readReturn();
	}
	
	//添加特遣队成员
	public void addMember(){
		System.out.println("\n--------------------添加特遣队成员---------------------\b");
		System.out.print("请输入添加士兵的ID：");
		int id = TSUtility.readInt();
		
		try {
			Soldier soldier = nls.getSoldier(id);
			ts.addMember(soldier);
			System.out.println("添加成功");
		} catch (TeamException e) {
			System.err.println("添加失败，原因：" + e.getMessage());
		}
		
		//按回车继续
		TSUtility.readReturn();
	}
	
	//显示特遣队成员列表
	public void getAllTeam(){
		System.out.println("\n--------------------特遣队成员列表---------------------\n");
		Infantry[] infantry = ts.getTeam();
		
		if(infantry.length == 0){
			System.out.println("暂无人员信息！");
		}else{
			System.out.println("TID/ID\t姓名\t年龄\t战斗力\t兵种\t野外生存指数\t指挥等级");
		}
		
		for (int i = 0; i < infantry.length; i++) {
			System.out.println(infantry[i].getDetailsForTeam());
		}
		
		System.out.println("----------------------------------------------------");
	}
	
	//显示部队中所有成员列表
	public void listAllSoldiers(){
		System.out.println("\n------------------------------特遣战队组建管理系统----------------------------\n");
		Soldier[] soldiers = nls.getAllSoldiers();
		
		if(soldiers.length == 0){
			System.out.println("没有找到士兵！");
		}else{
			System.out.println("ID\t姓名\t年龄\t战斗力\t兵种\t状态\t野外生存\t指挥等级\t配备武器");
		}
		
		for (int i = 0; i < soldiers.length; i++) {
			System.out.println(soldiers[i]);//相当于直接输出对象的引用
		}
		
		System.out.println("-----------------------------------------------------------------------");
		
	}
	
	public static void main(String[] args) {
		TeamView tv = new TeamView();
		tv.enterMainMenu();
	}

}
