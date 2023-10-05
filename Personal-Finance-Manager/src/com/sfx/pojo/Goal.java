package com.sfx.pojo;

import com.sfx.enums.GoalEnum;

public class Goal {

	private GoalEnum goalType;
	private long amount;

	public Goal(GoalEnum goalType, long amount) {
		super();
		this.goalType = goalType;
		this.amount = amount;
	}

	public GoalEnum getGoalType() {
		return goalType;
	}

	public void setGoalType(GoalEnum goalType) {
		this.goalType = goalType;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}
	
	public String toString() {
		return "Goal Type - "+this.goalType+", Goal Amount - "+this.amount;
	}

}
