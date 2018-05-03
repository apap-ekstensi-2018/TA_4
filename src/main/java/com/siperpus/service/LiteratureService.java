package com.siperpus.service;

import java.util.List;

import com.siperpus.model.LiteratureModel;

public interface LiteratureService {
	 List<LiteratureModel> selectAllLiteratures ();
	 
	 void addLiterature (LiteratureModel literature);
	 
	 void selectLiterature (Integer id);
	 
	 void updateLiterature (Integer id);
	 
	 void deleteLiterature (Integer id);
	 
}
