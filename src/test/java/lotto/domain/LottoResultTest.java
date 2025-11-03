package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.EnumMap;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @DisplayName("총 수익률을 올바르게 계산한다 (소수점 둘째 자리 반올림)")
    @Test
    void calculateProfitRate() {
        Map<LottoRank, Integer> ranks = new EnumMap<>(LottoRank.class);
        ranks.put(LottoRank.FIFTH, 1); 
        LottoResult result = new LottoResult(ranks);

        int purchaseAmount = 8000;

        double profitRate = result.calculateProfitRate(purchaseAmount);

        assertThat(profitRate).isEqualTo(62.5);
    }

    @DisplayName("수익률이 1000%가 넘는 경우도 올바르게 계산한다")
    @Test
    void calculateProfitRate_HighProfit() {
        Map<LottoRank, Integer> ranks = new EnumMap<>(LottoRank.class);
        ranks.put(LottoRank.FOURTH, 1);
        LottoResult result = new LottoResult(ranks);

        int purchaseAmount = 1000;

        double profitRate = result.calculateProfitRate(purchaseAmount);

        assertThat(profitRate).isEqualTo(5000.0);
    }
}