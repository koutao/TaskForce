package com.koutao.agg.taskForce.service;

public class Data {
    public static final int SOLDIER = 10;
    public static final int INFANTRY = 11;
    public static final int SPECIALTROOPS = 12;
    public static final int COMMANDER = 13;

    public static final int PISTOL = 21;
    public static final int RIFLE = 22;
    public static final int GRENADE = 23;

    //Soldier  		 :  10, id, name, age, fighting
    //Infantry  	 :  11, id, name, age, fighting
    //SpecialTroops  :  12, id, name, age, fighting, field
    //Commander 	 :  13, id, name, age, fighting, field, commanderRating
    public static final String[][] SOLDIERS = {
        {"10", "1", "小龙女", "22", "3000"},
        {"13", "2", "诸葛亮", "32", "18000", "15000", "5"},
        {"11", "3", "鲁智深", "23", "7000"},
        {"11", "4", "赵子龙", "24", "7300"},
        {"12", "5", "李师师", "28", "10000", "5000"},
        {"11", "6", "潘金莲", "22", "6800"},
        {"12", "7", "林冲", "29", "10800","5200"},
        {"13", "8", "韦小宝", "30", "19800", "15000", "3"},
        {"12", "9", "杨过", "26", "9800", "5500"},
        {"11", "10", "乔峰", "21", "6600"},
        {"11", "11", "吕布", "25", "7100"},
        {"12", "12", "陈圆圆", "27", "9600", "4800"}
    };

    //Pistol      :21, model, force
    //Rifle		  :22, model, size
    //Grenade	  :23, type, name
    public static final String[][] WEAPONS = {
        {},
        {"22", "AK47", "7.62"},
        {"21", "伯莱塔92F ", "8000"},
        {"21", "德国HKP7", "3800"},
        {"23", "杀伤型", "M24型柄式"},
        {"21", "沙漠之鹰", "9000"},
        {"21", "中国QSG92", "10000"},
        {"23", "烟雾", "OTO M35"},
        {"22", "M4A1", "5.56"},
        {"21", "鲁格P85", "5000"},
        {"21", "捷克CZ83","6000"},
        {"22", "95式", "5.8"}
    };
}
