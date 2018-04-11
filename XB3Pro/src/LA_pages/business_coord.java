package LA_pages;

import java.util.*;
import java.io.*;

/**
 * Business ADT that stores the data for each business including, name, phone
 * number, address, industry tag and location.
 * 
 * @author Group 13
 *
 */
public class business_coord {

	private final String bus_name;
	private final String bus_number;
	private final String bus_address;
	private final String bus_tag;
	private final double bus_lat;
	private final double bus_long;
	private int bus_ID;
	public final static double AVERAGE_RAD_EARTH_KM = 6371.0;

	/**
	 * Constructor for a business_coord ADT
	 * 
	 * @param name
	 *            Name of the business
	 * @param number
	 *            The phone number of the business
	 * @param location
	 *            The address of the business
	 * @param tag
	 *            The industry tag of the business
	 * @param lat
	 *            The latitude of the business
	 * @param lon
	 *            The longitude of the business
	 */
	public business_coord(String name, String number, String location, String tag, double lat, double lon) {
		this.bus_name = name;
		this.bus_number = number;
		this.bus_address = location;
		this.bus_tag = tag;
		this.bus_lat = lat;
		this.bus_long = lon;
		this.bus_ID = -1;
	}

	/**
	 * Mutator for the business_ID, which is used for Graphing
	 * 
	 * @param id
	 *            The new value for the business ID
	 */
	public void set_ID(int id) {
		this.bus_ID = id;
	}

	/**
	 * Accessor for the ID of the business
	 * 
	 * @return The ID of the business
	 */
	public int get_ID() {
		return this.bus_ID;
	}

	/**
	 * Accessor for the latitude of the business
	 * 
	 * @return The latitude of the business
	 */
	public double get_lat() {
		return this.bus_lat;
	}

	/**
	 * Accessor for the longitude of the business
	 * 
	 * @return The longitude of the business
	 */
	public double get_long() {
		return this.bus_long;
	}

	/**
	 * Accessor for the industry tag of the business
	 * 
	 * @return The the tag of the business
	 */
	public String get_tag() {
		return this.bus_tag;
	}

	/**
	 * Accessor for the business name
	 * 
	 * @return The name of the business
	 */
	public String get_name() {
		return this.bus_name;
	}

	/**
	 * Accessor for the phone number of the business
	 * 
	 * @return The phone number of the business
	 */
	public String get_number() {
		return this.bus_number;
	}

	/**
	 * Accessor for the address of the business
	 * 
	 * @return The address of the business
	 */
	public String get_address() {
		return this.bus_address;
	}

	/**
	 * Print out the business
	 */
	public void printBusiness() {
		System.out.println("------------------------------------------------");
		System.out.println("Business Name : " + this.bus_name);
		System.out.println("Phone Number : " + this.bus_number);
		System.out.println("Address : " + this.bus_address);
		System.out.println("------------------------------------------------");
	}

	/**
	 * Print out the business, with a calculated distance from a given location
	 * 
	 * @param user_lat
	 *            The user's latitude
	 * @param user_long
	 *            The user's longitude
	 */
	public void printBusiness(double user_lat, double user_long) {
		System.out.println("------------------------------------------------");
		System.out.println("Business Name : " + this.bus_name);
		System.out.println("Phone Number : " + this.bus_number);
		System.out.println("Address : " + this.bus_address);
		System.out.println("Distance : " + calculateDist(user_lat, user_long) + " km.");
		System.out.println("------------------------------------------------");
	}

	/**
	 * Calculates the distance from the business to the user
	 * 
	 * @param userLat
	 *            User latitude for reference
	 * @param userLng
	 *            User longitude for reference
	 * @return The distance between the two locations, taking into account the
	 *         curvature of the earth by using the harversine formula
	 */
	public double calculateDist(double userLat, double userLng) {
		double latDistance = Math.toRadians(userLat - this.bus_lat);
		double lngDistance = Math.toRadians(userLng - this.bus_long);
		double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + Math.cos(Math.toRadians(userLat))
				* Math.cos(Math.toRadians(this.bus_lat)) * Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double dist = ((double) Math.round((AVERAGE_RAD_EARTH_KM * c * 100000d))) / 100000d;
		return dist;
	}
}
