package com.example.linebot.value;

import java.util.EnumSet;
import java.util.regex.Pattern;

public enum Intent {

    // メッセージの意図に対応する正規表現パターン
    WEATHER("^(.*)の天気"),
    GREET("やあ"),
    OMIKUJI("おみくじ"),
    SOFTWARE("成功率"),
    UNKNOWN(".+");

    private String regexp;

    private Intent(String regexp) {
        this.regexp = regexp;
    }

    // メッセージと正規表現パターンからメッセージの意図を取得
    public static Intent whichIntent(String text) {
        return EnumSet.allOf(Intent.class).stream()
                .filter(i -> Pattern.matches(i.regexp, text))
                .findFirst().orElse(UNKNOWN);
    }

    public String getRegexp() {
        return regexp;
    }
}
