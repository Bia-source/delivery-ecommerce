package com.delivery.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class EcommerceDeliveryApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();

        System.setProperty("SUPABASE_URL", dotenv.get("SUPABASE_URL"));
        System.setProperty("SUPABASE_USER", dotenv.get("SUPABASE_USER"));
        System.setProperty("SUPABASE_PASS", dotenv.get("SUPABASE_PASS"));

		SpringApplication.run(EcommerceDeliveryApplication.class, args);
	}

}
