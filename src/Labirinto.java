import java.io.*;

/**
 * Método responsável por clonar o labirinto 
 * @return estrutura Clone de labirinto
 * @throws Exception exceções de validação de arquivo
 */

public class Labirinto implements Cloneable
{
	
	private char LabMatriz[][];
	private int linha = 0, coluna = 0;
	private Coordenada entrada, saida;
	
	/**
	 * #Precisa fazer#
	*/
	public Labirinto(String Arq) throws Exception{
		try {
			if(Arq == null || Arq == "")
				throw new Exception("Arquivo não encontrado");
			
			this.defineTamanho(Arq);
			
			if(this.linha <= 0) {
				throw new Exception("Numero de linhas inválido");
			}
			
			if(this.coluna <= 0) {
				throw new Exception("Numero de colunas inválido");
			}
			
			LabMatriz = new char[this.linha][this.coluna];
			
			this.preencheMatriz(Arq);
			
			validaLabirinto();
			
			
			
		}catch(Exception erro) {
			throw (erro);
		}
	}
	
	/**
     * Construtor responsável por montar o objeto do labirinto
     * @param String contendo o desenho do labirinto e linhas contendo a quantidade linhas do mesmo
     * @throws Exception exceções de validação de linha e coluna
     */
	public Labirinto(String Lab, int linhas) throws Exception{
		try {
			
			this.defineTamanho(Lab, linhas);
			
			if(this.linha <= 0) {
				throw new Exception("Numero de linhas inválido");
			}
			
			if(this.coluna <= 0) {
				throw new Exception("Numero de colunas inválido");
			}
			
			LabMatriz = new char[this.linha][this.coluna];
			
			this.preencheMatriz(Lab, linha);
			validaLabirinto();
			
		}catch(Exception erro) {
			throw(erro);
		}
	}
	
	
	/**
     * Método responsável por definir o tamanho das linhas e colunas do labirinto
     * @param String de nome do Arquivo
     * @throws Exception exceções de validação do tamanho da coluna 
     */
	private void defineTamanho(String nomeArq) throws Exception {
		
		BufferedReader in = null;
		int tamPadrao, contador = 0;
	
		in = new BufferedReader(new FileReader(nomeArq));
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
		else {
			throw new Exception("Tamanho das colunas não é igual.");
		}
	}
	
	/**
     * Método responsável por definir o tamanho das colunas e linhas do labirinto
     * @param String de lab e numero de linhas
     * @throws Exception exceções de validação do tamanho da coluna 
     */
	private void defineTamanho(String lab, int linhas) throws Exception {

		int tamPadrao, contador = 0, linhaAtual = 0;
		
		String str[] = new String [linhas];
		this.linha = linhas;
		
		str = lab.split("\n");
		tamPadrao = str[0].length();
		
		while(/*str[linhaAtual] != null ||*/ linhaAtual < linhas-1)
		{
			if (tamPadrao != str[linhaAtual].length())
			{
				contador++;
				break;
			}
			linhaAtual++;
		}
		
		if(contador == 0) {
			this.coluna = tamPadrao;
		}
		else {
			throw new Exception("Tamanho das colunas não é igual.");
		}
	}


	/**
     * Método responsável por preencher a Matriz
     * @param String de lab e numero de linhas
     */
	private void preencheMatriz(String lab, int linhas) {
		try{
			String str[] = new String [linhas];
			str = lab.split("\n");

			for(int i = 0; i < this.linha; i++)
			{
				this.LabMatriz[i] = str[i].toCharArray();
			}
		}
		
	catch(Exception e) {}
	}
	
	/**
     * Método responsável por preencher a Matriz
     * @param String do nome do Arquivo
     
     */
	private void preencheMatriz(String nomeArq) {
		int i;
		BufferedReader in = null;
		try{
			
			in = new BufferedReader(new FileReader(nomeArq));
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


	/**
     * Método responsável por validar o Labirinto
     
     * @throws Exception exceções de validação do valor de entrada, saida e estrutura de paredes
     */
	private void validaLabirinto () throws Exception
	    {
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
	                    {
	                    	saida = new Coordenada(i, j);
	                        scount++;
	                    }

	                    if (this.LabMatriz[i][j] == '#')
	                        hashcount++;

	                    if((i != 0 && i != (this.linha-1)) && j == 0)
	                        j = this.coluna-2;
	                }
	            }

	            if (ecount != 1)
                	throw new Exception("Valor de entradas inválido");
	            
	            if (scount != 1)
                	throw new Exception("Valor de saidas inválido");
	            
	            if (hashcount != (((this.linha + this.coluna))*2)-6)
	            	throw new Exception("Estrutura de paredes inválida");
	    }
	
	/**
     * Método responsável por verificar o Arredor
     * @param valor de x e de y da coordenada a ser verificada
     * @return Retorna o valor de 0, 1 ou 2 para verificar se tem espaco ao redor
     * @throws Exception exceções de validação de caracter ao redor
     */
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
	
	/**
     * Método responsável por modificar o caminho
     * @param Coodenada de c e valor inteiro indicando se o caminho passará ' ' ou *
     
     */
	public void modificarCaminho (Coordenada c, int tipo) {
		if(this.LabMatriz[c.getX()][c.getY()] == ' ' && tipo == 0) {
			this.LabMatriz[c.getX()][c.getY()] = '*';
		}
		
		if(this.LabMatriz[c.getX()][c.getY()] == '*' && tipo == 1) {
			this.LabMatriz[c.getX()][c.getY()] = ' ';
		}
	}
	
	/**
     * Método responsável pela saida
     
     * @return coordenada da saida
     
     */
 	public Coordenada getSaida()
	{
		return saida;
	}	
 	
 	/**
     * Método responsável pela entrada
     
     * @return a coordenada da entrada 
     
     */
	public Coordenada getEntrada()
    {
		Coordenada e = (Coordenada)entrada.clone();
        return e;
    }
	
	/**
     * Método responsável pela linha
     
     * @return quantidade de linhas
     
     */
	public int getLinha()
	{
		return linha;
	}
	
	/**
     * Método responsável pela coluna
     
     * @return quantidade de colunas
     
     */
	public int getColuna()
	{
		return coluna;
	}

	
	
	@Override
	public String toString() {
		String labReescrito = String.valueOf(this.LabMatriz[0]) + "\n";
		for(int i = 1; i < this.linha; i++) {
			if(i == this.linha -1)
				labReescrito += String.valueOf(this.LabMatriz[i]);
			else
				labReescrito += String.valueOf(this.LabMatriz[i]) + "\n";
			
		}
		return labReescrito;
	}
	
	@Override
	public int hashCode ()
	{
		int ret = 36;
		
		ret = 13*ret + new Integer (this.linha).hashCode();
		ret = 13*ret + new Integer (this.coluna).hashCode();
		
		for (int i = 0; i < this.linha; i++)
			for (int j = 0; j < this.coluna; j++)
				ret = 2*ret + new Character (this.LabMatriz[i][j]).hashCode();
		
		ret = 11*ret + this.entrada.hashCode();
		ret = 11*ret + this.saida.hashCode();
		
		return ret;
	}
	
	@Override
	public boolean equals (Object obj) 
	{
		if(this==obj)
			return true;
		
		if(obj==null) // só estou testando o obj, porque sei que o this NUNCA é null
            return false;
		
		if(this.getClass() != obj.getClass())
			return false;
		
		Labirinto lab = (Labirinto) obj;
		
		for(int i = 0; i < this.linha; i++)
			for(int j = 0; j < this.coluna; j++)
				if(this.LabMatriz[i][j] != lab.LabMatriz[i][j])
					return false;
		
		if(this.linha != lab.linha)
			return false;
		
		if(this.coluna != lab.coluna)
			return false;
		
		if(this.entrada != lab.entrada)
			return false;
					
		if(this.saida != lab.saida)
			return false;
		
		return true;
	}
	
	 /**
    * Método responsável pelo Labirinto
    * @param modelo do labirinto
    * @return o modelo do labirinto
    * @throws Exception exceções de validação do modelo do labirinto
    */
	public Labirinto (Labirinto modelo) throws Exception
	{
		if(modelo == null)
			throw new Exception ("Modelo ausente");
		
		this.linha = modelo.linha;
		this.coluna = modelo.coluna;
		this.entrada = modelo.entrada;
		this.saida = modelo.saida;
		
		this.LabMatriz = new char [modelo.linha][modelo.coluna];
		
		for(int i = 0; i < modelo.linha; i++)
			for(int j = 0; j < modelo.coluna; j++)
				this.LabMatriz[i][j] = modelo.LabMatriz[i][j];
	}
	
	 /**
    * Método responsável por clonar um objeto
    
    * @return novo labirinto clonado
   
    */
	public Object clone ()
	{
		Labirinto ret = null;
		
		try
		{
			ret = new Labirinto (this);
		}
		catch (Exception erro)
		{}
		
		return ret;
	}
}
	