package tudelft.alexroman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlexRoman
{
    private static Map<Character, Integer> map;
    /*static {
        map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }*/
    static {
        map = new HashMap<Character, Integer>();
        map.put('I', 0);
        map.put('V', 1);
        map.put('X', 2);
        map.put('L', 3);
        map.put('C', 4);
        map.put('D', 5);
        map.put('M', 6);
    }

    private static List<Algarismo> lstAlgarismos;
    static
    {
        lstAlgarismos = new ArrayList<>();
        lstAlgarismos.add(new Algarismo('I', 1, 1, true));
        lstAlgarismos.add(new Algarismo('V', 5, 1, false));
        lstAlgarismos.add(new Algarismo('X', 10, 2, true));
        lstAlgarismos.add(new Algarismo('L', 50, 2, false));
        lstAlgarismos.add(new Algarismo('C', 100, 3, true));
        lstAlgarismos.add(new Algarismo('D', 500, 3, false));
        lstAlgarismos.add(new Algarismo('M', 1000, 4, true));
    }


    public int convertOld(String s)
    {
        int valor = 0;

        int atual = -1;
        int proximo = -1;

        for(int i = 0; i < s.length(); i++)
        {
            atual = map.get( s.charAt(i) );

            if (i + 1 < s.length())
            {
                proximo = map.get( s.charAt(i + 1) );

                if (atual < proximo)
                {
                    if (atual == 5 || atual == 50 || atual == 500)
                    {
                        return -1;
                    }

                    if (proximo == map.get( 'M' ) && atual != map.get( 'C' ) )
                    {
                        return -1;
                    }

                    if (proximo == map.get( 'D' ) && atual != map.get( 'C' ) && atual != map.get( 'X' ))
                    {
                        return -1;
                    }

                    if (proximo == map.get( 'C' ) && atual != map.get( 'X' ))
                    {
                        return -1;
                    }

                    if (proximo == map.get( 'L' ) && atual != map.get( 'X' ) && atual != map.get( 'I' ))
                    {
                        return -1;
                    }

                    if (proximo == map.get( 'X' ) && atual != map.get( 'I' ))
                    {
                        return -1;
                    }

                    if (proximo == map.get( 'V' ) && atual != map.get( 'I' ))
                    {
                        return -1;
                    }

                    valor += proximo - atual;
                    i++;
                }
                else
                {
                    valor += atual;
                }
            }
            else
            {
                valor += atual;
            }
        }

        return valor;
    }

    public int convert(String s)
    {
        /*
        A unidade de um conjunto só pode ser subtraida pela unidade do conjunto inferior.
        A "dezena" de um conjunto só pode ser subtraida pela unidade do seu conjunto.
        */
        int valor = 0;

        Algarismo atual;
        Algarismo anterior;

        if ( s.matches("^.*(.)\\1\\1\\1.*$") )
        {
            return -1;
        }

        for(int i = s.length()-1; i >= 0; i--)
        {
            atual = lstAlgarismos.get( map.get( s.charAt(i) ) );
            if (i - 1 >= 0)
            {
                anterior = lstAlgarismos.get( map.get( s.charAt(i - 1) ) );

                if (anterior.getValor() < atual.getValor())
                {
                    if ((atual.isPrimeiraOrdem() && anterior.getConjunto() == atual.getConjunto()-1 && anterior.isPrimeiraOrdem()) ||
                       (!atual.isPrimeiraOrdem() && anterior.getConjunto() == atual.getConjunto() && anterior.isPrimeiraOrdem()))
                    {
                        valor += (atual.getValor() - anterior.getValor());
                        i--;

                        if (i - 1 >= 0)
                        {
                            Algarismo previo = lstAlgarismos.get( map.get( s.charAt(i - 1) ) );

                            if (previo.getValor() <= anterior.getValor())
                            {
                                return -1;
                            }
                        }

                    }
                    else
                    {
                        return -1;
                    }
                }
                else
                {
                    valor += atual.getValor();
                }
            }
            else
            {
                valor += atual.getValor();
            }
        }
        return valor;
    }

}
