
public class Coordenada {
	private int coordX;
	private int coordY;
	
	/**
	 * Constrói um objeto Coordenada com os valores de 'x' e 'y' passados.
	 * @param int x - Valor da posição 'x'
	 *
	*/
	public Coordenada(int x,int y) {
		coordX = x;
		coordY = y;
	}
	
	
	/**
	 * Retorna a propriedade de coordenada, no eixo X. 
     * @return int
     */
	public int getX()
	{
		return coordX;
	}
	
	/**
	 * Retorna a propriedade de coordenada, no eixo Y. 
     * @return int
     */
	public int getY()
	{
		return coordY;
	}
	
	
	@Override
	public String toString()
	{
		return ("{"+coordX+","+coordY+"}");
	}
	
	@Override
	public boolean equals(Object obj)
	{
        if(this==obj)
            return true;

        if(obj==null) // só estou testando o obj, porque sei que o this NUNCA é null
            return false;

        if(this.getClass()!=obj.getClass())
            return false;

        Coordenada coord = (Coordenada) obj;

        if(this.coordX != coord.coordX)
            return false;

        if(this.coordY != coord.coordY)
            return false;

        return true;
    }
	
	@Override
	public int hashCode() {
		Integer hashedX = Integer.valueOf(234);
        Integer hashedY = Integer.valueOf(433);

        hashedX = hashedY.hashCode() * this.coordX;
        hashedY = hashedX.hashCode() * this.coordY;

        if(hashedX < 0 || hashedY < 0){
            hashedX = -hashedX;
            hashedY = -hashedY;
        };

        return hashedX + hashedY;
    }
	
	
	/**
	 * Construtor com a função de fazer uma deep copy de uma coordenada. 
	 * 
	 * @param coordenada: se refere ao objeto a ser clonado.
     */
	public Coordenada(Coordenada modelo){
        this.coordX = modelo.coordX;
        this.coordY = modelo.coordY;

    }
	
	@Override
    public Object clone () {

        Coordenada aux = null;
        try {
            aux = new Coordenada(this);
        }
        catch (Exception error)
        {

        }

        return aux;
    }
	
	/**
	 * Compara os valores da coordenada X.
	 * -1 se X do comparador for menor que o comparado,
	 *  0 se X do comparador for igual    ao comparado,
	 *  1 se X do comparador for maior que o comparado. 
	 * 
	 * @param coordenada: se refere a coordenada comparada.
     * @return int:
     */
    public int compareTo (Coordenada coordenada){

        if(this.coordX < coordenada.coordX) return -1;
        if(this.coordX > coordenada.coordX) return  1;
        return 0;
    }
}
