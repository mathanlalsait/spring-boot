package springBootProfiles.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("prod")
@RequestMapping(value = "/")
public class ProdProfileController {

	@GetMapping
	public String message() {
		return "A message from prod";
	}

}
