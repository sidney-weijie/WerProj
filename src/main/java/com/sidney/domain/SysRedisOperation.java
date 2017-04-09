package com.sidney.domain;

import java.io.Serializable;
import java.util.Date;

public class SysRedisOperation implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5868433150818481161L;
	private Long id;
	private String redisKey;
	private Date inputtime;
	private String operation;
	private String operator;
	private Long ttlMinutes;
	private String redisValue;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRedisKey() {
		return redisKey;
	}
	public void setRedisKey(String redisKey) {
		this.redisKey = redisKey;
	}
	public Date getInputtime() {
		return inputtime;
	}
	public void setInputtime(Date inputtime) {
		this.inputtime = inputtime;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public Long getTtlMinutes() {
		return ttlMinutes;
	}
	public void setTtlMinutes(Long ttlMinutes) {
		this.ttlMinutes = ttlMinutes;
	}
	public String getRedisValue() {
		return redisValue;
	}
	public void setRedisValue(String redisValue) {
		this.redisValue = redisValue;
	}
	
	
}
