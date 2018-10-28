package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import compilador.MainCompilador;
import compilador.Archivo;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class Jlexico extends JFrame {

	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jlexico frame = new Jlexico();
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
	public Jlexico() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 727, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(173, 11, 259, 27);
		lblNewLabel.setText("Analizador Lexico");
		
		panel.add(lblNewLabel);
		
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 60, 226, 289);
		textArea.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel.add(textArea);
		
		//Boton Validar
		JButton btnValidar = new JButton("Validar");
		btnValidar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnValidar.setBounds(260, 300, 97, 27);
		btnValidar.setForeground(Color.BLUE);
		btnValidar.setBackground(Color.WHITE);
		btnValidar.setBorder(BorderFactory.createLineBorder(Color.BLUE,2));
		panel.add(btnValidar);

		btnValidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainCompilador m= new MainCompilador();
				
			}
		});
	
		
		//Creacion de text Area
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(367, 60, 259, 289);
		textArea_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		
		
		panel.add(textArea_1);
		
		
		//Boton cargar
		JButton btnCargar = new JButton("Cargar");
		btnCargar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCargar.setForeground(Color.green);
		btnCargar.setBackground(Color.white);
		btnCargar.setBorder(BorderFactory.createLineBorder(Color.green,2));
		
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			Archivo a= new Archivo();
			a.Abrir(e);
			//textArea_1.setText(contenido);
			}
		});
		
		btnCargar.setBounds(260, 59, 89, 23);
		panel.add(btnCargar);
		
		
		
		//Boton atras
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAtras.setForeground(Color.red);
		btnAtras.setBackground(Color.white);	
		btnAtras.setBorder(BorderFactory.createLineBorder(Color.red,2));
		
		btnAtras.setBounds(20, 360, 103, 34);
		panel.add(btnAtras);
		
	}
	   public String getArchivo( String ruta ){
	        FileReader fr = null;
	        BufferedReader br = null;
	        
	        String contenido = "";
	        try
	        {
	            fr = new FileReader( ruta );
	            br = new BufferedReader( fr );
	 
	            String linea;
	            
	            while( ( linea = br.readLine() ) != null ){ 
	                contenido += linea + "\n";
	            }
	 
	        }catch( Exception e ){  }
	        
	        finally
	        {
	            try{
	                br.close();
	            }catch( Exception ex ){}
	        }
	        return contenido;
	    }

}
