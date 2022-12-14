package com.blo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VilleDAO;
import com.dto.Ville;

@Service
public class VilleBLOImpl implements VilleBLO {
	@Autowired
	private VilleDAO villeDAO;
	@Override
	public List<Ville> getAllVille() {
		return villeDAO.findAllVille();
	}
	@Override
	public List<Ville> getVillesByCodeCommun(String code) {
		return villeDAO.findVilleByCodeCommune(code);
	}
	@Override
	public List<Ville> getVillesByCodePostal(String code) {
		return villeDAO.findVilleByCodePostal(code);
	}
	@Override
	public void addVille(Ville ville) {
		villeDAO.createVille(ville);
	}
	@Override
	public void modifyVille(Ville ville) {
		villeDAO.modifyVille(ville);
	}
	@Override
	public void deleteVille(String codeCommune) {
		villeDAO.deleteVille(codeCommune);
	}
}
