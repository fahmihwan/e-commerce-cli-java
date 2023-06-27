package com.lawencon.minimarket.util;

import java.util.Scanner;

public class ScannerUtil {
	
	public static int inputNumberRangeInteger(String description, int maxRange) {
		int chooseMenu = 0;
		Boolean isFailChoseMenu = false;
		do {
			chooseMenu =  ScannerUtil.inputNumber(description);
			if(chooseMenu <= maxRange && chooseMenu >= 1 ) {
				isFailChoseMenu = false;
			}else {
				isFailChoseMenu = true;
				System.out.println("masukan perintah dengan benar...");
			}
		}while(isFailChoseMenu == true);
		
		return  chooseMenu;
	}
	
	public static byte inputNumberRangeByte(String description, int maxRange) {
		byte chooseMenu = 0;
		Boolean isFailChoseMenu = false;
		do {
			chooseMenu = (byte) ScannerUtil.inputNumber(description);
			if(chooseMenu <= maxRange) {
				isFailChoseMenu = false;
			}else {
				isFailChoseMenu = true;
				System.out.println("masukan perintah dengan benar...");
			}
		}while(isFailChoseMenu == true);
		
		return  chooseMenu;
	}
	
	public static int inputNumber(String description) {
		boolean wenttocatch;
		String input = "";
		int	result=0;
		do {
			try {
				System.out.print(description);
				Scanner sc = new Scanner(System.in);
				wenttocatch = false;
				input = sc.nextLine().trim();
				result	= Integer.parseInt(input);
			} catch (Exception e) {
				wenttocatch = true;
				System.out.println("input harus bertipe angka...");
			}
		} while (wenttocatch == true);
		return result;
	}
	
	public static String inputText(String description) {
		boolean wenttocatch;
		String input = "";
		do {
			try {
				System.out.print(description);
				Scanner sc = new Scanner(System.in);
				wenttocatch = false;
				input = sc.nextLine().trim();
			} catch (Exception e) {
				wenttocatch = true;
				System.out.println("input harus bertipe teks..");
			}
		} while (wenttocatch == true);
		return input;
	}

}
