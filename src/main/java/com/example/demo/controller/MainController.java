package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Store;
import com.example.demo.service.StoreService;

@Controller
public class MainController {
	
	@Autowired
	private StoreService storeService;
	
	@GetMapping("/")
	public String getHomepage() {
		return "index";
	}
	
	@GetMapping("/stores")
	public String getStoresPage(Model model) {
		List<Store> stores = storeService.getAllStores();
		model.addAttribute("stores", stores); 
		return "stores";
	}
	
	@GetMapping("/new-store")
	public String getNewStorePage() {
		return "new-store";
	}
	
	@PostMapping("/add-store")
	public String addStore(@ModelAttribute("store") Store store) {
		storeService.saveNewStore(store);
		return "redirect:stores";
	}
	
	@GetMapping("/edit-store")
	public String getEditStorePage(Model model, @RequestParam("id") Integer id) {
		Store store = storeService.getStore(id);
		model.addAttribute("store", store);
		return "edit-store";
	}
	
	@PostMapping("/update-store")
	public String updateStore(@ModelAttribute("store") Store store) {
		storeService.updateStore(store.getId(), store);
		return "redirect:/stores";	
	}
	
	@GetMapping("/delete-store")
	public String deleteStore(@RequestParam("id") Integer id) {
		storeService.deleteStore(id);
		return "redirect:/stores";
	}

}