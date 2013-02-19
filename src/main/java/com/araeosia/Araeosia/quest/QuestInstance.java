package com.araeosia.Araeosia.quest;

import com.araeosia.Araeosia.util.AraeosiaPlayer;

import java.util.HashMap;

public class QuestInstance {
	private AraeosiaPlayer owner;
	private Quest quest;
	private HashMap<QuestObjective, Boolean> objectives = new HashMap<>();

	public QuestInstance(AraeosiaPlayer owner, Quest quest){
		this.owner = owner;
		this.quest = quest;
	}

	public Quest getQuest() {
		return quest;
	}

	public AraeosiaPlayer getOwner() {
		return owner;
	}

	public HashMap<QuestObjective, Boolean> getObjectives() {
		return objectives;
	}
}
