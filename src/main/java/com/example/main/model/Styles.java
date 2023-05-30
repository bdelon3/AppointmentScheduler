package com.example.main.model;

public class Styles {
    private static String theme;

    static {
        theme = "Dark";
    }

    public static void setTheme(String val)
    {
        theme = val;
    }
    public static String getTheme(){return theme;}
}
