package com.cell.BotRmDel.model;

import com.cell.BotRmDel.config.BotConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
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

    private static final int USER_ID = 510914120;

    @Value("classpath:spam.yaml")
    private Resource patternsResource;

    @Autowired
    private BotConfig botConfig;

    @Override
    public String getBotUsername() {
        return botConfig.getBotName();
    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }

    private void sendDeletedMessageText(Integer userId, String messageText, boolean isSpam) {
        SendMessage sendMessage;
        if (isSpam) {
            sendMessage = new SendMessage(userId.toString(), "Find spam:\n" + messageText);
        } else {
            sendMessage = new SendMessage(userId.toString(), "This message may not be spam:\n" + messageText);
        }
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private List<String> loadPatterns() {
        List<String> regexPatterns = new ArrayList<>();

        // Add patterns here
        regexPatterns.add("заработок\\sв\\sсфере\\sкриптовалют|удалённая\\sдеятельность");
        regexPatterns.add("пишите\\sв\\sличные\\sсообщения|в\\sличку|в\\sлс");
        regexPatterns.add("от\\s\\d+\\sлет");
        regexPatterns.add("обучение\\s|предоставляем\\sбесплатный\\sознакомительный\\sкурс");
        regexPatterns.add("web3");
        regexPatterns.add("криптовалют[аы]");
        regexPatterns.add("партн[её]рск");
        regexPatterns.add("от\\s\\d+\\sлет");
        regexPatterns.add("заработок");
        regexPatterns.add("дистанционн");
        regexPatterns.add("удал[её]нн");
        regexPatterns.add("подработ");
        regexPatterns.add("сво[ий] авто");
        regexPatterns.add("зарплат");
        regexPatterns.add("ваканс");
        regexPatterns.add("свободн[ыйая]");
        regexPatterns.add("обучен");
        regexPatterns.add("p2p(?:трейдинг|trading)");
        regexPatterns.add("привèт друг");
        regexPatterns.add("нɑпиши мнè");
        regexPatterns.add("пишите в личные сообщение");
        regexPatterns.add("нужны водители со своим автомобилем");
        regexPatterns.add("от 200 день");
        regexPatterns.add("от 70000 рублей в неделю");
        regexPatterns.add("со мной заработаешь");
        regexPatterns.add("от 800 в неделю");
        regexPatterns.add("только 18  лет");
        regexPatterns.add("от 3 до 65");
        regexPatterns.add("сфера крипты");
        regexPatterns.add("майнет");
        regexPatterns.add("профит34с круга");
        regexPatterns.add("бесплатнo oбучаю");
        regexPatterns.add("мой интерес от прибыли");
        regexPatterns.add("приоритет\\sпоставки\\sот\\s\\d+г");
        regexPatterns.add("минималка\\sот\\s\\d+г");
        regexPatterns.add("всем\\sпривет");
        regexPatterns.add("есть\\sвариант\\sзаработать\\sна\\sкрипте\\sза\\sпару\\sчасов\\sот\\s\\d+");
        regexPatterns.add("приветствую");
        regexPatterns.add("нужно\\sпарутройку\\sлюдей\\sдля\\sсовместного\\sдохода");
        regexPatterns.add("ищу\\sлюдей\\sна\\sработу\\sоплата\\sв\\sдень\\sот\\s\\d+");
        regexPatterns.add("есть\\sчя\\sтемка");
        regexPatterns.add("плата\\s\\d+");
        regexPatterns.add("на\\sпару\\sдней");
        regexPatterns.add("пиши\\sскорее\\sлс");
        regexPatterns.add("(привет|всем привет|привèт друг|приветствую)");
        regexPatterns.add("(пиши мне|пишите в личные сообщения|пиши скорее|напиши мне|пишите мне если интересно)");
        regexPatterns.add("(заработок|доход|оплата|возможность заработать|высокий доход|работа для каждого|удаленная работа|пассивный доход)");
        regexPatterns.add("(криптовалют|крипте|web3|trading|p2p|биржи)");
        regexPatterns.add("(ищу людей|нужны 2 человека|парутройку людей|вакансия|работу)");
        regexPatterns.add("(от 200 день|плата 1000|от 800 в неделю|от 70000 рублей в неделю|на пару дней|от 15г)");
        regexPatterns.add("(напиши и я расскажу что нужно делать|научу тебя зарабатывать|всему научу)");

        return regexPatterns;
    }


    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String chatId = update.getMessage().getChatId().toString();
            String message = update.getMessage().getText();

            log.error("chatId {}", chatId);
            log.error("message {}", message);

            boolean isSpam = isSpam(message);

            if (isSpam) {
                boolean deleted = deleteAndNotify(chatId, update.getMessage().getMessageId(),
                        USER_ID, message, isSpam);

                if (!deleted) {
                    log.error("Failed to delete message: {}", message);
                }
            } else {
                // Send non-spam message for verification
//                sendDeletedMessageText(Integer.parseInt(chatId), message, isSpam);
            }
        }
    }

    private boolean isSpam(String message) {
        List<String> regexPatterns = loadPatterns();
        String cleanedMessage = message.replaceAll("[^\\p{L}\\p{N} ]", "").toLowerCase();
        log.error("Cleaned message: {}", cleanedMessage);

        // Check each pattern against the cleaned message
        for (String pattern : regexPatterns) {
            if (Pattern.compile(pattern).matcher(cleanedMessage).find()) {
                log.error("isSpam true");
                return true; // If any pattern matches, mark as spam
            }
        }

        log.error("isSpam false");
        return false; // If no patterns match, mark as not spam
    }


    private boolean deleteAndNotify(String chatId, Integer messageId, Integer userId, String messageText, boolean isSpam) {
        // Delete the message
        boolean deleted = deleteMessage(chatId, messageId);

        // Send the deleted message text to the user
        if (deleted) {
            sendDeletedMessageText(userId, messageText, isSpam);
        }

        return deleted;
    }


    private boolean deleteMessage(String chatId, Integer messageId) {
        DeleteMessage deleteMessage = new DeleteMessage(chatId, messageId);
        try {
            execute(deleteMessage);
            return true;
        } catch (TelegramApiException e) {
            log.error("Error deleting message: {}", e.getMessage());
            return false;
        }
    }
}
