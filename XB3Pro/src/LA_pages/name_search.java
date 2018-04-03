package LA_pages;

public class name_search {

	public static int[] search(String name, business_coord[] businesses) {
		int[] INDEX = new int[] {-1, -1, -1, -1, -1};
		
		int count = 0;
		for (int i=0; i < businesses.length; i++) {
			//System.out.println(businesses[i].get_name());
			if (businesses[i].get_name() != null && businesses[i].get_name().contains(name.toUpperCase())) {
				//System.out.println(count);
				INDEX[count] = i;
				count++;
				if (count >= 4)
					break;
			}
		}
		
		return INDEX;
	}
}
