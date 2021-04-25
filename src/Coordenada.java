
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
}
