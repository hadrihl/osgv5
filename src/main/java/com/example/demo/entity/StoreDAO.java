package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StoreDAO {
	
	List<Store> stores = new ArrayList<>();
	
	public Store saveStore(Store store) {
		stores.add(store);
		return store;
	}
	
	public List<Store> getAllStores() {
		return stores;
	}

}
