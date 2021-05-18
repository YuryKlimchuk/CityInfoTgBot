package com.hydroyura.CityInfoTgBot.Service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public interface BotServiceInterface {
	
	public SendMessage sendMsg(String txt);

}
