package com.blo;

import java.util.List;
import com.dto.Ville;

public interface VilleBLO {
	List<Ville> getAllVille();
	List<Ville> getVille(String codeCommune);
	void addVille(Ville ville);
	void modifyVille(Ville ville);
	void deleteVille(String codeCommune);
}
