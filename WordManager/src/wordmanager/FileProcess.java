package wordmanager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileProcess {
	
	FileProcess(){
		
	}
	
	//+++++++++++++++++++++++
	//+++++ COPY METHOD +++++
	//+++++++++++++++++++++++
	void add(String original, String copy) {
		String s;
		try {
			 File fCopy = new File(copy);    //open file to copy						
	         FileReader frCopy = new FileReader(fCopy);
	         BufferedReader brCopy = new BufferedReader(frCopy);
	         
	         File fOriginal = new File(original); //create File object for the new file
	         FileWriter fwOriginal = new FileWriter(fOriginal,true);
	            
	         s=brCopy.readLine();
	         while(s!=null){
	        	 fwOriginal.write(s+System.getProperty("line.separator"));
	        	 s=brCopy.readLine();
	         }
	         fwOriginal.close();
	         frCopy.close();
		}catch(IOException e) {
			
		}
	}
	
	
	//++++++++++++++++++++++++++
	//+++++ DIVISOR METHOD +++++
	//++++++++++++++++++++++++++
	void divisor(String original, String copy, String newf){	//original file, file to analyze		
 
		boolean equal;
        String s1="",sCopy="";
        try{
        	//+++ FILE TO COPY +++
            File fCopy = new File(copy);    //open file to copy						
            FileReader frCopy = new FileReader(fCopy);
            BufferedReader brCopy = new BufferedReader(frCopy);
            
            //+++ NEW FILE +++
            File fNewf = new File(newf); //create File object for the new file
            FileWriter fwNewf = new FileWriter(fNewf,true);
            
            sCopy = brCopy.readLine();		//read the first word of the file to copy
            System.out.println("Writing in "+newf+" words in "+copy+" that aren't in "+original+"...");
            while(sCopy!=null){
                equal = false;
                
                //+++ ORIGINAL FILE +++
                File fOriginal = new File(original);
                FileReader frOriginal = new FileReader(fOriginal);
                BufferedReader brOriginal = new BufferedReader(frOriginal); //start to line 0
                s1 = brOriginal.readLine();		//read the first word of the original file
                while(s1!=null){	// while there are line in original file
                        if(sCopy.equals(s1)){
                                equal = true;				//to avoid to insert word already in the original file
                                break;
                        }
                        else{
                                s1 = brOriginal.readLine();		//read line in the original file
                        }
                }
                if(!equal)
                	fwNewf.write(sCopy+System.getProperty("line.separator"));
                sCopy = brCopy.readLine();		//read the first word of the file to copy
                frOriginal.close();
            }
            fwNewf.close();
            frCopy.close();
            
            System.out.println("File "+newf+" is ready!");
        }catch(IOException e){
        	
        }
        
    }
    
}
