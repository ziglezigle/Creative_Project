package Forecast;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class ShortTerm {

    public static void main(String[] args) throws IOException {

        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        LocalTime time = LocalTime.now();
        LocalTime start = LocalTime.of(1, 0);
        LocalTime end = LocalTime.of(4, 0);

        if (time.isAfter(start) && time.isBefore(end)) {
            now = now.minusDays(1);
        }

        String dateStr = now.format(formatter);
        LocalDateTime nowT = LocalDateTime.now().minusHours(1);
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH00");
        String baseTime = nowT.format(timeFormatter);

        int date = Integer.parseInt(dateStr);


        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=9ES0%2BotntA22Yw403XaDPS%2Fg39gOujCphKNzQdKON3hG1eBQFjuh%2B9OoOXI9ryoUJsVwn7CwyEqu080yTvWfIQ%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("1000", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("dataType", "UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*요청자료형식(XML/JSON) Default: XML*/
        urlBuilder.append("&" + URLEncoder.encode("base_date", "UTF-8") + "=" + URLEncoder.encode(dateStr, "UTF-8")); /*‘21년 6월 28일 발표*/
        urlBuilder.append("&" + URLEncoder.encode("base_time", "UTF-8") + "=" + URLEncoder.encode("0500", "UTF-8")); /*06시 발표(정시단위) */
        urlBuilder.append("&" + URLEncoder.encode("nx", "UTF-8") + "=" + URLEncoder.encode("84", "UTF-8")); /*예보지점의 X 좌표값*/
        urlBuilder.append("&" + URLEncoder.encode("ny", "UTF-8") + "=" + URLEncoder.encode("96", "UTF-8")); /*예보지점의 Y 좌표값*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(conn.getInputStream());
        JsonNode itemNode = rootNode.path("response").path("body").path("items").path("item");


        weatherData[] wd = new weatherData[3];
        for (int i = 0; i < wd.length; i++) {
            wd[i] = new weatherData(dateStr, baseTime, itemNode);
            date++;
            dateStr = Integer.toString(date);
            System.out.println("Date : " + wd[i].date + "\nSky : " + wd[i].sky + "\nTemperature now : " + wd[i].tmp
                    + "\nMin temperature : " + wd[i].tmn + "\nMax temperature : " + wd[i].tmx);
        }


    }

}
