package com.lawencon.minimarket.view.seller;

import java.util.List;

import com.lawencon.minimarket.model.Cart;
import com.lawencon.minimarket.model.Category;
import com.lawencon.minimarket.model.History;
import com.lawencon.minimarket.model.Item;

import com.lawencon.minimarket.service.impl.ItemServiceImpl;
import com.lawencon.minimarket.util.ScannerUtil;

public class ItemView {
	
	private ItemServiceImpl itemServiceImpl;

	
	private List<Category> arrCategories;
	private List<Item> arrItems;
	private List<Cart> arrCarts;
	private List<History> arrHistories;
	
	public void setState(List<Category> arrCategories,List<Item> arrItems, List<Cart> arrCarts, List<History> arrHistories) {
		this.arrCategories = arrCategories;
		this.arrItems = arrItems;
		this.arrCarts = arrCarts;
		this.arrHistories = arrHistories;
		this.itemServiceImpl = new ItemServiceImpl();
	}
	
	void show(){
		System.out.println("== PENJUAL ==");
		this.showListItems();
		System.out.println("-- menu item --");
		System.out.println("1. tambah item");	
		System.out.println("2. ubah jumlah");
		System.out.println("3. hapus item");
		System.out.println("4. kembali kemenu sebelumnya");
		byte chooseMenu =	ScannerUtil.inputNumberRangeByte("pilih menu : ", 4);
		if(chooseMenu == 1) {	
			this.create();
	 	}
		if(chooseMenu == 2) {
			this.edit();
		}
		if(chooseMenu == 3) {
			this.delete();
		}
		if(chooseMenu == 4) {
			HomeSellerView homeView = new HomeSellerView();
			homeView.setState(this.arrCategories,this.arrItems, this.arrCarts, this.arrHistories);
			homeView.show();
		}
	}
	
	
	void create() {
		CategoryView categoryView = new CategoryView();
		categoryView.setState(this.arrCategories,this.arrItems, this.arrCarts, this.arrHistories);
		
		this.showListItems();
		final String  name = ScannerUtil.inputText("masukan nama barang : ");
		final int price = ScannerUtil.inputNumber("masukan harga : ");
		categoryView.showListCategory();
		final int categoryId = ScannerUtil.inputNumberRangeInteger("pilih kategori: ", this.arrCategories.size());
		final int stock = ScannerUtil.inputNumber("masukan jumlah : ");
		this.arrItems.add(this.itemServiceImpl.create(this.arrItems.size() + 1, name,price, categoryId, stock));
		final byte chooseMenu = ScannerUtil.inputNumberRangeByte("apakah anda ingin menambahkan item lagi? [1/0]: ",1);
		if(chooseMenu == 1) {
			create();
		}
		if(chooseMenu == 0){
			show();
		}
	}
	
	 void edit() {
		 this.showListItems();
		 final int chooseItem = ScannerUtil.inputNumberRangeInteger("pilih item yang ingin diubah : ", this.arrItems.size());
		 final String  name = ScannerUtil.inputText("masukan nama item : ");
		 final int price = ScannerUtil.inputNumber("masukan harga : ");
		 final int categoryId = ScannerUtil.inputNumberRangeInteger("pilih kategori: ", this.arrCategories.size());
		 final int stock = ScannerUtil.inputNumber("masukan jumlah : "); 
		 this.arrItems.get(chooseItem - 1).setName(name);
		 this.arrItems.get(chooseItem - 1).setPrice(price);
		 this.arrItems.get(chooseItem - 1).setCategoryId(categoryId);
		 this.arrItems.get(chooseItem - 1).setStock(stock);
		 show();
		 System.out.println("data berhasil diubah...");
	 }
	 void delete() {	
		 showListItems();
		 final int chooseItem = ScannerUtil.inputNumberRangeInteger("pilih kategori yang ingin hapus : ",this.arrItems.size());
		 this.arrItems.remove(chooseItem - 1);	 
		 show();
	}
		 
	
	public void showListItems() {
		 System.out.println("--------------------------------------------------------");
		 System.out.println("LIST ITEM");
		 System.out.println("--------------------------------------------------------");
		 for (int i = 0; i < this.arrItems.size(); i++) {
			 System.out.println(i + 1 + ". " + this.arrItems.get(i).getName() + " " + this.arrItems.get(i).getPrice() + " " + this.arrItems.get(i).getStock());	
		 }
		 if(this.arrItems.size() == 0) {
			 System.out.println("item belum tersedia...");
		 }
		 System.out.println("--------------------------------------------------------");
	 }
	
}
