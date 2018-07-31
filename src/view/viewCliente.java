package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.TitledBorder;

import controller.VendaController;

import javax.swing.JTextField;
import javax.swing.UIManager;

public class viewCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JPanel panel = new JPanel();
	JButton btnLogin;
	JButton btnComprar;
	JButton btnCancelar;
	JButton btAddCedula;
	JButton btAddMoeda;
	private JRadioButton rdbtnCappuccino;
	private JRadioButton rdbtnAmericano;
	private JRadioButton rdbtnBlack;
	private JRadioButton rdbtnDouble;
	private JRadioButton rdbtnLatte;
	private JRadioButton rdbtnExpresso;
	private JLabel label;
	private JLabel lblCappuccino;
	private JLabel lblAmericano;
	private JLabel lblBlack;
	private JLabel lblDouble;
	private JLabel lblLatte;
	private JLabel lblExpresso;
	private JLabel lblCapa;
	viewLogin telaLogin = new viewLogin(this, true);
	private JLabel lblCafeEscolhido;
	private JLabel lblCafePreco;
	private JLabel lblCdula;
	private JLabel lblMoeda;
	private JTextField txtFieldCedula;
	private JTextField txtFieldMoeda;
	private VendaController vendaController;
	
	public viewCliente(){
		vendaController = new VendaController();
		initComponents();
	}


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewCliente frame = new viewCliente();
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
	private void initComponents() {
		contentPane = new JPanel();
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaLogin.setVisible(true);
			}
		});
		
		//Botões de escolha 
		
		rdbtnCappuccino = new JRadioButton("Cappuccino");
		rdbtnCappuccino.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(!vendaController.selectTipo(2)){
					panel.setVisible(false);
					JOptionPane.showMessageDialog(null, vendaController.mensagem);
					return;
				}
				panel.setVisible(true);
				lblCafeEscolhido.setIcon(new ImageIcon(viewCliente.class.getResource("/Imagens/Cappuccino.png")));
				lblCafePreco.setText(vendaController.getNomeCafe()+"\n R$ "+vendaController.getValorCafe());
				btnComprar.setEnabled(false);
				btAddCedula.setEnabled(true);
				btAddMoeda.setEnabled(true);
				txtFieldCedula.setText("");
				txtFieldMoeda.setText("");
			}
		});
		rdbtnCappuccino.setActionCommand(vendaController.getNomeCafe());
		
		rdbtnAmericano = new JRadioButton("Com Leite");
		rdbtnAmericano.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (!vendaController.selectTipo(1)){
					panel.setVisible(false);
					JOptionPane.showMessageDialog(null, vendaController.mensagem);
					return;
				}
				panel.setVisible(true);
				lblCafeEscolhido.setIcon(new ImageIcon(viewCliente.class.getResource("/Imagens/Americano.png")));
				lblCafePreco.setText(vendaController.getNomeCafe()+"\n R$ "+vendaController.getValorCafe());
				btnComprar.setEnabled(false);
				btAddCedula.setEnabled(true);
				btAddMoeda.setEnabled(true);
				txtFieldCedula.setText("");
				txtFieldMoeda.setText("");
			}
		});
		rdbtnAmericano.setActionCommand(vendaController.getNomeCafe()+"\n R$ "+vendaController.getValorCafe());
		
		rdbtnBlack = new JRadioButton("Preto");
		rdbtnBlack.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (!vendaController.selectTipo(0)){
					panel.setVisible(false);
					JOptionPane.showMessageDialog(null, vendaController.mensagem);
					return;
				}
				panel.setVisible(true);
				lblCafeEscolhido.setIcon(new ImageIcon(viewCliente.class.getResource("/Imagens/Black.png")));
				lblCafePreco.setText(vendaController.getNomeCafe()+"\n R$ "+vendaController.getValorCafe());
				btnComprar.setEnabled(false);
				btAddCedula.setEnabled(true);
				btAddMoeda.setEnabled(true);
				txtFieldCedula.setText("");
				txtFieldMoeda.setText("");
			}
		});
		rdbtnBlack.setActionCommand(vendaController.getNomeCafe()+"\n R$ "+vendaController.getValorCafe());
		
		rdbtnDouble = new JRadioButton("Capuccino amargo");
		rdbtnDouble.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (!vendaController.selectTipo(5)){
					panel.setVisible(false);
					JOptionPane.showMessageDialog(null, vendaController.mensagem);
					return;
				}
				panel.setVisible(true);
				lblCafeEscolhido.setIcon(new ImageIcon(viewCliente.class.getResource("/Imagens/Double.png")));
				lblCafePreco.setText(vendaController.getNomeCafe()+"\n R$ "+vendaController.getValorCafe());
				btnComprar.setEnabled(false);
				btAddCedula.setEnabled(true);
				btAddMoeda.setEnabled(true);
				txtFieldCedula.setText("");
				txtFieldMoeda.setText("");
			}
		});
		rdbtnDouble.setActionCommand(vendaController.getNomeCafe()+"\n R$ "+vendaController.getValorCafe());
		
		rdbtnLatte = new JRadioButton("Com Leite amargo");
		rdbtnLatte.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (!vendaController.selectTipo(4)){
					panel.setVisible(false);
					JOptionPane.showMessageDialog(null, vendaController.mensagem);
					return;
				}
				panel.setVisible(true);
				lblCafeEscolhido.setIcon(new ImageIcon(viewCliente.class.getResource("/Imagens/Latte.png")));
				lblCafePreco.setText(vendaController.getNomeCafe()+"\n R$ "+vendaController.getValorCafe());
				btnComprar.setEnabled(false);
				btAddCedula.setEnabled(true);
				btAddMoeda.setEnabled(true);
				txtFieldCedula.setText("");
				txtFieldMoeda.setText("");
			}
		});
		rdbtnLatte.setActionCommand(vendaController.getNomeCafe()+"\n R$ "+vendaController.getValorCafe());
		
		rdbtnExpresso = new JRadioButton("Preto amargo");
		rdbtnExpresso.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (!vendaController.selectTipo(1)) {
					panel.setVisible(false);
					JOptionPane.showMessageDialog(null, vendaController.mensagem);
					return;
				}
				panel.setVisible(true);
				lblCafeEscolhido.setIcon(new ImageIcon(viewCliente.class.getResource("/Imagens/Expresso.png")));
				lblCafePreco.setText(vendaController.getNomeCafe()+"\n R$ "+vendaController.getValorCafe());
				btnComprar.setEnabled(false);
				btAddCedula.setEnabled(true);
				btAddMoeda.setEnabled(true);
				txtFieldCedula.setText("");
				txtFieldMoeda.setText("");
			}
		});
		rdbtnExpresso.setActionCommand(vendaController.getNomeCafe()+"\n R$ "+vendaController.getValorCafe());

		//grupo de botões
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnCappuccino);
		group.add(rdbtnAmericano);
		group.add(rdbtnBlack);
		group.add(rdbtnDouble);
		group.add(rdbtnLatte);
		group.add(rdbtnExpresso);
		
		//Imagens
		
		label = new JLabel("");
		lblAmericano = new JLabel("");
		lblBlack = new JLabel("");
		lblDouble = new JLabel("");
		lblLatte = new JLabel("");
		lblExpresso = new JLabel("");		
		lblCappuccino = new JLabel("");
		lblCapa = new JLabel("");

		
		// Designs dos Componentes
		
		setSize(new Dimension(480, 600));
		setIconImage(Toolkit.getDefaultToolkit().getImage(viewCliente.class.getResource("/Imagens/Americano1.png")));
		setBackground(Color.BLACK);
		setTitle("M\u00E1quina de Caf\u00E9");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		contentPane.setBounds(new Rectangle(0, 0, 100, 110));
		contentPane.setSize(new Dimension(50, 100));
		contentPane.setBackground(new Color(102, 51, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel.setBackground(new Color(229, 210, 177));
		panel.setBounds(0, 349, 464, 212);
		contentPane.add(panel);
		panel.setLayout(null);
		
		rdbtnCappuccino.setBounds(316, 203, 108, 23);
		rdbtnCappuccino.setForeground(new Color(255, 255, 255));
		rdbtnCappuccino.setBackground(new Color(102, 51, 0));
		
		rdbtnAmericano.setBounds(186, 203, 108, 23);
		rdbtnAmericano.setForeground(new Color(255, 255, 255));
		rdbtnAmericano.setBackground(new Color(102, 51, 0));
		
		rdbtnBlack.setBounds(55, 203, 57, 23);
		rdbtnBlack.setForeground(new Color(255, 255, 255));
		rdbtnBlack.setBackground(new Color(102, 51, 0));
		
		rdbtnDouble.setBounds(320, 307, 70, 23);
		rdbtnDouble.setForeground(new Color(255, 255, 255));
		rdbtnDouble.setBackground(new Color(102, 51, 0));
		
		rdbtnLatte.setBounds(195, 307, 57, 23);
		rdbtnLatte.setForeground(new Color(255, 255, 255));
		rdbtnLatte.setBackground(new Color(102, 51, 0));
		
		rdbtnExpresso.setBounds(55, 307, 108, 23);
		rdbtnExpresso.setForeground(new Color(255, 255, 255));
		rdbtnExpresso.setBackground(new Color(102, 51, 0));
		
		label.setIcon(new ImageIcon(viewCliente.class.getResource("/Imagens/Cappuccino1.png")));
		label.setBounds(308, 153, 46, 14);
		
		lblAmericano.setBounds(182, 153, 70, 40);
		lblAmericano.setIcon(new ImageIcon(viewCliente.class.getResource("/Imagens/Americano1.png")));
		
		lblBlack.setBounds(63, 136, 70, 71);
		lblBlack.setIcon(new ImageIcon(viewCliente.class.getResource("/Imagens/Black1.png")));
		
		lblDouble.setBounds(335, 229, 70, 81);
		lblDouble.setIcon(new ImageIcon(viewCliente.class.getResource("/Imagens/Double1.png")));
		
		lblLatte.setBounds(206, 229, 70, 71);
		lblLatte.setIcon(new ImageIcon(viewCliente.class.getResource("/Imagens/Latte1.png")));
		
		lblExpresso.setBounds(56, 260, 70, 40);
		lblExpresso.setIcon(new ImageIcon(viewCliente.class.getResource("/Imagens/Expresso1.png")));
		
		lblCappuccino.setBounds(339, 136, 70, 71);
		lblCappuccino.setIcon(new ImageIcon(viewCliente.class.getResource("/Imagens/Cappuccino1.png")));
		
		lblCapa.setIcon(new ImageIcon(viewCliente.class.getResource("/Imagens/capa.png")));
		lblCapa.setBounds(92, -27, 372, 183);
		
		btnLogin.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnLogin.setBounds(0, 0, 57, 23);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(200, 178, 89, 23);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaController.clearDinheiros();
				btnComprar.setEnabled(false);
				btAddCedula.setEnabled(true);
				btAddMoeda.setEnabled(true);
				txtFieldCedula.setText("");
				txtFieldMoeda.setText("");
				JOptionPane.showMessageDialog(null, "Venda cancelada. Se você colocou dinheiro, pegue-o de volta no dispensador, ele será devolvido");
				
			}
		});
		panel.add(btnCancelar);
		
		btnComprar = new JButton("Comprar");
		btnComprar.setBounds(365, 178, 89, 23);
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!vendaController.processarCompra()){
					
					JOptionPane.showMessageDialog(null, vendaController.mensagem+". Pegue seu dinheiro de volta no dispensador, ele será devolvido");
					
				}
				else{
					JOptionPane.showMessageDialog(null, vendaController.mensagem);
					
				}
				vendaController.clearDinheiros();
				btnComprar.setEnabled(false);
				btAddCedula.setEnabled(true);
				btAddMoeda.setEnabled(true);
				txtFieldCedula.setText("");
				txtFieldMoeda.setText("");
			}
		});
		panel.add(btnComprar);
		panel.setVisible(false);
		
		lblMoeda = new JLabel("Moeda (R$ 0.50, 1)");
		lblMoeda.setBounds(155, 120, 110, 14);
		panel.add(lblMoeda);
		lblMoeda.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoeda.setForeground(new Color(102, 51, 0));
		
		lblCafeEscolhido = new JLabel("");
		lblCafeEscolhido.setBounds(10, 14, 155, 187);
		panel.add(lblCafeEscolhido);
		lblCafeEscolhido.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCafeEscolhido.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Caf\u00E9 Escolhido", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(102, 51, 0)));
		lblCafeEscolhido.setHorizontalAlignment(SwingConstants.CENTER);
		lblCafeEscolhido.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCafeEscolhido.setForeground(Color.WHITE);
		
		lblCdula = new JLabel("C\u00E9dula (R$ 2, 5 e 10)");
		lblCdula.setBounds(155, 95, 120, 14);
		panel.add(lblCdula);
		lblCdula.setHorizontalAlignment(SwingConstants.CENTER);
		lblCdula.setForeground(new Color(102, 51, 0));
		
		txtFieldCedula = new JTextField();
		txtFieldCedula.setBounds(284, 94, 132, 17);
		panel.add(txtFieldCedula);
		txtFieldCedula.setForeground(Color.BLACK);
		txtFieldCedula.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtFieldCedula.setHorizontalAlignment(SwingConstants.RIGHT);
		txtFieldCedula.setColumns(10);
		
		btAddCedula = new JButton("+");
		btAddCedula.setBounds(422, 94, 30, 17);
		btAddCedula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int valor = Integer.parseInt(txtFieldCedula.getText().trim());
				if(valor != 2 && valor != 5 && valor != 10){
					JOptionPane.showMessageDialog(null, "cédula inválida");
					return;
				}
				if(valor == 5){
					valor = 3;
				}
				else if(valor == 10){
					valor = 4;
				}
				if(vendaController.addDinheiro(valor)){
					btnComprar.setEnabled(true);
					btAddCedula.setEnabled(false);
					btAddMoeda.setEnabled(false);
				}
			}
		});
		panel.add(btAddCedula);
		
		lblCafePreco = new JLabel("");
		lblCafePreco.setBounds(187, 57, 172, 14);
		panel.add(lblCafePreco);
		lblCafePreco.setForeground(new Color(102, 51, 0));
		
		txtFieldMoeda = new JTextField();
		txtFieldMoeda.setBounds(284, 119, 132, 17);
		panel.add(txtFieldMoeda);
		txtFieldMoeda.setForeground(Color.BLACK);
		txtFieldMoeda.setHorizontalAlignment(SwingConstants.RIGHT);
		txtFieldMoeda.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtFieldMoeda.setColumns(10);
		
		btAddMoeda = new JButton("+");
		btAddMoeda.setBounds(422, 119, 30, 17);
		btAddMoeda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double valor = Double.parseDouble(txtFieldMoeda.getText().trim());
				if(valor != 0.5 && valor != 1){
					JOptionPane.showMessageDialog(null, "moeda inválida");
					return;
				}
				if(valor == 0.5){
					valor = 0;
				}
				
				if(vendaController.addDinheiro((int)valor)){
					btnComprar.setEnabled(true);
					btAddCedula.setEnabled(false);
					btAddMoeda.setEnabled(false);
				}
			}
		});
		panel.add(btAddMoeda);
		
		contentPane.setLayout(null);
		contentPane.add(lblAmericano);
		contentPane.add(rdbtnCappuccino);
		contentPane.add(rdbtnAmericano);
		contentPane.add(btnLogin);
		contentPane.add(lblBlack);
		contentPane.add(rdbtnBlack);
		contentPane.add(lblDouble);
		contentPane.add(rdbtnDouble);
		contentPane.add(lblLatte);
		contentPane.add(rdbtnLatte);
		contentPane.add(lblExpresso);
		contentPane.add(rdbtnExpresso);
		contentPane.add(lblCapa);
		contentPane.add(lblCappuccino);
	}
}
