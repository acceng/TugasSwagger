package com.EKSAD.tugas.TugasSwagger.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EKSAD.tugas.TugasSwagger.dao.BrandDAO;
import com.EKSAD.tugas.TugasSwagger.model.Brand;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/v1")
@Api(tags = "Brand")
public class BrandController {
	@Autowired
	BrandDAO brandDAO;
	@ApiOperation(
			value = "API to retrieve all Brand's data",
		    notes = "Return data with JSON Format",
		    tags = "Get Data API"
			)
	@GetMapping("getAllBrand")
	public List<Brand> getAll() {
		List<Brand> result = new ArrayList<>();
		
		brandDAO.findAll().forEach(result::add);
	
		return result;
		
	}
	@ApiOperation(
			value = "API to retrieve all Brand's data",
		    notes = "Return data with JSON Format",
		    tags = "Get Data API"
			)
	@GetMapping("getOneBrand/{id}")
	public Brand getOne(@PathVariable Long id) {
		return brandDAO.findById(id).orElse(null);
	}
	@ApiOperation(
			value = "Saving new Division's data",
		    notes = "Saving new Division's data to database",
		    tags = "Data Manipulation API"
			)
	@PostMapping("save")
	public Brand save(@RequestBody Brand brand) {
		try {
			
			
			return brandDAO.save(brand);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
				
	}
	@ApiOperation(
			value = "Update Division's data",
		    notes = "Update Division's data to database",
		    tags = "Data Manipulation API"
			)
	@PutMapping("update/{id}")
	public Brand update(@RequestBody Brand brand, @PathVariable Long id) {
		
		Brand brandSelected = brandDAO.findById(id).orElse(null);
		
		if (brandSelected !=null) {
			brandSelected.setName(brand.getName());
			brandSelected.setProductType(brand.getProductType());
			
			
			return brandDAO.save(brandSelected);
		}else {
			return null;
		}
	}
	@ApiOperation(
			value = "Delete Division's data",
		    notes = "Delete Division's data to database",
		    tags = "Data Manipulation API"
			)
	@DeleteMapping("delete/{id}")
	public HashMap<String, Object> delete (@PathVariable Long id){
		HashMap<String, Object> result = new HashMap<String, Object>();
		brandDAO.deleteById(id);
		result.put("message", "Berhasil Dihapus");
		return result;
		
	}
}          
