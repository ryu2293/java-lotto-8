package lotto.util;

public class Validator {

    public static void validatePurchaseAmount(String input) {
        int amount = validateNumeric(input);
        validateMinAmount(amount);
        validateDivisibleByLottoPrice(amount);
    }

    private static int validateNumeric(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Constants.ERROR_PREFIX + "구입 금액은 숫자여야 합니다.");
        }
    }

    private static void validateMinAmount(int amount) {
        if (amount < Constants.MIN_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(Constants.ERROR_PREFIX + "구입 금액은 "
                    + String.format("%,d", Constants.MIN_PURCHASE_AMOUNT) + "원 이상이어야 합니다.");
        }
    }

    private static void validateDivisibleByLottoPrice(int amount) {
        if (amount % Constants.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(Constants.ERROR_PREFIX + "구입 금액은 "
                    + String.format("%,d", Constants.LOTTO_PRICE) + "원 단위여야 합니다.");
        }
    }

    public static void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(Constants.ERROR_PREFIX + "보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}