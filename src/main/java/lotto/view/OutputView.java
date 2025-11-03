package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import java.util.List;

public class OutputView {

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printPublishedLottos(List<Lotto> lottos) {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printWinningStatistics(LottoResult result) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println(LottoRank.FIFTH.getDescription() + " - " + result.getCount(LottoRank.FIFTH) + "개");
        System.out.println(LottoRank.FOURTH.getDescription() + " - " + result.getCount(LottoRank.FOURTH) + "개");
        System.out.println(LottoRank.THIRD.getDescription() + " - " + result.getCount(LottoRank.THIRD) + "개");
        System.out.println(LottoRank.SECOND.getDescription() + " - " + result.getCount(LottoRank.SECOND) + "개");
        System.out.println(LottoRank.FIRST.getDescription() + " - " + result.getCount(LottoRank.FIRST) + "개");
    }

    public void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }
}