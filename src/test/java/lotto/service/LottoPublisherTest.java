package lotto.service;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class LottoPublisherTest {

    @DisplayName("구입 금액만큼 로또를 발행한다.")
    @Test
    void publishLottos() {
        LottoPublisher lottoPublisher = new LottoPublisher();
        int purchaseAmount = 8000;

        List<Lotto> lottos = lottoPublisher.publishLottos(purchaseAmount);

        assertThat(lottos).hasSize(8);
    }
}