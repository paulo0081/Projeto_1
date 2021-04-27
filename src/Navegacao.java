
public class Navegacao {
		Coordenada c = null;
		Pilha<Coordenada> pilhaMenor = null;
		Pilha<Pilha<Coordenada>> pilhaMaior = null;
	public Navegacao(Labirinto l) {
		int ret;
		try {
			this.c = l.getEntrada();
			this.pilhaMaior = new Pilha<Pilha<Coordenada>>();

		}catch(Exception erro) {
			System.out.println(erro);
		}
		
	}
	
	
	private void validaArredor(int x, int y, Labirinto l) throws Exception {
		int ret;
		
		
		ret = l.verificarArredor(x, y);
		
		if(ret == 2)
		{
			System.out.println(ret); // tempor�rio, ser� o print invertido de pilhaMaior
		}
		
		if(ret == 1)
		{
			pilhaMenor.guardeUmItem(new Coordenada(c.getX()+1, c.getY()));
		}
		
	}
	
	private void solucao(Labirinto l) throws Exception
	{
		//inicio do loop
		this.pilhaMenor = new Pilha<Coordenada>(3);
		validaArredor(c.getX()+1, c.getY(), l);
		validaArredor(c.getX(), c.getY()+1, l);
		validaArredor(c.getX()-1, c.getY(), l);
		validaArredor(c.getX(), c.getY()-1, l);
		
		if(!pilhaMenor.isVazia())
			this.pilhaMaior.guardeUmItem(this.pilhaMenor);
		else {
			Pilha<Coordenada> pilhaMenor = this.pilhaMaior.recupereUmItem();
			this.pilhaMaior.recupereUmItem();
		}
		
		this.c = pilhaMenor.recupereUmItem();
		
	}

	public Coordenada getCoordenada() {	
		return this.c;
	}

	public Pilha<Coordenada> getPilhaMenor() {
		return this.pilhaMenor;
	}

	public Pilha<Pilha<Coordenada>> getPilhaMaior() {
		return this.pilhaMaior;
	}
	
	/*public void encontraEntrada(Labirinto l) throws Exception {
		try {
			
		}
	}*/
	
}
