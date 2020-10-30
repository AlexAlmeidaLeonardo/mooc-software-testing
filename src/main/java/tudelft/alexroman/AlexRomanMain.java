package tudelft.alexroman;

public class AlexRomanMain
{
    public static void main (String[] args)
    {
        String romano = "MMMCMXCIX";
        //String romano = "XXC";
        //String romano = "IV";

        System.out.println("Romano: " + romano);

        AlexRoman alexRoman = new AlexRoman();
        int valor = alexRoman.convert(romano);

        System.out.println("Inteiro: " + valor);
    }
}
