 /**
     * Classe de navegacao clonada que tem pilhas de coordenada 
     * @param coordenadas do labirinto 1 e o valor de x e y
     * @throws Exception exceções de validação de erro
     */
public class Navegacao implements Cloneable
{
	
	Coordenada c;
	Pilha<Coordenada> pilhaMenor;
	Pilha<Pilha<Coordenada>> pilhaMaior;
		
	/**
	 * #Precisa fazer#
	*/
	public Navegacao(Labirinto l) throws Exception {
		try {
			this.c = l.getEntrada();
			this.pilhaMenor = new Pilha<Coordenada>(3);
			this.pilhaMaior = new Pilha<Pilha<Coordenada>>(l.getLinha()*l.getColuna());
			prosseguir(l);
			
		}catch(Exception erro) {
			throw (erro);
		}
		
	}
	
	 /**
     * Método responsável por validar as posicoes ao redor da coordenada
     * @param valor inteiro de x, y e labirinto 1
     * @return returna valor 0 ou 1
     * @throws Exception exceções de validação das posições do labirinto
     */
	private int validaArredor(int x, int y, Labirinto l) throws Exception {
		int ret;
		
		if((x < l.getLinha() && x > -1) && (y < l.getColuna() && y > -1))
		{
			ret = l.verificarArredor(x, y);
			
			if(ret == 1) {
				return 1;
			}
			
			if(ret == 2) {
				this.pilhaMenor.guardeUmItem(new Coordenada(x, y));
			}
		}
		return 0;
	}
	
	  /**
     * Método responsável por percorrer o labirinto
     * @param objeto do tipo labirinto 
     * @throws Exception exceções de validação do labirinto
     */
	private void prosseguir(Labirinto l) throws Exception {
		int resposta = 0;
		
		this.pilhaMenor = new Pilha<Coordenada>(3);
		
		resposta = validaArredor(c.getX()+1, c.getY(), l);
		if(resposta != 1)
			resposta = validaArredor(c.getX(), c.getY()+1, l);
		if(resposta != 1)
			resposta = validaArredor(c.getX()-1, c.getY(), l);
		if(resposta != 1)
			resposta = validaArredor(c.getX(), c.getY()-1, l);
		if(resposta != 1) {
			if(!pilhaMenor.isVazia()) {	
				this.pilhaMaior.guardeUmItem(this.pilhaMenor);
				this.c = this.pilhaMenor.recupereUmItem();
				l.modificarCaminho(c, 0);
				prosseguir(l);
			}
			
			else {
				retroceder(l);
			}
		}
	}
	
	  /**
     * Método responsável por voltar o que ja foi percorrido
     * @param obejto do tipo labirinto 
     * @throws Exception exceções de validação de saida
     */
	private void retroceder(Labirinto l) throws Exception {
		if(this.pilhaMaior.isVazia()){
			throw new Exception ("Saída não encontrada");
		} 
		
		else {
			this.pilhaMenor = this.pilhaMaior.recupereUmItem();
			this.pilhaMaior.removaUmItem();
			
			if(this.pilhaMenor.getQuantidade() == 1) {
				this.c = this.pilhaMenor.recupereUmItem();
				l.modificarCaminho(c, 1);
				retroceder(l);
			}
			else {
				this.c = this.pilhaMenor.recupereUmItem();
				l.modificarCaminho(c, 1);
				this.pilhaMenor.removaUmItem();
				this.c = this.pilhaMenor.recupereUmItem();
				l.modificarCaminho(c, 0);
				this.pilhaMaior.guardeUmItem(this.pilhaMenor);
				prosseguir(l);
			}
		}
	}
	

	
	@Override
	public String toString() {
		
		String caminho = "";
		try
		{
			Pilha<Pilha<Coordenada>> pilhaMaiorAuxiliar = new Pilha<Pilha<Coordenada>>(this.pilhaMaior.getQuantidade());
			
			while(!this.pilhaMaior.isVazia()) {
				pilhaMaiorAuxiliar.guardeUmItem(this.pilhaMaior.recupereUmItem());
				this.pilhaMaior.removaUmItem();
			}
			
			while(!pilhaMaiorAuxiliar.isVazia()) {
				this.pilhaMenor = pilhaMaiorAuxiliar.recupereUmItem();
				pilhaMaiorAuxiliar.removaUmItem();
				this.c = this.pilhaMenor.recupereUmItem();
				caminho += c.toString() + "\n";
			}
			
			
		}catch(Exception erro) {}
		
		return caminho;
	}

	@Override
	public boolean equals(Object obj) {
		if(this==obj)
			return true;
		
		if(obj==null)
            return false;
		
		if(this.getClass() != obj.getClass())
			return false;
		
		Navegacao nav = (Navegacao) obj;
		
		if(this.c != nav.c)
			return false;
		
		if(!this.pilhaMenor.equals(nav.pilhaMenor))
			return false;
		
		if(!this.pilhaMaior.equals(nav.pilhaMaior))
			return false;
		
		return true;
	}
	
	@Override
	public int hashCode() {
		
		int ret = 36;

		ret = 5 * ret + new Integer (this.c.getX()).hashCode();
		ret = 7 * ret + new Integer (this.c.getY()).hashCode();
		ret = 13* ret + new Integer (this.pilhaMenor.getQuantidade()).hashCode();
		ret = 2 * ret + new Integer (this.pilhaMaior.getQuantidade()).hashCode();

		return ret;
		
	}

	public int compareTo(Navegacao nav) {

		if(this.pilhaMenor.getQuantidade() > nav.pilhaMenor.getQuantidade()) return  1;
		if(this.pilhaMenor.getQuantidade() < nav.pilhaMenor.getQuantidade()) return -1;
		return 0;
	}
	
	/**
	 * Construtor com a função de fazer uma deep copy da Navegação. 
	 * 
	 * @param coordenada: se refere ao objeto a ser clonado.
     */
	public Navegacao (Navegacao nav) throws Exception {
		
		if(nav == null)
			throw new Exception ("Modelo ausente");
		
		this.c = nav.c;
		this.pilhaMaior = nav.pilhaMaior;
		this.pilhaMenor = nav.pilhaMenor;
	}
	
	@Override
	public Navegacao clone(){

		Navegacao aux = null;

		try { 
			aux = new Navegacao(aux);
		} catch(Exception error) {}

		return aux;
	}
}
