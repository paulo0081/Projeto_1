import java.io.*;

public class Labirinto {
	
	private char LabMatriz[][];
	
	public Labirinto(String Arq) {
		
		LabMatriz = new char[this.linha(Arq)][this.coluna(Arq)];
	}
	
	public int linha(String nomeArq) {
		int linha = 0;
		BufferedReader in = null;
		try{
			
			in = new BufferedReader(new FileReader("C:\\Users\\paulo\\eclipse-workspace\\Projeto_1\\" + nomeArq));
			String str;
			
			if((str = in.readLine()) != null) {
				linha = Integer.parseInt(str);
			}
			
			in.close();
		}
	catch(IOException e) {}
		return linha;
	}
	
	public int coluna(String nomeArq) {		// lembrar de comparar todas as linhas
		int coluna = 0;
		BufferedReader in = null;
		try{
			in = new BufferedReader(new FileReader("C:\\Users\\paulo\\eclipse-workspace\\Projeto_1\\" + nomeArq));
			String str;
			str = in.readLine();
			if((str = in.readLine()) != null) {
				coluna = str.length();
			}
			in.close();
		}
	catch(IOException e) {}
		return coluna;
	}
	
	// comentario
	// Temporário
	public int tamanho(){
		int linha = LabMatriz.length;
		int coluna = LabMatriz[0].length;
		return linha * coluna;
	}

	
}
