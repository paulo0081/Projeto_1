
public class Coordenada {
	private int coordX;
	private int coordY;
	
	public Coordenada(int x,int y) {
		coordX = x;
		coordY = y;
	}
	
	
    /** 
     * @return int
     * @see Retorna a propriedade de coordenada, no eixo X
     */
    public int getX()
	{
		return coordX;
	}
	
	
    /** 
     * @return int
     *  @metodo Retorna a propriedade de coordenada, no eixo Y
     */
    public int getY()
	{
		return coordY;
	}
	
	
	
	
    /** 
     * @return String
     * @see @metodo Método utilizado apenas para imprimir da maneira que gostariamos
     */
    @Override
	public String toString()
	{
		return ("{"+coordX+","+coordY+"}");
	}
	
	
    /** 
     * @param obj
     * @return boolean
     * @metodo Re-implementação do método equals, utilizando novas regras de negócio para que se adeque a sua chamada futuramente
     */
    @Override
	public boolean equals(Object obj)
	{
        if(this==obj)
            return true;

        if(obj==null) // s� estou testando o obj, porque sei que o this NUNCA � null
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
	
	
    /** 
     * @return int
     * @metodo Re-implementação do método hashCode, gerando um hash completamente diferente do padrão, modificado exclusivamente para esta classe
     */
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
	
	public Coordenada (Coordenada modelo){

        this.coordX = modelo.coordX;
        this.coordY = modelo.coordY;

    }

    
    /** 
     * @return Object
     * @metodo Re-implementação do metodo clone para que se adeque a classe
     */
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
     * @param coordenada
     * @return int
     * @metodo compareTo, para que seja possível a comparação das coordenadas a partir do parâmetro passado
     */
    public int compareTo (Coordenada coordenada){

        if(this.coordX < coordenada.coordX) return -1;
        if(this.coordY < coordenada.coordY) return -2;
        return 0;
    }
}
