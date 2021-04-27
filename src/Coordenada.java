
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
	
	
}
