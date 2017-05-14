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
        
        List<Point> points = Service.prepareInputPoints();
        HashMap<Point, List<Point>> staleClusters;
        
        Configuration.configure();
        
        do {
            staleClusters = Configuration.clusters;
            Service.reassignCluster(points);
        } while(Service.hasCentroidsChangedPosition(staleClusters));
        
        P.logPoints(points);
        P.logCluster();
    }
}
