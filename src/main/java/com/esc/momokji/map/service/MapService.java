package com.esc.momokji.map.service;

public interface MapService {

    public void findTarget(double latitude, double longitude);


    public double[][] calculateCircleCoordinates(double longitude, double latitude, double radius);

}
