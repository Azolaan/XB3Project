package LA_pages;

public class Sort {
	
	public static void merge(business[] a, business[] aux, int lo, int mid, int hi) {
		int i = lo, j = mid+1;
				
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		
		for (int k = lo; k <= hi; k++) {
			if (i > mid) 
				a[k] = aux[j++];
			else if (j > hi) 
				a[k] = aux[i++];
			else if (less(aux[j], aux[i]))
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
		}
	}
	
	public static void sortMerge ( business[] x, int n ) {
		business[] aux = new business[n];
		for (int sz = 1; sz < n; sz = sz+sz)
			for (int lo = 0; lo < n-sz; lo += sz+sz) {
				merge(x, aux, lo, lo+sz-1, Math.min(lo+sz+sz-1, n-1));
			}
	}
}
