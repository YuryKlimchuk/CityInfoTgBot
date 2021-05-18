# CityInfoTgBot
Telegram bot  with Spring Boot 

Телеграм бот с использованием Spring Boot, Hibernate.

Имя бота - CityInfoTgBot<br>
Токен бота - 1822034760:AAEIEsl7NjaVE90l3Sx2vvKCuyw7ZMIYC8g

Для запуска выполните следующее:
1. Скачать репозиторий, и импортировать как maven проект в IDE.
2. Скачать программу ngrok <a href="https://ngrok.com/download">ngrok</a>.
3. Запустить программу ngrok и выполнить команду ngrok http 5000.
4. В появившемся окне скопировать https адрес в сроке Forwarding (адрес вида - https://1c6fe450d0c8.ngrok.io).
5. Скопированный адрес вставить в переменную bot.path в файле application.properties.
6. Зарегистрировать Webhook, отправив https запрос через браузер на адерс - https://api.telegram.org/bot1822034760:AAEIEsl7NjaVE90l3Sx2vvKCuyw7ZMIYC8g/setWebhook?url=<br>
(после = добавить адрес из пункта 3).
7. Запустить приложение. 
