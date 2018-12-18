package com.cg.btva.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class DemoException {

	@ExceptionHandler(value = { Exception.class })
	public ModelAndView handleConflict(Exception ex, HttpServletRequest req) {
		String bodyOfResponse = ex.getMessage();
		String uri = req.getRequestURL().toString();

		ErrorInfo errorInfo = new ErrorInfo(uri, bodyOfResponse);
         ModelAndView view = new ModelAndView();
         view.setViewName("error");
         view.addObject("errorInfo", errorInfo);
         
		return view;
	}
}
