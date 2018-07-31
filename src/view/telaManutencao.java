package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class telaManutencao extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JMenuBar menuBar; 
	private JMenu mnGerenciar;
	private JMenuItem mnTroco;
	private JMenuItem mnCopos;
	private JMenuItem mnInsumos;
	private JMenuItem mnVendas;
	private JMenu mnRelatrio;
	private JMenuItem mnRelatorioVendas;
	private JMenuItem mnRelatorioInsumos;
	cadastroTroco telaTroco = new cadastroTroco();
	cadastroCopo telaCopo = new cadastroCopo();
	cadastroInsumo telaInsumo = new cadastroInsumo();
	gerenciaVendas telaGVendas = new gerenciaVendas();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaManutencao frame = new telaManutencao();
					//frame.setExtendedState(MAXIMIZED_BOTH);
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
	public telaManutencao() {	
		
		//Menu
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnGerenciar = new JMenu("Gerenciar");
		menuBar.add(mnGerenciar);
		
		mnTroco = new JMenuItem("Troco");
		mnTroco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaInsumo.setVisible(false);
				telaCopo.setVisible(false);
				contentPane.add(telaTroco);
				lblNewLabel.setVisible(false);
				telaTroco.show();
			}
		});
		mnGerenciar.add(mnTroco);

		
		mnCopos = new JMenuItem("Copos");
		mnCopos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaTroco.setVisible(false);
				telaInsumo.setVisible(false);
				contentPane.add(telaCopo);
				lblNewLabel.setVisible(false);				
				telaCopo.show();
			}
		});
		//mnGerenciar.add(mnCopos);
		
		mnInsumos = new JMenuItem("Insumos");
		mnInsumos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaTroco.setVisible(false);
				telaCopo.setVisible(false);
				contentPane.add(telaInsumo);
				lblNewLabel.setVisible(false);
				telaInsumo.show();
			}
		});
		mnGerenciar.add(mnInsumos);
			
		
		mnVendas = new JMenuItem("Vendas");
		mnVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaTroco.setVisible(false);
				telaCopo.setVisible(false);
				telaInsumo.setVisible(false);
				lblNewLabel.setVisible(false);
				contentPane.add(telaGVendas);
				telaGVendas.show();
				
			}
		});
		mnGerenciar.add(mnVendas);
		
		mnRelatrio = new JMenu("Relat\u00F3rio");
		//menuBar.add(mnRelatrio);
		
		mnRelatorioVendas = new JMenuItem("Gerar Relat\u00F3rio de Vendas");
		mnRelatrio.add(mnRelatorioVendas);
		
		mnRelatorioInsumos = new JMenuItem("Gerar Relat\u00F3rio de Insumos");
		mnRelatrio.add(mnRelatorioInsumos);
		
		//design dos componentes
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(telaManutencao.class.getResource("/Imagens/Americano1.png")));
		setTitle("Manuten\u00E7\u00E3o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(telaManutencao.class.getResource("/Imagens/capa.png")));
		lblNewLabel.setBounds(76, 24, 307, 177);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 51, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
