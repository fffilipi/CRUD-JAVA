package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Principal {
private JFrame frmCadastroDeAlunos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frmCadastroDeAlunos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});		
}
	
	
		
	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDeAlunos = new JFrame();
		frmCadastroDeAlunos.setTitle("Cadastro de Alunos");
		frmCadastroDeAlunos.setBounds(100, 100, 607, 425);
		frmCadastroDeAlunos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroDeAlunos.getContentPane().setLayout(null);
		
		JDesktopPane painel_desktop = new JDesktopPane();
		painel_desktop.setBounds(0, 0, 591, 358);
		frmCadastroDeAlunos.getContentPane().add(painel_desktop);
		
		JMenuBar menuBar = new JMenuBar();
		frmCadastroDeAlunos.setJMenuBar(menuBar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Inserir");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Ao clicar no botão inserir no menu, vai ser mostrado no desktop
				
				JanelaInserir jInserir = new JanelaInserir(); // criar objeto jInserir
				painel_desktop.add(jInserir); //colocar a janela criada no desktop
				jInserir.setVisible(true); //deixar janela visivel para o usuario
				
				
			}
		});
		menuBar.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Alterar");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
               
				//Ao clicar no botão inserir no menu, vai ser mostrado no desktop
				
				JanelaAlterar jAlterar = new JanelaAlterar(); // criar objeto jAlterar
				painel_desktop.add(jAlterar); //colocar a janela criada no desktop
				jAlterar.setVisible(true); //deixar janela visivel para o usuario
							
			}
		});
		menuBar.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Deletar");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Ao clicar no botão inserir no menu, vai ser mostrado no desktop
				
				JanelaDeletar jDeletar = new JanelaDeletar(); // criar objeto jDeletar
				painel_desktop.add(jDeletar); //colocar a janela criada no desktop
				jDeletar.setVisible(true); //deixar janela visivel para o usuario 
				
			}
		});
		menuBar.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Listar");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Ao clicar no botão inserir no menu, vai ser mostrado no desktop
				
				JanelaListar jListar = new JanelaListar(); // criar objeto jListar
				painel_desktop.add(jListar); //colocar a janela criada no desktop
				jListar.setVisible(true); //deixar janela visivel para o usuario
				
			}
		});
		menuBar.add(mntmNewMenuItem_3);
	}

}