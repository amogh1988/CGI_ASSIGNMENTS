package com.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.bean.Product;

public class ProductService {

	private List<Product> listOfProducts = new ArrayList<Product>();

	public void writeProducts() {

		ObjectOutputStream oos = null;
		FileOutputStream fout = null;
		try {

			if (this.listOfProducts.size() > 0) {
				fout = new FileOutputStream("product.ser", false);
				oos = new ObjectOutputStream(fout);
				oos.writeObject(this.listOfProducts);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public ProductService() {
		super();
		FileInputStream fis;
		try {
			fis = new FileInputStream("product.ser");
			if (fis.available() > 0) {
				ObjectInputStream ois = new ObjectInputStream(fis);
				this.listOfProducts = (ArrayList<Product>) ois.readObject();
				ois.close();
			}
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String addProduct(Product product) {
		int flag = 0;
		if (listOfProducts.size() == 0) {
			listOfProducts.add(product);
			return "Product added successfully";
		} else {
			Iterator<Product> li = listOfProducts.iterator();
			while (li.hasNext()) {
				Product p = li.next();
				if (p.getPid() == product.getPid()) {
					flag++;
					break;
				}
			}
		}
		if (flag == 0) {
			listOfProducts.add(product);
			return "Product added successfully";
		} else {
			flag = 0;
			return "Product is must be unique";
		}
	}

	public List<Product> findAllProducts() {
		return listOfProducts;
	}

	public String deleteProduct(int pid) {
		int flag = 0;

		Iterator<Product> li = listOfProducts.iterator();
		while (li.hasNext()) {
			Product p = li.next();
			if (p.getPid() == pid) {
				li.remove();
				flag++;
				break;
			}
		}

		if (flag == 0) {
			return "Product not present";
		} else {
			flag = 0;
			return "Product deleted successfully";
		}
	}

	public String updatetProduct(Product product) {
		int flag = 0;
		Iterator<Product> li = listOfProducts.iterator();
		while (li.hasNext()) {
			Product p = li.next();
			if (p.getPid() == product.getPid()) {
				p.setPrice(product.getPrice());
				flag++;
				break;
			}
		}
		if (flag == 0) {
			return "Product not present";
		} else {
			flag = 0;
			return "Product price updated successfully";
		}
	}
}
