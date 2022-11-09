package com.dao;

import java.sql.*;
import java.util.ArrayList;

import com.dto.Coordonnee;
import com.dto.Ville;
import org.springframework.stereotype.Repository;

@Repository
public class VilleDAOImpl implements VilleDAO {
	private static final String BDD_URL = "jdbc:mysql://localhost:3308/twic";
	private static final String LOGIN = "root";
	private static final String PASSWORD = "root";

	public ArrayList<Ville> findAllVilles(String codePostal) throws SQLException {
		ArrayList<Ville> listVille = new ArrayList<>();
		Connection cn = null;
		Statement st = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection(BDD_URL, LOGIN, PASSWORD);
			st = cn.createStatement();
			String sql = "SELECT * FROM ville_france";
			if(codePostal != null) {
				sql = sql + " WHERE Code_postal = " + codePostal +";";
			}
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Ville ville = new Ville();
				ville.setCodeCommune(rs.getString("Code_commune_INSEE"));
				ville.setNomCommune(rs.getString("Nom_commune"));
				ville.setCodePostal(rs.getString("Code_postal"));
				ville.setLibelleAcheminement(rs.getString("Libelle_acheminement"));
				ville.setCoordonnee(new Coordonnee(rs.getString("Latitude"), rs.getString("Longitude")));
				listVille.add(ville);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			assert st != null;
			st.close();
			cn.close();
		}

		return listVille;
	}
}
