package com.dao;

import java.util.List;
import com.dto.Ville;

public interface VilleDAO {
	List<Ville> findAllVille();
	List<Ville> findVille(String code);
	void createVille(Ville ville);
	void modifyVille(Ville ville);
	void deleteVille(String codeCommune);
}
