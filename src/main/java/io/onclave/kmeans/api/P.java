/*
 * This repository / codebase is Open Source and free for use and rewrite.
 */
package io.onclave.kmeans.api;

import io.onclave.kmeans.datastructure.Point;
import java.util.List;
import java.util.Map;

/**
 *
 * @author sajib
 */
public class P {
    
    public static final String CLUSTER_INPUT_FILE = "kmeans_input.txt";
    public static final String BLANK_STRING = "";
    public static final String CONFIGURATION_CONFIGURE_1 = "\n\n|--------K-MEANS--------|\n\nEnter number of centroids to introduce (value of K): ";
    public static final String LOG_CLUSTER_1 = "----------------CENTROID : ";
    public static final String LOG_CLUSTER_2 = "----------------";
    
    public static void p(final String string) {
        p(string, true);
    }

    public static void p(final String string, final boolean newLine) {
        if(newLine) System.out.println(string); else System.out.print(string);
    }
    
    public static void logCluster() {
        
        Configuration.clusters.entrySet().stream().map((Map.Entry<Point, List<Point>> pair) -> {
            p(LOG_CLUSTER_1 + ((Point) pair.getKey()).toString() + LOG_CLUSTER_2);
            return pair;
        }).forEach((pair) -> {
            ((List<Point>) pair.getValue()).stream().forEach((point) -> { p(point.toString()); });
        });
    }
    
    public static void logPoints(List<Point> points) {
        p("\n\nAll points : ", false);
        points.stream().forEach((point) -> { p(point.toString(), false); }); p("\n\n");
    }
}
