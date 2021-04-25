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
		}
	catch(IOException e) {}
	}

	public Coordenada getEntrada() throws Exception // Não está bom Malignooo, não está eficienteeee 
	{
		
		try {
			Coordenada c = null;
			
			for(int i = 0; i < this.linha-1; i++)
			{
				for(int j = 0; j < this.coluna; j++) 
				{
					if(this.LabMatriz[i][j] == 'E')
					{
						c = new Coordenada(i, j);
					}
				}
			}
			return c;
		}catch(Exception erro)
		{
			throw new Exception("Entrada inexistente, sua Anta!");
		}
		
		
	}
	
	public int verificarArredor(int x, int y) throws Exception {
		
		if(x < 0 || y < 0 || (x > this.linha-1) || (x > this.coluna-1)) {
			throw new Exception ("Valor da coordenada inválido.");
		}
		
		if(this.LabMatriz[x][y] == '#' ||this.LabMatriz[x][y] == '*' || this.LabMatriz[x][y] == 'E') {
			return 0;
		}
		
		if(this.LabMatriz[x][y] == ' ') {
			return 1;
		}
		
		if(this.LabMatriz[x][y] == 'S') {
			return 2;
		}
		
		throw new Exception ("Caracter inválido.");
		
	}
	
	public int navegar (Labirinto l)
	{
		Navegacao n = new Navegacao(l);
		return 0;
	}
	
	public int getLinha()
	{
		return linha;
	}
	public int getColuna()
	{
		return coluna;
	}

}
