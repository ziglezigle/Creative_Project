//package Forecast;
//
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import java.io.IOException;
//import java.net.*;
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.time.format.DateTimeFormatter;
//
//public class MiddleTermStatus {
//    WeatherDTO weatherReturn() throws IOException {
//        WeatherDTO weatherDTO = new WeatherDTO();
//        LocalDate now = LocalDate.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
//        LocalTime time = LocalTime.now();
//        LocalTime start = LocalTime.of(1, 0);
//        LocalTime end = LocalTime.of(4, 0);
//
//        if (time.isAfter(start) && time.isBefore(end)) {
//            now = now.minusDays(1);
//        }
//
//        String formattedNow = now.format(formatter);
//        System.out.println("formattedNow = " + formattedNow);
//
//        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/MidFcstInfoService/getMidLandFcst"); /*URL*/
//        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=NG93VOctZ9VKxKU432WUqon%2FIPZALfb4PrU6t0BLvGWFP6p9ebEy1kOjEwCNvmwCxEEBjvq8rlX0s%2F8sGhg1sw%3D%3D"); /*Service Key*/
//        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
//        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
//        urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*요청자료형식(XML/JSON)Default: XML*/
//        urlBuilder.append("&" + URLEncoder.encode("regId","UTF-8") + "=" + URLEncoder.encode("11B00000", "UTF-8"));
//        urlBuilder.append("&" + URLEncoder.encode("tmFc","UTF-8") + "=" + URLEncoder.encode(formattedNow+"0600", "UTF-8")); /*-일 2회(06:00,18:00)회 생성 되며 발표시각을 입력 YYYYMMDD0600 (1800)-*/
//        URL url = new URL(urlBuilder.toString());
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        conn.setRequestMethod("GET");
//        conn.setRequestProperty("Content-type", "application/json");
//        System.out.println("Response code: " + conn.getResponseCode());
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        JsonNode rootNode = objectMapper.readTree(conn.getInputStream());
//        JsonNode itemNode = rootNode.path("response").path("body").path("items").path("item");
//
//        for (JsonNode node : itemNode) {
//            weatherDTO.setCode(node.path("regId").asText());
//            weatherDTO.setD3StringTemp(node.path("wf3Pm").asText());
//            weatherDTO.setD4StringTemp(node.path("wf4Pm").asText());
//            weatherDTO.setD5StringTemp( node.path("wf5Pm").asText());
//                    weatherDTO.setD6StringTemp(node.path("wf6Pm").asText());
//                    weatherDTO.setD7StringTemp(node.path("wf7Pm").asText());
//
//        }
//        return  weatherDTO;
//    }
//
//}
//
