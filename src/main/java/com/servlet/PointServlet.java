package com.servlet;

import com.domain.Location;
import com.service.PointService;
import com.service.impl.PointServiceImple;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "PointServlet")
public class PointServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PointService ps = new PointServiceImple();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        ArrayList<Location> point = new ArrayList<Location>();
        point = ps.getPoint(request.getParameter("videoid"));
        String x = "";
        String y = "";
        for(int i = 0;i<point.size();i++){
            x=x+point.get(i).getX()+",";
            y=y+point.get(i).getY()+",";
        }
        String re = "{\"X\":\""+x+"\",\"Y\":\""+y+"\"}";
        out.write(re);




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
