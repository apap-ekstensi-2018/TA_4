package com.siperpus.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MahasiswaModel {
	 private String npm;
	 private String name;
	 private double gpa;
	 
	 /**
	 * Folder location for storing files
     */
	 
	 private String location = "upload-dir";

}
