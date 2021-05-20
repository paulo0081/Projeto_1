import java.util.Scanner;

/**
 * Método responsável pela Main do projeto
 * @param recebe um parameto do tipo String
 */
public class Main {

	public static void  main(String[] args){
		try {
			new Janela();
		} catch(Exception erro) {
			System.err.println(erro);
		}
	}
}