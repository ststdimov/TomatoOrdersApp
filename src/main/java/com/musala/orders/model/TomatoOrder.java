package com.musala.orders.model;


public class TomatoOrder {
	
	private String id;
	private int tomatoes;
	private String provider;
	private long timestamp;
	
	public TomatoOrder() {
		
	}
	
	public TomatoOrder(String id, int tomatoes, String provider, long timestamp) {
		this.id = id;
		this.tomatoes = tomatoes;
		this.provider = provider;
		this.timestamp = timestamp;
	}
	
	public String getId() {
		return id;
	}
	
	/**
	 * @param id Should be valid UUID string
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * @return int Returned value is measured in kilograms
	 */
	public int getTomatoes() {
		return tomatoes;
	}
	
	/**
	 * @param tomatoes Tomatoes amount (in kilograms) 
	 * should be greater than 0 and not greater than 2000
	 */
	public void setTomatoes(int tomatoes) {
		this.tomatoes = tomatoes;
	}
	
	public String getProvider() {
		return provider;
	}
	
	/**
	 * @param provider Provider to set should be one
	 * from the following list of providers: 
	 * "Heinz", "Hunt's", "Del Monte", "Le Ol' Granma"
	 */
	public void setProvider(String provider) {
		this.provider = provider;
	}
	
	/**
	 * @return long Returned timestamp is measured in milliseconds
	 */
	public long getTimestamp() {
		return timestamp;
	}
	
	/**
	 * @param timestamp Timestamp (in milliseconds) should be in
	 * the interval defined by the start of the year and the 
	 * current time
	 */
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "TomatoOrder [id=" + id + ", tomatoes=" + tomatoes + ", provider=" + provider + ", timestamp="
				+ timestamp + "]";
	}
}
