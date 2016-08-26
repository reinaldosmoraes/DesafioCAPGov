import java.util.Scanner;

public class Login {

	private static Scanner input;

	public static boolean fazerLogin(){
		
		String senhaCorreta = "admin";
		String senhaDigitada;
		input = new Scanner(System.in);	

		System.out.print("Senha de acesso:");
		senhaDigitada = input.nextLine();
		
		if(senhaDigitada.equals(senhaCorreta))
			return true;
			
		else
			return false;	
	
	}
	
}
