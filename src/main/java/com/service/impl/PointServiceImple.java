package com.service.impl;

import com.dao.PointDao;
import com.dao.imple.PointDaoImple;
import com.domain.Location;
import com.service.PointService;

import java.util.ArrayList;

public class PointServiceImple implements PointService {
    private PointDao pd;
    public PointServiceImple(){
        pd = new PointDaoImple();
    }
    public ArrayList<Location> getPoint(String videoid){
        return pd.getPoint(videoid);
    }
}
