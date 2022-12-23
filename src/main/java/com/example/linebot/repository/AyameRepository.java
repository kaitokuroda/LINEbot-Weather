package com.example.linebot.repository;

import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

@Repository
public class AyameRepository {
    private final RestTemplate restTemplate;

    @Autowired
    public AyameRepository(RestTemplateBuilder templateBuilder){
        this.restTemplate = templateBuilder.build();
    }

    public String findAyameURL(String num) throws IOException {

        String strUrl = "http://3.89.254.121/" ;
        HttpURLConnection  urlConn = null;
        InputStream in = null;
        BufferedReader reader = null;

        try {
            //接続するURLを指定する
            URL url = new URL(strUrl);

            //コネクションを取得する
            urlConn = (HttpURLConnection) url.openConnection();

            urlConn.setRequestMethod("GET");

            urlConn.connect();

            int status = urlConn.getResponseCode();

            //System.out.println("HTTPステータス:" + status);

            if (status == HttpURLConnection.HTTP_OK) {

                in = urlConn.getInputStream();

                reader = new BufferedReader(new InputStreamReader(in));

                StringBuilder output = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    output.append(line);
                }
                //System.out.println(output.toString());
                return output.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (urlConn != null) {
                    urlConn.disconnect();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "e";
    }
}
