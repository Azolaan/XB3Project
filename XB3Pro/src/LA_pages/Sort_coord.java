package LA_pages;

public class Sort_coord {
	
	public final static double AVERAGE_RADIUS_OF_EARTH_KM = 6371;
	
	private static business_coord[] aux;
	
	public static void merge(double userLat, double userLng, business_coord[] a, int lo, int mid, int hi) {
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
	
	public static void sortMerge (double userLat, double userLng, business_coord[] x, int lo, int hi ) {
		if (hi <= lo)
			return;
		int mid= lo + (hi-lo)/2;
		sortMerge(userLat, userLng, x, lo, mid);
		sortMerge(userLat, userLng, x, mid + 1, hi);
		merge(userLat, userLng, x, lo, mid, hi);
	}
	
	public static void sort(double userLat, double userLng, business_coord[] a) {
		aux = new business_coord[a.length];
		sortMerge(userLat, userLng, a, 0, a.length - 1);
	}
	
	private static int Compare(double userLat, double userLng, business_coord a, business_coord b) {
		if (a.calculateDist(userLat, userLng) < b.calculateDist(userLat, userLng))
			return -1;
		else if (a.calculateDist(userLat, userLng) > b.calculateDist(userLat, userLng))
			return 1;
		return 0;
	}
	
	private static boolean less(double userLat, double userLng, business_coord a, business_coord b) {
		return (Compare(userLat, userLng, a, b) < 0);
	}
}
