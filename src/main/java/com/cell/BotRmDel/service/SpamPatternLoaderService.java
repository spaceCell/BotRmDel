package com.cell.BotRmDel.service;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SpamPatternLoaderService implements SpamPatternLoader {
    @Override
    public List<String> loadPatterns() {
        List<String> regexPatterns = new ArrayList<>();
        // Regular expressions to identify potential spam patterns
        regexPatterns.add("бизнеса\\s(?:\\p{L}+\\s){0,3}web\\d");
        regexPatterns.add("удалённый\\sзаработок\\s(?:\\p{L}+\\s){0,5}крипте");
        regexPatterns.add("доход\\sот\\s\\d+\\sежедневно.*|есть\\sчя\\sтемка\\sплата\\s\\d+\\sна\\sпару\\sдней");
        regexPatterns.add("ищет\\sудаляемую\\sработ(?:у|ы)\\sот\\s\\d+\\sлет");
        regexPatterns.add("web3");
        regexPatterns.add("cryptо");
        regexPatterns.add("шaбaшкa");
        regexPatterns.add("зapaбοтοκ");
        regexPatterns.add("нужны\\s(?:\\p{L}+\\s)*люди");
        regexPatterns.add("работа\\sс\\sкриптовалютой");
        regexPatterns.add("бизнеса\\s(?:\\p{L}+\\s){0,3}web\\d");
        regexPatterns.add("ищу\\s\\d+\\s(?:\\p{L}+\\s){0,4}сотрудников?");
        regexPatterns.add("работа\\s(?:\\p{L}+\\s){0,3}криптовалют(?:ой|а|у)?");
        regexPatterns.add("заработок\\sзависит\\s(?:\\p{L}+\\s){0,4}только\\sот\\sтебя");
        regexPatterns.add("удалённый\\sзаработок\\s(?:\\p{L}+\\s){0,5}крипте");
        regexPatterns.add("доход\\sот\\s\\d+\\s(?:\\p{L}+\\s){0,4}недел(?:ю|и|ями)?");
        regexPatterns.add("возраст\\s\\d+");
        regexPatterns.add("бесплатный\\sознакомительный\\s(?:\\p{L}+\\s){0,4}курс");
        regexPatterns.add("удаленн(?:ая|ой|ую)\\s(?:\\p{L}+\\s){0,4}деятельност(?:ь|и|ью)");
        regexPatterns.add("финансовой\\sсвобод(?:е|у)?");
        regexPatterns.add("пɑссивному\\sзɑрɑботку.*финɑнсовой\\sсвободè\\sсегодня.*высоким\\sдоходом\\sбез\\sлишних\\sусилий");
        regexPatterns.add(".*пɑссивнȯму\\sзɑрɑбȯтку.*\\s.*\\s.*\\s.*\\s.*\\s.*\\s.*\\s.*\\s.*высȯким\\sдȯхȯдȯм\\sбèз\\sлишних\\sусилий.*");
        regexPatterns.add(".*нужны\\s\\d+\\s(?:\\p{L}+\\s)*человека.*");
        regexPatterns.add("пɑссивн.*зɑрɑбот.*финɑнс.*свобод.*сегод.*высок.*доход.*без\\sлишн.*усили.*");
        regexPatterns.add("оплата\\s\\d+");
        regexPatterns.add("партнёрство\\sот\\s\\d+\\s(?:в|во|в\\sдень)");
        regexPatterns.add("нужен\\sводитель\\sна\\sсво(?:ем|ём)\\sавто");
        regexPatterns.add("доходность\\sот\\s\\d+\\sтыс\\s(?:в|во|в\\sнеделю)");
        regexPatterns.add("оплата\\sв\\sдень\\sот\\s\\d+к");
        regexPatterns.add("набор\\sлюдей\\sзп\\sот\\s\\d+\\s(?:в|во|в\\sнеделю)");
        regexPatterns.add("ищет\\sудаляемую\\sработ(?:у|ы)\\sот\\s\\d+\\sлет");
        regexPatterns.add("доход\\sот\\s\\d+\\sежедневно.*|есть\\sчя\\sтемка\\sплата\\s\\d+\\sна\\sпару\\sдней");
        regexPatterns.add("нужен\\s\\p{L}+\\s(?:на\\s)?онлайн\\sработ(?:у|ы)\\s(?:\\p{L}+\\s){0,4}крипт(?:ы|у|е|ой)");
        regexPatterns.add("заработок\\sв\\s(?:сфере\\s)?сфер(?:е|у|ой)\\s\\p{L}+\\s(?:crypto|cripto)");
        regexPatterns.add("удалённый\\sзаработок\\s\\p{L}+\\sкрипт(?:а|ы|е)?");
        regexPatterns.add("\\sна\\s\\p{L}+\\s+дому\\s(?:с\\s)?доход(?:ом|а)?\\s");
        regexPatterns.add("заработок\\sв\\s\\p{L}+\\sр2р\\sторг(?:ов(?:л(?:и|ей))?|ами)?\\s(?:возможность\\sработать\\sиз\\sдома)?");
        regexPatterns.add("дополнительный\\sзаработок\\s\\p{L}+\\s(?:совместим(?:о(?:сть)?|а|о)?\\sс\\sосновной\\sработ(?:ой|ою))?\\sдоход(?:ом|а)?");
        regexPatterns.add("желает\\sосвоить\\s\\p{L}+\\s(?:ниш(?:а|у))?\\sтестнет(?:ы|и)?");
        regexPatterns.add("открыт\\sнабор\\sв\\sкоманду\\s(?:нов(?:ом|ым)?\\sнаправлении)?\\sтрейдинг(?:а|у)?\\sна\\sp2p");
        regexPatterns.add("дополнительный\\sдоход\\sв\\sсфере\\s(?:крипто|crypto)");
        regexPatterns.add("работа\\sс\\sцифров(?:ыми|ими)\\sвалют(?:ами)?\\s\\p{L}+\\s(?:свободным\\sграфиком\\s)?(?:бесплатным\\sобучением)?");
        regexPatterns.add("ищем\\s\\d+\\sпартнёр(?:ов|а)?\\s\\p{L}+\\sуслов(?:ия|иями)?\\sпредоставляем\\sобучение");
        regexPatterns.add("\\bзараб[а-яё]*\\b.*\\bкрипт[а-яё]*\\b.*\\bдоход\\b.*");
        regexPatterns.add("\\bудал[её]нн?[а-яё]*\\b.*\\bработ[а-яё]*\\b.*\\bдоход\\b");
        regexPatterns.add("\\b(партн[её]рств[а-яё]*|команд[а-яё]*)\\b.*\\bкрипт[а-яё]*\\b.*\\bдоход\\b");
        regexPatterns.add("\\bработ[а-яё]*\\b.*\\bкрипт[а-яё]*\\b.*\\bзаработ[а-яё]*\\b");
        regexPatterns.add("\\b(обучен[ию]|поддержк[а-яё]*)\\b.*\\bдоход\\b.*\\bзаработ[а-яё]*\\b");
        regexPatterns.add("\\bдо\\s?\\d+\\b.*\\bзарплат[а-яё]*\\b.*\\bработ[а-яё]*\\b");
        regexPatterns.add("\\bвысок[а-яё]*\\b.*\\bдоход\\b.*\\bдом[а-яё]*\\b.*\\bработ[а-яё]*\\b");
        regexPatterns.add("\\bбыстр[о-яё]*\\b.*\\bзаработ[а-яё]*\\b.*\\bработ[а-яё]*\\b.*\\bминимальн[о-яё]*\\b");
        regexPatterns.add("\\b(присоединяйтесь|замечательн[а-яё]*)\\b.*\\bдоход\\b.*\\bкоманд[а-яё]*\\b");
        regexPatterns.add("\\b(забудь|ценные|успех[а-яё]*)\\b.*\\bдоход\\b.*\\bобучен[ию]\\b");
        regexPatterns.add("\\b(замечательн[а-яё]*|потенциал)\\b.*\\b3ара[б0]отк[а-яё]*\\b.*");
        regexPatterns.add("заработок\\sв\\sсфере\\sкриптовалют|удалённая\\sдеятельность");
        regexPatterns.add("пишите\\sв\\sличные\\sсообщения|в\\sличку|в\\sлс");
        regexPatterns.add("от\\s\\d+\\sлет");
        regexPatterns.add("обучение\\s|предоставляем\\sбесплатный\\sознакомительный\\sкурс");
        regexPatterns.add("криптовалют[аы]");
        regexPatterns.add("партн[её]рск");
        regexPatterns.add("от\\s\\d+\\sлет");
        regexPatterns.add("заработок");
        regexPatterns.add("дистанционн");
        regexPatterns.add("подработ");
        regexPatterns.add("сво[ий] авто");
        regexPatterns.add("зарплат");
        regexPatterns.add("ваканс");
        regexPatterns.add("свободн[ыйая]");
        regexPatterns.add("обучен");
        regexPatterns.add("p2p(?:трейдинг|trading)");
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
        regexPatterns.add("есть\\sвариант\\sзаработать\\sна\\sкрипте\\sза\\sпару\\sчасов\\sот\\s\\d+");
        regexPatterns.add("нужно\\sпарутройку\\sлюдей\\sдля\\sсовместного\\sдохода");
        regexPatterns.add("ищу\\sлюдей\\sна\\sработу\\sоплата\\sв\\sдень\\sот\\s\\d+");
        regexPatterns.add("есть\\sчя\\sтемка");
        regexPatterns.add("плата\\s\\d+");
        regexPatterns.add("на\\sпару\\sдней");
        regexPatterns.add("пиши\\sскорее\\sлс");
        regexPatterns.add("(пиши мне|пишите в личные сообщения|пиши скорее|напиши мне|пишите мне если интересно)");
        regexPatterns.add("(заработок|доход|оплата|возможность заработать|высокий доход|работа для каждого|удаленная работа|пассивный доход)");
        regexPatterns.add("(криптовалют|крипте|web3|trading|p2p|биржи)");
        regexPatterns.add("(ищу людей|нужны 2 человека|парутройку людей|вакансия|работу)");
        regexPatterns.add("(от 200 день|плата 1000|от 800 в неделю|от 70000 рублей в неделю|на пару дней|от 15г)");
        regexPatterns.add("(напиши и я расскажу что нужно делать|научу тебя зарабатывать|всему научу)");
        regexPatterns.add("crypt[o|а]"); // Covering variations in character sets
        regexPatterns.add("бизнеса\\s(?:\\p{L}+\\s){0,3}web\\d");
        regexPatterns.add("удаленн(?:ая|ой|ую)\\s(?:\\p{L}+\\s){0,4}работ(?:а|ы|у)");
        regexPatterns.add("зарплат[а-яё]*\\sот\\s\\d+"); // Targeting specific payment mentions
        regexPatterns.add("работа\\sс\\sкриптовалют(?:ой|а|у)?");
        // More refined patterns for specific spam contexts
        regexPatterns.add("доход\\sот\\s\\d+\\sежедневно.*|есть\\sчя\\sтемка\\sплата\\s\\d+\\sна\\sпару\\sдней");
        regexPatterns.add("партнёрство\\sот\\s\\d+\\s(?:в|во|в\\sдень)"); // Specific partnership mentions
        regexPatterns.add("финансовой\\sсвобод(?:е|у)?");
        // New patterns targeting specific spam messages or contexts
        regexPatterns.add("заработок\\sв\\sсфере\\sкриптовалют|удалённая\\sдеятельность");
        regexPatterns.add("пиши\\sскорее\\sлс");
        regexPatterns.add("(пиши мне|пишите в личные сообщения|пиши скорее|напиши мне|пишите мне если интересно)");
        regexPatterns.add("(заработок|доход|оплата|возможность заработать|высокий доход|работа для каждого|удаленная работа|пассивный доход)");
        regexPatterns.add("(криптовалют|крипте|web3|trading|p2p|биржи)");
        regexPatterns.add("(ищу людей|нужны 2 человека|парутройку людей|вакансия|работу)");
        regexPatterns.add("(от 200 день|плата 1000|от 800 в неделю|от 70000 рублей в неделю|на пару дней|от 15г)");
        regexPatterns.add("(напиши и я расскажу что нужно делать|научу тебя зарабатывать|всему научу)");
        regexPatterns.add("\\b(найди\\sсебя|найди\\sсво[её] направление)\\b.*\\b(?:в|в\\s)?(?:перспективном|новом|свежем)?\\s(?:направлении|месте|поле)?\\b");
        regexPatterns.add("\\bт(?:е)?ст[и]?р(?:у|0)?[вб]\\p{L}+\\sсети\\b");
        regexPatterns.add("\\bс\\s\\d+\\p{L}+\\s(?:лет|года|годами)\\b");
        regexPatterns.add("\\bбез\\s(?:особых|нулевых)?\\s(?:рисков|потерь)\\b");
        regexPatterns.add("\\bот\\s\\d+\\p{L}+\\s(?:в|во|в\\s)?(?:день|сутки)\\b");
        regexPatterns.add("\\bподдержк[а-яё]*\\s24\\d+\\b");
        regexPatterns.add("\\bзаинтересованным\\sписать\\s(?:в\\s)?лс\\b");

        return regexPatterns;

    }
}
