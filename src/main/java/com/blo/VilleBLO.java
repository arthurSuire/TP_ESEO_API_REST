package com.blo;

import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.Ville;

public interface VilleBLO {

	ArrayList<Ville> getInfoVilles(String codePostal) throws SQLException;
}
