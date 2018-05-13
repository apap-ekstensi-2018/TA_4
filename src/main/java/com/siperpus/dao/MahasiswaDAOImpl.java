package com.siperpus.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.siperpus.model.MahasiswaModel;

@Service
public class MahasiswaDAOImpl implements MahasiswaDAO {
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public MahasiswaModel selectMahasiswa(String npm) {
		MahasiswaModel mahasiswa = restTemplate.getForObject("https://apap-fasilkom.herokuapp.com/api/mahasiswa/view/npm/"+npm, MahasiswaModel.class);
		 return mahasiswa;
	}

}
