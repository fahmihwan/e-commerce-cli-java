package com.lawencon.minimarket.view.seller;

import java.util.List;

import com.lawencon.minimarket.model.Cart;
import com.lawencon.minimarket.model.Category;
import com.lawencon.minimarket.model.History;
import com.lawencon.minimarket.model.Item;
import com.lawencon.minimarket.service.impl.CategoryServiceImpl;
import com.lawencon.minimarket.util.ScannerUtil;

public class CategoryView {
	

	private CategoryServiceImpl categoryServiceImpl;

	private List<Category> arrCategories;
	private List<Item> arrItems;
	private List<Cart> arrCarts;
	private List<History> arrHistories;
	
	public void setState(List<Category> arrCategories,List<Item> arrItems, List<Cart> arrCarts, List<History> arrHistories) {
		this.arrCategories = arrCategories;
		this.arrItems = arrItems;
		this.arrCarts = arrCarts;
		this.arrHistories = arrHistories;
		this.categoryServiceImpl = new CategoryServiceImpl();
	}
	
	
	void show(){
		System.out.println("== PENJUAL ==");
		this.showListCategory();
		System.out.println("-- menu kategori --");
		System.out.println("1. tambah kategori");	
		System.out.println("2. ubah kategori");
		System.out.println("3. hapus kategori");
		System.out.println("4. kembali kemenu sebelumnya");
		byte chooseMenu =	ScannerUtil.inputNumberRangeByte("pilih menu : ", 4);
		if(chooseMenu == 1) {
			create();
	 	}
		if(chooseMenu == 2) {
			edit();
		}
		if(chooseMenu == 3) {
			delete();
		}
		if(chooseMenu == 4) {
			HomeSellerView homeSellerView = new HomeSellerView();
			homeSellerView.setState(this.arrCategories,this.arrItems,this.arrCarts, this.arrHistories);
			homeSellerView.show();
		}
	}
	
	 void create() {
		System.out.println("== PENJUAL ==");
		showListCategory();
		System.out.println("-- tambah kategori --");
		final String  name = ScannerUtil.inputText("masukan nama kategori : ");	 
		this.arrCategories.add(this.categoryServiceImpl.create(this.arrCategories.size() + 1, name));
		final byte chooseMenu = ScannerUtil.inputNumberRangeByte("apakah anda ingin menambahkan kategori lagi? [1/0]: ",1);
		if(chooseMenu == 1) {
			create();
		}
		if(chooseMenu == 0){
			show();
		}
			 	 	 
	}
	 
	 void edit() {
		 showListCategory();
		 final int chooseCategory = ScannerUtil.inputNumberRangeInteger("pilih kategori yang ingin diubah : ", this.arrCategories.size());
		 final String  name = ScannerUtil.inputText("masukan nama kategori : ");
		 this.arrCategories.get(chooseCategory - 1).setName(name);
		 System.out.println("data berhasil diubah");
		 show();
	 }
	 
	  void delete() {
		 this.showListCategory();
		 final int chooseCategory = ScannerUtil.inputNumberRangeInteger("pilih kategori yang ingin hapus : ",this.arrCategories.size());
		 this.arrCategories.remove(chooseCategory - 1);	 
		 show();
	 }
	 
	 public void showListCategory() {
		 System.out.println("--------------------------------------------------------");
		 System.out.println("LIST KATEGORI");
		 System.out.println("--------------------------------------------------------");
		 for (int i = 0; i < this.arrCategories.size(); i++) {
			 System.out.println(i + 1 + ". " + this.arrCategories.get(i).getName());	
		 }
		 if(this.arrCategories.size() == 0) {
			 System.out.println("kategori belum tersedia...");
		 }
		 System.out.println("--------------------------------------------------------");
	 }
	
	
}
