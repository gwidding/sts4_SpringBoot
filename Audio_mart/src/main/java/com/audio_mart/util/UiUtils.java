package com.audio_mart.util;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.audio_mart.constant.Method;


@Controller
public class UiUtils {
	
	public String showMessageWithRedirect(
			  @RequestParam(value = "message", required = false) String message,
			  @RequestParam(value = "redirectUri", required = false) String redirectUri,
			  @RequestParam(value = "method", required = false) Method method,
			  @RequestParam(value = "params", required = false) Map<String, Object> params,
			  Model model) {
		
				model.addAttribute("message", message);
				model.addAttribute("redirectUri", redirectUri);
				model.addAttribute("method", method);
				model.addAttribute("params", params);
				
		return "utils/message-redirect";
	}
	
	public String showSuccessMessage( @RequestParam(value = "message", required = false) String message,
			  @RequestParam(value = "redirectUri", required = false) String redirectUri,
			  @RequestParam(value = "isSuccess", required = true) boolean isSuccess,
			  Model model) {
		
				model.addAttribute("message", message);
				model.addAttribute("redirectUri", redirectUri);
				model.addAttribute("isSuccess", isSuccess);
		
		return "utils/success-false";
	}
	
}
