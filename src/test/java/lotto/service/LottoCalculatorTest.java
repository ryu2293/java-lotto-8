package lotto.service;

import lotto.domain.LottoResult;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoCalculatorTest {

    @DisplayName("구매한 로또와 당첨 번호를 비교하여 당첨 통계를 올바르게 생성한다.")
    @Test
    void calculateResult() {
        LottoCalculator lottoCalculator = new LottoCalculator();
        Lotto winning = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(winning, 7);

        List<Lotto> purchasedLottos = List.of(
                new Lotto(List.of(1, 2, 3, 10, 11, 12)),
                new Lotto(List.of(1, 2, 3, 4, 10, 11)),
                new Lotto(List.of(1, 2, 3, 4, 5, 10)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(10, 11, 12, 13, 14, 15))
        );

        LottoResult result = lottoCalculator.calculateResult(purchasedLottos, winningLotto);

        assertThat(result.getCount(LottoRank.FIFTH)).isEqualTo(1);
        assertThat(result.getCount(LottoRank.FOURTH)).isEqualTo(1);
        assertThat(result.getCount(LottoRank.THIRD)).isEqualTo(1);
        assertThat(result.getCount(LottoRank.SECOND)).isEqualTo(1);
        assertThat(result.getCount(LottoRank.FIRST)).isEqualTo(1);
    }
}