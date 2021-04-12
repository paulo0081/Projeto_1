public class Pilha <X>
{
    private Object[] elemento; // private X[] elemento;
    private int      tamanhoInicial;
    private int      ultimo = -1; // vazia
    
    // construtor padrao, pois nao tem parametros
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
    
    // LIFO
    public void guardeUmItem (X x) throws Exception
    {
        if (x==null)
            throw new Exception ("Valor ausente");
        
        if (this.ultimo+1==this.elemento.length) // cheia
            this.redimensioneSe (2.0F);
            
        this.ultimo++;
        this.elemento[this.ultimo]=x;
    }

    // LIFO
    public X recupereUmItem () throws Exception
    {
        if (this.ultimo==-1)
            throw new Exception ("Pilha vazia");
            
        return (X)this.elemento[this.ultimo];
    }

    // LIFO
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
    
    /*
    public boolean isCheia ()
    {
        if(this.ultimo+1==this.elemento.length)
            return true;

        return false;
    }
    */
    public boolean isCheia ()
    {
        return this.ultimo+1==this.elemento.length;
    }
    /*
    public boolean isVazia ()
    {
        if(this.ultimo==-1)
            return true;

        return false;
    }
    */
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
    
    // estamos aqui para comparar o this, QUE SEI QUE � UMA PILHA<X>,
    // com o obj, QUE N�O SEI O QUE �
    @Override
    public boolean equals (Object obj)
    {
        if(this==obj)
            return true;

        if(obj==null) // s� estou testando o obj, porque sei que o this NUNCA � null
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
        int ret=666/*qualquer positivo*/;

        ret = ret*7/*primo*/ + new Integer(this.ultimo        ).hashCode();
        ret = ret*7/*primo*/ + new Integer(this.tamanhoInicial).hashCode();

        for (int i=0; i<=this.ultimo; i++)
            ret = ret*7/*primo*/ + this.elemento[i].hashCode();

        if (ret<0)
            ret=-ret;

        return ret;
    }
}
