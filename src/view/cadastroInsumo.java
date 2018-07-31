package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.BandejaTroco;
import model.Insumos;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class cadastroInsumo extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblAbastecerBandejaDe;
	private JLabel labelcafe;
	private JLabel lblleite;
	private JLabel lblacucar;
	private JLabel lblchocolate;
	private JLabel lblcopo;
	private JButton btnExit;
	private JButton btnConfirmar;
	private JTextField textFieldcafe;
	private JTextField textFieldleite;
	private JTextField textFieldacucar;
	private JTextField textFieldchocolate;
	private JTextField textFieldcopo;
	private JTextArea txtRelatorio;
	
	public cadastroInsumo(){
		super();
		setFrameIcon(new ImageIcon(cadastroTroco.class.getResource("/Imagens/Americano1.png")));
		setTitle("Gerenciar Insumos");
		setBackground(new Color(102, 51, 0));
		initComponents();
	}
	
public void initComponents() {
		
		//Botão sair
		btnExit = new JButton("Sair");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastroInsumo.this.setVisible(false);
			}
		});
		
		//design dos componentes
		
		getContentPane().setBackground(new Color(102, 51, 0));
		setBounds(100, 100, 640, 480);
		getContentPane().setLayout(null);
		
		lblAbastecerBandejaDe = new JLabel("Gerenciar Insumos");
		lblAbastecerBandejaDe.setForeground(Color.WHITE);
		lblAbastecerBandejaDe.setFont(new Font("DK Pastis", Font.PLAIN, 32));
		lblAbastecerBandejaDe.setBounds(61, 11, 314, 31);
		getContentPane().add(lblAbastecerBandejaDe);
		
		textFieldcafe = new JTextField();
		textFieldcafe.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldcafe.setForeground(Color.LIGHT_GRAY);
		textFieldcafe.setBounds(91, 85, 86, 20);
		getContentPane().add(textFieldcafe);
		textFieldcafe.setColumns(10);
		textFieldcafe.setToolTipText("cafe");
		
		textFieldleite = new JTextField();
		textFieldleite.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldleite.setForeground(Color.LIGHT_GRAY);
		textFieldleite.setColumns(10);
		textFieldleite.setBounds(91, 116, 86, 20);
		getContentPane().add(textFieldleite);
		textFieldleite.setToolTipText("leite");
		
		textFieldacucar = new JTextField();
		textFieldacucar.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldacucar.setForeground(Color.LIGHT_GRAY);
		textFieldacucar.setColumns(10);
		textFieldacucar.setBounds(91, 147, 86, 20);
		getContentPane().add(textFieldacucar);
		textFieldacucar.setToolTipText("acucar");
		
		labelcafe = new JLabel("Café");
		labelcafe.setForeground(Color.WHITE);
		labelcafe.setFont(new Font("DK Pastis", Font.PLAIN, 18));
		labelcafe.setBounds(30, 86, 61, 20);
		getContentPane().add(labelcafe);
		
		lblleite = new JLabel("Leite");
		lblleite.setForeground(Color.WHITE);
		lblleite.setFont(new Font("DK Pastis", Font.PLAIN, 18));
		lblleite.setBounds(30, 119, 61, 17);
		getContentPane().add(lblleite);
		
		lblacucar = new JLabel("Açúcar");
		lblacucar.setForeground(Color.WHITE);
		lblacucar.setFont(new Font("DK Pastis", Font.PLAIN, 18));
		lblacucar.setBounds(30, 150, 61, 17);
		getContentPane().add(lblacucar);
		
		textFieldchocolate = new JTextField();
		textFieldchocolate.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldchocolate.setForeground(Color.LIGHT_GRAY);
		textFieldchocolate.setColumns(10);
		textFieldchocolate.setBounds(307, 100, 86, 20);
		textFieldchocolate.setToolTipText("choco");
		getContentPane().add(textFieldchocolate);
		
		lblchocolate = new JLabel("Chocolate");
		lblchocolate.setForeground(Color.WHITE);
		lblchocolate.setFont(new Font("DK Pastis", Font.PLAIN, 18));
		lblchocolate.setBounds(246, 101, 61, 19);
		getContentPane().add(lblchocolate);
		
		textFieldcopo = new JTextField();
		textFieldcopo.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldcopo.setForeground(Color.LIGHT_GRAY);
		textFieldcopo.setColumns(10);
		textFieldcopo.setBounds(307, 131, 86, 20);
		textFieldcopo.setToolTipText("copo");
		getContentPane().add(textFieldcopo);
		
		lblcopo = new JLabel("Copo");
		lblcopo.setForeground(Color.WHITE);
		lblcopo.setFont(new Font("DK Pastis", Font.PLAIN, 18));
		lblcopo.setBounds(246, 132, 61, 19);
		getContentPane().add(lblcopo);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(283, 236, 110, 23);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cafe = Integer.parseInt(textFieldcafe.getText().trim());
				int leite = Integer.parseInt(textFieldleite.getText().trim());
				int acucar = Integer.parseInt(textFieldacucar.getText().trim());
				int choco = Integer.parseInt(textFieldchocolate.getText().trim());
				int copo = Integer.parseInt(textFieldcopo.getText().trim());
				Insumos insumos = new Insumos();
				int r = insumos.adiciona(0, cafe);
				if(r>=0){
					String t = (cafe>0)?"adicionado":"removido";
					JOptionPane.showMessageDialog(null, cafe+"g de café "+t);
				}
				else if(r==-2){
					JOptionPane.showMessageDialog(null, "Café não retirado/removido. Não pode retirar/adicionar além do limite.");
				}
				else if(r==-1) JOptionPane.showMessageDialog(null, "Erro no banco");
				
				r = insumos.adiciona(1, leite);
				if(r>=0){
					String t = (leite>0)?"adicionado":"removido";
					JOptionPane.showMessageDialog(null, leite+"g leite "+t);
				}
				else if(r==-2){
					JOptionPane.showMessageDialog(null, "Leite não retirado/removido. Não pode retirar/adicionar além do limite.");
				}
				else if(r==-1) JOptionPane.showMessageDialog(null, "Erro no banco");
				
				r = insumos.adiciona(2, acucar);
				if(r>=0){
					String t = (acucar>0)?"adicionado":"removido";
					JOptionPane.showMessageDialog(null, acucar+"g de açúcar "+t);
				}
				else if(r==-2){
					JOptionPane.showMessageDialog(null, "Açúcar não retirado/removido. Não pode retirar/adicionar além do limite.");
				}
				else if(r==-1) JOptionPane.showMessageDialog(null, "Erro no banco");
				
				r = insumos.adiciona(3, choco);
				if(r>=0){
					String t = (choco>0)?"adicionado":"removido";
					JOptionPane.showMessageDialog(null, choco+"g de chocolate "+t);
				}
				else if(r==-2){
					JOptionPane.showMessageDialog(null, "Chocolate não retirado/removido. Não pode retirar/adicionar além do limite.");
				}
				else if(r==-1) JOptionPane.showMessageDialog(null, "Erro no banco");
				
				r = insumos.adiciona(4, copo);
				if(r>=0){
					String t = (copo>0)?"adicionado":"removido";
					JOptionPane.showMessageDialog(null, copo+" copos "+t);
				}
				else if(r==-2){
					JOptionPane.showMessageDialog(null, "Copo(s) não retirado(s)/removido(s). Não pode retirar/adicionar além do limite.");
				}
				else if(r==-1) JOptionPane.showMessageDialog(null, "Erro no banco");
				
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
		Insumos insumos = new Insumos();
		txtRelatorio.setText(insumos.relatorio());
	}

}
