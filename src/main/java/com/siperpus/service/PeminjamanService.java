package com.siperpus.service;

import java.util.List;

import com.siperpus.model.LiteratureModel;
import com.siperpus.model.MahasiswaModel;

public interface PeminjamanService {
	 List<LiteratureModel> selectAllLiteratures ();
	 
	 void addLiterature (LiteratureModel literature);
	 
	 LiteratureModel selectLiterature (Integer id);
	 
	 void updateLiterature  (LiteratureModel literature);
	 
	 void deleteLiterature (Integer id);
	 
}
