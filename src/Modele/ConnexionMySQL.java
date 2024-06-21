package src.Modele;
import java.sql.*;
import java.io.*;
import java.util.Scanner;

public class ConnexionMySQL {
	private Connection mysql;
	private boolean connecte=false;
	public ConnexionMySQL() throws ClassNotFoundException{
		this.mysql=null;
		this.connecte=false;
		Class.forName("org.mariadb.jdbc.Driver");
	}

	public void connecter(String nomFichier) throws SQLException {
		this.mysql=null;
		this.connecte=false;
		try {
			FileInputStream fichier = new FileInputStream(nomFichier);
			Scanner scanner = new Scanner(fichier);
			String nomServeur = scanner.nextLine();
			String nomBase = scanner.nextLine();
			String nomLogin = scanner.nextLine();
			String motDePasse = scanner.nextLine();
			scanner.close();
			this.mysql = DriverManager.getConnection(
					"jdbc:mysql://"+nomServeur+":3306/"+nomBase,nomLogin, motDePasse);
		this.connecte=true;
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void close() throws SQLException {
		this.mysql.close();
		this.connecte=false;
	}

    public boolean isConnecte() { return this.connecte;}
    public Blob createBlob()throws SQLException{
		return this.mysql.createBlob();
	}
	public Statement createStatement() throws SQLException {
		return this.mysql.createStatement();
	}

	public PreparedStatement prepareStatement(String requete) throws SQLException{
		return this.mysql.prepareStatement(requete);
	}
}
