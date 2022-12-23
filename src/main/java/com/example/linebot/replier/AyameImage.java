package com.example.linebot.replier;


import com.example.linebot.value.Replier;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.ImageMessage;
import com.linecorp.bot.model.message.Message;

import java.net.URI;
import java.net.URISyntaxException;

public class AyameImage implements Replier {


    private final String msg;
    public AyameImage(MessageEvent<TextMessageContent> msg){
        this.msg = String.valueOf(msg);
    }

    @Override
    public Message reply() throws URISyntaxException {
        URI uri = new URI(msg);
        String body = msg;
        return new ImageMessage(uri, uri);
    }

}