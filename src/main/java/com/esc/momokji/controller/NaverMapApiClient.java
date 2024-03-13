package com.esc.momokji.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Component
public class NaverMapApiClient {
    @Value("${naver.map.client.id}")
    private String CLIENT_ID;
    @Value("${naver.map.client.secret}")
    private String CLIENT_SECRET;
    private final String NAVER_MAP_API_URL = "https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode";
    private final String NAVER_SEARCH_API_URL = "https://openapi.naver.com/v1/search/local.json";

    public String getGeocode(String query) throws Exception {
//        String apiURL = NAVER_MAP_API_URL + "?query=" + query; // 400 bad request error 발생
//        String apiURL = NAVER_MAP_API_URL + "?query=" + URLEncoder.encode(query, "utf-8")
//                + "&display=5"; // 200
//        String apiURL = NAVER_MAP_API_URL + "?coordinate=" + query; // 200

        String encodedQuery = null;
        try {
            encodedQuery = URLEncoder.encode(query, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("검색어 인코딩 실패",e);
        }
//        String encodedLocation = URLEncoder.encode(location, "UTF-8");

//        String apiURL = NAVER_SEARCH_API_URL + "?query=" + encodedQuery;
        String apiURL = NAVER_SEARCH_API_URL + "?query=" + encodedQuery + "&start=1&display=5&sort=random";

        Map<String, String> requestHeaders = new HashMap<>();
//        requestHeaders.put("X-NCP-APIGW-API-KEY-ID", CLIENT_ID);
//        requestHeaders.put("X-NCP-APIGW-API-KEY", CLIENT_SECRET);
        requestHeaders.put("X-Naver-Client-Id", CLIENT_ID);
        requestHeaders.put("X-Naver-Client-Secret", CLIENT_SECRET);
        String responseBody = get(apiURL,requestHeaders);

        return responseBody;

//        HttpURLConnection connection = null;
//        BufferedReader reader = null;

//        try {
//            URL apiUrl = new URL(apiURL);
//            connection = (HttpURLConnection) apiUrl.openConnection();
//            connection.setRequestMethod("GET");
//            connection.setRequestProperty("X-NCP-APIGW-API-KEY-ID", CLIENT_ID);
//            connection.setRequestProperty("X-NCP-APIGW-API-KEY", CLIENT_SECRET);
//
//            int responseCode = connection.getResponseCode();
//            if (responseCode == HttpURLConnection.HTTP_OK) {
//                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//                String inputLine;
//                StringBuilder response = new StringBuilder();
//
//                while ((inputLine = in.readLine()) != null) {
//                    response.append(inputLine);
//                }
//                in.close();
//
//                return response.toString();
//            } else {
//                throw new RuntimeException("HTTP GET Request Failed with Error code: " + responseCode);
//            }
//        } finally {
//            if(reader != null) {
//                try {
//                    reader.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//            if(connection != null) {
//                connection.disconnect();
//            }
//        }
    }

    private static String get(String apiUrl, Map<String, String> requestHeaders){
        HttpURLConnection con = connect(apiUrl);
        try {
            con.setRequestMethod("GET");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }


            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
                return readBody(con.getInputStream());
            } else { // 오류 발생
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
    }

    private static HttpURLConnection connect(String apiUrl){
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection)url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }


    private static String readBody(InputStream body){
        InputStreamReader streamReader = new InputStreamReader(body);


        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();


            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }


            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는 데 실패했습니다.", e);
        }
    }
}

