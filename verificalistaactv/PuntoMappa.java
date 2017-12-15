/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificalistaactv;

/**
 *
 * @author David
 */
public class PuntoMappa {
    private String stopID;
    private String stopName;
    private double stopLat;
    private double stopLon;

    public PuntoMappa(String stopID, String stopName, double stopLat, double stopLon) {
        this.stopID = stopID;
        this.stopName = stopName;
        this.stopLat = stopLat;
        this.stopLon = stopLon;
    }
    public PuntoMappa(){}

    public double distanza(double x,double y){
        return Math.sqrt((stopLat-x)*(stopLat-x) + (stopLon-y)*(stopLon-y));
    }
    
    public String getStopID() {
        return stopID;
    }

    public void setStopID(String stopID) {
        this.stopID = stopID;
    }

    public String getStopName() {
        return stopName;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    public double getStopLat() {
        return stopLat;
    }

    public void setStopLat(double stopLat) {
        this.stopLat = stopLat;
    }

    public double getStopLon() {
        return stopLon;
    }

    public void setStopLon(double stopLon) {
        this.stopLon = stopLon;
    }

    @Override
    public String toString() {
        return "Sei vicino a : " + "stopID=" + stopID + ", stopName=" + stopName + ", stopLat=" + stopLat + ", stopLon=" + stopLon;
    }
    
}
