import java.util.ArrayList;
import java.util.List;

public final class FNDS {
    public static List<List<Individuo>> execute(List<Individuo> pop) {
        List<List<Individuo>> fronts = new ArrayList<>();
        List<Individuo> frontsA = new ArrayList<>();
        /*
         * ========================================================================
         * PARTE 1
         * ========================================================================
         */

        for (Individuo p : pop) {
            p.n = 0;
            p.dominados = new ArrayList<>();
            for (Individuo q : pop) {
                if (p.objetivos[0] <= q.objetivos[0] && p.objetivos[1] <= q.objetivos[1]) {
                    p.dominados.add(q);
                } else if (p.objetivos[0] >= q.objetivos[0] && p.objetivos[1] >= q.objetivos[1]) {
                    p.n++;
                }
            }
            if (p.n == 0) {
                p.r = 1;
                frontsA.add(p);
            }
        }
        /*
         * ========================================================================
         * PARTE 2
         * ========================================================================
         */
        fronts.add(frontsA);
        int i = 0;
        while (!fronts.get(i).isEmpty()) {
            List<Individuo> Q = new ArrayList<>();
            for (Individuo p : fronts.get(i)) {
                for (Individuo q : p.dominados) {
                    q.n--;
                    if (q.n == 0) {
                        q.r = i + 1;
                        Q.add(q);
                    }
                }
            }
            i++;
            fronts.add(Q);
        }

        return fronts;
    }
}
