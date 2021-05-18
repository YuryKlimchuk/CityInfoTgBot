package com.hydroyura.CityInfoTgBot.Bot.fsm;

import org.telegram.telegrambots.meta.api.objects.Update;

/*
 * Интерфейс описывающий методы автомата состояний
 */
public interface FinateStateMachine<T, E extends State<T>> {
	
	// Устанавливает начальное состояние
	public void setInitialState(E state);	
	
	public void update(Update update);
	public void changeState(E newState, Update update);
	public E getCurrentState();
	public T getOwner();

}
