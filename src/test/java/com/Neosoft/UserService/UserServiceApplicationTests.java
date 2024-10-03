package com.Neosoft.UserService;

import com.Neosoft.paymentService.entities.Payment;
import com.Neosoft.paymentService.services.PaymentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class UserServiceApplicationTests {


	@Test
	void contextLoads() {
	}

	@Autowired
	private PaymentService paymentService;


	@Test
	void createPayment(){
		Payment payment = Payment.builder().paymentMode("ONLINE").userId("").amount(90879).payment_Id("").build();
		Payment savePayment = paymentService.createPayment(payment);

		System.out.println(savePayment+ "payment  Done");
	}
}
