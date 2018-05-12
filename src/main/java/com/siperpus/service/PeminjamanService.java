package com.siperpus.service;

import java.util.List;

<<<<<<< HEAD
import com.siperpus.model.PeminjamanModel;

public interface PeminjamanService {
	 
	List<PeminjamanModel> selectAllPeminjaman ();
	
	PeminjamanModel selectPeminjaman (Integer id);

	
=======
import com.siperpus.model.LiteratureModel;
import com.siperpus.model.MahasiswaModel;

public interface PeminjamanService {
	 List<LiteratureModel> selectAllLiteratures ();
	 
	 void addLiterature (LiteratureModel literature);
	 
	 LiteratureModel selectLiterature (Integer id);
	 
	 void updateLiterature  (LiteratureModel literature);
	 
	 void deleteLiterature (Integer id);
>>>>>>> 23f695539d594836ba4a2900ec3e59525d761d94
	 
}
