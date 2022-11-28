package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.dto.Coordonnee;
import com.dto.Ville;
import org.springframework.stereotype.Repository;

@Repository
public class VilleDAOImpl implements VilleDAO {
	private static final String BDD_URL = "jdbc:mysql://localhost:3308/twic";
	private static final String LOGIN = "root";
	private static final String PASSWORD = "root";

	@Override
	public List<Ville> findAllVille() {
		ArrayList<Ville> listVille = new ArrayList<>();
		try (
				Connection cn = DriverManager.getConnection(BDD_URL, LOGIN, PASSWORD);
				Statement st = cn.createStatement()
		){
			String sql = "SELECT * FROM ville_france";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Ville ville = new Ville();
				ville.setCodeCommune(rs.getString("Code_commune_INSEE"));
				ville.setNomCommune(rs.getString("Nom_commune"));
				ville.setCodePostal(rs.getString("Code_postal"));
				ville.setLibelleAcheminement(rs.getString("Libelle_acheminement"));
				ville.setLigne5(rs.getString("Ligne_5"));
				ville.setCoordonnee(new Coordonnee(rs.getString("Latitude"), rs.getString("Longitude")));
				listVille.add(ville);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listVille;
	}

	@Override
	public List<Ville> findVilleByCodeCommune(String codeCommune) {
		ArrayList<Ville> listVilleQuery = new ArrayList<>();
		try (
				Connection cn = DriverManager.getConnection(BDD_URL, LOGIN, PASSWORD);
				Statement st = cn.createStatement()
		){
			String sql = "SELECT * FROM ville_france WHERE code_commune_INSEE=" + codeCommune;
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Ville ville = new Ville();
				ville.setCodeCommune(rs.getString("Code_commune_INSEE"));
				ville.setNomCommune(rs.getString("Nom_commune"));
				ville.setCodePostal(rs.getString("Code_postal"));
				ville.setLibelleAcheminement(rs.getString("Libelle_acheminement"));
				ville.setLigne5(rs.getString("Ligne_5"));
				ville.setCoordonnee(new Coordonnee(rs.getString("Latitude"), rs.getString("Longitude")));
				listVilleQuery.add(ville);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listVilleQuery;
	}

	@Override
	public List<Ville> findVilleByCodePostal(String codePostal) {
		ArrayList<Ville> listVilleQuery = new ArrayList<>();
		try (
				Connection cn = DriverManager.getConnection(BDD_URL, LOGIN, PASSWORD);
				Statement st = cn.createStatement()
		){
			String sql = "SELECT * FROM ville_france WHERE code_postal=" + codePostal;
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Ville ville = new Ville();
				ville.setCodeCommune(rs.getString("Code_commune_INSEE"));
				ville.setNomCommune(rs.getString("Nom_commune"));
				ville.setCodePostal(rs.getString("Code_postal"));
				ville.setLibelleAcheminement(rs.getString("Libelle_acheminement"));
				ville.setLigne5(rs.getString("Ligne_5"));
				ville.setCoordonnee(new Coordonnee(rs.getString("Latitude"), rs.getString("Longitude")));
				listVilleQuery.add(ville);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listVilleQuery;
	}

	@Override
	public void createVille(Ville ville) {
		try(
			Connection cn = DriverManager.getConnection(BDD_URL, LOGIN, PASSWORD);
			Statement st = cn.createStatement()
		){
			String sql =  "INSERT INTO ville_france VALUES('"+
					ville.getCodeCommune()+"','"+
					ville.getNomCommune()+"','"+
					ville.getCodePostal()+"','"+
					ville.getLibelleAcheminement() + "','"+
					ville.getLigne5()+"','"+
					ville.getCoordonnee().getLatitude()+"','"+
					ville.getCoordonnee().getLongitude()+"')";
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modifyVille(Ville ville) {
		try(
				Connection cn = DriverManager.getConnection(BDD_URL, LOGIN, PASSWORD);
				Statement st = cn.createStatement()
		){
			String sql = "UPDATE ville_france SET Nom_commune='" + ville.getNomCommune() +
					"', Code_postal='" + ville.getCodePostal() +
					"', Libelle_acheminement='" + ville.getLibelleAcheminement() +
					"', Ligne_5='" + ville.getLigne5() +
					"', Latitude='" + ville.getCoordonnee().getLatitude() +
					"', Longitude='" + ville.getCoordonnee().getLongitude() +
					"' WHERE Code_commune_INSEE='" + ville.getCodeCommune() + "'";
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteVille(String codeCommune) {
		try(
				Connection cn = DriverManager.getConnection(BDD_URL, LOGIN, PASSWORD);
				Statement st = cn.createStatement()
		){
			String sql = "DELETE FROM ville_france WHERE Code_commune_INSEE=" + codeCommune;
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
