package com.siperpus.service;

import java.util.List;

import com.siperpus.model.LiteratureModel;


public interface LiteratureService {
	 List<LiteratureModel> selectAllLiteratures ();
	 
	 void addLiterature (LiteratureModel literature);
	 
	 LiteratureModel selectLiterature (Integer id);
	 
	 void updateLiterature  (LiteratureModel literature);
	 
	 void deleteLiterature (Integer id);
	 List<LiteratureModel> selectAllLiteraturesBySearchJenis(LiteratureModel literature);
	 List<LiteratureModel> selectAllLiteraturesBySearch(LiteratureModel literature);
}
