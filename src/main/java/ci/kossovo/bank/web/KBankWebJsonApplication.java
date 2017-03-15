package ci.kossovo.bank.web;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import ci.kossovo.bank.Application;

@SpringBootApplication
@Import({Application.class})
public class KBankWebJsonApplication {

	public static void main(String[] args) {
	
				
	}
}
