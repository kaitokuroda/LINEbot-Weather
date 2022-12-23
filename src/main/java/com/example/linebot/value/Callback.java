package com.example.linebot.value;

import com.example.linebot.Follow;
import com.example.linebot.Greet;
import com.example.linebot.Omikuji;
import com.example.linebot.Parrot;
import com.example.linebot.replier.Ayame;
import com.example.linebot.replier.AyameImage;
import com.example.linebot.replier.Weather;
import com.example.linebot.repository.AyameRepository;
import com.linecorp.bot.model.event.FollowEvent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.event.MessageEvent;
import com.example.linebot.service.ExternalService;

import java.io.IOException;
import java.net.URISyntaxException;

@LineMessageHandler
public class Callback {

    private static final Logger log = LoggerFactory.getLogger(Callback.class);

    private final ExternalService externalService;

    public Callback(ExternalService externalService) {
        this.externalService = externalService;
    }


    // フォローイベントに対応する
    @EventMapping
    public Message handleFollow(FollowEvent event) {
        // 実際はこのタイミングでフォロワーのユーザIDをデータベースにに格納しておくなど
        Follow follow = new Follow(event);
        return follow.reply();
    }
    @EventMapping
    public Message handleMessage(MessageEvent<TextMessageContent> event) throws IOException, URISyntaxException {

            TextMessageContent tmc = event.getMessage();
            String text = tmc.getText();
            Intent intent=Intent.whichIntent(text);
            switch (intent) {
                case GREET:
                    Greet greet = new Greet();
                    return greet.reply();
                case OMIKUJI:
                    Omikuji omikuji = new Omikuji();
                    return omikuji.reply();
                case WEATHER:
                    Weather weather=externalService.doReplyWithWeather(text);
                    return weather.reply();
                case SOFTWARE:
                    Ayame ayame=new Ayame(event);
                    return ayame.reply();

//                    AyameRepository ayameRepository=new AyameRepository();
//                    return ayameRepository.findAyameURL();

                default:
                    Parrot parrot = new Parrot(event);
                    return parrot.reply();
            }
        }

    }


