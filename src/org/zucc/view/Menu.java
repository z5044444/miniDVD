package org.zucc.view;

import java.text.ParseException;
import java.util.Scanner;

import org.zucc.dao.DvdDao;
import org.zucc.entity.Dvd;
import org.zucc.service.DvdManager;

public class Menu {

	Scanner sc = new Scanner(System.in);
//	DvdDao dvddao = new DvdDao(); 
	DvdManager dm = new DvdManager();

	public void mainMenu() throws ParseException {
		System.out.println("欢迎使用迷你DVD管理器");
		System.out.println("-----------------------");
		System.out.println("1.新增DVD");
		System.out.println("2.查看DVD");
		System.out.println("3.删除DVD");
		System.out.println("4.借出DVD");
		System.out.println("5.归还DVD");
		System.out.println("6.查看热门DVD");
		System.out.println("7.退出");
		System.out.print("请选择:");
		int num = sc.nextInt();
		switch (num) {

		case 1:
			item1();
			break;
		case 2:		
		    item2();
			break;
		case 3:
			item3();
			break;
		case 4:
			item4();
			break;
		case 5:
			item5();
			break;
		case 6:
			item6();
			break;
		case 7:
			System.out.println("谢谢使用");
			break;
		default:
			break;
		}
}
	public void returnMenu() throws ParseException {
		System.out.println("请输入0返回");
		int num = sc.nextInt();
		if (num == 0) {
			mainMenu();
		} else {
			System.out.println("输入错误，请输入正确：");
			returnMenu();
		}
	}
	public void item1() throws ParseException {
		dm.adddvd();
		returnMenu();
	}
	public void item2() throws ParseException{
		dm.showall();
		returnMenu();		
	}
	public void item3() throws ParseException{
		dm.deleteDvd();
		returnMenu();
	}
	public void item4() throws ParseException{	
		dm.borrowDvd();
		returnMenu();	
	}
	public void item5() throws ParseException{	
		dm.returnDvd();
		returnMenu();
	}
	public void item6() throws ParseException{		
		dm.dvdtop();
		returnMenu();
	}
}