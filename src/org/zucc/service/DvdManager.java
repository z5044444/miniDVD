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
		System.out.println("������Ҫ�����DVDid");
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
		System.out.println("������Ҫ�黹��DVDid");
		int Id = sc.nextInt();
		dvd = dvddao.findbyId(Id);
		dvd.setState(0);
		dvd.setReturndate(new Date());
		System.out.println("���Ϊ");
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
		System.out.print("���");
		System.out.print("\t    �������");
		System.out.print("\t�������");
		System.out.print("\t\t����");
		System.out.print("\t\t�黹����");
		System.out.println("\t\t״̬��1���/0δ�����");
		for(Dvd dvd:list){
			System.out.println(dvd);
		}
	}
	public void adddvd(){
		Dvd dvd = new Dvd();
		System.out.println("����������DVD������");
		dvd.setName(sc.next());
		dvddao.addDvd(dvd);
	}
	
	public void showall(){
		System.out.print("���");
		System.out.print("\t    �������");
		System.out.print("\t�������");
		System.out.print("\t\t����");
		System.out.print("\t\t�黹����");
		System.out.println("\t\t״̬��1���/0δ�����");
		List<Dvd> list = dvddao.findall();
		for (Dvd dvd : list) {
			System.out.println(dvd);
		}
	}
	public void deleteDvd(){
		Dvd dvd = new Dvd();
		int Id = 0;
		System.out.println("������Ҫɾ����DVDid");
		dvd.setId(sc.nextInt());
		dvddao.deletebyId(Id);
	}
	
	
	
	
	}
	


