package com.hydroyura.CityInfoTgBot.Bot;

import org.telegram.telegrambots.meta.api.objects.Update;

// Хранит всопомгальные методы для работы с ботом, и строки
public class BotSupport {
	
	/*
	 * Извлекает chatId из обьекта Update
	 */
	public static long getChadId(Update update) {
		return update.getMessage().getChatId();
	}
	
	/*
	 * Извлекает текст из обьекта Update
	 */
	public static String getMessage(Update update) {
		return update.getMessage().getText();
	}
	
	
	/*
	 * Извлекает имя отправителя сообщения
	 */
	public static String getUserName(Update update) {
		return update.getMessage().getFrom().getUserName();
	}
	
	// Сообщения бота
	public static final String BOT_MSG_FIRST = "Это бот каторый может тебе расказать про разные города. Для того чтобы начать, ты должен поздороваться со мной. Скажи мне привет или hello и мы начнем.";
	public static final String BOT_MSG_SECOND = "Поздоровайся и мы начнем.";
	public static final String BOT_MSG_GREETINGS = "Привет %s! Давай начнем.";
	public static final String BOT_MSG_INSTRUCTONS = "Чтобы узнать информацию о городе напиши !xxxx, где xxxx - название города. К сожелению я знаю не про все города, чтобы узнать список городов про которые я знаю напиши !список.";
	public static final String BOT_MSG_UNKNOWN_COMMAND = "Я тебя не понимаю. Ппробуй еще раз!";
	public static final String BOT_MSG_UNKNOWN_CITY = "Я не знаю такого города(((. Спроси про другой.";
	public static final String BOT_MSG_CITY_INFO = "Город - %s, население - %s млн. человек, площадь - %s кв. км.";
	
	// Команды для распознания
	public static final String BOT_COMMAND_START = "/start";
	public static final String BOT_COMMAND_PRIVET = "привет";
	public static final String BOT_COMMAND_HELLO = "hello";
	public static final String BOT_COMMAND_LIST = "!список";

}
