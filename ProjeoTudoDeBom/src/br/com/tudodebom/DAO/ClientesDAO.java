package br.com.tudodebom.DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.tudodebom.conexao.BancoDeDados;
import br.com.tudodebom.model.Clientes;

public class ClientesDAO {
	
	


	
	
	private PreparedStatement statement;
	private Connection connection = BancoDeDados.getConnection();
	private ResultSet resultset=null;

	public List<Clientes> listaClientes() {
		List<Clientes> lista = new ArrayList<>();
		PreparedStatement statement;
		Connection connection = BancoDeDados.getConnection();
		ResultSet resultset=null;
		try {
			
			// Tratando excecao do retorno select
			String query = "select * from clientes";
			statement = connection.prepareStatement(query);
			resultset=statement.executeQuery(query);
			while (this.resultset.next()) {
				Clientes cliente =new Clientes();
                cliente.setIdCliente(resultset.getInt("id_cliente"));
                cliente.setNomeCliente(resultset.getString("nome_cliente"));
                cliente.setDataNascimento(resultset.getString("data_nascimento"));
                cliente.setCpf(resultset.getString("cpf_cliente"));
                cliente.setNomeCliente(resultset.getString("nome_cliente"));
                lista.add(cliente);
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return lista;
	}

	//inserir registros
	
	public void inserirCliente(Clientes cliente){
		
		  	Connection con = BancoDeDados.getConnection();
	        
	        PreparedStatement stmt = null;
		
	
		try {
			//String query="INSERT INTO clientes1 (nome_cliente,data_nascimento,cpf_cliente,telefone_cliente) VALUES (`?`,`?`,`?`,`?`);";
			stmt=con.prepareStatement("INSERT INTO clientes (nome_cliente,data_nascimento,cpf_cliente,telefone_cliente) VALUES (?,?,?,?);");
			stmt.setString(1, cliente.getNomeCliente());
			stmt.setString(2, cliente.getDataNascimento());
			stmt.setString(3, cliente.getCpf());
			stmt.setString(4, cliente.getTelefone());
			stmt.execute();
		    JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
		 }  catch (Exception e) {
				System.out.println("Erro:"+e.getMessage());
		} finally {
            BancoDeDados.closeConnection(con, stmt);
        }
	}

	public void AtualizarCliente(Clientes cliente) {
		PreparedStatement statement;
		Connection connection = BancoDeDados.getConnection();
		ResultSet resultset=null;
		try {
			// linha de execucao da sinxtaxe update em sql
			String query = ("update clientes SET nome_cliente = ? ,telofone_cliente= ? WHERE id_cliente = ?");
			statement = connection.prepareStatement(query);
			statement.setString(1, cliente.getNomeCliente());
			statement.setString(2, cliente.getTelefone());
			statement.setInt(3, cliente.getIdCliente());
			this.statement.execute(query);
			
		} catch (Exception e) {
			System.out.println("Erro:" + e.getMessage());
		}
	}

	public void deletarCliente(Clientes cliente) {
		PreparedStatement statement;
		Connection connection = BancoDeDados.getConnection();
		
		try {
			// linha de execucao da sintaxe delete em sql
			String query = "delete from clientes where id= ? ;";
			statement=connection.prepareStatement(query);
			statement.setInt(1, cliente.getIdCliente());
			statement.execute(query);
		} catch (Exception e) {
			System.out.println("Erro:" + e.getMessage());
		}
	}
	

}
