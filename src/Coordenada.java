
public class Coordenada {
	private int coordX; //
	private int coordY;
	
	public Coordenada(int x,int y) {
		coordX = x;
		coordY = y;
	}

    //coordinates equals
    public boolean equals(int x, int y) { 
        //makes x a primitive number
        Integer trueXInteger = Integer.valueOf(x); 

        //makes y a primitive number
        Integer trueYInteger = Integer.valueOf(y); 

        //checks if the past values aren't null
        if(trueXInteger == null || trueYInteger == null) 
            return false;

        //checks if this coordinate has already been registered
        if (trueYInteger.equals(this.coordX) && trueYInteger.equals(this.coordY)) {
            return true;
        }

        return false; 
    }

    //hashCode 
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
