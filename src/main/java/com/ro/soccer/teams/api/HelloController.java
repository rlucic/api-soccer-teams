package com.ro.soccer.teams.api;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@RequestMapping(path="/hi/{name}")
	public String hiThere(Map model, @PathVariable String name){
		model.put("name", name);
		return "hello";
	}
}
