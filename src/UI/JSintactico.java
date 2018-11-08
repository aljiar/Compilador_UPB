package UI;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JSintactico extends JFrame {
 
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public JSintactico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 916, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAnalizadorSintactico = new JLabel("Analizador Sintactico");
		lblAnalizadorSintactico.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnalizadorSintactico.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblAnalizadorSintactico.setBounds(260, 41, 385, 57);
		contentPane.add(lblAnalizadorSintactico);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(12, 99, 292, 372);
		textArea.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		
		
		contentPane.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(464, 99, 292, 361);
		textArea_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		contentPane.add(textArea_1);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnAtras.setBounds(38, 484, 109, 26);
		contentPane.add(btnAtras);
		
		JButton btnNewButton = new JButton("Cargar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(331, 131, 121, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Validar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_1.setBounds(331, 312, 109, 35);
		contentPane.add(btnNewButton_1);
		getContentPane().add(contentPane);
	}
}
