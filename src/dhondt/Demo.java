package dhondt;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        wikipediaRealSample();
        System.out.println((System.currentTimeMillis() - start) + " ms");
    }

    private static void wikipediaRealSample() {
        List<Integer> votes = new ArrayList<Integer>();
        votes.add(83647); // ODS
        votes.add(63181); // CSSD
        votes.add(24823); // KSCM
        votes.add(20646); // SZ
        votes.add(9131);  // KDU-CSL

        List<Integer> mandates = DHondt.compute(votes, 8);
        //System.out.println(mandates);
    }
}
