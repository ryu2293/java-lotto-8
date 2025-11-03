package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    @DisplayName("일치 개수와 보너스 여부로 정확한 등수를 반환한다.")
    @Test
    void valueOf() {
        assertThat(LottoRank.valueOf(6, false)).isEqualTo(LottoRank.FIRST);
        assertThat(LottoRank.valueOf(5, true)).isEqualTo(LottoRank.SECOND);
        assertThat(LottoRank.valueOf(5, false)).isEqualTo(LottoRank.THIRD);
        assertThat(LottoRank.valueOf(4, false)).isEqualTo(LottoRank.FOURTH);
        assertThat(LottoRank.valueOf(3, true)).isEqualTo(LottoRank.FIFTH);
        assertThat(LottoRank.valueOf(3, false)).isEqualTo(LottoRank.FIFTH);
        assertThat(LottoRank.valueOf(2, true)).isEqualTo(LottoRank.MISS);
        assertThat(LottoRank.valueOf(0, false)).isEqualTo(LottoRank.MISS);
    }
}