package com.digitalhouse.payments.client;

import org.springframework.stereotype.Service;

import com.digitalhouse.payments.model.Payment;

@Service
public class PaymentClient {
	
	
	public Boolean createPayment(Payment payment) {
		//ejecuta una llamada a un seervicio externo para crear el pago
		
		
		return true;
	}

}
