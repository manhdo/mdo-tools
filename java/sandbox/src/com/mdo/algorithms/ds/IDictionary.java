package com.mdo.algorithms.ds;

public interface IDictionary {
	void add(String key, Object data);
	void delete(String key);
	Object get(String key);
}
