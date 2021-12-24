package visual;
 

import java.awt.EventQueue;


import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class JanelaAlterar extends JInternalFrame {
	private JTextField nome_alunos;
	private JTextField codigo_aluno;
	private JTextField semestre_aluno;
	
	public static Connection conexao = null;
	public static PreparedStatement comando;
	public static ResultSet resultado;
	
		
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaAlterar frame = new JanelaAlterar();
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

	public JanelaAlterar() {
		setTitle("Alterar Dados");
		setClosable(true);
		setBounds(100, 100, 302, 195);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(10, 25, 58, 14);
		getContentPane().add(lblNewLabel);
		
		nome_alunos = new JTextField();
		nome_alunos.setBounds(78, 22, 191, 20);
		getContentPane().add(nome_alunos);
		nome_alunos.setColumns(10);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(10, 101, 58, 14);
		getContentPane().add(lblCdigo);
		
		codigo_aluno = new JTextField();
		codigo_aluno.setColumns(10);
		codigo_aluno.setBounds(78, 101, 58, 20);
		getContentPane().add(codigo_aluno);
		
		JButton btnNewButton = new JButton("Alterar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Alterar();
			}
		});
		btnNewButton.setBounds(188, 132, 89, 23);
		getContentPane().add(btnNewButton);
		
		JLabel lblSemestre = new JLabel("Semestre");
		lblSemestre.setBounds(10, 63, 58, 14);
		getContentPane().add(lblSemestre);
		
		semestre_aluno = new JTextField();
		semestre_aluno.setColumns(10);
		semestre_aluno.setBounds(78, 60, 58, 20);
		getContentPane().add(semestre_aluno);
		
	}
		
	public void Alterar() 
	{
		
		try { 
			Connection conexao = ClasseConexao.Conectar();
			String sql = "UPDATE alunos set nome=?, semestre=? WHERE codigo=?";
			comando = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			//Vamos substituir as interrogações:
			comando.setString(1, nome_alunos.getText()); // 1 significa que é a primeira Interrogação do VALUES
			comando.setInt(2, Integer.parseInt(semestre_aluno.getText())); // 2 significa que é a segunda Interrogação do VALUES
			comando.setInt(3, Integer.parseInt(codigo_aluno.getText())); // 3 significa que é a terceira Interrogação do VALUES
			
				
			nome_alunos.setText("");
			semestre_aluno.setText("");
			codigo_aluno.setText("");
									
			
			//Vamos verificar se inseriu na tabela e mostrar o código
			if(comando.executeUpdate() > 0 ) {
				JOptionPane.showMessageDialog(null, "Dados atualizados!");
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace(); // imprime o erro caso aconteça
		}
	}
	
}

