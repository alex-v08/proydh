package com.digitalhouse.checkout.controller;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digitalhouse.checkout.model.Checkout;
import com.digitalhouse.checkout.service.ICheckoutService;



@RestController
@RequestMapping(value ="/checkout")
public class CheckoutRestController {
	private ICheckoutService checkoutService;
	
	Logger logger = LoggerFactory.getLogger(CheckoutRestController.class);
	public CheckoutRestController(ICheckoutService checkoutService) {
		super();
		this.checkoutService = checkoutService;
	}
	
	@GetMapping("/{id}")
	public Checkout getById(@PathVariable String id) {
		return new Checkout(id);
	}
	

	@GetMapping()
	public Checkout getCheckout(@RequestParam List<String> productIds,@RequestHeader("X-Request-from") String requestFrom,@RequestHeader() Map<String,String> headers) {
		logger.info("ENVIADO DESDE: "+requestFrom);
		System.out.println("Enviado desde: "+ requestFrom);
		if(!requestFrom.equals("gateway")) {
			return null;
		}
		return checkoutService.buildCheckout(productIds);
		
	}
	

	@GetMapping(value = "/exception/ahora")
	public String exception() {
		String response = "";
		try {
			throw new Exception("Exception has occured....");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());

			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String stackTrace = sw.toString();
			logger.error("Exception - " + stackTrace);
			response = stackTrace;
		}

		return response;
	}

}
