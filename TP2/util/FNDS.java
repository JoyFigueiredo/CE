package util;
import java.util.ArrayList;
import java.util.List;

import individuo.Individuo;
import problema.ProblemaExemplo;


public class FNDS {

    public List<List<Individuo>> executar(List<Individuo> insList){
        List<Ponto> P = new ArrayList<Ponto>(insList.size());
        List<Ponto> front1 = new ArrayList<Ponto>();
        List<List<Ponto>> fronts = new ArrayList<List<Ponto>>();

        for(Individuo ind : insList){
            P.add(new Ponto(ind));
        }

        /*
         * ========================================================================
         * PARTE 1
         * ========================================================================
         */
        for(Ponto p : P){
            p.S = new ArrayList<Ponto>(); /*dominados*/
            p.n = 0;
            for(Ponto q : P){
                if(domina(p, q)){
                    p.S.add(q);
                }else if(domina(q, p)){
                    p.n++;
                }
            }
            if(p.n == 0){
                p.rank = 0;
                front1.add(p);
            }
        }

         /*
         * ========================================================================
         * PARTE 2
         * ========================================================================
         */
        fronts.add(front1);
        int i = 0;
        List<Ponto> Fi = fronts.get(i);
        while (Fi.size() != 0) {
            List<Ponto> Q = new ArrayList<>();
            for (Ponto p : Fi) {
                List<Ponto> Sp = p.S;
                for (Ponto q : Sp) {
                    q.n--;
                    if (q.n == 0) {
                        q.rank = i + 1;
                        Q.add(q);
                    }
                }
            }
            i++;
            fronts.add(Q);
            Fi = Q;
        }

        List<List<Individuo>> frontsInd = new ArrayList<List<Individuo>>();
        for (List<Ponto> front : fronts) {
            List<Individuo> frontInd = new ArrayList<Individuo>();
            for (Ponto p : front) {
                frontInd.add(p.getInd());
            }
            frontsInd.add(frontInd);
        }

        return frontsInd;
    }


    public boolean domina(Ponto p, Ponto q){
        boolean flag = true;

        double[] obj1 = p.objetivos;
        double[] obj2 = q.objetivos;

        for(int i = 0; i < obj1.length; i++){
            if(obj2[i] < obj1[i]){
                return false;
            }
        }
        flag = false;
        for(int i = 0; i < obj1.length; i++){
            if(obj1[i] < obj2[i]){
                return true;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        List<Individuo> pop = new ArrayList<Individuo>();
        pop.add(new Individuo(new ProblemaExemplo(), new double[]{0}));
        pop.add(new Individuo(new ProblemaExemplo(), new double[]{1}));
        pop.add(new Individuo(new ProblemaExemplo(), new double[]{2}));
        pop.add(new Individuo(new ProblemaExemplo(), new double[]{3}));
        pop.add(new Individuo(new ProblemaExemplo(), new double[]{4}));
        pop.add(new Individuo(new ProblemaExemplo(), new double[]{5}));

        FNDS fnds = new FNDS();
        List<List<Individuo>> fronts = fnds.executar(pop);
        System.out.println("Fonts: ");
        for (int i = 0; i < fronts.size(); i++) {
            System.out.println("Front: " + (i+1)+ ":");
            for (Individuo ind : fronts.get(i)) {
                System.out.println(ind);
            }
        }
        
    }
    
}
