package com.cognizant.truyum.dao;

import com.cognizant.truyum.dao.CartDao;

import com.cognizant.truyum.dao.CartDaoCollectionImpl;

import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {

	public static void testAddCartItem() throws CartEmptyException {
		// 1. Instantiate CartDaoCollectionImpl and assign it to CartDao reference
		// variable cartDao.
		CartDao cartDao = new CartDaoCollectionImpl();
		// 2. Invoke cartDao.addCartItem()
		cartDao.addCartItem(1, 2L);
		cartDao.addCartItem(1, 5L);
		cartDao.addCartItem(2, 1L);
		cartDao.addCartItem(2, 3L);
		Cart cart = cartDao.getAllCartItems(1);
		// List<MenuItem> menuItemListCustomer = cartDao.getAllCartItems(1);
		System.out.println("User Added Cart List for Checkout");
		for (MenuItem menuItem : cart.getMenuItemList()) {
			System.out.println(menuItem);
		}
	}

	public static void testRemoveCartItem() {
		// 1. Instantiate CartDaoCollectionImpl and assign it CartDao reference variable
		// cartDao.
		CartDao cartDao = new CartDaoCollectionImpl();
		// 2. Invoke cartDao.removeCartItem() method with following parameters
		System.out.println("\nItem List for Customer after Remove");
		try {
			cartDao.removeCartItem(1, 2L);
			cartDao.removeCartItem(2, 1L);
			cartDao.removeCartItem(1, 5L);
			// 3. Invoke cartDao.getAllCartItems() with userId as 1
			Cart cart = cartDao.getAllCartItems(1);
			for (MenuItem menuItem : cart.getMenuItemList()) {
				System.out.println(menuItem);
			}
		} catch (CartEmptyException e) {
			System.out.println(e.getMessage());
		}
	}

	// for(int i = 0; i < menuItemList.size(); i++) {
	// if(menuItemList.get(i).getId() == menuItemId) {
	// menuItemList.remove(i);
	// return;

	public static void testGetAllCartItems() {

	}

	public static void main(String args[]) throws CartEmptyException {
		testAddCartItem();
		testRemoveCartItem();
	}

}
