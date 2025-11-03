package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.service.LottoCalculator;
import lotto.service.LottoPublisher;
import lotto.util.InputParser;
import lotto.util.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputParser inputParser;
    private final LottoPublisher lottoPublisher;
    private final LottoCalculator lottoCalculator;

    public LottoGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.inputParser = new InputParser();
        this.lottoPublisher = new LottoPublisher();
        this.lottoCalculator = new LottoCalculator();
    }

    public void run() {
        int purchaseAmount = readPurchaseAmountWithRetry();

        List<Lotto> lottos = lottoPublisher.publishLottos(purchaseAmount);
        outputView.printPublishedLottos(lottos);

        WinningLotto winningLotto = readWinningLottoWithRetry();

        LottoResult result = lottoCalculator.calculateResult(lottos, winningLotto);

        outputView.printWinningStatistics(result);
        double profitRate = result.calculateProfitRate(purchaseAmount);
        outputView.printProfitRate(profitRate);
    }

    private int readPurchaseAmountWithRetry() {
        while (true) {
            try {
                String input = inputView.readPurchaseAmount();
                Validator.validatePurchaseAmount(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private WinningLotto readWinningLottoWithRetry() {
        Lotto winningNumbers = readWinningNumbersWithRetry();
        while (true) {
            try {
                String bonusInput = inputView.readBonusNumber();
                int bonusNumber = inputParser.parseBonusNumber(bonusInput);
                Validator.validateBonusNumber(bonusNumber);
                return new WinningLotto(winningNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private Lotto readWinningNumbersWithRetry() {
        while (true) {
            try {
                String input = inputView.readWinningNumbers();
                List<Integer> numbers = inputParser.parseWinningNumbers(input);
                return new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}