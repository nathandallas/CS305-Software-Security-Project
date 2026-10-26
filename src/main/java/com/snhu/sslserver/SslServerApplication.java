package com.snhu.sslserver;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.tomcat.util.buf.HexUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

@SpringBootApplication
public class SslServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SslServerApplication.class, args);
	}

}

@RestController
class ServerController {

	@GetMapping("/hash")
	public String myHash() {
		String data = "Nathaniel Challender - Hello World Check Sum!";

		String checksum;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] hash = md.digest(data.getBytes(StandardCharsets.UTF_8));
			checksum = HexUtils.toHexString(hash);
		} catch (NoSuchAlgorithmException e) {
			return "<p>Checksum unavailable.</p>";
		}

		return "<p>Data: " + HtmlUtils.htmlEscape(data) + "</p>"
			 + "<p>Name of Cipher Algorithm Used: SHA-256</p>"
			 + "<p>CheckSum Value: " + checksum + "</p>";
	}
}