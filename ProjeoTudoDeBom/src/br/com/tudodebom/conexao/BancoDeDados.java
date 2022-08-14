package br.com.tudodebom.conexao;


import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;



public class BancoDeDados {
	private  static Connection con = null;
	
	/* Variável para se conectar ao DataBase */
	private static String  servidor = "jdbc:mysql://localhost/ibm";

	/* Variável para receber o nome do usuário do Banco de Dados */
	private  static String usuario = "root";

	/* Variável para receber a senha do usuário do Banco de dados */
	private  static String senha = "wandos12";

	/* Variável para vincular o driver de conexão */
	private static String driver = "com.mysql.cj.jdbc.Driver";

	/*
	 * Permite realizar tratamento da exceção se a conexão com o Banco de Dados
	 * falhar
	 */
	
	/* Metodo para fazer a conexão */
	

	public static Connection getConnection() {
	  
		try {
			if (con == null) {
				Class.forName(driver);
				con = DriverManager.getConnection(servidor, usuario, senha);
			} else if (con.isClosed()) {
				con = null;
				return getConnection();
			}
	  } catch (ClassNotFoundException e) {
	
	    //TODO: use um sistema de log apropriado.
	
	    e.printStackTrace();
	  } catch (SQLException e) {
	
	    //TODO: use um sistema de log apropriado.
	
	    e.printStackTrace();
	  }
	  return con;
	}
	
	public static boolean estaConectado(Connection connection) {
		if(connection!=null) {
			return true;
		}else {
			return false;
		}		
	}
  

}

