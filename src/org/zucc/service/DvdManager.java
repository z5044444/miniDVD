package org.zucc.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.zucc.dao.DvdDao;
import org.zucc.entity.Dvd;

public class DvdManager {
	Scanner sc = new Scanner(System.in); 
	DvdDao dvddao = new DvdDao(); 
	public void borrowDvd() throws ParseException{
		Dvd dvd = new Dvd();
		System.out.println("请输入要借出的DVDid");
		int Id = sc.nextInt();
		dvd = dvddao.findbyId(Id);
		dvd.setState(1);
		dvd.setBorrowdate(new Date());
		dvd.setReturndate(null);
		dvd.setDvdcount(dvd.getDvdcount()+1);
		dvddao.updateDvd(dvd);
		
		
	}
	public void returnDvd() throws ParseException{
		Dvd dvd = new Dvd();
		System.out.println("请输入要归还的DVDid");
		int Id = sc.nextInt();
		dvd = dvddao.findbyId(Id);
		dvd.setState(0);
		dvd.setReturndate(new Date());
		System.out.println("租金为");
		long day ;
		day = (dvd.getReturndate().getTime()-dvd.getBorrowdate().getTime())/(1000*60*60*24);
		if(day!=0){
		 day = (dvd.getReturndate().getTime()-dvd.getBorrowdate().getTime())/(1000*60*60*24);
		 }
		else{
			day=0;
		}
		System.out.println(day*5);
		dvd.setBorrowdate(null);
		dvddao.updateDvd(dvd);
		
		
	}
	public void dvdtop(){
		List<Dvd> list = dvddao.findall();
		Collections.sort(list);
		System.out.print("编号");
		System.out.print("\t    借出日期");
		System.out.print("\t借出次数");
		System.out.print("\t\t名字");
		System.out.print("\t\t归还日期");
		System.out.println("\t\t状态（1借出/0未借出）");
		for(Dvd dvd:list){
			System.out.println(dvd);
		}
	}
	public void adddvd(){
		Dvd dvd = new Dvd();
		System.out.println("请输入新增DVD的名字");
		dvd.setName(sc.next());
		dvddao.addDvd(dvd);
	}
	
	public void showall(){
		System.out.print("编号");
		System.out.print("\t    借出日期");
		System.out.print("\t借出次数");
		System.out.print("\t\t名字");
		System.out.print("\t\t归还日期");
		System.out.println("\t\t状态（1借出/0未借出）");
		List<Dvd> list = dvddao.findall();
		for (Dvd dvd : list) {
			System.out.println(dvd);
		}
	}
	public void deleteDvd(){
		Dvd dvd = new Dvd();
		int Id = 0;
		System.out.println("请输入要删除的DVDid");
		dvd.setId(sc.nextInt());
		dvddao.deletebyId(Id);
	}
	
	
	
	
	}
	


