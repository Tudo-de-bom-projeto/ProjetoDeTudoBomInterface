package br.com.tudodebom.view;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.tudodebom.DAO.ClientesDAO;
import br.com.tudodebom.conexao.BancoDeDados;
import br.com.tudodebom.model.Clientes;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;

import java.awt.event.ActionEvent;

public class Formulario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textData;
	private JTextField textCpf;
	private JTextField textTelefone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Connection connection=BancoDeDados.getConnection();
		if(BancoDeDados.estaConectado(connection)) {
			System.out.println("Conexão com Banco de Dados foi conectado");
		}else {
			System.out.println("Nao possivel conectar com o Banco de Dados");
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario frame = new Formulario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Formulario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome do Cliente: ");
		lblNome.setBounds(10, 37, 99, 14);
		contentPane.add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(106, 32, 206, 25);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblData = new JLabel("Data de Nascimento:");
		lblData.setBounds(0, 84, 112, 14);
		contentPane.add(lblData);
		
		textData = new JTextField();
		textData.setColumns(10);
		textData.setBounds(106, 79, 206, 25);
		contentPane.add(textData);
		
		JLabel lblCpf = new JLabel("Cpf :");
		lblCpf.setBounds(39, 127, 53, 14);
		contentPane.add(lblCpf);
		
		textCpf = new JTextField();
		textCpf.setColumns(10);
		textCpf.setBounds(106, 122, 206, 25);
		contentPane.add(textCpf);
		
		JLabel lblTelefone = new JLabel("Telefone  :");
		lblTelefone.setBounds(39, 167, 53, 14);
		contentPane.add(lblTelefone);
		
		textTelefone = new JTextField();
		textTelefone.setColumns(10);
		textTelefone.setBounds(106, 162, 206, 25);
		contentPane.add(textTelefone);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				ClientesDAO clientedao = new ClientesDAO();
				Clientes c = new Clientes(); 
				c.setNomeCliente(textNome.getText());
				c.setDataNascimento(textData.getText());
				c.setCpf(textCpf.getText());
				c.setTelefone(textTelefone.getText());
				clientedao.inserirCliente(c);
				textNome.setText("");
			    textData.setText("");
			     textCpf.setText("");
			        textTelefone.setText("");
			}
		});
		btnInserir.setBounds(162, 213, 89, 23);
		contentPane.add(btnInserir);
	}
}

