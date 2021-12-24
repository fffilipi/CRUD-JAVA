package visual;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ClasseConexao {
	
	//Vamos criar um objeto para fazer a conexão:
	public static Connection conexao = null;
				
	public static Connection Conectar () {
	
		//Vamos criar uma variavel com as configurações de acesso ao banco de dados:
		
		try {
			if(conexao == null)
			{
			String config = "jdbc:mysql://localhost/escola"; // alterar aqui no novo projeto
			
			//vamos conectar com base de dados:
			conexao = DriverManager.getConnection(config, "root", "");
			}else conexao = null;
		}catch(SQLException e) {
			e.printStackTrace(); // imprime erro na tela caso ocorrer o erro
		}
		
			return conexao;
		}
	
	
	//Método para fechar a conexão
	
	public static void FecharConexao (Connection c) {
		try {
			if (c !=null) {
				c.close();
			}
		}catch(SQLException e ) {
			e.printStackTrace(); // imprime o erro na tela.
		}
	
	}
		
}
