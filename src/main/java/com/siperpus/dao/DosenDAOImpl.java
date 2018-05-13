package com.siperpus.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.siperpus.model.DosenModel;
import com.siperpus.model.MahasiswaModel;

@Service
public class DosenDAOImpl implements DosenDAO {
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public DosenModel selectDosen(String nip) {
		DosenModel dosen = restTemplate.getForObject("https://apap-fasilkom.herokuapp.com/api/dosen/view/id/"+nip, DosenModel.class);
		 return dosen;
	}

}
