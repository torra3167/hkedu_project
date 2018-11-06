package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Aca implements Serializable {
	private int anum;
	private String aname;
	
	
	public int getAnum() {
		return anum;
	}
	public void setAnum(int anum) {
		this.anum = anum;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	
	
}
