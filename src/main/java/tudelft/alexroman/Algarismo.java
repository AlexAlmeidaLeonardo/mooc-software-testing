package tudelft.alexroman;

public class Algarismo
{
    private Character letra;
    public Character getLetra()
    {
        return letra;
    }
    public void setLetra(Character letra)
    {
        this.letra = letra;
    }

    private int valor;
    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }

    private int conjunto;
    public int getConjunto() {
        return conjunto;
    }
    public void setConjunto(int conjunto) {
        this.conjunto = conjunto;
    }

    private boolean primeiraOrdem;
    public boolean isPrimeiraOrdem() {
        return primeiraOrdem;
    }
    public void setPrimeiraOrdem(boolean primeiraOrdem) {
        this.primeiraOrdem = primeiraOrdem;
    }

    public Algarismo(Character l, int v, int c, boolean p)
    {
        letra = l;
        valor = v;
        conjunto = c;
        primeiraOrdem = p;
    }

}
