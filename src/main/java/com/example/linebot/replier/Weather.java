package com.example.linebot.replier;


import com.example.linebot.value.Replier;
import com.example.linebot.value.WeatherItem;
import com.linecorp.bot.model.message.FlexMessage;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.flex.container.Bubble;
import com.linecorp.bot.model.message.flex.unit.FlexAlign;
import com.linecorp.bot.model.message.flex.unit.FlexFontSize;
import com.linecorp.bot.model.message.flex.unit.FlexLayout;
import com.linecorp.bot.model.message.flex.unit.FlexMarginSize;

import com.linecorp.bot.model.message.flex.component.Image;
import com.linecorp.bot.model.message.flex.component.Text;
import com.linecorp.bot.model.message.flex.component.Icon;
import com.linecorp.bot.model.message.flex.component.Box;


import java.net.URI;





public class Weather implements Replier {
    private final WeatherItem item;

    public Weather(WeatherItem item) {
        this.item = item;
    }

    @Override
    public Message reply() {
        String region = item.getName();
        String icon = item.getWeather().get(0).getIcon();
        String main = item.getWeather().get(0).getMain();
        double temp = item.getMain().getTemp();
        double humidity = item.getMain().getHumidity();
        double wind = item.getWind().getSpeed();

        Text title = Text.builder()
                .text(region + "の天気")
                .size(FlexFontSize.XL)
                .weight(Text.TextWeight.BOLD)
                .build();
        Image image = Image.builder()
                .url(URI.create("https://openweathermap.org/img/wn/" + icon + "@2x.png"))
                .size(Image.ImageSize.LG)
                .build();
        Text weather = Text.builder()
                .text(main)
                .margin(FlexMarginSize.SM)
                .flex(0)
                .align(FlexAlign.CENTER)
                .weight(Text.TextWeight.BOLD)
                .build();
        Icon icon1 = Icon.builder()
                .url(URI.create("https://user-images.githubusercontent.com/23183700/71070786-d3d9f180-21be-11ea-8319-4a8632adaf6d.png"))
                .offsetTop("2px")
                .build();
        Icon icon2 = Icon.builder()
                .url(URI.create("https://user-images.githubusercontent.com/23183700/71070988-22878b80-21bf-11ea-8505-e76db18aa499.png"))
                .offsetTop("2px")
                .build();
        Text temp1 = Text.builder()
                .text("現在の気温")
                .margin(FlexMarginSize.SM)
                .flex(0)
                .build();
        Text temp2 = Text.builder()
                .text(temp + "℃")
                .size(FlexFontSize.SM)
                .align(FlexAlign.END)
                .color("#ff0000")
                .build();
        Text humidity1 = Text.builder()
                .text("湿度")
                .margin(FlexMarginSize.SM)
                .flex(0)
                .build();
        Text humidity2 = Text.builder()
                .text(humidity + "%")
                .size(FlexFontSize.SM)
                .align(FlexAlign.END)
                .color("#002aff")
                .build();
        Text wind1 = Text.builder()
                .text("風速")
                .margin(FlexMarginSize.SM)
                .flex(0)
                .build();
        Text wind2 = Text.builder()
                .text(wind + "m/s")
                .size(FlexFontSize.SM)
                .align(FlexAlign.END)
                .build();
        Box tempBox = Box.builder()
                .layout(FlexLayout.BASELINE)
                .contents(icon1, temp1, temp2)
                .build();
        Box humidityBox = Box.builder()
                .layout(FlexLayout.BASELINE)
                .contents(icon1, humidity1, humidity2)
                .build();
        Box windBox = Box.builder()
                .layout(FlexLayout.BASELINE)
                .contents(icon2, wind1, wind2)
                .build();
        Box subBox = Box.builder()
                .layout(FlexLayout.VERTICAL)
                .contents(tempBox, humidityBox, windBox)
                .build();
        Box mainBox = Box.builder()
                .layout(FlexLayout.VERTICAL)
                .contents(title, image, weather, subBox)
                .build();
        Bubble bubble = Bubble.builder()
                .body(mainBox)
                .build();
        FlexMessage flexMessage = new FlexMessage("天気", bubble);
        return flexMessage;
    }

}
