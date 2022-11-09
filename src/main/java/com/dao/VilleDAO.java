package com.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.Ville;

public interface VilleDAO {

	public ArrayList<Ville> findAllVilles(String codePostal) throws SQLException;
}
