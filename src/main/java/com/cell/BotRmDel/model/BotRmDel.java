package com.cell.BotRmDel.model;

import com.cell.BotRmDel.config.BotConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class BotRmDel extends TelegramLongPollingBot {

    @Autowired
    private BotConfig botConfig;
//    private String chatId;

    @Override
    public String getBotUsername() {
        return botConfig.getBotName();
    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }

//    @Override
//    public void onUpdateReceived(Update update) {
//    }

    @Override
    public void onUpdateReceived(Update update) {

            if (update.hasMessage() && update.getMessage().hasText()) {
                String chatId = update.getMessage().getChatId().toString();
                String message = update.getMessage().getText();

                // Check if message is from a user and not the bot itself
                if (!update.getMessage().getFrom().getUserName().equals("RmDel_bot")) {
                    // Implement spam detection logic here
                    boolean isSpam = isSpam(message);

                    if (isSpam) {
                        // Delete or warn about the spam message
                        deleteMessage(chatId, update.getMessage().getMessageId());
                        // Or warn the user about the spam
                        warnUser(Math.toIntExact(update.getMessage().getFrom().getId()), "Your message appears to be spam!");
                    }
                }
            }
        }

        private boolean isSpam(String message) {
            if (message.contains("test")) {
                return true;
            }
            return false;
        }

        private void deleteMessage(String chatId, Integer messageId) {
            DeleteMessage deleteMessage = new DeleteMessage(chatId, messageId);
            try {
                execute(deleteMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

        private void warnUser(Integer userId, String warningMessage) {
            SendMessage sendMessage = new SendMessage(userId.toString(), warningMessage);
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
}
