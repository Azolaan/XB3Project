/**
 * @author Group 13
 * mergesort implementation for sorting by distance from user location
 */
package LA_pages;

public class Sort_coord {
	
	private static business_coord[] aux;
	
	/**
	 * merge function
	 * @param userLat - user latitude
	 * @param userLng - user longitude
	 * @param a - array of businesses
	 * @param lo - low index
	 * @param mid - mid index
	 * @param hi - high index
	 */
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
	
	/**
	 * recursive mergesort
	 * @param userLat - user latitude
	 * @param userLng - user longitude
	 * @param x - array of businesses
	 * @param lo - low index
	 * @param hi - high index
	 */
	public static void sortMerge (double userLat, double userLng, business_coord[] x, int lo, int hi ) {
		if (hi <= lo)
			return;
		int mid= lo + (hi-lo)/2;
		sortMerge(userLat, userLng, x, lo, mid);
		sortMerge(userLat, userLng, x, mid + 1, hi);
		merge(userLat, userLng, x, lo, mid, hi);
	}
	
	/**
	 * calls mergesort
	 * @param userLat - user latitude
	 * @param userLng - user longitude
	 * @param a - array of businesses
	 */
	public static void sort(double userLat, double userLng, business_coord[] a) {
		aux = new business_coord[a.length];
		sortMerge(userLat, userLng, a, 0, a.length - 1);
	}
	
	/**
	 * Compare two businesses and return the closest to the user
	 * @param userLat - user latitude
	 * @param userLng - user longitude
	 * @param a - first business
	 * @param b - second business
	 * @return closest business
	 */
	private static int Compare(double userLat, double userLng, business_coord a, business_coord b) {
		if (a.calculateDist(userLat, userLng) < b.calculateDist(userLat, userLng))
			return -1;
		else if (a.calculateDist(userLat, userLng) > b.calculateDist(userLat, userLng))
			return 1;
		return 0;
	}
	
	/**
	 * true if business a is less than business b
	 * @param userLat - user latitude
	 * @param userLng - user longitude
	 * @param a - business a
	 * @param b - business b
	 * @return boolean
	 */
	private static boolean less(double userLat, double userLng, business_coord a, business_coord b) {
		return (Compare(userLat, userLng, a, b) < 0);
	}
}
