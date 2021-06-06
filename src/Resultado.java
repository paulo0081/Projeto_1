/**
* Classe Resultado, responsável pelo retorno do resultado do labirinto.
*/
@SuppressWarnings("serial")
public class Resultado extends Comunicado
{
	private String labirinto;

    /**
    * Construtor Resultado, atribui o labirinto recebido como parâmentro.
    * @param lab labirinto recebido como parâmetro
    */
	public Resultado (String lab)
    {
    	this.labirinto = lab;
    }

    /**
    * @return Retorna o labirinto
    */
    public String getLabirinto ()
    {
    	return this.labirinto;
    }
    
    /**
    * @return Retorna o labirinto em formato de string
    */
    public String toString ()
    {
    	return (""+this.labirinto);
	}

}
