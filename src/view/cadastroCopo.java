package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class cadastroCopo extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtQuantidade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cadastroCopo frame = new cadastroCopo();
					frame.setMaximizable(true);
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
	public cadastroCopo() {
		setFrameIcon(new ImageIcon(cadastroCopo.class.getResource("/Imagens/Americano1.png")));
		setTitle("Abastecer Copos");
		setBounds(100, 100, 640, 480);
		getContentPane().setBackground(new Color(102, 51, 0));
		getContentPane().setLayout(null);		
		
		JLabel lblAbastecerCopos = new JLabel("Abastecer Copos");
		lblAbastecerCopos.setForeground(Color.WHITE);
		lblAbastecerCopos.setFont(new Font("DK Pastis", Font.PLAIN, 32));
		lblAbastecerCopos.setBounds(123, 39, 192, 40);
		getContentPane().add(lblAbastecerCopos);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setHorizontalAlignment(SwingConstants.RIGHT);
		txtQuantidade.setForeground(Color.LIGHT_GRAY);
		txtQuantidade.setText("Quantidade");
		txtQuantidade.setBounds(192, 122, 86, 20);
		getContentPane().add(txtQuantidade);
		txtQuantidade.setColumns(10);
		
		JLabel lblCopos = new JLabel("Copos");
		lblCopos.setForeground(Color.WHITE);
		lblCopos.setFont(new Font("DK Pastis", Font.PLAIN, 18));
		lblCopos.setBounds(149, 123, 47, 19);
		getContentPane().add(lblCopos);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.setBounds(229, 194, 111, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastroCopo.this.setVisible(false);
			}
		});
		btnCancelar.setBounds(86, 194, 89, 23);
		getContentPane().add(btnCancelar);
		setBounds(100, 100, 450, 300);

	}

}
