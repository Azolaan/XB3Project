public class DistanceFormula {
    public final static double AVERAGE_RAD_EARTH_KM = 6371;
    public static double calculateDist(double userLat, double userLng, double venueLat, double venueLng) {

        double latDistance = Math.toRadians(userLat - venueLat);
        double lngDistance = Math.toRadians(userLng - venueLng);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
        + Math.cos(Math.toRadians(userLat)) * Math.cos(Math.toRadians(venueLat))
        * Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double dist = ((double)Math.round((AVERAGE_RAD_EARTH_KM * c * 100000d)))/100000d; 
        return  dist;
    }

    }