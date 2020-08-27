package mn.golomt.posservice;

import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PosserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PosserviceApplication.class, args);
	}
	
	@GetMapping("/put")
	public String put(@RequestParam(value = "merchantId", defaultValue = "None") String merchantId, 
			@RequestParam(value = "terminalId", defaultValue = "None") String terminalId,
			@RequestParam(value = "amount", defaultValue = "None") String amount) 
	{
		if(merchantId.compareTo("None") == 0) return new String("merchantId must not be empty");
		if(terminalId.compareTo("None") == 0) return new String("terminalId must not be empty");
		if(amount.compareTo("None") == 0) return new String("amount must not be empty");
		JSONObject request = new JSONObject();
		request.put("merchantId", merchantId);
		request.put("terminalId", terminalId);
		request.put("amount", amount);
		String ret = PosAPIHandler.putHandler(amount);
		return ret;
	}
	
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
	return String.format("Hello %s!", name);
	}
}
