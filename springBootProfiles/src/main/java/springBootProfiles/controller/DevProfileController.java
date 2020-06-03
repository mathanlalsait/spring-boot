package springBootProfiles.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("dev")
@RequestMapping(value = "/")
public class DevProfileController {

	@GetMapping
	public String messages() {
		return "A message from dev";
	}

}
