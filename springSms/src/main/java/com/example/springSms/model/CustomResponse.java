package com.example.springSms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomResponse {
	private ResponseModel responseModel;
	private RequestModel requestModel;
}
