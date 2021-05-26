import java.util.Scanner;

/**
 * M�todo respons�vel pela Main do projeto
 * @param passa um parameto de String
 */
public class Main {

	public static void  main(String[] args){
		try {
			new Cliente(args);
			new Janela();
		} catch(Exception erro) {
			System.err.println(erro);
		}
	}
}
