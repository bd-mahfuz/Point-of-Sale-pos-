package com.pos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pos.dao.SupplierDao;
import com.pos.dto.Supplier;

@Controller
public class SupplierController {
	
	@Autowired
	SupplierDao supplierDao;

	// adding new supplier
	@RequestMapping(value="user/addSupplier", method= RequestMethod.POST)
	public String addNewSupplier(@ModelAttribute("supplier") Supplier supplier, Model model) {
		// add the new supplier into the database 
		boolean flag = supplierDao.add(supplier);
		
		// send back message based on supplier is added or not
		String message="";
		if(flag == true) {
			message = "Supplier added Successfully";
		}
		else {
			message = "Supplier is not Added";
		}
		
		return "redirect:/user/setup?message="+message;
	}
	
	//updating existing supplier info
	@RequestMapping(value="/user/edit/{id}/supplier")
	public String editSupplier(@PathVariable int id, Model model) {
		Supplier supplier = supplierDao.get(id);
		model.addAttribute("supplier", supplier);
		model.addAttribute("userClickEditSupplier", true);
		return "index";
	}
	
	@RequestMapping(value="user/updateSupplier", method= RequestMethod.POST)
	public String updateSupplier(@ModelAttribute("supplier") Supplier supplier, Model model) {
		// add the new supplier into the database 
		boolean flag = supplierDao.update(supplier);
		
		// send back message based on supplier is updated or not
		String updateMessage="";
		if(flag == true) {
			updateMessage = "Supplier updated Successfully";
		}
		else {
			updateMessage = "Supplier is not updated";
		}
		model.addAttribute("updateMessage", updateMessage);
		model.addAttribute("userClickEditSupplier", true);
		return "index";
	}
	
	
	//delete existing supplier info
	@RequestMapping(value="/user/delete/{id}/supplier", method=RequestMethod.POST)
	@ResponseBody
	public String deleteSupplier(@PathVariable int id, Model model) {
		boolean isFlag = supplierDao.delete(id);
		
		return (isFlag)? "You have successfully delete the supplier with id:"+id 
				: "Supplier delete is not successfull with id"+id;
	}
}
