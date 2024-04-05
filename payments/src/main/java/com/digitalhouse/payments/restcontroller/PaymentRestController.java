package com.digitalhouse.payments.restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalhouse.payments.model.Payment;
import com.digitalhouse.payments.service.PaymentService;

@RequestMapping("/payments")
@RestController
public class PaymentRestController {
	
	
	private PaymentService paymentService;
	
	Logger log = LoggerFactory.getLogger(PaymentRestController.class);
	
	public PaymentRestController(PaymentService paymentService) {
		super();
		this.paymentService = paymentService;
	}
	
	@GetMapping()
	public Payment getPayment(String id) {
		log.info("Intentando obtener payment con id: "+id +".....");
		
		/// utilizar un servicio
		
		log.error("Error al intentar obtener un payment");
		
		return new Payment(id, 400.0f,"id 1", "id 2");
		
	}


	@PostMapping()
	public void createPayment(@RequestBody Payment payment) {
		
		paymentService.createPayment(payment);
	}

}
