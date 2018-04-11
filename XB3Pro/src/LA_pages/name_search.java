/**
 * @author Group 13
 * searches for a substring in the business name within an array of businesses
 */
package LA_pages;

public class name_search {

	/**
	 * Search function
	 * @param name - Name of the business
	 * @param businesses - Array of businesses
	 * @return - first 5 matching businesses
	 */
	public static int[] search(String name, business_coord[] businesses) {
		int[] INDEX = new int[] {-1, -1, -1, -1, -1};
		
		int count = 0;
		for (int i=0; i < businesses.length; i++) {
			
			if (businesses[i].get_name() != null && businesses[i].get_name().contains(name.toUpperCase())) {
				INDEX[count] = i;
				count++;
				if (count >= 4)
					break;
			}
		}
		
		return INDEX;
	}
}
