import java.util.Scanner;

public class Main {

	public static void  main(String[] args){
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		System.out.println("Favor digitar o nome do labirinto que será resolvido. ");
		String arquivo = s.nextLine();
		
		try {
			Labirinto tamanho = new Labirinto(arquivo);
			//System.out.println(tamanho.toString());
			tamanho.resolverLabirinto(tamanho);
			System.out.println(tamanho.toString());
			
		} catch(Exception erro) {
			System.err.println(erro);
		}
	}
}
