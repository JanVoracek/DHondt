package dhondt;


import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class DHondtTest {
    @Test
    public void withEmptyInputReturnsEmptyOutput() {
        List<Integer> votes = new ArrayList<Integer>();
        List<Integer> mandates = DHondt.compute(votes, 0);
        assertTrue(mandates.isEmpty());
    }

    @Test
    public void withOnePartyAssignAllMandatesToIt() {
        List<Integer> votes = new ArrayList<Integer>();
        votes.add(1);
        int mandatesCount = 100;

        List<Integer> mandates = DHondt.compute(votes, mandatesCount);
        assertTrue(mandates.size() == 1);
        assertTrue(mandates.get(0) == mandatesCount);
    }

    @Test
    public void wikipediaSample1() {
        List<Integer> votes = new ArrayList<Integer>();
        votes.add(100);
        votes.add(60);
        votes.add(45);

        List<Integer> mandates = DHondt.compute(votes, 3);

        assertTrue(mandates.get(0) == 2);
        assertTrue(mandates.get(1) == 1);
        assertTrue(mandates.get(2) == 0);

    }

    @Test
    public void wikipediaRealSample() {
        List<Integer> votes = new ArrayList<Integer>();
        votes.add(83647); // ODS
        votes.add(63181); // CSSD
        votes.add(24823); // KSCM
        votes.add(20646); // SZ
        votes.add(9131);  // KDU-CSL

        List<Integer> mandates = DHondt.compute(votes, 8);

        assertTrue(mandates.get(0) == 4);
        assertTrue(mandates.get(1) == 3);
        assertTrue(mandates.get(2) == 1);
        assertTrue(mandates.get(3) == 0);
        assertTrue(mandates.get(4) == 0);
    }
}