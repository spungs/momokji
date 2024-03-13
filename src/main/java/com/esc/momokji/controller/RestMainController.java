package com.esc.momokji.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Log4j2
@RestController
public class RestMainController {

    private final NaverMapApiClient naverMapApiClient;

    public RestMainController(NaverMapApiClient naverMapApiClient) {
        this.naverMapApiClient = naverMapApiClient;
    }

    @Autowired
    MainServiceImpl service;

    /**
     * 사용자 근처 가게들 목록을 반환
     * @return
     */
    @ResponseBody
    @PostMapping(value = "getNearStore", produces = "application/json")
    public HashMap getNearStore(@RequestBody Map<String, Object> position) {
        log.debug("@@@@position: " + position);

        double latitude = (double) position.get("latitude");
        double longitude = (double) position.get("longitude");
        log.debug("@@@@latitude: " + latitude);
        log.debug("@@@@longitude: " + longitude);
//        service.findTarget(latitude, longitude);



        HashMap<String, ArrayList> nearStores = null;
        return nearStores;
    }

    @GetMapping("/geocode")
    public String getGeocode(String query) {
        try {
            return naverMapApiClient.getGeocode(query);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while fetching geocode.";
        }
    }

}
