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

public class MiddleTerm {
    public static void main(String[] args) throws IOException {

        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalTime time = LocalTime.now();
        LocalTime start = LocalTime.of(1, 0);
        LocalTime end = LocalTime.of(4, 0);

        if (time.isAfter(start) && time.isBefore(end)) {
            now = now.minusDays(1);
        }

        String formattedNow = now.format(formatter);

        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/MidFcstInfoService/getMidTa"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=NG93VOctZ9VKxKU432WUqon%2FIPZALfb4PrU6t0BLvGWFP6p9ebEy1kOjEwCNvmwCxEEBjvq8rlX0s%2F8sGhg1sw%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*요청자료형식(XML/JSON)Default: XML*/
        urlBuilder.append("&" + URLEncoder.encode("regId","UTF-8") + "=" + URLEncoder.encode("11H10501", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("tmFc","UTF-8") + "=" + URLEncoder.encode(formattedNow+"0600", "UTF-8")); /*-일 2회(06:00,18:00)회 생성 되며 발표시각을 입력 YYYYMMDD0600 (1800)-*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(conn.getInputStream());
        JsonNode itemNode = rootNode.path("response").path("body").path("items").path("item");



        for (JsonNode node : itemNode) {
            String regId = node.path("regId").asText();
            int taMin3 = node.path("taMin3").asInt();
            int taMax3 = node.path("taMax3").asInt();
            int taMin4 = node.path("taMin4").asInt();
            int taMax4 = node.path("taMax4").asInt();
            int taMin5 = node.path("taMin5").asInt();
            int taMax5 = node.path("taMax5").asInt();
            int taMin6 = node.path("taMin6").asInt();
            int taMax6 = node.path("taMax6").asInt();
            int taMin7 = node.path("taMin7").asInt();
            int taMax7 = node.path("taMax7").asInt();

            // Add more fields as needed

            if(regId.equals("11H10501") ) {
                regId = "안동";
            } else if (regId.equals("11B10101")) {
                regId = "서울";
            }else {
                System.out.println("틀린구역코드");
            }


            System.out.printf("Region ID: %s, Min Temperature (3 days later): %d, Max Temperature (3 days later): %d%n",
                    regId, taMin3, taMax3);
            System.out.printf("Region ID: %s, Min Temperature (4 days later): %d, Max Temperature (4 days later): %d%n",
                    regId, taMin4, taMax4);
            System.out.printf("Region ID: %s, Min Temperature (5 days later): %d, Max Temperature (5 days later): %d%n",
                    regId, taMin5, taMax5);
            System.out.printf("Region ID: %s, Min Temperature (6 days later): %d, Max Temperature (6 days later): %d%n",
                    regId, taMin6, taMax6);
            System.out.printf("Region ID: %s, Min Temperature (7 days later): %d, Max Temperature (7 days later): %d%n",
                    regId, taMin7, taMax7);
        }

    }

}

