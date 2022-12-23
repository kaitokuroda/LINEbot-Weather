package com.example.linebot.value;

import com.linecorp.bot.model.message.Message;

import java.io.IOException;
import java.net.URISyntaxException;

// 返信用クラスのためのインターフェース
    public interface Replier {

        // 返信用クラスが必ず実装するメソッド
        Message reply() throws IOException, URISyntaxException;

    }

