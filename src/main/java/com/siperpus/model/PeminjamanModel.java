package com.siperpus.model;

<<<<<<< HEAD
=======
import java.time.LocalDate;

>>>>>>> 23f695539d594836ba4a2900ec3e59525d761d94
import com.siperpus.model.PeminjamanModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
<<<<<<< HEAD

public class PeminjamanModel{
	private int id;
	private int id_literatur;
	private String username_peminjam;
	private String tanggal_peminjaman;
	private String tanggal_pengembalian;
	private int id_surat;
	private String status_peminjaman;

}

=======
public class PeminjamanModel {
	private int id;
	private int id_literatur;
	private String username_peminjam;
	private LocalDate tanggal_peminjaman;
	private LocalDate tanggal_pengembalian;
	private String status_peminjaman;
	private int id_status;
}
>>>>>>> 23f695539d594836ba4a2900ec3e59525d761d94
