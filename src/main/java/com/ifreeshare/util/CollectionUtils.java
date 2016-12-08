package com.ifreeshare.util;

import java.util.Iterator;
import java.util.Map;

public class CollectionUtils {
	
	/**
	 * Get Key from Value
	 * @param map Need to query the Map
	 * @param value   Need to query the value of the map
	 * @return  the key of the value
	 */
	public static <T> T getValueByKey(Map<T, Object> map, Object value ){
		Iterator<T> it = map.keySet().iterator();
		while (it.hasNext()) {
			T  key  =  it.next();
			Object mValue = map.get(key);
			if( mValue == value){
				return key;
			}
		}
		return null;
		
	}

}
