package com.hydroyura.CityInfoTgBot.Bot.fsm;

import org.telegram.telegrambots.meta.api.objects.Update;

/*
 * Описание состояния для FSM
 */
public interface State<T> {
	
	/*
	 * Вызывается при входе в состоние
	 */
	public void enter(T entity, Update update);
	
	/*
	 * Вызывается при нахождении в состоянии
	 */
	public void update(T entity, Update update);
	
	/*
	 * Вызывается при покидании состояния
	 */
	public void exit(T entity, Update update);
	
}
