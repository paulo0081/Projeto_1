import java.util.Scanner;

public class Main {

	public static void  main(String[] args){
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		System.out.println("Favor digitar o nome do labirinto que será resolvido. ");
		String arquivo = s.nextLine();
		
		try {
			Labirinto lab = new Labirinto(arquivo);
			Navegacao nav = new Navegacao(lab);
			
			System.out.println(nav.toString());
			System.out.println(lab.toString());
			
		} catch(Exception erro) {
			System.err.println(erro);
		}
	}
}
