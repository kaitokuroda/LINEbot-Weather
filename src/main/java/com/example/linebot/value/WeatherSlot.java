package com.example.linebot.value;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WeatherSlot {
    private final String region;

    public WeatherSlot(String text) {
        //Slotに当たる部分を取り出す正規表現の仕組み（Matcher）を作る
        String regexp = Intent.WEATHER.getRegexp();
        Pattern pattern=Pattern.compile(regexp);
        Matcher matcher=pattern.matcher(text);
        if(matcher.matches()){
            region= matcher.group(1);
        }else{
            throw new IllegalArgumentException("textをスロットに分けられません");
        }
    }

    public String getRegion() {
        return region;
    }
}
