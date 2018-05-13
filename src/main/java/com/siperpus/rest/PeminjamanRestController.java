package com.siperpus.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siperpus.model.DosenModel;
import com.siperpus.model.MahasiswaModel;
import com.siperpus.model.PeminjamanModel;
import com.siperpus.model.UserAccountModel;
import com.siperpus.model.UserRestModel;
import com.siperpus.service.PeminjamanService;
import com.siperpus.service.UserAccountService;
 
 
@RestController
@RequestMapping("/rest")
public class PeminjamanRestController {
	
	@Autowired
	PeminjamanService peminjamanService;
	
	@Autowired
	UserAccountService userAccountService;
	
	@RequestMapping("/api/json/isOverdue/{userAccount}")
	public UserRestModel view (@PathVariable(value = "userAccount") String user_account) {
		
		// check valid user account
		UserAccountModel userAccount = userAccountService.selectUserAccount(user_account);

		UserRestModel userReturn = new UserRestModel();
		
		if (userAccount != null) {
			userReturn.setStatusRestHttp("200");
			userReturn.setUsername(userAccount.getUsername()); 
			DosenModel userExistDosen = userAccount.getDosenModel();
			MahasiswaModel userExistMahasiswa = userAccount.getMahasiswaModel();
			
			userReturn.setMsg("Data Mahasiswa/Dosen tidak ditemukan dari API fasilkom-APAP : ");
			if (userExistDosen != null) {
				userReturn.setName(userExistDosen.getNama());
				userReturn.setMsg("Data Dosen ditemukan dari API : ");
			}
			else if (userExistMahasiswa != null) {
				userReturn.setName(userExistMahasiswa.getNama());
				userReturn.setMsg("Data Mahasiswa ditemukan dari API: ");
			}
			
			if (userExistMahasiswa == null && userExistDosen == null) {
				userReturn.setStatusRestHttp("404");
				userReturn.setMsg("Data Mahasiswa ditemukan di user account SIPERPUS dan tidak ditemukan dari API fasilkom-APAP ");
			}
			
			boolean checkOverdueByUserAccount = peminjamanService.isPeminjamanOverdue(user_account);
			if(checkOverdueByUserAccount) {
				// return name, and npm/user account
				userReturn.setOverdue("true");
				return userReturn;
			}
			else {
				userReturn.setOverdue("false");
				return userReturn;
			}
		}
		else {
			userReturn.setStatusRestHttp("404");
			userReturn.setMsg("User name tidak ditemukan");
		}
		
		
	 return null;
	 
	 }
}
