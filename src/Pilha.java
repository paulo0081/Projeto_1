public class Pilha <X> implements Cloneable
{
    private Object[] elemento; // private X[] elemento;
    private int      tamanhoInicial;
    private int      ultimo = -1; // vazia
    
    
    public Pilha ()
    {
        this.elemento       = new Object [10]; // this.elemento = new X [10];
        this.tamanhoInicial = 10;
    }
    
    public Pilha (int tamanho) throws Exception
    {
        if (tamanho<=0)
            throw new Exception ("Tamanho invalido");
            
        this.elemento       = new Object [tamanho]; // this.elemento = new X [tamanho];
        this.tamanhoInicial = tamanho;
    }
    
    public int getQuantidade ()
    {
        return this.ultimo+1;
    }
    
    private void redimensioneSe (float fator)
    {
        // X[] novo = new X [Math.round(this.elemento.length*fator)];
        Object[] novo = new Object [Math.round(this.elemento.length*fator)];
        
        for(int i=0; i<=this.ultimo; i++)
            novo[i] = this.elemento[i];

        this.elemento = novo;
    }
    
   public void guardeUmItem (X x) throws Exception
    {
        if (x==null){
            throw new Exception ("Valor ausente");
        }

        if (this.ultimo-1==this.elemento.length) {
            throw new Exception("Pilha cheia");
        }// cheia
            
        this.ultimo++;
        this.elemento[this.ultimo]=x;
    }

    public X recupereUmItem () throws Exception
    {
        if (this.ultimo==-1)
            throw new Exception ("Pilha vazia");
            
        return (X)this.elemento[this.ultimo];
    }

    public void removaUmItem () throws Exception
    {
        if (this.ultimo==-1) // vazia
            throw new Exception ("Nada a remover");

        this.elemento[this.ultimo] = null;
        this.ultimo--;

        if (this.elemento.length>this.tamanhoInicial &&
            this.ultimo+1<=Math.round(this.elemento.length*0.25F))
            this.redimensioneSe (0.5F);
    }
    
    public boolean isCheia ()
    {
        return this.ultimo+1==this.elemento.length;
    }

    public boolean isVazia ()
    {
        return this.ultimo==-1;
    }
    
    
    
    @Override
    public String toString ()
    {
        String ret;
        
        if (this.ultimo==0)
            ret="1 elemento";
        else
            ret=(this.ultimo+1)+" elementos";
            
        if (this.ultimo!=-1)
            ret += ", sendo o ultimo "+this.elemento[this.ultimo];
        
        return ret;
    }
    
    @Override
    public boolean equals (Object obj)
    {
        if(this==obj)
            return true;

        if(obj==null) 
            return false;

        if(this.getClass()!=obj.getClass())
            return false;

        Pilha<X> pil = (Pilha<X>) obj;

        if(this.ultimo!=pil.ultimo)
            return false;

        if(this.tamanhoInicial!=pil.tamanhoInicial)
            return false;

        for(int i=0 ; i<=this.ultimo; i++)
            if(!this.elemento[i].equals(pil.elemento[i]))
                return false;

        return true;
    }

    @Override
    public int hashCode ()
    {
        int ret=12;

        ret = ret*7/*primo*/ + new Integer(this.ultimo        ).hashCode();
        ret = ret*5/*primo*/ + new Integer(this.tamanhoInicial).hashCode();

        for (int i=0; i<=this.ultimo; i++)
            ret = ret*3/*primo*/ + this.elemento[i].hashCode();

        if (ret<0)
            ret=-ret;

        return ret;
    }
    
    public Pilha (Pilha<X> modelo) throws Exception 
    {
    	if(modelo == null)
    		throw new Exception("Modelo inexistente.");
    		
		this.elemento = new Object[modelo.getQuantidade()];
		this.tamanhoInicial = modelo.tamanhoInicial;
		this.ultimo = -1;
		
		Pilha<X> pilhaAuxiliar = new Pilha<X>(modelo.getQuantidade());
		
		while(!modelo.isVazia()) {
			pilhaAuxiliar.guardeUmItem(modelo.recupereUmItem());
			modelo.removaUmItem();
		}
		
		while(!pilhaAuxiliar.isVazia()) {
			modelo.guardeUmItem(pilhaAuxiliar.recupereUmItem());
			this.guardeUmItem(pilhaAuxiliar.recupereUmItem());
			pilhaAuxiliar.removaUmItem();
		}
    }
    
    public Object clone()
    {
    	
    	Pilha<X> ret = null;
    	try {
    		ret = new Pilha<X>(this);
    	}
    	catch(Exception erro) {}
    	
    	return ret;
    }
    
    public int compareTo(Pilha<X> pilha) 
    {
    	if(this.getQuantidade() < pilha.getQuantidade())
    		return -1;
    	if(this.getQuantidade() < pilha.getQuantidade())
    		return 1;
    	return 0;
    }
}
