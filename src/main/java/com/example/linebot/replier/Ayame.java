package com.example.linebot.replier;

import com.example.linebot.value.Replier;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalTime;
import java.util.Objects;

public class Ayame implements Replier {

    private final MessageEvent<TextMessageContent> event;

    public Ayame(MessageEvent<TextMessageContent> event){
        this.event = event;
    }

    @Override
    public Message reply() {
        RestTemplateBuilder templateBuilder= new RestTemplateBuilder();
        RestTemplate restTemplate = templateBuilder.build();

        String url = "http://127.0.0.1:8888/";

        try{
            String result = restTemplate.getForObject(url, String.class);
            return new TextMessage(Objects.requireNonNull(result));
        }catch (RestClientException e){
            return new TextMessage(Objects.requireNonNull(e.getMessage()));
        }
    }
}