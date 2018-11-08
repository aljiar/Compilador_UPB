package UI;


import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Component;
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


public class Jlexico extends JFrame implements ActionListener {

	public String direccion = "";
	public JPanel contentPane;
	
	JTextArea textArea = new JTextArea();
	public JTextArea textArea_1 ;
	public JButton btnValidar;
	public JButton btnSintactico;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Jlexico() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1018, 681);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel.setBounds(281, 13, 284, 44);
		lblNewLabel.setText("Analizador Lexico");
		
		panel.add(lblNewLabel);
		
		

		textArea.setBounds(10, 60, 323, 458);
		textArea.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel.add(textArea);
		
		//Boton Validar
		btnValidar = new JButton("Validar");
		btnValidar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnValidar.setBounds(366, 277, 117, 39);
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
		textArea_1 = new JTextArea();
		textArea_1.setBounds(532, 60, 385, 458);
		textArea_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		
		
		panel.add(textArea_1);
		
		
		//Boton cargar
		JButton btnCargar = new JButton("Cargar");
		btnCargar.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnCargar.setForeground(Color.green);
		btnCargar.setBackground(Color.white);
		btnCargar.setBorder(BorderFactory.createLineBorder(Color.green,2));
		
		
		 
	
		btnCargar.addActionListener(this);
		btnCargar.setBounds(362, 84, 121, 39);
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
		
		btnAtras.setBounds(24, 547, 103, 34);
		panel.add(btnAtras);
		
		btnSintactico = new JButton("Sintactico");
		btnSintactico.setBounds(846, 554, 97, 25);
		panel.add(btnSintactico);
		
		
		
		
	}
	
	 @Override
	   public void actionPerformed(ActionEvent e) { 
	    	
	    	JFileChooser fileChooser = new JFileChooser();
	        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	        
	        FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("TEXT FILES", "txt", "text"); 
	       

	        int result = fileChooser.showOpenDialog(this);

	        if (result != JFileChooser.CANCEL_OPTION) {

	            File fileName = fileChooser.getSelectedFile();

	            if ((fileName == null) || (fileName.getName().equals(""))) {
	                
	            } else {
	            	System.out.println(direccion);
	            	direccion = fileName.getAbsolutePath();
	            	System.out.println(direccion);
	            	String contenido = getArchivo( direccion );
	            	textArea.setText( contenido );
	                //txt.setText(fileName.getAbsolutePath());
	            }
	        }
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