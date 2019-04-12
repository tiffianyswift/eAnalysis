package com.dao.imple;

import java.sql.*;
import java.util.ArrayList;

import com.dao.PointDao;
import com.domain.Location;

public class PointDaoImple implements PointDao {
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/legend?&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    String username = "root";
    String password = "19990609";
    public ArrayList<Location> getPoint(String videoid){
        ArrayList<Location> points = new ArrayList<Location>();
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            String sql = "select x,y from "+videoid+"";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                int x = rs.getInt(1);
                int y = rs.getInt(2);
                points.add(new Location(x,y));
            }
            stmt.close();
            conn.close();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return points;

    }
}
