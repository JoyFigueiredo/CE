package individuo;
import problema.Problema;
import problema.ProblemaExemplo;

public class Individuo {

    private double[] vars;
    private double[] objetivos;

    public double d;

    private Problema problema;

    public Individuo(Problema problema, double[] vars) {
        this.problema = problema;
        this.vars = vars;
    }

    public Individuo(ProblemaExemplo problema, double[] vars) {
        this.problema = problema;
        this.vars = vars;
    }

    public double[] getObjetivos() {
        if (objetivos == null) {
            objetivos = problema.avaliar(vars);
        }
        return objetivos;
    }

    public String toString() {
        String ret = "Individuo - vars[";
        for (int i = 0; i < vars.length; i++) {
            if (i==vars.length-1) {
                ret += vars[i] + " ]";
                
            }else{
                ret += vars[i] + ", ";
            }
        }

        ret = ret + " - objetivos[";
        for (int i = 0; i < objetivos.length; i++) {
            if (i==objetivos.length-1) {
                ret += objetivos[i] + " ]";
                
            }else{
                ret += objetivos[i] + ", ";
            }
        }
        return ret;
    }
}
