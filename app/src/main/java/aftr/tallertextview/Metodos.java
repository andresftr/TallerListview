package aftr.tallertextview;

import static java.lang.Math.PI;

public class Metodos {
    public static double areaCuadrado(double lad){
        return lad*lad;
    }

    public static double areaRectangulo(double bas, double alt){
        return bas*alt;
    }

    public static double areaCirculo(double rad){
        return PI*Math.pow(rad,2);
    }
    
    public static double volumenCilindro(double rad, double alt){
        return PI*Math.pow(rad,2)*alt;
    }

    public static double volumenCono(double rad, double alt){
        return (PI*Math.pow(rad,2)*alt)/3;
    }

    public static double volumenCubo(double lad){
        return Math.pow(lad,3);
    }
}
