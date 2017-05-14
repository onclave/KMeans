/*
 * This repository / codebase is Open Source and free for use and rewrite.
 */
package io.onclave.kmeans.datastructure;

import io.onclave.kmeans.api.Configuration;

/**
 *
 * @author sajib
 */
public class Point {
    
    public Point() {
        this(-999f, -999f);
    }
    
    public Point(final String[] coordinates) {
        this(Float.parseFloat(coordinates[0]), Float.parseFloat(coordinates[1]));
    }
    
    public Point(final float x_coordinate, final float y_coordinate) {
        this(x_coordinate, y_coordinate, Long.toString(System.currentTimeMillis()) + "-" + Integer.toString(Configuration.generateRandomInt()));
    }
    
    public Point(final float x_coordinate, final float y_coordinate, final String id) {
        
        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;
        this.id = id;
    }
    
    private float x_coordinate;
    private float y_coordinate;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getX_coordinate() {
        return x_coordinate;
    }

    public void setX_coordinate(float x_coordinate) {
        this.x_coordinate = x_coordinate;
    }

    public float getY_coordinate() {
        return y_coordinate;
    }

    public void setY_coordinate(float y_coordinate) {
        this.y_coordinate = y_coordinate;
    }
    
    @Override
    public String toString() {
        return "[" + getX_coordinate() + "|" + getY_coordinate() + "]";
    }
}
