package aftr.tallertextview;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void areaCuadrado(){
        double a=5, b;
        b=25;
        assertEquals(b,Metodos.areaCuadrado(a),0);
    }
}