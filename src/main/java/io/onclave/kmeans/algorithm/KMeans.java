/*
 * This repository / codebase is Open Source and free for use and rewrite.
 */
package io.onclave.kmeans.algorithm;

import io.onclave.kmeans.api.Configuration;
import io.onclave.kmeans.api.P;
import io.onclave.kmeans.api.Service;
import io.onclave.kmeans.datastructure.Point;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author sajib
 */
public class KMeans {
    
    public static void main(String[] args) throws IOException {
        
        int iteration = 0;
        List<Point> points = Service.prepareInputPoints();
        HashMap<Point, List<Point>> staleClusters;
        
        Configuration.configure();
        
        do {
            P.p("Pass : " + iteration + " | ", false);
            staleClusters = Configuration.cloner.deepClone(Configuration.clusters);
            Service.reassignCluster(points);
        } while(Service.hasCentroidsChangedPosition(staleClusters) && ++iteration < Configuration.MAX_ITERATIONS);
        
        P.logPoints(points);
        P.logCluster();
    }
}
