package aftr.tallertextview;

import org.junit.Test;

import static java.lang.Math.PI;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void areaCuadrado(){
        double a=3, b;
        b=9;
        assertEquals(b,Metodos.areaCuadrado(a),0);
    }
    @Test
    public void areaRectangulo(){
        double a=4, b=5, c;
        c=20;
        assertEquals(c,Metodos.areaRectangulo(a,b),0);
    }
    @Test
    public void areaCirculo(){
        double a=6, b;
        b=PI*36;
        assertEquals(b,Metodos.areaCirculo(a),0);
    }
    @Test
    public void volumenCilindro(){
        double a=3, b=4, c;
        c=PI*36;
        assertEquals(c,Metodos.volumenCilindro(a,b),0);
    }
    @Test
    public void volumenCono(){
        double a=5, b=6, c;
        c=(PI*150)/3;
        assertEquals(c,Metodos.volumenCono(a,b),0);
    }
    @Test
    public void volumenCubo(){
        double a=7, b;
        b=343;
        assertEquals(b,Metodos.volumenCubo(a),0);
    }
}