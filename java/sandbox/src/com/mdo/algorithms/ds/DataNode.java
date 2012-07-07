package com.mdo.algorithms.ds;

public class DataNode implements Comparable{
	
	private String name;
	private Object data;
	
	public DataNode(String name, Object data) {
		this.name = name;
		this.data = data;
	}
	
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + name.hashCode();
		hash = 31 * hash + (null == data ? 0 : data.hashCode());
		return hash;
	}
	
	public boolean equals(Object other) {
		// if the references are equal, then just return true
		if (this == other) return true;
		
		// must be in the same class and not null
		if (other == null || (other.getClass() != this.getClass())) {
			return false;
		}
		
		DataNode node = (DataNode)other;
		return (name.equals(node.name));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public int compareTo(Object other) {
		if (other == null || (other.getClass() != this.getClass())) 
			return 1;
		
		if (name == null) return -1;
		DataNode node = (DataNode)other;
		
		return name.compareTo(node.name);
	}
	
	
}
