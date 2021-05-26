
public class Servidor {
	
package network;

import network.entidade.ComunicadoDeDesligamento;
import network.servidor.AceitadoraDeConexao;
import network.servidor.UsuarioConexao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Servidor {
	
	private static final int PORTA_PADRAO = 2021;
	
	public static void main (String [] args) {
		
		ArrayList<UsuarioConexao> usuarios = new ArrayList();
		
		AceitadoraDeConexao aceitadoraDeConexao = null;
		
		try {
			aceitadoraDeConexao = new AceitadoraDeConexao (PORTA_PADRAO, usuario);
			aceitadoraDeConexao.start();
		}
		catch (Exception erro) {
			System.err.println ("Escolha uma porta e liberada para uso \n");
			return;
		}
		
		for(;;) {
			System.out.println ("O servidor esta ativo! Para desativa-lo,");
			System.out.println ("use o comando \"desativar\" \n");
			System.out.print (">");
			
			String comando = null;
			
			try {
				comando = new BfferedReader (new InputStreamReader(System.in)).readLine();
			}
			catcj (Exception ignored){
		}
			if (comando.toLowerCase().equals("desativar")) {
				synchronized (usuarios) {
					ComunicadoDeDesligamento comunicadoDeDesligamento = new ComunicadoDeDesligamento ();
					
					for (UsuarioConexao usuario:usuarios) {
						try {
							usuario.receba(comunicadoDeDesligamento);
							usuario.adeus;
						}
						catch (Exception erro) {
							
						}
					}
				}
				System.out.println ("O Servidor foi desativado \n");
				System.exit();
			}
			else System.err.println ("Comando Invalido \n")
			}
	}
}

}
