package com.app.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomePageController {

public HomePageController()
{

}
@GetMapping("/")
public ModelAndView showHomePage()
{
	return new ModelAndView("/index","home_content",LocalDate.now());
}
}
	