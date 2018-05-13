package com.siperpus.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRestModel {
	private String username;
	private String name;
	private String overdue;
	private String statusRestHttp;
	private String msg;
}
