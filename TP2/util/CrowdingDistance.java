package util;

import java.util.ArrayList;
import java.util.List;

import individuo.Individuo;
import problema.ProblemaExemplo;

public class CrowdingDistance {

    public void avaliar(List<Individuo> T) {
        int t = T.size();
        for (Individuo ind : T) {
            ind.d = 0;
        }
        
        Individuo ind0 = T.get(0);
        
        for (int o = 0; o < ind0.getObjetivos().length; o++) {
            sort(T, o); // ordena os indivíduos de acordo com o objetivo o
            T.get(0).d = Double.POSITIVE_INFINITY; // extremos
            T.get(t - 1).d = Double.POSITIVE_INFINITY; // extremos

            // calcula a distância de cada indivíduo
            for (int i = 1; i < t - 1; i++) {
                double aux = ((T.get(i + 1).getObjetivos()[o] - T.get(i - 1).getObjetivos()[o]) / (T.get(t - 1).getObjetivos()[o] - T.get(0).getObjetivos()[o]));
                T.get(i).d += aux; // distância
            }
        }
    }

    public void sort(List<Individuo> T, int m) {
        // ordena os indivíduos de acordo com o objetivo m
        for (int i = 0; i < T.size(); i++) {
            for (int j = i + 1; j < T.size(); j++) {
                // se o indivíduo i domina o indivíduo j
                if (T.get(i).getObjetivos()[m] > T.get(j).getObjetivos()[m]) {
                    Individuo aux = T.get(i);
                    T.set(i, T.get(j));
                    T.set(j, aux);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Individuo> f = new ArrayList<Individuo>();
        f.add(new Individuo(new ProblemaExemplo(), new double[]{6}));
        f.add(new Individuo(new ProblemaExemplo(), new double[]{7}));
        f.add(new Individuo(new ProblemaExemplo(), new double[]{8}));
        f.add(new Individuo(new ProblemaExemplo(), new double[]{9}));

        CrowdingDistance cd = new CrowdingDistance();
        cd.avaliar(f);

        List<Individuo> fronts = f;
        for (Individuo ind : fronts) {
            System.out.println(ind.d);
        }

    }
}
