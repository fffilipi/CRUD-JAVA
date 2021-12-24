
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

public class JanelaInserir extends JInternalFrame {
	private JTextField semestre_alunos;
	private JTextField nome_alunos;
	
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
					JanelaInserir frame = new JanelaInserir();
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
	
	public JanelaInserir() {
		setClosable(true);
		setTitle("Inserir Alunos");
		setBounds(100, 100, 342, 138);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(10, 21, 72, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblSemestre = new JLabel("Semestre:");
		lblSemestre.setBounds(10, 65, 72, 14);
		getContentPane().add(lblSemestre);
		
		semestre_alunos = new JTextField();
		semestre_alunos.setColumns(10);
		semestre_alunos.setBounds(92, 62, 79, 20);
		getContentPane().add(semestre_alunos);
		
		JButton btnNewButton = new JButton("INSERIR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			     Inserir();
			}
		});
		btnNewButton.setBounds(224, 61, 89, 23);
		getContentPane().add(btnNewButton);
		
		nome_alunos = new JTextField();
		nome_alunos.setColumns(10);
		nome_alunos.setBounds(92, 11, 193, 20);
		getContentPane().add(nome_alunos);

	}
	
	public void Inserir() 
	{
			
		try {
			Connection conexao = ClasseConexao.Conectar();	
			String sql = "INSERT INTO alunos (nome, semestre) VALUES (?, ?)";
			comando = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			//Vamos substituir as interrogações:
			comando.setString(1, nome_alunos.getText()); // 1 significa que é a primeira Interrogação do VALUES
			comando.setInt(2, Integer.parseInt(semestre_alunos.getText())); // 2 significa que é a segunda Interrogação do VALUES
			//Integer.parseInt é o metodo que converte a string em um INT, pois la no Banco de dados colocamos o semestre com INT
			
			
			//Apagar texto após Inseridos
			nome_alunos.setText("");
			semestre_alunos.setText("");
			
										
			//Vamos verificar se inseriu na tabela e mostrar o código
			if(comando.executeUpdate() > 0 ) {
				resultado = comando.getGeneratedKeys();
				if(resultado.next()) {
					JOptionPane.showMessageDialog(null, "Dados gravados no código: " + resultado.getInt(1)); // abre uma janela com uma mensagem apra o usuario
				}
			}
			
		}catch(SQLException e) {
			e.printStackTrace(); // imprime o erro caso aconteça
		}
		
	}
}

