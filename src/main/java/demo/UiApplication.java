package demo;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class UiApplication {

	@RequestMapping("/resource")
	public Map<String,Object> home() {
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("id", "Kathawala presents");
		model.put("content", "Boogle");
		return model;
	}

	@RequestMapping("/query/{query}")
	public Map<String,Object> query(@PathVariable String query) {
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("id", query);
		model.put("content", "Hello World " + query);
		return model;
	}


	public static void main(String[] args) {
		SpringApplication.run(UiApplication.class, args);
	}

}
