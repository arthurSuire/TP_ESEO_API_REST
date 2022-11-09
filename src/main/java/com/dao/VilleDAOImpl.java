package com.dao;

import java.sql.*;
import java.util.ArrayList;

import com.dto.Coordonnee;
import com.dto.Ville;
import org.springframework.stereotype.Repository;

@Repository
public class VilleDAOImpl implements VilleDAO {
	private final static String BDD_URL = "jdbc:mysql://localhost:3308/twic";
	private final static String LOGIN = "root";
	private final static String PASSWORD = "root";

	public ArrayList<Ville> findAllVilles(String codePostal){

		Connection cn=null;
		Statement st=null;
		ResultSet rs=null;

		ArrayList<Ville> listVille = new ArrayList<Ville>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection(BDD_URL, LOGIN, PASSWORD);
			st = cn.createStatement();
			String sql = "SELECT * FROM ville_france";
			if(codePostal != null) {
				sql = sql + " WHERE Code_postal = " + codePostal +";";
			}
			rs = st.executeQuery(sql);
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
			try {
				assert cn != null;
				cn.close();
				assert st != null;
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return listVille;
	}
}
