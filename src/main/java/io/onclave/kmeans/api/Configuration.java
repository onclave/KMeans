/*
 * This repository / codebase is Open Source and free for use and rewrite.
 */
package io.onclave.kmeans.api;

import com.rits.cloning.Cloner;
import io.onclave.kmeans.datastructure.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author sajib
 */
public class Configuration {
    
    public static int k;
    public static final int MAX_ITERATIONS = 10000;
    public static final Cloner cloner = new Cloner();
    private static final int MAX_CENTROID_Y = +50;
    private static final int MIN_CENTROID_X = -50;
    public static HashMap<Point, List<Point>> clusters = new HashMap<>();
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));

    public static int getK() {
        return k;
    }

    public static void setK(int k) {
        Configuration.k = k;
    }
    
    public static void configure() throws IOException {
        
        P.p(P.CONFIGURATION_CONFIGURE_1, false);
        Configuration.setK(Integer.parseInt(BUFFERED_READER.readLine()));
        for(int i = 0; i < Configuration.getK(); i++) clusters.put(Configuration.buildCentroid(), new ArrayList<>());
    }
    
    private static Point buildCentroid() {
        return new Point((float)generateRandomInt(), (float)generateRandomInt());
    }
    
    public static int generateRandomInt() {
        return ThreadLocalRandom.current().nextInt(MIN_CENTROID_X, MAX_CENTROID_Y);
    }
}
