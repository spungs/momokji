package com.esc.momokji.controller;

import jakarta.servlet.http.HttpServletRequest;

public interface MainService {

    public void findTarget(double latitude, double longitude);


    public double[][] calculateCircleCoordinates(double longitude, double latitude, double radius);

}
