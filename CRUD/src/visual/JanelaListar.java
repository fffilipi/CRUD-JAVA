
package visual;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;



public class JanelaListar extends JInternalFrame {
	private JTable tabela1;
	private JTextField txt_pesquisa;
	
	public static Connection conexao = null;
	public static ResultSet resultado;
	public static Statement comando;
	
	
	/**
	 * Launch the application.
	 */

 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaListar frame = new JanelaListar();
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

	public JanelaListar() {
		setClosable(true);
		setTitle("Lista");
		setBounds(100, 100, 380, 242);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 24, 338, 138);
		getContentPane().add(scrollPane);
		
		tabela1 = new JTable();
		scrollPane.setViewportView(tabela1);
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Listar();
			}
		});
		btnNewButton.setBounds(227, 173, 121, 23);
		getContentPane().add(btnNewButton);
		
		txt_pesquisa = new JTextField();
		txt_pesquisa.setBounds(10, 174, 181, 20);
		getContentPane().add(txt_pesquisa);
		txt_pesquisa.setColumns(10);

	}
	
	public void Listar() 
	{
		
						
		try {
			Connection conexao = ClasseConexao.Conectar();
			comando = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			//Comando SQL a ser exeutado:
			String sql = "SELECT codigo as Código, nome as Nome, semestre as Semestre FROM alunos WHERE nome LIKE '%" + txt_pesquisa.getText() + "%'";
			//Vamos executar e receber os dados da tabela:
			resultado =  comando.executeQuery(sql);
			// Enquanto houver linhas mostre na tela:
			if(resultado.next()) {
				//System.out.println(resultado.getString("nome") + " Semestre: " + resultado.getInt("semestre"));
				//Baixar arquivo RS2xml.JAR
				//Vamos preencher a tabela:
								
				tabela1.setModel(DbUtils.resultSetToTableModel(resultado));
				
			}
		
		}catch(SQLException e) {
			e.printStackTrace(); // imprime o erro caso aconteça
		}
	}
}

