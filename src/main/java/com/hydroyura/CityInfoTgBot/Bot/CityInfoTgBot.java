package com.hydroyura.CityInfoTgBot.Bot;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import com.hydroyura.CityInfoTgBot.Bot.fsm.BotStates;
import com.hydroyura.CityInfoTgBot.Bot.fsm.DefaultStateMachine;
import com.hydroyura.CityInfoTgBot.Bot.fsm.FinateStateMachine;
import com.hydroyura.CityInfoTgBot.Bot.fsm.State;
import com.hydroyura.CityInfoTgBot.Entities.City;
import com.hydroyura.CityInfoTgBot.Repositories.CityRepositiory;


// Бот
@Component("CityInfoTgBot")
public class CityInfoTgBot extends TelegramWebhookBot {
	
	@Value("${bot.username}")
	private String USER_NAME;
	
	@Value("${bot.path}")
	private String PATH;
	
	@Value("${bot.token}")
	private String TOKEN;
	
	@Autowired
	private CityRepositiory repository;
	
	// Aвтомат состояний
	private DefaultStateMachine fsm = new DefaultStateMachine(BotStates.INIT_STATE, this);

	@PostConstruct
	private void init() {
		/*
		System.out.println("CityInfoTgBot.PostConstruct()");
		System.out.println("BOT NAME - " + getBotUsername());
		System.out.println("BOT TOKEN - " + getBotToken());
		System.out.println("BOT PATH - " + getBotPath());
		*/
	}
	
	
	public void sendMessage(String msg, long chadId) {
		SendMessage sendMessage = new SendMessage();
		sendMessage.setText(msg);
		sendMessage.setChatId(String.valueOf(chadId));
		try {
			execute(sendMessage);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}
	
	// Возращает список городов
	public Iterable<String> getCities() {
		return repository.getCityNames();
	}
	
	// Возращает инфуоб городе.
	public Optional<City> getCity(String name) {
		//System.out.println("CityInfoTgBot.getCity(), name = " + name);
		return repository.findCityByName(name);
	}
	
	@Override
	public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
		if(update.hasMessage()) fsm.update(update);
		return null;
	}
	
	public FinateStateMachine<CityInfoTgBot, State<CityInfoTgBot>> getFsm() {
		return fsm;
	}

	@Override
	public String getBotUsername() {
		return USER_NAME;
	}

	@Override
	public String getBotPath() {
		return PATH;
	}

	@Override
	public String getBotToken() {
		return TOKEN;
	}

}
