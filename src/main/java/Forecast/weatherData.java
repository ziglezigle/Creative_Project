package Forecast;

import com.fasterxml.jackson.databind.JsonNode;

public class weatherData {
    public String date, sky;
    public int weather, tmp, tmn, tmx;

    weatherData(String date, String time, JsonNode itemNode){
        this.date = date;
        tmp = getTmpNow(date, time, itemNode);
        tmn = tmx = tmp;

        for(JsonNode node : itemNode){
            if(node.path("fcstDate").asText().equals(date))
            {
                if(node.path("category").asText().equals("TMP")){
                    int temp = node.path("fcstValue").asInt();
                    tmn = temp < tmn? temp : tmn;
                    tmx = temp > tmx? temp : tmx;
                }
            }
        }
    }
    public int getTmpNow(String date, String time, JsonNode itemNode){
        int tmp = 0;
        int sky = -1;
        for(JsonNode node : itemNode){
            if(node.path("fcstDate").asText().equals(date) && node.path("fcstTime").asText().equals(time))
                if(node.path("category").asText().equals("TMP")) {
                    tmp = node.path("fcstValue").asInt();
                }else if(node.path("category").asText().equals("SKY")){
                    sky = node.path("fcstValue").asInt();
                    break;
                }
        }
        if(sky >= 0 && sky <= 5)
            this.sky = "Sunny";
        else if(sky > 5 && sky <= 8)
            this.sky = "Cloudy";
        else if(sky > 8 && sky <= 10)
            this.sky = "Rainy";
        else
            this.sky = "No data";
        return tmp;
    }
}