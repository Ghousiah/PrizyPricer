package com.prizy.pricer.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.prizy.pricer.models.Product;
import com.prizy.pricer.services.ProductService;

@Controller
@RequestMapping("/products")
public class ViewController {

	private ProductService productService;
	//private ArrayList<Double> priceList = new ArrayList<Double>();

	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		request.setAttribute("products", this.productService.getAllProducts());
		request.setAttribute("mode", "MODE_HOME");
		return "index";
	}

	@RequestMapping(value = { "/all" }, method = RequestMethod.GET)
	public ModelAndView getHome(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("index");
		List<Product> products = this.productService.getAllProducts();
		modelAndView.addObject("products", products);
		request.setAttribute("mode", "MODE_TASKS");
		return modelAndView;
	}

	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newProduct(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_NEW");
		return "index";
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	public String addNewProduct(@ModelAttribute(value = "product") Product product, HttpServletRequest request) {
		double price = product.getPrice();
		product.setName(product.getName());
		product.setDescription(product.getDescription());
		product.setAvgPrice(price);
		product.setLowestPrice(price);
		product.setHighestPrice(price);
		product.setIdealPrice(price);
		product.setPriceCollectCount(1);
		this.productService.addProduct(product);

		//priceList.add(price);

		request.setAttribute("products", this.productService.getAllProducts());
		request.setAttribute("mode", "MODE_TASKS");
		return "index";
	}

	@RequestMapping(value = { "/edit" }, method = RequestMethod.GET)
	public ModelAndView editProduct(@RequestParam String id, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("update");
		if (id != null) {
			Optional<Product> response = this.productService.getProductById(id);
			Product prod = response.isPresent() ? response.get() : new Product();
			prod.setBarcode(id);
			modelAndView.addObject("product", prod);
		}
		request.setAttribute("mode", "MODE_UPDATE");
		return modelAndView;
	}

	@RequestMapping(value = { "/edit-view" }, method = RequestMethod.POST)
	public ModelAndView getDetails(@RequestParam String id, @ModelAttribute(value = "product") Product product,
			HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("view");
		System.out.println(id);
		if (id != null) {
			Optional<Product> prod = this.productService.getProductById(id);
			Product response = prod.isPresent() ? prod.get() : new Product();

			product.setBarcode(id);

			int i = response.getPriceCollectCount();
			i += 1;
			product.setPriceCollectCount(i);

//			product.setHighestPrice(Collections.max(priceList));
//			product.setLowestPrice(Collections.min(priceList));

//			double sum = 0;
//			int count = 0;
//
//			for (Double d : priceList) {
//				sum += d;
//				count += 1;
//			}

//			double avg = sum / count;
//			product.setAvgPrice(avg);

			this.productService.updateProduct(product);
			modelAndView.addObject("product", product);

		}

		request.setAttribute("products", this.productService.getAllProducts());
		request.setAttribute("mode", "MODE_VIEW");
		return modelAndView;
	}

	@RequestMapping(value = { "/delete" }, method = RequestMethod.GET)
	public String deleteProduct(@RequestParam String id, HttpServletRequest request) {
		this.productService.deleteProduct(id);
		request.setAttribute("products", this.productService.getAllProducts());
		request.setAttribute("mode", "MODE_TASKS");
		return "index";
	}
}
