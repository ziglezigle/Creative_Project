package Forecast;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MiddleTerm {

    public static List<weatherData> getWeatherInfo(String code) throws IOException {
        List<weatherData> list = new ArrayList<>();
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalTime time = LocalTime.now();
        LocalTime start = LocalTime.of(1, 0);
        LocalTime end = LocalTime.of(4, 0);

        if (time.isAfter(start) && time.isBefore(end)) {
            now = now.minusDays(1);
        }

        String formattedNow = now.format(formatter);

        weatherData[] weatherArr = getTmp(code, formattedNow);
        String[] sky = getSky(code, formattedNow);

        int date = Integer.parseInt(formattedNow) + 3;
        for(int i = 0; i < weatherArr.length; i++){
            weatherArr[i].setDate(formattedNow);
            weatherArr[i].setSky(sky[i]);
            date++;
            formattedNow = Integer.toString(date);
            list.add(weatherArr[i]);
        }


        return list;
    }

    public static weatherData[] getTmp(String code, String formattedNow) throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/MidFcstInfoService/getMidTa"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=NG93VOctZ9VKxKU432WUqon%2FIPZALfb4PrU6t0BLvGWFP6p9ebEy1kOjEwCNvmwCxEEBjvq8rlX0s%2F8sGhg1sw%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*요청자료형식(XML/JSON)Default: XML*/
        urlBuilder.append("&" + URLEncoder.encode("regId","UTF-8") + "=" + URLEncoder.encode(code, "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("tmFc","UTF-8") + "=" + URLEncoder.encode(formattedNow+"0600", "UTF-8")); /*-일 2회(06:00,18:00)회 생성 되며 발표시각을 입력 YYYYMMDD0600 (1800)-*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(conn.getInputStream());
        JsonNode itemNode = rootNode.path("response").path("body").path("items").path("item");


        weatherData[] arr = new weatherData[5];
        for (JsonNode node : itemNode) {

            arr[0] = new weatherData();
            arr[0].setTmn(node.path("taMin3").asInt());
            arr[0].setTmx(node.path("taMax3").asInt());

            arr[1] = new weatherData();
            arr[1].setTmn(node.path("taMin4").asInt());
            arr[1].setTmx(node.path("taMax4").asInt());

            arr[2] = new weatherData();
            arr[2].setTmn(node.path("taMin5").asInt());
            arr[2].setTmx(node.path("taMax5").asInt());

            arr[3] = new weatherData();
            arr[3].setTmn(node.path("taMin6").asInt());
            arr[3].setTmx(node.path("taMax6").asInt());

            arr[4] = new weatherData();
            arr[4].setTmn(node.path("taMin7").asInt());
            arr[4].setTmx(node.path("taMax7").asInt());

        }
        return arr;
    }

    public static String[] getSky(String code, String formattedNow) throws IOException {

        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/MidFcstInfoService/getMidLandFcst"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=NG93VOctZ9VKxKU432WUqon%2FIPZALfb4PrU6t0BLvGWFP6p9ebEy1kOjEwCNvmwCxEEBjvq8rlX0s%2F8sGhg1sw%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*요청자료형식(XML/JSON)Default: XML*/
        urlBuilder.append("&" + URLEncoder.encode("regId","UTF-8") + "=" + URLEncoder.encode(code, "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("tmFc","UTF-8") + "=" + URLEncoder.encode(formattedNow+"0600", "UTF-8")); /*-일 2회(06:00,18:00)회 생성 되며 발표시각을 입력 YYYYMMDD0600 (1800)-*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(conn.getInputStream());
        JsonNode itemNode = rootNode.path("response").path("body").path("items").path("item");

        String[] sky = new String[5];
        for (JsonNode node : itemNode) {
            sky[0] = node.path("wf3Pm").asText();
            sky[1] = node.path("wf4Pm").asText();
            sky[2] = node.path("wf5Pm").asText();
            sky[3] = node.path("wf6Pm").asText();
            sky[4] = node.path("wf7Pm").asText();
        }
        System.out.println(code);
        return sky;
    }


}

