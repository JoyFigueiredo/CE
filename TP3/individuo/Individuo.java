package individuo;
import java.util.ArrayList;
import java.util.List;

import operadores.crossover.CrossOver;
import operadores.crossover.impl.CrossOverBLXAlfa;
import operadores.mutation.Mutation;
import operadores.mutation.impl.MutationNone;
import problema.Problema;
import problema.ProblemaExemplo;

public class Individuo {

    private double[] vars;  // Variáveis de decisão
    private double[] objetivos;  // Valores dos objetivos
    public double d;  // Distância de crowding

    private Problema problema;  // Problema associado ao indivíduo
    private CrossOver crossOver;
    private Mutation mutation;

    // Construtor que recebe um problema e as variáveis de decisão
    public Individuo(Problema problema, double[] vars) {
        this(problema, vars, new CrossOverBLXAlfa(0.1), new MutationNone())
    }

    public Individuo(Problema problema, double[] vars, CrossOver crossOver, Mutation mutation) {
        this.problema = problema;
        this.vars = vars;
        this.crossOver = crossOver;
        this.mutation = mutation;
    }

    // Construtor que recebe um problema específico (ProblemaExemplo) e as variáveis de decisão
    public Individuo(ProblemaExemplo problema, double[] vars) {
        this.problema = problema;
        this.vars = vars;
    }

    // Retorna os valores dos objetivos, avaliando-os se ainda não foram calculados
    public double[] getObjetivos() {
        if (objetivos == null) {
            objetivos = problema.avaliar(vars);
        }
        return objetivos;
    }

    public List<Individuo> recombinar(Individuo p2) {
        List<Individuo> filhos = new ArrayList<Individuo>(2);

        double[] varsP1 = this.vars;
        double[] varsP2 = p2.vars;

        double[][] filhosMat = crossOver.getOffSpring(this.vars, p2.vars, new double[] {-10,-10}, new double[] {10,10});
        
        return filhos;
    }

    // Representação textual do indivíduo
    public String toString() {
        String ret = "Individuo - vars[";
        for (int i = 0; i < vars.length; i++) {
            if (i==vars.length-1) {
                ret += vars[i] + " ]";
                
            } else {
                ret += vars[i] + ", ";
            }
        }

        ret = ret + " - objetivos[";
        for (int i = 0; i < objetivos.length; i++) {
            if (i==objetivos.length-1) {
                ret += objetivos[i] + " ]";
                
            } else {
                ret += objetivos[i] + ", ";
            }
        }
        return ret;
    }
}
