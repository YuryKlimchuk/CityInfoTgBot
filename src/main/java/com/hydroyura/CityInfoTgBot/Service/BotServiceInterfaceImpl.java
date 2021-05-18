package com.hydroyura.CityInfoTgBot.Service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;


public class BotServiceInterfaceImpl implements BotServiceInterface {

	@Override
	public SendMessage sendMsg(String txt) {
		SendMessage sendMessage = new SendMessage();
		sendMessage.setText(txt);
		return sendMessage;
	}

}
