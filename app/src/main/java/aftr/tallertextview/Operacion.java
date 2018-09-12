package aftr.tallertextview;

public class Operacion {
    private String oper;
    private String dat;
    private String res;

    public Operacion(String oper, String dat, String res) {
        this.oper = oper;
        this.dat = dat;
        this.res = res;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    public String getDat() {
        return dat;
    }

    public void setDat(String dat) {
        this.dat = dat;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }
    
    public void guardar(){
        Datos.guardar(this);
    }
}
