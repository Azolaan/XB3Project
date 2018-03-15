package LA_pages;

public class Sort {
	
	public final static double AVERAGE_RADIUS_OF_EARTH_KM = 6371;
	
	public static void merge(double userLat, double userLng, business[] a, business[] aux, int lo, int mid, int hi) {
		int i = lo, j = mid+1;
				
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		
		for (int k = lo; k <= hi; k++) {
			if (i > mid) 
				a[k] = aux[j++];
			else if (j > hi) 
				a[k] = aux[i++];
			else if (less(userLat, userLng, aux[j], aux[i]))
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
		}
	}
	
	public static void sortMerge (double userLan, double userLng, business[] x, int n ) {
		business[] aux = new business[n];
		for (int sz = 1; sz < n; sz = sz+sz)
			for (int lo = 0; lo < n-sz; lo += sz+sz) {
				merge(userLan, userLng, x, aux, lo, lo+sz-1, Math.min(lo+sz+sz-1, n-1));
			}
	}
	
	private static int Compare(double userLat, double userLng, business a, business b) {
		if (calculateDist(userLat, userLng, a.get_lat, a.get_lon) < calculateDist(userLat, userLng, b.get_lat, b.get_lon))
			return -1;
		else if (calculateDist(userLat, userLng, a.get_lat, a.get_lon) > calculateDist(userLat, userLng, b.get_lat, b.get_lon))
			return 1;
		return 0;
	}
	
	private static boolean less(double userLat, double userLng, business a, business b) {
		return (Compare(userLat, userLng, a, b) < 0);
	}
	    
	public static double calculateDist(double userLat, double userLng, double venueLat, double venueLng) {

	double latDistance = Math.toRadians(userLat - venueLat);
	double lngDistance = Math.toRadians(userLng - venueLng);

	double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
	+ Math.cos(Math.toRadians(userLat)) * Math.cos(Math.toRadians(venueLat))
	* Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2);

	double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

	return AVERAGE_RADIUS_OF_EARTH_KM * c/100.0;
	}
	
	
}
