package com.lawencon.minimarket.view.seller;

import java.util.List;

import com.lawencon.minimarket.model.Cart;
import com.lawencon.minimarket.model.Category;
import com.lawencon.minimarket.model.History;
import com.lawencon.minimarket.model.Item;
import com.lawencon.minimarket.util.ScannerUtil;
import com.lawencon.minimarket.view.AuthView;


public class HomeSellerView {
	
	private List<Category> arrCategories;
	private List<Item> arrItems;
	private List<Cart> arrCarts;
	private List<History> arrHistories;
	
	public void setState(List<Category> arrCategories,List<Item> arrItems, List<Cart> arrCarts, List<History> arrHistories) {
		this.arrCategories = arrCategories;
		this.arrItems = arrItems;
		this.arrCarts = arrCarts;
		this.arrHistories = arrHistories;
	}
	
	
	public void show() {
		System.out.println("== PENJUAL ==");
		System.out.println("--beranda--");
		System.out.println("1. lihat semua kategori item");
		System.out.println("2. lihat semua item");
		System.out.println("3. lihat transaksi pembeli");
		System.out.println("4. switch user");
		System.out.println("5. keluar aplikasi");
		
		byte chooseMenu = ScannerUtil.inputNumberRangeByte("pilih menu : ", 5);
		System.out.println("\n");
		if(chooseMenu == 0) {
			show();
		}
		if(chooseMenu == 1){
			CategoryView categoryView = new CategoryView();
			categoryView.setState(this.arrCategories,this.arrItems, this.arrCarts,this.arrHistories);
			categoryView.show();
		}
		if(chooseMenu == 2) {
			ItemView itemView = new ItemView();
			itemView.setState(this.arrCategories,this.arrItems, this.arrCarts, this.arrHistories);
			itemView.show();
		}
		if(chooseMenu == 3) {
			CheckTransactionView checkTransactionView = new CheckTransactionView();
			checkTransactionView.setState(arrCategories, arrItems, arrCarts, arrHistories);
			checkTransactionView.show();
		}
		if(chooseMenu == 4) {
			AuthView authView = new AuthView();
			authView.setState(this.arrCategories, this.arrItems, this.arrCarts, this.arrHistories);
			authView.show();
		}
		if(chooseMenu == 5) {
			System.out.println("anda telah keluar");
		}
		
		
	}
	
	
	
}
