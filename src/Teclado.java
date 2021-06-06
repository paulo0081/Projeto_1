import java.io.*;
/**
* Classe responsável pelo controle dos dados que entraram através do teclado.
*/
public class Teclado
{
    private static BufferedReader teclado =
                   new BufferedReader (
                   new InputStreamReader (
                   System.in));

    /**
    * @return Retorna uma string digitada
    * @throws Exception Exceção para caso ocorra um erro no processo de leitura do que foi digitado pelo teclado
    */
    public static String getUmString ()
    {
        String ret=null;

        try
        {
            ret = teclado.readLine ();
        }
        catch (IOException erro)
        {} // sei que nao vai dar erro

        return ret;
    }

    /**
    * @return Retorna um byte, que foi convertido a partir do que foi digitado pelo teclado
    * @throws Exception Exceção para se caso ocorra um erro caso o byte seja inválido
    */
    public static byte getUmByte () throws Exception
    {
        byte ret=(byte)0;

        try
        {
            ret = Byte.parseByte (teclado.readLine ());
        }
        catch (IOException erro)
        {} // sei que nao vai dar erro
        catch (NumberFormatException erro)
        {
            throw new Exception ("Byte invalido!");
        }

        return ret;
    }
 
    /**
    * @return Retorna um short, que foi convertido a partir do que foi digitado pelo teclado
    * @throws Exception Exceção para se caso ocorra um erro caso o short seja inválido
    */
    public static short getUmShort () throws Exception
    {
        short ret=(short)0;

        try
        {
            ret = Short.parseShort (teclado.readLine ());
        }
        catch (IOException erro)
        {} // sei que nao vai dar erro
        catch (NumberFormatException erro)
        {
            throw new Exception ("Short invalido!");
        }

        return ret;
    }

    /**
    * @return Retorna um inteiro, que foi convertido a partir do que foi digitado pelo teclado
    * @throws Exception Exceção para se caso ocorra um erro caso o int seja inválido
    */
    public static int getUmInt () throws Exception
    {
        int ret=0;

        try
        {
            ret = Integer.parseInt (teclado.readLine ());
        }
        catch (IOException erro)
        {} // sei que nao vai dar erro
        catch (NumberFormatException erro)
        {
            throw new Exception ("Int invalido!");
        }

        return ret;
    }

    /**
    * @return Retorna um long, que foi convertido a partir do que foi digitado pelo teclado
    * @throws Exception Exceção para se caso ocorra um erro caso o long seja inválido
    */
    public static long getUmLong () throws Exception
    {
      //long ret=(long)0;
      //long ret=0;
        long ret=0L;

        try
        {
            ret = Long.parseLong (teclado.readLine ());
        }
        catch (IOException erro)
        {} // sei que nao vai dar erro
        catch (NumberFormatException erro)
        {
            throw new Exception ("Long invalido!");
        }

        return ret;
    }

    /**
    * @return Retorna um float, que foi convertido a partir do que foi digitado pelo teclado
    * @throws Exception Exceção para se caso ocorra um erro caso o float seja inválido
    */
    public static float getUmFloat () throws Exception
    {
      //float ret=0;
      //float ret=(float)0.0;
        float ret=0.0F;

        try
        {
            ret = Float.parseFloat (teclado.readLine ());
        }
        catch (IOException erro)
        {} // sei que nao vai dar erro
        catch (NumberFormatException erro)
        {
            throw new Exception ("Float invalido!");
        }

        return ret;
    }

    /**
    * @return Retorna um double, que foi convertido a partir do que foi digitado pelo teclado
    * @throws Exception Exceção para se caso ocorra um erro caso o double seja inválido
    */
    public static double getUmDouble () throws Exception
    {
      //double ret=0;
      //double ret=(long)0;
      //double ret=0L;
        double ret=0.0;

        try
        {
            ret = Double.parseDouble (teclado.readLine ());
        }
        catch (IOException erro)
        {} // sei que nao vai dar erro
        catch (NumberFormatException erro)
        {
            throw new Exception ("Double invalido!");
        }

        return ret;
    }

    /**
    * @return Retorna um char, a partir do que digitado pelo teclado
    * @throws Exception Exceção para se caso ocorra um erro caso o char seja inválido
    */
    public static char getUmChar () throws Exception
    {
        char ret=' ';

        try
        {
            String str = teclado.readLine ();

            if (str==null)
                throw new Exception ("Char invalido!");

            if (str.length() != 1)
                throw new Exception ("Char invalido!");

             ret = str.charAt(0);
        }
        catch (IOException erro)
        {} // sei que nao vai dar erro

        return ret;
    }

    /**
    * @return Retorna um boolean, de acordo com o que foi digitado pelo teclado
    * @throws Exception Exceção para se caso ocorra um erro caso o boolean seja inválido
    */
    public static boolean getUmBoolean () throws Exception
    {
        boolean ret=false;

        try
        {
            String str = teclado.readLine ();

            if (str==null)
                throw new Exception ("Boolean invalido!");

            if (!str.equals("true") && !str.equals("false"))
                throw new Exception ("Boolean invalido!");

            ret = Boolean.parseBoolean (str);
        }
        catch (IOException erro)
        {} // sei que nao vai dar erro

        return ret;
    }
}