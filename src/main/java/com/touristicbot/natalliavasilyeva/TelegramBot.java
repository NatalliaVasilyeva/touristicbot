package com.touristicbot.natalliavasilyeva;

import com.touristicbot.natalliavasilyeva.model.City;
import com.touristicbot.natalliavasilyeva.service.CityService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.annotation.PostConstruct;


@Component
public class TelegramBot extends TelegramLongPollingBot {

    private static final Logger logger = LogManager.getLogger(TelegramBot.class);

    @Autowired
    private CityService cityService;

    @PostConstruct
    public void registerBot() {
        TelegramBotsApi botsApi = new TelegramBotsApi();
        try {
            botsApi.registerBot(this);
        } catch (TelegramApiException e) {
            logger.error(e.toString());
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        String text = message.getText();
        String userName = message.getFrom().getFirstName();
        System.out.println(userName + " --> " + text);
        if(message.hasText()){
            switch (text){
                case "/start":
                    sendMessage(message, "Enter the name of city ...");
                    break;
                case "/help":
                    sendMessage(message, "I'm telegram bot and I tell you about sightseeing of the cities, " +
                            "enter the name of city...");
                    break;
                default:
                   City city = cityService.getByName(message.getText());
                    if(city!=null){
                        sendMessage(message, city.getDescription().getDescription());
                    } else {
                        sendMessage(message, "There is no such city, " +
                                "or the description for this city hasn't been added yet");
                    }
                    break;
            }
        }
    }

    private synchronized void sendMessage(Message message, String text){
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText(text);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            logger.error(e.toString());
        }
    }


    @Override
    public String getBotToken() {
        return "";
    }

    @Override
    public String getBotUsername() {
        return "TouristicBot";
    }

}
