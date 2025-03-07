package com.digitalhouse.payments.service;

import org.springframework.stereotype.Service;

import com.digitalhouse.payments.client.PaymentClient;
import com.digitalhouse.payments.model.Payment;

@Service
public class PaymentService {
	
	private PublishNotification publishNotification;
	
	private PaymentClient paymentClient;
	
	
	
	
	public PaymentService(PublishNotification publishNotification, PaymentClient paymentClient) {
		
		this.publishNotification = publishNotification;
		this.paymentClient = paymentClient;
	}




	public void createPayment(Payment payment) {
		
		// crear un payment
		paymentClient.createPayment(payment);
		
		publishNotification.sendMessageToTopic(payment.getClientId());
		
	}
 
}
