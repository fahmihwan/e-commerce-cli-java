package com.lawencon.minimarket.view.buyer;

import java.util.List;

import com.lawencon.minimarket.model.Cart;
import com.lawencon.minimarket.model.Category;
import com.lawencon.minimarket.model.History;
import com.lawencon.minimarket.model.Item;
import com.lawencon.minimarket.service.impl.CartServiceImpl;
import com.lawencon.minimarket.util.ScannerUtil;

public class CartView {

	private List<Category> arrCategories;
	private List<Item> arrItems;
	private List<Cart> arrCarts;
	private List<History> arrHistories;
	private CartServiceImpl cartServiceImpl;
	
	
	public void setState(List<Category> arrCategories,List<Item> arrItems, List<Cart> arrCarts, List<History> arrHistories) {
		this.arrCategories = arrCategories;
		this.arrItems = arrItems;
		this.arrCarts = arrCarts;
		this.arrHistories = arrHistories;
		this.cartServiceImpl = new CartServiceImpl();
	}
	
	void show() {
		System.out.println("== PEMBELI ==");
		showListCart();
		System.out.println("-- beranda --");
		System.out.println("1. ubah quantity");
		System.out.println("2. hapus sebagian barang belanja");
		System.out.println("3. checkout");
		System.out.println("4. kembali ke beranda");
		final byte chooseMenu = ScannerUtil.inputNumberRangeByte("pilih menu : ", 4);
		System.out.println("\n");
		if(chooseMenu == 1) {
			editQty();
		}
		if(chooseMenu == 2) {
			delete();
		}
		if(chooseMenu == 3) {
			checkout();
		}
		if(chooseMenu == 4) {
			HomeBuyerView homeBuyerView = new HomeBuyerView();
			homeBuyerView.setState(this.arrCategories, this.arrItems, this.arrCarts, this.arrHistories);
			homeBuyerView.show();
		}
	}
	
	void editQty() {
		System.out.println("== PEMBELI ==");
		showListCart();
		System.out.println("-- ubah quantity --");
		final int chooseItem = ScannerUtil.inputNumberRangeInteger("pilih barang : ",this.arrCarts.size());
		final int qty = ScannerUtil.inputNumber("masukan jumlah : ");
		this.arrCarts.get(chooseItem - 1).setQty(qty);
//		this.cartServiceImpl.editQty(arrCarts, arrItems, chooseItem);
		show();
	}
	
	void delete() {
		System.out.println("== PEMBELI ==");
		showListCart();
		System.out.println("-- hapus sebagian barang belanjaan --");
		final int chooseItem = ScannerUtil.inputNumberRangeInteger("pilih barang yang ingin hapus dari keranjang : ",this.arrCarts.size());
		this.cartServiceImpl.deleteCart(this.arrCarts,this.arrItems, chooseItem);
		show();
	}
	
	void checkout() {
		System.out.println("== PEMBELI ==");
		showListCart();
		System.out.println("-- checkout --");
		final byte checkoutNow = ScannerUtil.inputNumberRangeByte("checkout barang sekarang [1/0]: ", 1);
		if(checkoutNow == 1) {
			this.cartServiceImpl.checkout(this.arrCarts, this.arrHistories);
			System.out.println("barang berhasil di checkout");
			show();
		}
		if(checkoutNow == 0) {
			show();
		}
	}
	
	public void showListCart() {
		System.out.println("--------------------------------------------------------");
		System.out.println("LIST KERANJANG");
		System.out.println("--------------------------------------------------------");
		int grantTotal = 0;
		for (int i = 0; i < this.arrCarts.size(); i++) {
			System.out.println(i+1 + ". " + this.arrCarts.get(i).getName() + " "+ this.arrCarts.get(i).getQty()+ " "+this.arrCarts.get(i).getPrice() * this.arrCarts.get(i).getQty() + " " );
			grantTotal += this.arrCarts.get(i).getQty() * this.arrCarts.get(i).getPrice();
 		}
		System.out.println("grant total : " + grantTotal);
	}
}
