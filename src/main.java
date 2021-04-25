
public class main {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		try {
			Labirinto tamanho = new Labirinto("teste.txt");
			//System.out.println(tamanho.toString());
			Coordenada c = tamanho.getEntrada();
			tamanho.navegar(tamanho);
			System.out.println(c.toString());
			
		} catch(Exception erro) {
			System.err.println(erro);
		}
		

	}

}
