package lapages;

import java.util.Scanner;
import java.io.*;

public class test_reader{

    public static void main(String[] args) throws IOException {
    	File f = new File("data/testlist.csv");
    	BufferedReader r = new BufferedReader(new FileReader(f));
    	String labels = r.readLine();
    	String line = r.readLine();
    	String linesplit [];
    	String bus_name;
    	String bus_number;
    	String loc_address;
    	String bus_genre;
    	double loc_long;
    	double loc_lat;
    	while(line != null) {
        	linesplit = line.split(",");
        	for (int i = 0; i < linesplit.length; i ++)
        		System.out.print(i +": "+linesplit[i] + "|");
        	System.out.println();
        	if (linesplit.length != 17) {
        		String [] temp = new String [17];
        		int count = 0;
        		for (int i = 0; i < 12; i++) {
        			temp[i] = linesplit[i];
	        		count ++;
	        	}
        		for (int i = 0; i < (linesplit.length - 16) - 1; i++) {
        			temp[11] += "," + linesplit[12+i];
        			count++;
        		}
        		for (int i = 0; i < 5; i++) {
        			temp[12+i] = linesplit[count];
        			count++;
        		}
        		linesplit = temp;
        		if (linesplit[2].contains("LLC") || linesplit[2].contains("INC")) {
        			temp[1] = linesplit[1] + linesplit[2];
        			for (int i = 0; i < 8; i++) {
        				linesplit[i+2] = linesplit[i+3];
        			}
        			String [] eleven = linesplit[11].split(",");
        			linesplit[10] = eleven[0];
        			linesplit[11] = eleven[1];
        		}
        	}

        	for (int i = 0; i < linesplit.length; i ++)
        		System.out.print(i +": "+linesplit[i] + "|");
        	System.out.println();
        	if (linesplit[2] == "")
        		bus_name = linesplit[1];
        	else
        		bus_name = linesplit[2];
        	System.out.println(linesplit[11]);
        	bus_number = linesplit[5];
        	loc_address = linesplit[3];
        	bus_genre = linesplit[11]; 
        	loc_long =  Double.parseDouble(linesplit[15].substring(2));
        	loc_lat = Double.parseDouble(linesplit[16].substring(0,linesplit[16].length()-2));
        	business temp_bus = new business(bus_name, bus_number, loc_address, bus_genre, loc_long, loc_lat);
        	line = r.readLine();
    	}
    }

}