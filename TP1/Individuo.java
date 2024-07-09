import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Individuo {

    ArrayList<Individuo> dominados = new ArrayList<>();
    int n, r;
    double[] genes;
    double[] objetivos;

    public Individuo(int qtdGenes, int qtdObjt) {
        this.genes = new double[qtdGenes];
        this.objetivos = new double[qtdObjt];
    }

    public Individuo(double[] genes, double[] objetivos) {
        this.genes = Arrays.copyOf(genes, genes.length);
        this.objetivos = Arrays.copyOf(objetivos, objetivos.length);
    }

}
