package demo;

import java.util.*;

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
		model.put("content", "Type?");
		return model;
	}

	@RequestMapping("/query/{query}/{type}")
	public Map<String,Object> query(@PathVariable String query, @PathVariable String type) {
    Set<Result> set = new HashSet<>();
    for (int i = 0; i < 100; i++) {
      set.add(new Result("title_" + i, "address_" + i));
    }

		Map<String,Object> model = new HashMap<String,Object>();
		model.put("id", "Kathawala presents : " + query);
    model.put("content", "Type :: " + type);
    model.put("results", set);
		return model;
	}


	public static void main(String[] args) {
		SpringApplication.run(UiApplication.class, args);
	}

	static class Result {
	  String title;
	  String address;

    public Result() {}

    public Result(String title, String address) {
      this.title = title;
      this.address = address;
    }

    public String getTitle() {
      return title;
    }

    public void setTitle(String title) {
      this.title = title;
    }

    public String getAddress() {
      return address;
    }

    public void setAddress(String address) {
      this.address = address;
    }
  }
}
