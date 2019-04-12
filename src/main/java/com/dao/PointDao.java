package com.dao;

import com.domain.Location;

import java.util.ArrayList;

public interface PointDao {
    public ArrayList<Location> getPoint(String videoid);
}
