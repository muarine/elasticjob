package com.muarine.entity;

/**
 * 
 * LogApi. api执行Log
 * 
 * @author Muarine maoyun@rtmap.com
 * @date 2015年7月24日
 * @since 2.0
 */
public class LogApi extends BaseEntity{
	
	/** The serialVersionUID */
	private static final long serialVersionUID = 8733899713228846845L;
	private String ip;
    private String api;
    private String action;
    private String method;
    private Long running_time;
    
    
	public String getApi() {
		return api;
	}
	public void setApi(String api) {
		this.api = api;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public Long getRunning_time() {
		return running_time;
	}
	public void setRunning_time(Long running_time) {
		this.running_time = running_time;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
    
}