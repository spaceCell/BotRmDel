package com.cell.BotRmDel.model;

import com.cell.BotRmDel.config.BotConfig;
import com.cell.BotRmDel.service.SpamPatternLoaderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.*;
import java.util.regex.Pattern;

@Component
@Slf4j
public class BotRmDel extends TelegramLongPollingBot {

    private static final String CHAT_ID = "-1002131436559";

    @Autowired
    private BotConfig botConfig;
    @Autowired
    private SpamPatternLoaderService patternLoaderService;

    @Override
    public String getBotUsername() {
        return botConfig.getBotName();
    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }


    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String chatId = update.getMessage().getChatId().toString();
            String message = update.getMessage().getText();
//            String senderName = update.getMessage().getFrom().getFirstName();
            String senderName = update.getMessage().getFrom().getUserName();

            log.info("Received message in chatId {}: {}", chatId, message);

            boolean isSpam = isSpam(message);

            if (isSpam) {
                log.info("Message identified as spam: {}", message);
                deleteAndSendToBotChat(chatId, update.getMessage().getMessageId(), message, senderName);
            }
        }
    }

    private boolean isSpam(String message) {
        List<String> regexPatterns = patternLoaderService.loadPatterns();
        String cleanedMessage = message.replaceAll("[^\\p{L}\\p{N}\\s]", "").toLowerCase();

        log.info("cleanedMessage {}", cleanedMessage);

        for (String pattern : regexPatterns) {
            if (Pattern.compile(pattern).matcher(cleanedMessage).find()) {
                log.info("Spam pattern found: {}", pattern);
                log.error("isSpam true");
                return true; // If any pattern matches, mark as spam
            }
        }
        log.error("isSpam false");
        return false; // If no patterns match, mark as not spam
    }

    private void deleteAndSendToBotChat(String chatId, Integer messageId, String messageText, String senderName) {
        DeleteMessage deleteMessage = new DeleteMessage(chatId, messageId);

        // Replace BOT_ID with the ID of the group/chat where you want to send the notification
        String notificationChatId = CHAT_ID; // Replace with the actual chat/group ID

        SendMessage sendMessage = new SendMessage(notificationChatId, "Deleted Spam. Username: " + senderName + ":\n" + messageText);

        try {
            execute(deleteMessage); // Delete the message
            execute(sendMessage); // Send the deleted message to the specified chat/group
        } catch (TelegramApiException e) {
            log.error("Error deleting or sending message: {}", e.getMessage());
        }
    }
}
