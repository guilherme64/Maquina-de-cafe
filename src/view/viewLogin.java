package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;

public class viewLogin extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblLogin;
	private JLabel lblSenha;
	private JLabel lblNewLabel;
	
	public String usuario;
	public String senha;
	private JButton btnEntrar;
	private JButton btnSair;
	
	public viewLogin(Frame parent, boolean modal){
		super(parent, modal);
		setIconImage(Toolkit.getDefaultToolkit().getImage(viewLogin.class.getResource("/Imagens/Americano1.png")));
		setTitle("Login");
		initComponents();
	}
	
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent evt){
		if(textField.getText().equals("admin") && passwordField.getText().equals("1234")){
				usuario = textField.getText();
				senha = passwordField.getText();
		
				JOptionPane.showMessageDialog(null, "Bem-Vindo");
				
			}
			else{
				JOptionPane.showMessageDialog(null, "Dados não conferem");
				}
		}

		 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewLogin dialog = new viewLogin(new javax.swing.JFrame(), true);
					dialog.setVisible(true);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	
		
	/**
	 * Create the dialog.
	 */

	private void initComponents() {		
		btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(174, 207, 89, 23);
		contentPanel.add(btnEntrar);
		
		//Ação botões
		btnEntrar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("admin") && passwordField.getText().equals("1234")){
					usuario = textField.getText();
					senha = passwordField.getText();

					JOptionPane.showMessageDialog(null, "Bem-Vindo");
					setVisible(false);
					telaManutencao viewManutencao = new telaManutencao();
		
				}
				else{
					JOptionPane.showMessageDialog(null, "Dados não conferem");
					}
			}
		});
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewLogin.this.setVisible(false);
			}
		});
		
		//design dos componentes
		
		setBounds(100, 100, 300, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(102, 51, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblLogin = new JLabel("Login");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setBounds(18, 106, 46, 14);
		contentPanel.add(lblLogin);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setBounds(18, 150, 46, 14);
		contentPanel.add(lblSenha);
		
		textField = new JTextField();
		textField.setBounds(18, 122, 245, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(18, 166, 245, 20);
		contentPanel.add(passwordField);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(viewLogin.class.getResource("/Imagens/Americano1.png")));
		lblNewLabel.setBounds(102, 11, 93, 79);
		contentPanel.add(lblNewLabel);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(174, 207, 89, 23);
		contentPanel.add(btnEntrar);
		
		btnSair.setBounds(18, 207, 89, 23);
		contentPanel.add(btnSair);
	}
}
