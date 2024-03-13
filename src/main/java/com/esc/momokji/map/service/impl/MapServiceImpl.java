package com.esc.momokji.map.service.impl;

import com.esc.momokji.map.service.MapService;
import org.springframework.stereotype.Service;

@Service
public class MapServiceImpl implements MapService {

    public static final double EARTH_RADIUS = 6371000; // 지구 반지름 (미터)

    @Override
    public void findTarget(double currentLatitude, double currentLongitude) {
        double radiusInMeters = 100; // 반경 (미터)

        double[][] coordinates = calculateCircleCoordinates(currentLongitude, currentLatitude, radiusInMeters);

        for (int i = 0; i < coordinates.length; i++) {
            double longitude = coordinates[i][0];
            double latitude = coordinates[i][1];
            System.out.println("경도: " + longitude + ", 위도: " + latitude);
        }
    }

    @Override
    public double[][] calculateCircleCoordinates(double longitude, double latitude, double radius) {
        int numberOfPoints = 360; // 원을 근사하기 위해 360개의 점을 생성
        double[][] coordinates = new double[numberOfPoints][2];

        for (int i = 0; i < numberOfPoints; i++) {
            double angle = Math.toRadians(i);
            double deltaLongitude = Math.toDegrees(radius / (EARTH_RADIUS * Math.cos(Math.toRadians(latitude))));
            double deltaLatitude = Math.toDegrees(radius / EARTH_RADIUS);

            double newLongitude = longitude + deltaLongitude * Math.cos(angle);
            double newLatitude = latitude + deltaLatitude * Math.sin(angle);

            coordinates[i][0] = newLongitude;
            coordinates[i][1] = newLatitude;
        }

        return coordinates;
    }
}
