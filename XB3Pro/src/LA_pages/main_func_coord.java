package LA_pages;
import java.sql.*;
import java.util.Arrays;
import java.util.Map;

import geocoder.OpenStreetMapUtils;

public class main_func_coord {
	
	public static double user_long;
	public static double user_lat;
	
	public static void main(String[] args) throws SQLException {
		
		// takes user tag preference for industry, can be more than one
		System.out.println("Enter business tag of choice : ");
		String user_tag = args[0];
		
		String user_tag2 = args[1];
		
		// takes business name to prioritize businesses that match the name
		System.out.println("Enter business name (optional, enter 0 if no preference))");
		String user_name = args[2];
		
		String user_loc = args[3];
		System.out.println(user_loc);
		
		//address to lon and lat coordinates
		Map<String, Double> coords;
		coords = OpenStreetMapUtils.getInstance().getCoordinates(user_loc);
		user_long = coords.get("lon");
		user_lat = coords.get("lat");
		
		// establish connection
		Connection con = DatabaseConnection_coord.Initialize("jdbc:mysql://127.0.0.1:3306/business_schema", "root", "120800");
		business_coord[] filtered = DatabaseConnection_coord.IndustryFilter(con, user_tag);
		Sort_coord.sort(user_lat, user_long, filtered);

		// 1 tag and specific business name
		if (!user_name.equals("0") && user_tag2.equals("0")) {
			int[] name_index = name_search.search(user_name, filtered);
		
			print_name_searched(name_index, filtered);
			print(name_index, filtered);
		}
		else if (!user_tag2.equals("0")) {
			business_coord[] filtered2 = DatabaseConnection_coord.IndustryFilter(con, user_tag2);
			Sort_coord.sort(user_lat, user_long, filtered2);
			if (filtered.length < 2 || filtered2.length < 2) {
				System.out.println("NOT ENOUGH MATCHING INDUSTRY TAGS");
				
			}
			else {
				business_coord [] for_graph = new business_coord [6];
				for_graph[0] = new business_coord("src", "", "","",user_lat, user_long);
				for_graph[5] = new business_coord("","","","",0,0);
				for(int i = 0; i < 2; i++) {
					for_graph[i+1] = filtered[i];
					for_graph[i+3] = filtered2[i];
				}
				for (int i = 0; i < 6; i ++)
					for_graph[i].set_ID(i);
				EdgeWeightedDigraph G = new EdgeWeightedDigraph(6);
				// src to A
				for (int i = 1; i < 3; i ++) {
					G.addEdge(new DirectedEdge(for_graph[0],for_graph[i], for_graph[0].calculateDist(for_graph[i].get_lat(), for_graph[i].get_long())));
				}
				// A to B
				for (int i = 0; i < 2; i ++)
					for (int j = 0; j < 2; j++)
					G.addEdge(new DirectedEdge(for_graph[i+1], for_graph[j+3], for_graph[0].calculateDist(for_graph[i+1].get_lat(), for_graph[j+3].get_long())));
				// B to Dummy
				for (int i = 0; i < 2; i++)
					G.addEdge(new DirectedEdge(for_graph[3+i], for_graph[5], 50));
				DijkstraSP spPath = new DijkstraSP(G, for_graph[0]);
				Iterable<DirectedEdge> spPath2 = spPath.pathTo(for_graph[5]);
				printSP(spPath2);
			}
		}
		// tag and no specific business name
		else {
			print_tag(filtered);
		}
	}
	
	public static void print(int[] index, business_coord[] filtered) {
		System.out.println("------------MATCHING INDUSTRY TAG---------------");
		int marker = 0;
		for (int e = 0; e < filtered.length; e++) {
			if (e != index[marker] || index[marker] == -1)
				filtered[e].printBusiness(user_lat, user_long);
			else
				marker++;
		}
		System.out.println("------------------------------------------------");
	}
	
	public static void print_tag(business_coord[] filtered) {
		System.out.println("------------MATCHING INDUSTRY TAG---------------");
		for (int e = 0; e < filtered.length; e++) {
			filtered[e].printBusiness(user_lat, user_long);
		}
		System.out.println("------------------------------------------------");
	}
	
	public static void print_name_searched(int[] index, business_coord[] filtered) {
		System.out.println("------------MATCHING BUSINESS NAMES-------------");
		for (int i = 0; i < index.length; i++) {
			if (index[i] != -1)
				filtered[index[i]].printBusiness(user_lat, user_long);
		}
	}
	
	public static void printSP(Iterable<DirectedEdge> path) {
		System.out.println("------------SHORTEST PATH-------------");
		for(DirectedEdge x : path) {
			System.out.println(x.from().get_name());
		}
	}
}