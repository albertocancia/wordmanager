package wordmanager;



public class WordManager {
	public static void main(String[] args) {
        Menu menu = new Menu();
        if(args.length>4){ // if there are more than 4 arguments print an error
            System.out.println("Invalid syntax! For command use -h or -help");
        	menu.help();
        }else if(args.length<1){ // if there are less than 1 argument print an error
			System.out.println("Invalid syntax! For command use -h or -help");
        	menu.help();
		}
        else{
            menu.commands(args);
        }
    }
}
