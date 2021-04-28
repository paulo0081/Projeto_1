
public class Coordenada {
	private int coordX;
	private int coordY;
	
	public Coordenada(int x,int y) {
		coordX = x;
		coordY = y;
	}
	
	public int getX()
	{
		return coordX;
	}
	
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
	
	public Coordenada (Coordenada modelo){

        this.coordX = modelo.coordX;
        this.coordY = modelo.coordY;

    }

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

    public int compareTo (Coordenada coordenada){

        if(this.coordX < coordenada.coordX) return -1;
        if(this.coordY < coordenada.coordY) return -2;
        return 0;
    }
	
	
	
	
}
