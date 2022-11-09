package com.blo;

import java.sql.SQLException;
import java.util.List;

import com.dto.Ville;

public interface VilleBLO {

	List<Ville> getInfoVilles(String codePostal) throws SQLException;
}
