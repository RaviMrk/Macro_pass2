package pass2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class pass2 {
	

	public static void main(String[] args) throws IOException {
		
		
		FileWriter ala=new FileWriter("ala1.txt");
	    FileWriter mdt=new FileWriter("mdt1.txt");
	    BufferedWriter bufferedWriter_mdt=new BufferedWriter(mdt);
		BufferedWriter bufferedWriter_ala=new BufferedWriter(ala);
		int ala_count=1;
		
		
		String output =new Scanner(new File("pass2.txt")).useDelimiter("\\z").next();
	
		
		String result1[]=output.split("[,\\s+\\?]");//skipping space and comma and storing into variable
        //loop for skipping  remaining space if any
		int k;
		String result;
        for(k=0;k<result1.length;k++) {
        	for(int j=k+1;j<result1.length;j++) {
        	if(result1[k].equals("")) {
        	result=result1[k];
        	result1[k]=result1[j];
        	result1[j]=result;
        	
        	}
        	}
        }
        
  
   //-----------------------------------------MNT----------------------------------------------------     
        
        String mnt =new Scanner(new File("mnt1.txt")).useDelimiter("\\z").next();
		
		
		String mntstring[]=mnt.split("[,\\s+\\?]");
		
		
		String result2;
        for(k=0;k<mntstring.length;k++) {
        	for(int j=k+1;j<mntstring.length;j++) {
        	if(mntstring[k].equals("")) {
        	result2=mntstring[k];
        	mntstring[k]=mntstring[j];
        	mntstring[j]=result2;
        	
        	}
        	}
        }
        
       
 //--------------------------------------new ALA-----------------------------------------------
        BufferedReader reader;
        int a[]=new int[10];
        int count=0,c=0;
		try {
			
			reader = new BufferedReader(new FileReader("pass2.txt"));
			
			String line = reader.readLine();
			while (line != null) {
				System.out.println(line);
				
				String pass2in[]=line.split("[,\\s+\\?]");
				
					
				// read next line
				for(int j=0;j<mntstring.length;j++) 
				{
					
					if(pass2in[0].equals(mntstring[j])) {
						
						System.out.println(pass2in[0]+"=="+mntstring[j]);
						bufferedWriter_ala.write("ALA_TABLE"+String.valueOf(ala_count));
						ala_count++;
						bufferedWriter_ala.newLine();
						for(int i=1;i<pass2in.length;i++)
						{	
							bufferedWriter_ala.write(String.valueOf(i)+" "+pass2in[i]);
							bufferedWriter_ala.newLine();
							
						}
										
					}
					
				}
			
				line = reader.readLine();
			
			}
			bufferedWriter_ala.close();
			
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//------------------------------ALA read---------------------------------------
		
        String alaresult= new Scanner(new File("ala1.txt")).useDelimiter("\\z").next(); 
        String alastring[]=alaresult.split("[,\\s+\\?]");

        for(k=0;k<alastring.length;k++) {
        	for(int j=k+1;j<alastring.length;j++) {
        	if(alastring[k].equals("")) {
        	result=alastring[k];
        	alastring[k]=alastring[j];
        	alastring[j]=result;
        	
        	}
        	}
        }
       

        //------------------------------------------mdt-----------------
        
        
        BufferedReader reader1;
        int mend_flag=1;
        int length;
        String dummy="";
try {
			
			reader1 = new BufferedReader(new FileReader("mdt.txt"));
			
			String line1 = reader1.readLine();
			while (line1 != null) {
				
				
				String mdtin[]=line1.split("[,\\s+\\?]");
				
				if(mdtin[(mdtin.length)-1].equals("MEND")) 
				{
						
					mend_flag++;
					
				}
				
				for(int i=0;i<alastring.length;i++)
				{
					if(alastring[i].equals("ALA_TABLE"+String.valueOf(mend_flag))) {
						for(int j=i+1;j<alastring.length;j++)
						{
							if(alastring[j].contains("ALA_TABLE"))
							{
								break;
							}
							else 
							{
								
								if(mdtin[(mdtin.length)-1].equals(alastring[j]))
								{
									
									dummy=alastring[j+1];
									
								}
							}
						}
					}
				}
				mdtin[((mdtin.length)-1)]=dummy;
				 //-----------------------------MDT WRITE------------------------------------------------
				
				for(int i=0;i<mdtin.length;i++) 
				{
					if(mdtin.length>2) 
					{
						System.out.println(mdtin[i]);
						if(i==3 || i==0)
						{
					
						}
						else
						{
								bufferedWriter_mdt.write(mdtin[i]+" ");
						}
					}
					else
					{
							
					}
					
				}
				bufferedWriter_mdt.newLine();
				
				
				line1 = reader1.readLine();
				
			
			}//-------------end of while--------------
			bufferedWriter_mdt.write("END");
			bufferedWriter_mdt.close();
			reader1.close();
} catch (IOException e) {
			e.printStackTrace();
		}


       
	
		
        
	}}
