/**
 * 
 */
package com.spc.generastrings;

/**
 * @author pedrosantangelocalvo
 *
 */

import java.io.*;
import java.util.Arrays;

import com.googlecode.jcsv.reader.CSVEntryParser;
import com.opencsv.CSVReader;



public class ParseCSVFile {

	/**
	 * @param args
	 */
	String cabecera = "<?xml version=\"1.0\" encoding=\"utf-8\"?> \n<resources>\n";
	char c=0;
	public static void main(String[] args) {
		if (args[0] == null) {System.out.println("Uso: java -jar ParseCSVFile.jar Traducciones.csv");
		 					System.exit (1);}
		String filename = args[0];
		
		//String filename = "/Users/pedrosantangelocalvo/Documents/Traducciones.csv";
        ParseCSVFile parseCSVFile = new ParseCSVFile();  
        	
        System.out.println("Starting to parse CSV file using opencsv"); 
        parseCSVFile.parseUsingOpenCSV(filename);
    	
	}   

	 private void parseUsingOpenCSV(String filename){
		 FileWriter fileWriter = null;
		 
	        try {            
	            CSVReader reader = new CSVReader(new FileReader(filename));
	         
	            String [] nextLine = null;
	            int rowNumber = 0; 
	            
	            // Las tres primeras filas son especiales
	            String[] header1 = reader.readNext();
	            String[] header2 = reader.readNext();
	            String[] header3 = reader.readNext();
	            String[] header4 = reader.readNext(); // Idioma que se quiere aprender
	            
	        //    FileOutputStream ficherosalida = new FileOutputStream("strings.xml");
	            
	        
	           	            
	            while ((nextLine = reader.readNext()) != null) {
	                rowNumber++;
	                for(int i = 0;i< nextLine.length ; i++){ //No interesa la última columna
	                    //display CSV values
	                	              
	                	  if (rowNumber >= 1){    
	          	            String directorio = nextLine[(nextLine.length)-1];
	          	            directorio = "values-" + directorio;
	          	            new File(directorio).mkdir();
	          	            }
	                	System.out.println("Cell row index: " + rowNumber);  
	                    System.out.println("Cell column index: " + i);
	                    System.out.println("Cell Value: " + nextLine[i]);
	                    System.out.println("---");

	    	            String directorio = nextLine[(nextLine.length)-1];
	    	            directorio = "values-" + directorio;
	    	            File ficherosalida = new File(directorio + "/strings.xml");
	    	            fileWriter = new FileWriter(ficherosalida);
	    	            fileWriter.write(cabecera);
	    	                  
	    	            for (int col = 1;col < (nextLine.length - 1); col++){ // No interesa la última columna
	    	            	if (col <= 5 ){
        	    	            fileWriter.write("	<string name=\"" + header1[col] +"\"" + ">" + nextLine[col] + "</string>\n");
	    	    	           // fileWriter.write("	<string name=\"" + header1[2] +"\"" + ">" + nextLine[col] + "</string>\n");
	    	    	           // fileWriter.write("	<string name=\"" + header1[3] +"\"" + ">" + nextLine[col] + "</string>\n"); 
	    	    	           // fileWriter.write("	<string name=\"" + header1[4] +"\"" + ">" + nextLine[col] + "</string>\n");
	    	    	           // fileWriter.write("	<string name=\"" + header1[5] +"\"" + ">" + nextLine[col] + "</string>\n");
	    	    	            
	    	            		/* fileWriter.write(rowNumber +"  "+ i);
	    	            		 fileWriter.write("	<string name=\"" + header1[0] +"\"" + ">" + header3[rowNumber] + "</string>\n");
	    		    	         fileWriter.write("	<string name=\"" + header1[1] +"\"" + ">" + header3[rowNumber] + "</string>\n");
	    		    	         fileWriter.write("	<string name=\"" + header1[2] +"\"" + ">" + header3[rowNumber] + "</string>\n"); 
	    		    	         fileWriter.write("	<string name=\"" + header1[3] +"\"" + ">" + header3[rowNumber] + "</string>\n");
	    		    	         fileWriter.write("	<string name=\"" + header1[4] +"\"" + ">" + header3[rowNumber] + "</string>\n"); */
	    	            	}
	    	            		if (col > 5 && col < 78 ){
	    	    	            	
	    	            		
	    	            		fileWriter.write("	<string name=\"" + header1[col] +"\"" + ">" + header4[col] + " -- "+ nextLine[col] + "</string>\n");     
	    	            		fileWriter.write("	<string name=\"di_" + header1[col] +"\"" + ">" + header4[col] + "</string>\n");     
	    	            		}
	    	            		
	    	            		if (col >= 78) {
	    	            			fileWriter.write("	<string name=\"" + header1[col] +"\"" + ">" + nextLine[col] + "</string>\n"); 
	    	            		}
	    	            	
	    	            		
	    	            }
	    	            fileWriter.write("</resources>");       	            
	    	            fileWriter.close();
	                }
	            }
	   
	        } catch (FileNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    } 
	    
	    
	    
}
