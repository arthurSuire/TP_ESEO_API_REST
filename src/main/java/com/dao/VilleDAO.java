package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dto.Ville;

public interface VilleDAO {

	List<Ville> findAllVilles(String codePostal) throws SQLException;
}
