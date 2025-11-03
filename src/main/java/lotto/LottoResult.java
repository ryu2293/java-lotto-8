package lotto;

import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> rankCounts;

    public LottoResult(Map<LottoRank, Integer> rankCounts) {
        this.rankCounts = rankCounts;
    }

    public int getCount(LottoRank rank) {
        return rankCounts.getOrDefault(rank, 0);
    }

    public double calculateProfitRate(int purchaseAmount) {
        long totalPrize = calculateTotalPrize();
        if (purchaseAmount == 0) {
            return 0.0;
        }
        return (double) totalPrize / purchaseAmount * 100.0;
    }

    private long calculateTotalPrize() {
        return rankCounts.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}