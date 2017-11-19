package com.musala.orders.model;

public class TomatoOrder {
	
	private String id;
	private int tomatoes;
	private String provider;
	private long timestamp;
	
	public TomatoOrder() {
		
	}
	
	public TomatoOrder(String id, int tomatoes, String provider, long timestamp) {
		super();
		this.id = id;
		this.tomatoes = tomatoes;
		this.provider = provider;
		this.timestamp = timestamp;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public int getTomatoes() {
		return tomatoes;
	}
	
	public void setTomatoes(int tomatoes) {
		this.tomatoes = tomatoes;
	}
	
	public String getProvider() {
		return provider;
	}
	
	public void setProvider(String provider) {
		this.provider = provider;
	}
	
	public long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "TomatoOrder [id=" + id + ", tomatoes=" + tomatoes + ", provider=" + provider + ", timestamp="
				+ timestamp + "]";
	}
}
