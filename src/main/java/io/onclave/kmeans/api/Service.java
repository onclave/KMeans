/*
 * This repository / codebase is Open Source and free for use and rewrite.
 */
package io.onclave.kmeans.api;

import io.onclave.kmeans.datastructure.Point;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author sajib
 */
public class Service {
    
    public static void reassignCluster(List<Point> points) {
         
        points.stream().forEach((Point point) -> {
            int position = 0;
            float[] distanceArray = new float[Configuration.getK()];
            Point[] pointsArray = new Point[Configuration.getK()];
            
            for(Point centroid : Configuration.clusters.keySet()) pointsArray[position++] = centroid;
            for(int i = 0; i < Configuration.getK(); i++) distanceArray[i] = Service.distance(point, pointsArray[i]);
            
            Configuration.clusters.get(pointsArray[Service.getMinValuePosition(distanceArray)]).add(point);
        });
        
        reassignCentroid();
    }
    
    public static void reassignCentroid() {
        
        Configuration.clusters.entrySet().stream().forEach((Map.Entry<Point, List<Point>> cluster) -> {
            float x = 0, y = 0;
            List<Point> points = cluster.getValue();
            if (points.size() > 0) {
                for(Point point : points) { x += point.getX_coordinate(); y += point.getY_coordinate(); }
                x = x / points.size(); y = y / points.size();
                cluster.getKey().setX_coordinate(x); cluster.getKey().setY_coordinate(y);
            }
        });
    }
    
    public static boolean hasCentroidsChangedPosition(final HashMap<Point, List<Point>> staleClusters) {
        return staleClusters.entrySet().stream().anyMatch((staleCluster) -> (Configuration.clusters.entrySet().stream().filter((cluster) -> (((Point) cluster.getKey()).getId().equals(((Point) staleCluster.getKey()).getId()))).anyMatch((cluster) -> ((((Point) cluster.getKey()).getX_coordinate() != ((Point) staleCluster.getKey()).getX_coordinate()) || (((Point) cluster.getKey()).getY_coordinate() != ((Point) staleCluster.getKey()).getY_coordinate())))));
    }
    
    public static List<Point> prepareInputPoints() throws FileNotFoundException, IOException {
        
        String read_point;
        FileReader fileReader = new FileReader(P.CLUSTER_INPUT_FILE);
        List<Point> points = new ArrayList<>();
        
        try(BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while((read_point = bufferedReader.readLine()) != null) {
                points.add(new Point(read_point.split(",")));
            }
        }
        
        return points;
    }
    
    public static float distance(final Point p1, final Point p2) {
        return Math.abs((float) Math.sqrt(Math.pow((p2.getX_coordinate() - p1.getX_coordinate()), 2) + Math.pow((p2.getY_coordinate() - p1.getY_coordinate()), 2)));
    }
    
    public static int getMinValuePosition(final float[] array) {
        
        float min = 999;
        int position = array.length - 1;
        
        for(int i = 0; i < array.length; i++) if(array[i] < min) {
            min = array[i]; position = i;
        }
        
        return position;
    }
}
