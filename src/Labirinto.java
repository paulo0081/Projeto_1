import java.io.*;

public class Labirinto {
	
	private char LabMatriz[][];
	private int linha = 0, coluna = 0;
	private Coordenada entrada, saida;
	
	public Labirinto(String Arq) throws Exception{
		
			this.defineTamanho(Arq);
			if(this.coluna == 0) {
				throw new Exception("Numero de colunas inválido");
			}
			LabMatriz = new char[this.linha][this.coluna];
			this.preencheMatriz(Arq);
			if(validaLabirinto()) {
				
			}
	}
	
	private void defineTamanho(String nomeArq) throws Exception {
		
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

	private boolean validaLabirinto () throws Exception
	    {
	        try {
	            int ecount = 0, scount = 0, hashcount = 0;

	            for(int i = 0; i < this.linha; i++)
	            {
	                for(int j = 0; j < this.coluna; j++) 
	                {
	                    if(this.LabMatriz[i][j] == 'E')
	                    {
	                        entrada = new Coordenada(i, j);
	                        ecount++;
	                    }

	                    if(this.LabMatriz[i][j] == 'S')
	                    	saida = new Coordenada(i, j);
	                        scount++;

	                    if (this.LabMatriz[i][j] == '#')
	                        hashcount++;

	                    if((i != 0 && i != (this.linha-1)) && j == 0)
	                        j = this.coluna-2;
	                }
	            }

	            if ((hashcount == (((this.linha + this.coluna))*2)-6) && (ecount == 1 && scount == 1))
	                return true;
	            else
	                return false;
	        }
	        catch(Exception erro)
	        {
	            throw new Exception("Entrada inexistente, sua Anta!");
	        }
	    }
	
	
	public int verificarArredor(int x, int y) throws Exception {
		
		if(this.LabMatriz[x][y] == ' ') {
			return 2;
		}
		
		if(this.LabMatriz[x][y] == 'S') {
			return 1;
		}
		
		if(this.LabMatriz[x][y] != '#' && this.LabMatriz[x][y] != '*' && this.LabMatriz[x][y] != 'E') {
			throw new Exception ("Caracter inválido.");
		}
		
		return 0;
		
	}
	
	
	public int resolverLabirinto (Labirinto l) throws Exception
	{
		try {
			Navegacao n = new Navegacao(l);
			n.navegarLabirinto(l);
		}catch(Exception erro) {
			throw new Exception (erro);
		}
		
		return 0;
	}
	
	public void modificarCaminho (Coordenada c, int tipo) {
		if(this.LabMatriz[c.getX()][c.getY()] == ' ' && tipo == 0) {
			this.LabMatriz[c.getX()][c.getY()] = '*';
		}
		
		if(this.LabMatriz[c.getX()][c.getY()] == '*' && tipo == 1) {
			this.LabMatriz[c.getX()][c.getY()] = ' ';
		}
	}
	
 	public Coordenada getSaida()
	{
		return saida;
	}	
	public Coordenada getEntrada()
    {
        return entrada;
    }
	public int getLinha()
	{
		return linha;
	}
	public int getColuna()
	{
		return coluna;
	}

	public String toString() {
		String labReescrito = String.valueOf(this.LabMatriz[0]) + "\n";
		for(int i = 1; i < this.linha; i++) {
			labReescrito += String.valueOf(this.LabMatriz[i]) + "\n";
		}
		return labReescrito;
	}
}
	