package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import model.BandejaTroco;
import model.Vendas;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class gerenciaVendas extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblGerenciamentoDeVenda;
	private JButton btnSair;
	private JTextArea relatorio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gerenciaVendas frame = new gerenciaVendas();
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
	public gerenciaVendas() {
		//botão sair 
		btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerenciaVendas.this.setVisible(false);
			}
		});
		
		//design dos componentes
		
		setBounds(100, 100, 640, 480);
		setBackground(new Color(102, 51, 0));
		getContentPane().setLayout(null);
		
		lblGerenciamentoDeVenda = new JLabel("Gerenciamento de Venda");
		lblGerenciamentoDeVenda.setForeground(Color.WHITE);
		lblGerenciamentoDeVenda.setFont(new Font("DK Pastis", Font.PLAIN, 32));
		lblGerenciamentoDeVenda.setBounds(96, 11, 270, 54);
		getContentPane().add(lblGerenciamentoDeVenda);
		
		relatorio = new JTextArea();
		relatorio.setEditable(false);
		
		
		JScrollPane sp = new JScrollPane( relatorio );
		sp.setBounds(10, 60, 300, 300);
		atualizarRelatorio();
		getContentPane().add(sp);

		btnSair.setBounds(10, 630, 89, 23);
		getContentPane().add(btnSair);
		
	}
	
	public void atualizarRelatorio(){
		Vendas vendas = new Vendas();
		relatorio.setText(vendas.relatorio());
	}

}
