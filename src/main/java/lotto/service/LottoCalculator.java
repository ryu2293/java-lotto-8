package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoCalculator {

    public LottoResult calculateResult(List<Lotto> purchasedLottos, WinningLotto winningLotto) {
        Map<LottoRank, Integer> rankCounts = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.MISS) {
                rankCounts.put(rank, 0);
            }
        }

        for (Lotto lotto : purchasedLottos) {
            LottoRank rank = determineRank(lotto, winningLotto);
            if (rank != LottoRank.MISS) {
                rankCounts.put(rank, rankCounts.get(rank) + 1);
            }
        }

        return new LottoResult(rankCounts);
    }

    private LottoRank determineRank(Lotto lotto, WinningLotto winningLotto) {
        int matchCount = countMatches(lotto, winningLotto.getLotto());
        boolean hasBonus = lotto.contains(winningLotto.getBonusNumber());
        return LottoRank.valueOf(matchCount, hasBonus);
    }

    private int countMatches(Lotto lotto, Lotto winningNumbers) {
        return (int) lotto.getNumbers().stream()
                .filter(winningNumbers.getNumbers()::contains)
                .count();
    }
}