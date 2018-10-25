package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JFileChooser;

public class Ventana extends JFrame implements ActionListener{

	JFileChooser fileChooser = new JFileChooser();
	private JPanel contentPane;
	private String direccion = "";
	JTextArea textArea = new JTextArea();
	JPanel panel = new JPanel ();

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton LexicoButton = new JButton("Lexico");
		menuBar.add(LexicoButton);
		
		JButton SintacticoButton = new JButton("Sintactico");
		menuBar.add(SintacticoButton);
		
		JButton CargarButton = new JButton("Cargar");
		CargarButton.addActionListener(this);
		menuBar.add(CargarButton);
		
		
		
		
	    
        JScrollPane scrollPane = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,

				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
       
        panel.add(textArea);

        getContentPane().add(scrollPane, BorderLayout.CENTER);
		
        
        
       
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.add(textArea);
		contentPane.add(panel, BorderLayout.CENTER);
		
		
	}
	
	 @Override
	   public void actionPerformed(ActionEvent e) { 
	    	
	    	JFileChooser fileChooser = new JFileChooser();
	        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	        
	        FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("TEXT FILES", "txt", "text"); 
	        fileChooser.setFileFilter(imgFilter);

	        int result = fileChooser.showOpenDialog(this);

	        if (result != JFileChooser.CANCEL_OPTION) {

	            File fileName = fileChooser.getSelectedFile();

	            if ((fileName == null) || (fileName.getName().equals(""))) {
	                
	            } else {
	            	
	            	direccion = fileName.getAbsolutePath();
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
