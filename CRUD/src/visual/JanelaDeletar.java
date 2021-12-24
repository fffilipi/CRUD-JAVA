
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

public class JanelaDeletar extends JInternalFrame {
	private JTextField codigo_alunos;
	
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
					JanelaDeletar frame = new JanelaDeletar();
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

	public JanelaDeletar() {
		setClosable(true);
		setTitle("Excluir aluno do Banco de Dados");
		setBounds(100, 100, 273, 148);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo do Aluno");
		lblNewLabel.setBounds(10, 27, 93, 26);
		getContentPane().add(lblNewLabel);
		
		codigo_alunos = new JTextField();
		codigo_alunos.setBounds(139, 30, 85, 20);
		getContentPane().add(codigo_alunos);
		codigo_alunos.setColumns(10);
		
		JButton btnNewButton = new JButton("Deletar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Deletar();
			}
		});
		btnNewButton.setBounds(139, 84, 89, 23);
		getContentPane().add(btnNewButton);

	}
	
	public void Deletar() 
	{	
	
		
		try {
			Connection conexao = ClasseConexao.Conectar();
			String sql = "DELETE FROM alunos WHERE codigo=?";
			comando = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			//Vamos substituir as interrogações:
			comando.setInt(1, Integer.parseInt(codigo_alunos.getText())); // 1 significa que é a primeira Interrogação do VALUES
			
					
			codigo_alunos.setText("");
												
			//Vamos verificar se inseriu na tabela e mostrar o código
			if(comando.executeUpdate() > 0 ) {
				JOptionPane.showMessageDialog(null, "Dados excluidos!");
			}
			
		}catch(SQLException e) {
			e.printStackTrace(); // imprime o erro caso aconteça
		}
		
	}
}
