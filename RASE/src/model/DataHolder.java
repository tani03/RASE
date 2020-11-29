package model;

import java.util.HashMap;
import java.util.Map;

public class DataHolder {
	Map<String,User> data;

	public DataHolder(){
		data = new HashMap<>();
	}
	
	public Map<String, User> getDataHolder() {
		return data;
	}

	public void setDataHolder(Map<String, User> dataHolder) {
		this.data = dataHolder;
	}
}