package org.zucc.entity;

import java.util.Date;

public class Dvd implements Comparable<Dvd>{

	private int id;
	private String name;
	private int state;// 1½è³ö 0Î´½è³ö
	private Date borrowdate;
	private Date returndate;
	private int dvdcount;
	

	public int getDvdcount() {
		return dvdcount;
	}

	public void setDvdcount(int dvdcount) {
		this.dvdcount = dvdcount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Date getBorrowdate() {
		return borrowdate;
	}

	public void setBorrowdate(Date borrowdate) {
		this.borrowdate = borrowdate;
	}

	public Date getReturndate() {
		return returndate;
	}

	public void setReturndate(Date returndate) {
		this.returndate = returndate;
	}

	@Override
	public String toString() {
		return   id + "\t    " + borrowdate + "\t " + dvdcount
				+ "\t\t  " + name + "\t\t"
				+ returndate + "\t\t " + state ;
	}

	@Override
	public int compareTo(Dvd d) {
		// TODO Auto-generated method stub
		
		return d.getDvdcount()-this.getDvdcount();
	}

	

	
}
