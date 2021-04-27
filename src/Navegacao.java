
public class Navegacao {
	
		Coordenada c;
		Pilha<Coordenada> pilhaMenor;
		Pilha<Pilha<Coordenada>> pilhaMaior;
		
		
	public Navegacao(Labirinto l) {
		try {
			this.c = l.getEntrada();
			this.pilhaMenor = new Pilha<Coordenada>(3);
			this.pilhaMaior = new Pilha<Pilha<Coordenada>>(l.getLinha()*l.getColuna());
			
		}catch(Exception erro) {
			System.out.println(erro);
		}
		
	}
	
	private int validaArredor(int x, int y, Labirinto l) throws Exception {
		int ret;
		
		if((x < l.getLinha() && x > -1) && (y < l.getColuna() && y > -1))
		{
			ret = l.verificarArredor(x, y);
			
			if(ret == 1) {
				return 1; // tempor�rio, ser� o print invertido de pilhaMaior
			}
			
			if(ret == 2) {
				this.pilhaMenor.guardeUmItem(new Coordenada(x, y));
			}
		}
		return 0;
	}
	
	private void prosseguir(Labirinto l) throws Exception {
		int resposta = 0;
		//inicio do loop
		
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
	
	private void retroceder(Labirinto l) throws Exception {
		l.modificarCaminho(c, 1);
		if(this.pilhaMaior.isVazia()){
			throw new Exception ("Sa�da n�o encontrada");
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
	
	public void navegarLabirinto(Labirinto l) throws Exception {
		try {
			
			prosseguir(l);
			imprimeLabirinto();
			
		}catch(Exception erro){
			throw new Exception (erro);
		}
	}
	
	private void imprimeLabirinto() throws Exception {
		
		Pilha<Pilha<Coordenada>> pilhaMaiorAuxiliar = new Pilha<Pilha<Coordenada>>(this.pilhaMaior.getQuantidade());
		
		if(this.pilhaMaior.isVazia())
			throw new Exception ("Caminho inexistente");
		
		while(!this.pilhaMaior.isVazia()) {
			pilhaMaiorAuxiliar.guardeUmItem(this.pilhaMaior.recupereUmItem());
			this.pilhaMaior.removaUmItem();
		}
		
		while(!pilhaMaiorAuxiliar.isVazia()) {
			this.pilhaMenor = pilhaMaiorAuxiliar.recupereUmItem();
			pilhaMaiorAuxiliar.removaUmItem();
			this.c = this.pilhaMenor.recupereUmItem();
			System.out.println(c.toString());
		}
		
	}
}
