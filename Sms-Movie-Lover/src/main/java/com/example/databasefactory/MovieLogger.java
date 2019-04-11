package com.example.databasefactory;

import java.util.HashMap;

public class MovieLogger {
	private HashMap<String, String> hashMap = new HashMap<>();
	public final static String TABLE = "table";
	public final static String CODE = "code";
	public final static String 	EXCEPTION = "exception";
	
	public void addMessage(String key, String value) {
		hashMap.put(key, value);
	}
	public void addTable(String value) {
		addMessage(TABLE, value);
	}
	public void addCode(String value) {
		addMessage(CODE, value);
	}
	public void addEXCEPTION(String value) {
		addMessage(EXCEPTION, value);
	}
	/**
	 * @return the hashMap
	 */
	public HashMap<String, String> getHashMap() {
		return hashMap;
	}
	/**
	 * @return the table
	 */
	public static String getTable() {
		return TABLE;
	}
	/**
	 * @return the code
	 */
	public static String getCode() {
		return CODE;
	}
	/**
	 * @return the exception
	 */
	public static String getException() {
		return EXCEPTION;
	}
	/**
	 * @param hashMap the hashMap to set
	 */
	public void setHashMap(HashMap<String, String> hashMap) {
		this.hashMap = hashMap;
	}
}
