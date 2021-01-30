package com.travel.bot.service;

import com.travel.bot.model.CityInfo;
import com.travel.bot.service.MyCityInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
@PropertySource("classpath:application.properties")
public class TravelBot extends TelegramLongPollingBot {

    private final MyCityInfoService service;

//    @Value("@travel_tips_123_bot")
    private String botUsername = "@travel_tips_123_bot";

//    @Value("1677843639:AAGUdgnbiVY9USH7drhIyJ2792r3OuvPDKk")
    private String botToken = "1677843639:AAGUdgnbiVY9USH7drhIyJ2792r3OuvPDKk";

    @Autowired
    public TravelBot(MyCityInfoService service) {
        this.service = service;
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.getMessage() != null && update.getMessage().hasText()) {
            long chat_id = update.getMessage().getChatId();

            String message = service.getCityInfo(update.getMessage().getText()).map(CityInfo::getDescription)
                    .orElse("Sorry, we don't have tips for this city");
            try {
                execute(new SendMessage(String.valueOf(chat_id), message));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}
