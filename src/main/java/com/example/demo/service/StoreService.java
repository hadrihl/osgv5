package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Store;
import com.example.demo.repository.StoreRepository;

@Service
@Transactional
public class StoreService {

	private StoreRepository storeRepository;
	
	// get store information by id
	public Store getStore(Integer id) {
		Store store = storeRepository.findById(id).get();
		return store;
	}
	
	// get all stores information
	public List<Store> getAllStores() {
		List<Store> stores = storeRepository.findAll();
		return stores;
	}
	
	// save new store
	public Store saveNewStore(Store store) {
		return storeRepository.save(store);
	}
	
	// update store information by id
	public Store updateStore(Integer id, Store newStore) {
		Store oldStore = storeRepository.findById(id).get();
		
		oldStore.setName(newStore.getName());
		oldStore.setPhone(newStore.getPhone());
		
		Store latestStore = storeRepository.save(newStore); // save the updated info
		
		return latestStore;
	}
	
	// delete store by id
	public void deleteStore(Integer id) {
		storeRepository.deleteById(id);
	}
}
