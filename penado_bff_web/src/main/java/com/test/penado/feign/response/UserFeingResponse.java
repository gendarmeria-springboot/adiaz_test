package com.test.penado.feign.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFeingResponse {
	private Integer id;
	private String name;
}
