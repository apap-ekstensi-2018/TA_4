package com.siperpus.service;

import java.util.List;


import com.siperpus.model.PeminjamanModel;

import com.siperpus.model.LiteratureModel;


public interface PeminjamanService {
	 List<LiteratureModel> selectAllLiteratures ();
	 
	 void addLiterature (LiteratureModel literature);
	 PeminjamanModel selectPeminjaman (Integer id);
	 LiteratureModel selectLiterature (Integer id);
	 
	 void updateLiterature  (LiteratureModel literature);
	 
	 void deleteLiterature (Integer id);

	 
}
