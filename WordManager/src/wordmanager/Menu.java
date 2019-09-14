package wordmanager;


public class Menu {
	
	Menu(){
		
	}
	/*-----------------------------------*/
	/*| 	COMMANDS METHOD 	|*/
	/*-----------------------------------*/
	public void commands(String args[]){
		
		//+++ CHECK FIRST 2 CHARACTER +++
	    if(args[0].length()!=2){		//if first arg length !=2 --> ERROR
	        System.out.println("Invalid syntax! For command use -h or -help");
	        this.help();
	        return;
	    }
	    char check = args[0].charAt(0);       //take the first char
	    if(check!='-'){
	        System.out.println("Invalid syntax! For command use -h or -help"); // if the first char isn't '-'
	        this.help();
	        return;         // stop
	    }
	    char cmd = args[0].charAt(1);		//take the second char
	    
	    FileProcess fp = new FileProcess();
	    
	    //+++ SWITCH MENU +++
	    switch(cmd){
	        case 'd':
	            if(args.length==4)		// select the words from file 2 and write them in file 3 if they aren't in file 1
	                fp.divisor(args[1],args[2],args[3]);
	            else
	                System.out.println("Invalid syntax! For command use -h or -help");
	            break;
	            
	        case 'c':
	        	fp.add(args[1],args[2]);
	        	break;
	        case 'h':
	            this.help();
	            break;
	        
	        default:
	            System.out.println("Invalid syntax! For command use -h or -help");
	    }
	}
	void help() {
         System.out.println("-d <file1> <file2> <file3> | select the words from file2 and write them in file3 if they aren't in file1");
         System.out.println("-c <file1> <file2> | copy the words from file2 into file1 in append mode");
         System.out.println("-h or -help show how to use");
	}
}

