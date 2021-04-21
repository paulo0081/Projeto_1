import java.io.*;

public class Labirinto {
	
	private char LabMatriz[][];
	private int linha = 0, coluna = 0;
	
	public Labirinto(String Arq) throws Exception{
		
			this.tamanho(Arq);
			if(this.coluna == 0) {
				throw new Exception("Numero de colunas inválido");
			}
			LabMatriz = new char[this.linha][this.coluna];
			this.preencheMatriz(Arq);	
	}
	
	private void tamanho(String nomeArq) throws Exception {
		
		BufferedReader in = null;
		int tamPadrao, contador = 0;
	
		in = new BufferedReader(new FileReader("C:\\Users\\paulo\\eclipse-workspace\\Projeto_1\\" + nomeArq));
		String str;
		
		if((str = in.readLine()) != null) {
			this.linha = Integer.parseInt(str);
		}
		
		str = in.readLine();
		tamPadrao = str.length();
		
		while((str = in.readLine()) != null)
		{
			if (tamPadrao != str.length())
			{
				contador++;
				break;
			}
		}
		
		in.close();
		if(contador == 0)
			this.coluna = tamPadrao;
	}
	
	public void preencheMatriz(String nomeArq) {
		int i;
		BufferedReader in = null;
		try{
			
			in = new BufferedReader(new FileReader("C:\\Users\\paulo\\eclipse-workspace\\Projeto_1\\" + nomeArq));
			String str;
			str = in.readLine();

			for(i = 0; i < this.linha; i++)
			{
				str = in.readLine();
				this.LabMatriz[i] = str.toCharArray();
			}
			
			/*for(i = 0; i < this.linha; i++)
			{
				System.out.println(LabMatriz[i]);
			}
			in.close();*/
		}
	catch(IOException e) {}
	}
	
	private void resolveMat() {
		
	}
}
