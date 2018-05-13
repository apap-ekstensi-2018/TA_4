package com.siperpus.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
 
import com.siperpus.model.SuratModel;

@Repository
public class SuratDAOImpl implements SuratDAO {
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public SuratModel selectSurat(int no_surat) {
		SuratModel surat = restTemplate.getForObject("http://sisurat-2.herokuapp.com/api/surat/view/"+no_surat, SuratModel.class);
		
		//SuratModel surat = new SuratModel();
		//surat.setId_mahasiswa("");
		//surat.setJenis_surat("");
		//surat.setKeterangan("Default test");
		//surat.setStatus_surat("disetujui");
		
		return surat;
	}

}

