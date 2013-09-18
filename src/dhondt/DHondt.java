package dhondt;

import java.util.ArrayList;
import java.util.List;


public class DHondt {
    public static List<Integer> compute(List<Integer> votes, int mandateCount) {
        List<Integer> mandates = createMandatesList(votes.size());

        for (int i = 0; i < mandateCount; i++) { // v kazdem kole se prideli jeden mandat
            computeRound(votes, mandates);
        }

        return mandates;
    }

    private static void computeRound(List<Integer> votes, List<Integer> mandates) {
        int indexOfWinner = getRoundWinner(votes, mandates);
        mandates.set(indexOfWinner, mandates.get(indexOfWinner) + 1); // prida mandat strane, ktera vyhrala kolo
    }

    /**
     * Zjisti stranu, ktere bude v aktualnim kole algoritmu pridelen mandat
     */
    private static int getRoundWinner(List<Integer> votes, List<Integer> mandates) {
        int indexOfWinner = 0;
        int winnersRoundVotes = 0;
        for (int i = 0; i < votes.size(); i++) { // de facto hledani maxima pro dane kolo
            int partyRoundVotes = votes.get(i) / (mandates.get(i) + 1); // kolovy pocet hlasu se pocita jako: pocet ziskanych hlasu / (pocet jiz obdrzenych mandatu + 1)
            if (partyRoundVotes > winnersRoundVotes) {
                indexOfWinner = i;
                winnersRoundVotes = partyRoundVotes;
            }
        }
        return indexOfWinner;
    }

    private static List<Integer> createMandatesList(int size) {
        List<Integer> mandates = new ArrayList<Integer>(size);
        for (int i = 0; i < size; i++)
            mandates.add(0);
        return mandates;
    }
}
