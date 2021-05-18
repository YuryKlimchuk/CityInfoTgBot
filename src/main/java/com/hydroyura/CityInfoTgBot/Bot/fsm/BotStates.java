package com.hydroyura.CityInfoTgBot.Bot.fsm;

import java.util.Optional;

import org.telegram.telegrambots.meta.api.objects.Update;

import com.hydroyura.CityInfoTgBot.Bot.BotSupport;
import com.hydroyura.CityInfoTgBot.Bot.CityInfoTgBot;
import com.hydroyura.CityInfoTgBot.Entities.City;



public enum BotStates implements State<CityInfoTgBot>{
	
	// Начальное состояние бота, при открытии окна,  после команды "/start"
	INIT_STATE() {
		
		@Override
		public void update(CityInfoTgBot entity, Update update) {
			// Извлекаем сообщение
			String msg = BotSupport.getMessage(update);
			
			if(msg.equals(BotSupport.BOT_COMMAND_START)) {
				entity.sendMessage(BotSupport.BOT_MSG_FIRST, BotSupport.getChadId(update));
			} else if(msg.equals(BotSupport.BOT_COMMAND_HELLO) || msg.equals(BotSupport.BOT_COMMAND_PRIVET)) {
				entity.sendMessage(String.format(BotSupport.BOT_MSG_GREETINGS, BotSupport.getUserName(update)), BotSupport.getChadId(update));
				entity.getFsm().changeState(WORK_STATE, update);
			} else {
				entity.sendMessage(BotSupport.BOT_MSG_SECOND, BotSupport.getChadId(update));
			}
			
		}
		
		@Override
		public void exit(CityInfoTgBot entity, Update update) {
			entity.sendMessage(BotSupport.BOT_MSG_INSTRUCTONS, BotSupport.getChadId(update));
		}
		
		
	},

	// Сосотояние в котором бот готов к работе и готов говорить информацию об городе или вывести список всех городов из базы
	WORK_STATE() {
		
		
		@Override
		public void update(CityInfoTgBot entity, Update update) {
			// Извлекаем сообщение
			String msg = BotSupport.getMessage(update);
			
			if(msg.equals(BotSupport.BOT_COMMAND_LIST)) {
				
				Iterable<String> cities = entity.getCities();
				String answer = "Города которые я знаю -> ";
				
				for (String string : cities) {
					answer = answer + string + ", ";
				}
				
				answer = answer.substring(0, answer.length() - 2);
				entity.sendMessage(answer, BotSupport.getChadId(update));
				
			} else if(msg.charAt(0) == '!') {
				Optional<City> city = entity.getCity(msg.substring(1));
				if(city.isPresent()) {
					entity.sendMessage(
							String.format(BotSupport.BOT_MSG_CITY_INFO, 
									String.valueOf(city.get().getName()), 
									String.valueOf(city.get().getPopulation()), 
									String.valueOf(city.get().getArea())),
							BotSupport.getChadId(update));
				} else {
					entity.sendMessage(BotSupport.BOT_MSG_UNKNOWN_CITY, BotSupport.getChadId(update));
				}
				
			} else {
				entity.sendMessage(BotSupport.BOT_MSG_UNKNOWN_COMMAND, BotSupport.getChadId(update));
			}
		
		}
		
	};


	@Override
	public void enter(CityInfoTgBot entity, Update update) {
		//System.out.println("BotStates.enter()");
	}

	@Override
	public void update(CityInfoTgBot entity, Update update) {
		//System.out.println("BotStates.update()");
	}

	@Override
	public void exit(CityInfoTgBot entity, Update update) {
		//System.out.println("BotStates.exit()");
	}

}
