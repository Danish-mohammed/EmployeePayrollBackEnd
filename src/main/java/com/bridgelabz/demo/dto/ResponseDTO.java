package com.bridgelabz.demo.dto;

import org.springframework.stereotype.Component;

// import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Component
public @Data class ResponseDTO {
	
	private String message;
	private Object data;
	// private Object token;


	public ResponseDTO(String message,Object data) {
		this.message = message;
		this.data = data;
	}
}
