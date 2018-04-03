package geocoder;

import java.util.Map;

import org.apache.log4j.BasicConfigurator;

public class GetCoordinates {

    static String address = "Los Angeles, CA 90095";

    public static void main(String[] args) {
        Map<String, Double> coords;
        coords = OpenStreetMapUtils.getInstance().getCoordinates(address);
        System.out.println("latitude :" + coords.get("lat"));
        System.out.println("longitude:" + coords.get("lon"));
    }
}
