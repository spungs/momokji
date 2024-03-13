package com.esc.momokji.map.controller;

import com.esc.momokji.api.NaverMapApiClient;
import com.esc.momokji.map.service.impl.MapServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Log4j2
@RestController
public class RestMapController {

    private final NaverMapApiClient naverMapApiClient;

    public RestMapController(NaverMapApiClient naverMapApiClient) {
        this.naverMapApiClient = naverMapApiClient;
    }

    @Autowired
    MapServiceImpl service;

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
