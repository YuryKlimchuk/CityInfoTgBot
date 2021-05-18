package com.hydroyura.CityInfoTgBot.Bot.fsm;

import org.telegram.telegrambots.meta.api.objects.Update;
import com.hydroyura.CityInfoTgBot.Bot.CityInfoTgBot;

// Автомат конечных состояний, простенький вариант
public class DefaultStateMachine implements FinateStateMachine<CityInfoTgBot, State<CityInfoTgBot>> {
	
	private State<CityInfoTgBot> currentState;
	private CityInfoTgBot owner;

	public DefaultStateMachine(State<CityInfoTgBot> initialState, CityInfoTgBot bot) {
		this.setInitialState(initialState);
		this.owner = bot;
	}
	
	@Override
	public void setInitialState(State<CityInfoTgBot> state) {
		this.currentState = state;
		
	}

	@Override
	public void update(Update update) {
		this.currentState.update(owner, update);
	}

	@Override
	public void changeState(State<CityInfoTgBot> newState, Update update) {
		currentState.exit(owner, update);
		newState.enter(owner, update);
		currentState = newState;
	}

	@Override
	public State<CityInfoTgBot> getCurrentState() {
		return currentState;
	}

	@Override
	public CityInfoTgBot getOwner() {
		return owner;
	}

}
