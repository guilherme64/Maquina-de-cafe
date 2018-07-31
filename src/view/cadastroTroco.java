package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

import model.BandejaTroco;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class cadastroTroco extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblAbastecerBandejaDe;
	private JLabel label2reais;
	private JLabel lblR5reais;
	private JLabel lblR10reais;
	private JLabel labe50cents;
	private JLabel lbl1real;
	private JButton btnExit;
	private JButton btnConfirmar;
	private JTextField textField2reais;
	private JTextField textField5reais;
	private JTextField textField10reais;
	private JTextField textField;
	private JTextField textField_1;
	private JTextArea txtRelatorio;
	
	public cadastroTroco(){
		super();
		setFrameIcon(new ImageIcon(cadastroTroco.class.getResource("/Imagens/Americano1.png")));
		setTitle("Abastercer Troco");
		setBackground(new Color(102, 51, 0));
		initComponents();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cadastroTroco frame = new cadastroTroco();
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
	public void initComponents() {
		
		//Botão sair
		btnExit = new JButton("Sair");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastroTroco.this.setVisible(false);
			}
		});
		
		//design dos componentes
		
		getContentPane().setBackground(new Color(102, 51, 0));
		setBounds(100, 100, 640, 480);
		getContentPane().setLayout(null);
		
		lblAbastecerBandejaDe = new JLabel("Abastecer Bandeja de Troco");
		lblAbastecerBandejaDe.setForeground(Color.WHITE);
		lblAbastecerBandejaDe.setFont(new Font("DK Pastis", Font.PLAIN, 32));
		lblAbastecerBandejaDe.setBounds(61, 11, 314, 31);
		getContentPane().add(lblAbastecerBandejaDe);
		
		textField2reais = new JTextField();
		textField2reais.setHorizontalAlignment(SwingConstants.RIGHT);
		textField2reais.setForeground(Color.LIGHT_GRAY);
		textField2reais.setBounds(91, 85, 86, 20);
		getContentPane().add(textField2reais);
		textField2reais.setColumns(10);
		
		textField5reais = new JTextField();
		textField5reais.setHorizontalAlignment(SwingConstants.RIGHT);
		textField5reais.setForeground(Color.LIGHT_GRAY);
		textField5reais.setColumns(10);
		textField5reais.setBounds(91, 116, 86, 20);
		getContentPane().add(textField5reais);
		
		textField10reais = new JTextField();
		textField10reais.setHorizontalAlignment(SwingConstants.RIGHT);
		textField10reais.setForeground(Color.LIGHT_GRAY);
		textField10reais.setColumns(10);
		textField10reais.setBounds(91, 147, 86, 20);
		getContentPane().add(textField10reais);
		
		label2reais = new JLabel("R$ 2,00");
		label2reais.setForeground(Color.WHITE);
		label2reais.setFont(new Font("DK Pastis", Font.PLAIN, 18));
		label2reais.setBounds(30, 86, 61, 20);
		getContentPane().add(label2reais);
		
		lblR5reais = new JLabel("R$ 5,00");
		lblR5reais.setForeground(Color.WHITE);
		lblR5reais.setFont(new Font("DK Pastis", Font.PLAIN, 18));
		lblR5reais.setBounds(30, 119, 61, 17);
		getContentPane().add(lblR5reais);
		
		lblR10reais = new JLabel("R$ 10,00");
		lblR10reais.setForeground(Color.WHITE);
		lblR10reais.setFont(new Font("DK Pastis", Font.PLAIN, 18));
		lblR10reais.setBounds(30, 150, 61, 17);
		getContentPane().add(lblR10reais);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setForeground(Color.LIGHT_GRAY);
		textField.setColumns(10);
		textField.setBounds(307, 100, 86, 20);
		getContentPane().add(textField);
		
		labe50cents = new JLabel("R$ 0,50");
		labe50cents.setForeground(Color.WHITE);
		labe50cents.setFont(new Font("DK Pastis", Font.PLAIN, 18));
		labe50cents.setBounds(246, 101, 61, 19);
		getContentPane().add(labe50cents);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_1.setForeground(Color.LIGHT_GRAY);
		textField_1.setColumns(10);
		textField_1.setBounds(307, 131, 86, 20);
		getContentPane().add(textField_1);
		
		lbl1real = new JLabel("R$ 1,00");
		lbl1real.setForeground(Color.WHITE);
		lbl1real.setFont(new Font("DK Pastis", Font.PLAIN, 18));
		lbl1real.setBounds(246, 132, 61, 19);
		getContentPane().add(lbl1real);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(283, 236, 110, 23);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int valor50 = Integer.parseInt(textField.getText().trim());
				int valor1 = Integer.parseInt(textField_1.getText().trim());
				int valor2 = Integer.parseInt(textField2reais.getText().trim());
				int valor5 = Integer.parseInt(textField5reais.getText().trim());
				int valor10 = Integer.parseInt(textField10reais.getText().trim());
				BandejaTroco bandeja = new BandejaTroco();
				int r = bandeja.carregarBandeja(0, valor50);
				if(r>=0){
					String t = (valor50>0)?"adicionadas":"removidas";
					JOptionPane.showMessageDialog(null, valor50+" moedas de R$ 0,50 "+t);
				}
				else if(r==-2){
					JOptionPane.showMessageDialog(null, "Moedas de R$ 0,50 não retiradas. Não pode retirar abaixo da quantidade atual.");
				}
				else if(r==-3){
					JOptionPane.showMessageDialog(null, "Moedas de R$ 0,50 não adicionadas. Não pode adicionar acima da capacidade de 1000.");
				}
				
				r = bandeja.carregarBandeja(1, valor1);
				if(r>=0){
					String t = (valor1>0)?"adicionadas":"removidas";
					JOptionPane.showMessageDialog(null, valor1+" cédulas de R$ 1,00 "+t);
				}
				else if(r==-2){
					JOptionPane.showMessageDialog(null, "Cédulas de R$ 1,00 não retiradas. Não pode retirar abaixo da quantidade atual.");
				}
				else if(r==-3){
					JOptionPane.showMessageDialog(null, "Cédulas de R$ 1,00 não adicionadas. Não pode adicionar acima da capacidade de 1000.");
				}
				
				r = bandeja.carregarBandeja(2, valor2);
				if(r>=0){
					String t = (valor2>0)?"adicionadas":"removidas";
					JOptionPane.showMessageDialog(null, valor2+" cédulas de R$ 2,00 "+t);
				}
				else if(r==-2){
					JOptionPane.showMessageDialog(null, "Cédulas de R$ 2,00 não retiradas. Não pode retirar abaixo da quantidade atual.");
				}
				else if(r==-3){
					JOptionPane.showMessageDialog(null, "Cédulas de R$ 2,00 não adicionadas. Não pode adicionar acima da capacidade de 1000.");
				}
				
				r = bandeja.carregarBandeja(3, valor5);
				if(r>=0){
					String t = (valor5>0)?"adicionadas":"removidas";
					JOptionPane.showMessageDialog(null, valor5+" cédulas de R$ 5,00 "+t);
				}
				else if(r==-2){
					JOptionPane.showMessageDialog(null, "Cédulas de R$ 5,00 não retiradas. Não pode retirar abaixo da quantidade atual.");
				}
				else if(r==-3){
					JOptionPane.showMessageDialog(null, "Cédulas de R$ 5,00 não adicionadas. Não pode adicionar acima da capacidade de 1000.");
				}
				
				r = bandeja.carregarBandeja(4, valor10);
				if(r>=0){
					String t = (valor10>0)?"adicionadas":"removidas";
					JOptionPane.showMessageDialog(null, valor10+" cédulas de R$ 10,00 "+t);
				}
				else if(r==-2){
					JOptionPane.showMessageDialog(null, "Cédulas de R$ 10,00 não retiradas. Não pode retirar abaixo da quantidade atual.");
				}
				else if(r==-3){
					JOptionPane.showMessageDialog(null, "Cédulas de R$ 10,00 não adicionadas. Não pode adicionar acima da capacidade de 1000.");
				}
				
				atualizarRelatorio();
			}
		});
		getContentPane().add(btnConfirmar);
		
		btnExit.setBounds(10, 236, 89, 23);
		getContentPane().add(btnExit);
		
		txtRelatorio = new JTextArea();
		txtRelatorio.setEditable(false);
		txtRelatorio.setBounds(10, 266, 400, 200);
		atualizarRelatorio();
		getContentPane().add(txtRelatorio);

	}
	
	public void atualizarRelatorio(){
		BandejaTroco bandeja = new BandejaTroco();
		txtRelatorio.setText(bandeja.relatorioTrocos());
	}
}
