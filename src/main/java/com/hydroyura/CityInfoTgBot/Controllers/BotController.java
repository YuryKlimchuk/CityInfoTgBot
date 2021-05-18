package com.hydroyura.CityInfoTgBot.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

import com.hydroyura.CityInfoTgBot.Bot.CityInfoTgBot;

@RestController
public class BotController {
	
	@Autowired
	@Qualifier("CityInfoTgBot")
	private CityInfoTgBot bot;
	
	// Сюда приходят сообщения от бота 
	@PostMapping
	public BotApiMethod<?> indexBoxUlr(@RequestBody Update update) {
		/*
		System.out.println("UserName = " + update.getMessage().getFrom().getUserName());
		System.out.println("LastName = " + update.getMessage().getFrom().getLastName());
		System.out.println("FirstName = " + update.getMessage().getFrom().getFirstName());
		*/
		return bot.onWebhookUpdateReceived(update);
	}

}
