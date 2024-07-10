package algoritmo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import individuo.Individuo;
import individuo.IndividuoFactory;
import individuo.IndividuoShafferFactory;
import problema.Problema;
import problema.ProblemaShaffer;

public class NSGA2 {

    public void execute(IndividuoFactory individuoFactory, int nPop, int qtdEpocas) {
        List<Individuo> pop = new ArrayList<Individuo>(nPop);
        for (int i = 0; i < nPop; i++) {
            pop.add(individuoFactory.getIndividuo());
        }

        int e = 1;

        while (e <= qtdEpocas) {
            List<Individuo> q = new ArrayList<Individuo>(nPop);
            makeOffSpring(q,pop);
        }
    }

    private void makeOffSpring(List<Individuo> q, List<Individuo> pop) {
        Random rnd = new Random();
        List<Individuo> r = new ArrayList<Individuo>(pop.size());
        r.addAll(pop);

        while (r.size() > 1) {
            int idx1 = rnd.nextInt(r.size());
            Individuo p1 = r.remove(idx1);
            int idx2 = rnd.nextInt(r.size());
            Individuo p2 = r.remove(idx2);

            
        }
    }

    public static void main(String[] args) {

        IndividuoFactory factory = new IndividuoShafferFactory();

    }

}
