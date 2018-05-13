package com.siperpus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siperpus.dao.DosenDAO;
import com.siperpus.dao.MahasiswaDAO;
import com.siperpus.dao.UserAccountMapper;
import com.siperpus.model.DosenModel;
import com.siperpus.model.MahasiswaModel;
import com.siperpus.model.UserAccountModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserAccountServiceImpl implements UserAccountService{
	
	@Autowired
	UserAccountMapper userAccountMapper;
	
	@Autowired
	MahasiswaDAO mahasiswaDao;
	

	@Autowired
	DosenDAO dosenDao;
	
	@Override
	public UserAccountModel selectUserAccount(String username) {
		
		UserAccountModel userAccount = userAccountMapper.selectUserAccount(username);
		if (userAccount != null) {
			// check role
			if (userAccount.getRole()=="ROLE_DOSEN") {
				// mapping dosen model and add into existing user account
				DosenModel detailDosen = dosenDao.selectDosen(userAccount.getUsername());
				if (detailDosen != null) {
					// add detail dosen  into user account 
					userAccount.setDosenModel(detailDosen);
					
				}
			}
			else if (userAccount.getRole()=="ROLE_MAHASISWA") {
				// mapping mahasiswa model add into existing user account
				MahasiswaModel detailMahasiswa = mahasiswaDao.selectMahasiswa(userAccount.getUsername());
				if (detailMahasiswa!= null) {
					// add detail into user account existing
					userAccount.setMahasiswaModel(detailMahasiswa);;
				}
			}
		}
		
		return userAccount;
	}
}
