package compilador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import UI.Jlexico;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Archivo {
	private String direccion = "";
	
	public void Abrir(ActionEvent e){
		
	    	JFileChooser fileChooser = new JFileChooser();
	        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	        
	        FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("TEXT FILES", "txt", "text"); 
	        fileChooser.setFileFilter(imgFilter);

	        int result = fileChooser.showOpenDialog((Component)e.getSource());

	        if (result != JFileChooser.CANCEL_OPTION) {

	            File fileName = fileChooser.getSelectedFile();

	            if ((fileName == null) || (fileName.getName().equals(""))) {
	                
	            } else {
	            	
	            	direccion = fileName.getAbsolutePath();
	            	String contenido = getArchivo( direccion );
	            }
	         }
	        Jlexico j= new Jlexico();
	        
	  
	                //txt.setText(fileName.getAbsolutePath());
	            
	        
	            
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
