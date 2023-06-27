package com.lawencon.minimarket.view.buyer;

import java.util.ArrayList;
import java.util.List;

import com.lawencon.minimarket.model.Cart;
import com.lawencon.minimarket.model.Category;
import com.lawencon.minimarket.model.History;
import com.lawencon.minimarket.model.Item;
import com.lawencon.minimarket.service.impl.CartServiceImpl;
import com.lawencon.minimarket.util.ScannerUtil;
import com.lawencon.minimarket.view.seller.CategoryView;

public class OrderView {

	private List<Category> arrCategories;
	private List<Item> arrItems;
	private List<Cart> arrCarts;
	private List<History> arrHistories;
	private List<Item> filterItem = new ArrayList<>();
	
	public void setState(List<Category> arrCategories,List<Item> arrItems, List<Cart> arrCarts, List<History> arrHistories) {
		this.arrCategories = arrCategories;
		this.arrItems = arrItems;
		this.arrCarts = arrCarts;
		this.arrHistories = arrHistories;
	}
	void show(){
		CategoryView categoryView = new CategoryView();
		categoryView.setState(this.arrCategories, this.arrItems, this.arrCarts, this.arrHistories);
		categoryView.showListCategory();
		int chooseCategory = ScannerUtil.inputNumberRangeInteger("pilih jenis barang :", this.arrCategories.size());
		order(chooseCategory);
	}
	
	void order(int categoryId) {
		this.filterItemByCategory(categoryId);
		System.out.println("--------------------------------------------------------");
		int chooseItem = ScannerUtil.inputNumberRangeInteger("pilih barang : ", this.arrCategories.size());
		int qty = ScannerUtil.inputNumber("masukan jumlah : ");
		CartServiceImpl cartServiceImpl = new CartServiceImpl();
		boolean	isSuccess =	cartServiceImpl.addCart(this.arrCarts.size() + 1,this.arrItems.get(chooseItem - 1).getName(),this.arrItems.get(chooseItem - 1).getId(), qty, this.filterItem.get(chooseItem - 1).getPrice(),this.arrCarts,this.arrItems);
		if(isSuccess) {
			System.out.println("barang berhasil dimasukan kedalam keranjang belanjaan...");
		}else {
			System.out.println("stock melebihi batas");
		}
		final byte chooseMenu = ScannerUtil.inputNumberRangeByte("apakah anda ingin membeli lagi? [1/0]: ",1);
		if(chooseMenu == 1) {
			order(categoryId);
		}
		if(chooseMenu == 0){
			CartView cartView = new CartView();
			cartView.setState(this.arrCategories, this.arrItems, this.arrCarts, this.arrHistories);
			cartView.show();
		}	
	}
	
	
	public void filterItemByCategory(int categoryId) {
		System.out.println(this.arrItems.size());
		System.out.println("--------------------------------------------------------");
		System.out.println("LIST BARANG");
		System.out.println("--------------------------------------------------------");
		for (int i = 0; i < this.arrItems.size(); i++) {
			if(this.arrItems.get(i).getCategoryId() == categoryId) {
				 System.out.println(i + 1 + ". " + this.arrItems.get(i).getName() + " " + this.arrItems.get(i).getPrice() + " " + this.arrItems.get(i).getStock() );
				 Item temporaryItem = new Item();
				 temporaryItem.setId(this.arrItems.get(i).getId());
				 temporaryItem.setName(this.arrItems.get(i).getName());
				 temporaryItem.setCategoryId(this.arrItems.get(i).getId());
				 temporaryItem.setStock(this.arrItems.get(i).getStock());
				 temporaryItem.setPrice(this.arrItems.get(i).getPrice());
				 this.filterItem.add(temporaryItem);	 
			}
		}
		if(this.arrItems.size() == 0) {
			 System.out.println("item belum tersedia...");
		}
	}
}
