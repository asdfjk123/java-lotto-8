package lotto;

import java.util.EnumMap;
import java.util.Map;

public class Result {

    private final Map<Rank, Integer> rankCounts = new EnumMap<>(Rank.class);

    public void add(Rank rank) {
        rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
    }

    public int getCount(Rank rank) {
        return rankCounts.getOrDefault(rank, 0);
    }

    public double calculateRateOfReturn(int purchaseAmount) {
        long totalPrize = 0;
        for (Map.Entry<Rank, Integer> entry : rankCounts.entrySet()) {
            totalPrize += (long) entry.getKey().getPrizeMoney() * entry.getValue();
        }
        return (double) totalPrize / purchaseAmount * 100;
    }
}
