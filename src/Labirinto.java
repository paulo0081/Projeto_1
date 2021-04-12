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
	
	public int tamanho(){
		int linha = LabMatriz.length;
		int coluna = LabMatriz[0].length;
		return linha * coluna;
	}
	
	public boolean preencheMatriz() {
		char vet[];
		int i, j, linha;
		BufferedReader in = null;
		try{
			
			in = new BufferedReader(new FileReader("C:\\Users\\paulo\\eclipse-workspace\\Projeto_1\\teste.txt"));
			String str;
			
			str = in.readLine();
			linha = Integer.parseInt(str);
			
			for(i = 0; i < linha; i++)
			{
				str = in.readLine();
				vet = new char[str.length()];
				vet = str.toCharArray();
				
				for(j = 0; j < str.length(); j++)
				{
					this.LabMatriz[i][j] = vet[j];
				}
			}
			
			in.close();
			
			for(i = 0; i < linha; i++)
			{
				for(j = 0; j < str.length(); j++)
				{
					System.out.print(this.LabMatriz[i][j]);
				}
				System.out.print("\n");
			}
		}
	catch(IOException e) {}
		return true;
	}
}
