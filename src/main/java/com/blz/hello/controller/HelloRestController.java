package com.blz.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blz.hello.dto.User;

@RestController
@RequestMapping("/hello")
public class HelloRestController {
	
	/**
	 * curl localhost:8080/hello -w "\n"
	 * 
	 * @return
	 */
	@GetMapping(value = { "", "/", "/home" })
	public String sayHello() {
		return "Hello From BridgeLabz!";
	}

	/**
	 * curl localhost:8080/hello/query?fname=Mark -w "\n"
	 * 
	 * @param fname
	 * @return
	 */
	@GetMapping(value = { "/query" })
	public String sayHello(@RequestParam(value = "fname") String fname) {
		return "Hello " + fname + " from BridgeLabz!";
	}

	/**
	 * curl localhost:8080/hello/param/Mark -w "\n"
	 * 
	 * @param name
	 * @return
	 */
	@GetMapping("/param/{name}")
	public String sayHelloParam(@PathVariable String name) {
		return "Hello " + name + " from BridgeLabz!";
	}

	/**
	 * curl -X POST -H "Content-Type: application/json" -d
	 * '{"fname":"Mark","lname":"Taylor"}' localhost:8080/hello/query?fname=Mark -w
	 * "\n"
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping("/post")
	public String sayHello(@RequestBody User user) {
		return "Hello " + user.getFname() + " " + user.getLname() + " from BridgeLabz!";
	}

	/**
	 * curl -X PUT localhost:8080/hello/put/Mark/?lname=Taylorr -w "\n"
	 * 
	 * @param fname
	 * @param lname
	 * @return
	 */
	@PutMapping("/put/{fname}")
	public String sayHello(@PathVariable String fname, @RequestParam(value = "lname") String lname) {
		return "Hello " + fname + " " + lname + " from BridgeLabz!";
	}
}
