package tudelft.alexroman;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AlexRomanTest {

    private AlexRoman roman;

    @BeforeEach
    public void initialize()
    {
        System.out.print("This method is called before each test!\n");
        roman = new AlexRoman();
    }

    @Test
    void convert_IIV()
    {
        int result = roman.convert("IIV");
        Assertions.assertEquals(-1, result);
    }

    @Test
    void convert_I()
    {
        int result = roman.convert("I");
        Assertions.assertEquals(1, result);
    }

    @Test
    void convert_II()
    {
        int result = roman.convert("II");
        Assertions.assertEquals(2, result);
    }

    @Test
    void convert_III()
    {
        int result = roman.convert("III");
        Assertions.assertEquals(3, result);
    }

    @Test
    void convert_IIII()
    {
        int result = roman.convert("IIII");
        Assertions.assertEquals(-1, result);
    }

    @Test
    void convert_IIIII()
    {
        int result = roman.convert("IIIII");
        Assertions.assertEquals(-1, result);
    }

    @Test
    void convert_MMMCMXCIX()
    {
        int result = roman.convert("MMMCMXCIX");
        Assertions.assertEquals(3999, result);
    }

    @Test
    void convert_IIX()
    {
        int result = roman.convert("IIX");
        Assertions.assertEquals(-1, result);
    }

    @Test
    void convert_IM()
    {
        int result = roman.convert("IM");
        Assertions.assertEquals(-1, result);
    }

    @Test
    void convert_VX()
    {
        int result = roman.convert("VX");
        Assertions.assertEquals(-1, result);
    }

}