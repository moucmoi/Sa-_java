import java.sql.*;

public class ConnexionMySQL {
	private Connection mysql;
	private boolean connecte=false;
	public ConnexionMySQL() throws ClassNotFoundException{
		this.mysql=null;
		this.connecte=false;
		Class.forName("org.mariadb.jdbc.Driver");
	}

	public void connecter() throws SQLException {
		this.mysql=null;
		this.connecte=false;
		this.mysql = DriverManager.getConnection(
					"jdbc:mysql://servinfo-maria:3306/DBfonteny","fonteny","fonteny");
		this.connecte=true;
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
