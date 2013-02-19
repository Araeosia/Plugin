package com.araeosia.Araeosia.util;

import com.araeosia.Araeosia.quest.QuestInstance;

import java.util.ArrayList;

public class AraeosiaPlayer {
	private String name;
	private CurrencyAmount money;
	private ArrayList<QuestInstance> quests = new ArrayList<>();
	private QuestInstance currentQuest=null;

	public AraeosiaPlayer(String name){
		this.name = name;
		this.money = new CurrencyAmount();
	}

	public String getName() {
		return name;
	}

	public CurrencyAmount getMoney() {
		return money;
	}

	public void setMoney(CurrencyAmount money) {
		this.money = money;
	}

	public ArrayList<QuestInstance> getQuests() {
		return quests;
	}

	public QuestInstance getCurrentQuest() {
		return currentQuest;
	}

	public void setCurrentQuest(QuestInstance currentQuest) {
		this.currentQuest = currentQuest;
	}

	public Object[] save(){
		Object[] output = new Object[this.getClass().getDeclaredFields().length];
		return output;
	}

	public static AraeosiaPlayer load(String playerName){
		// TODO player loading.
		AraeosiaPlayer player = new AraeosiaPlayer(playerName);
		return player;
	}
}
