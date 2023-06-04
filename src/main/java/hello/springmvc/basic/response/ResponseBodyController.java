package hello.springmvc.basic.response;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ResponseBodyController {

	@GetMapping("/response-body-string-v1")
	public void responseDobyV1(HttpServletResponse response) throws IOException {
		response.getWriter().write("ok");
	}
	
	@GetMapping("/response-body-string-v2")
	public ResponseEntity<String> responseDobyV2(){
		return new ResponseEntity<String>("ok", HttpStatus.OK);
	}
	
	@ResponseBody
	@GetMapping("/response-body-string-v3")
	public String responseDobyV3(){
		return "ok";
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@ResponseBody
	@GetMapping("/response-body-string-v4")
	public String responseDobyV4(){
		return "ok";
	}
	
	@GetMapping("/response-body-json-v1")
	public ResponseEntity<HelloData> responseBodyJsonV1(){
		HelloData helloData = new HelloData();
		helloData.setUsername("user");
		helloData.setAge(10);
		return new ResponseEntity<>(helloData, HttpStatus.OK);
	}
	
	@ResponseBody
	@GetMapping("/response-body-json-v2")
	public HelloData responseBodyJsonV2(){
		HelloData helloData = new HelloData();
		helloData.setUsername("user");
		helloData.setAge(10);
		return helloData;
	}
}
