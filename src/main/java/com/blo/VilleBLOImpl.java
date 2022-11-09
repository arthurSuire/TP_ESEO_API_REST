package com.blo;

import java.sql.SQLException;
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
	public List<Ville> getInfoVilles(String codePostal) throws SQLException {
		return villeDAO.findAllVilles(codePostal);
	}

}
