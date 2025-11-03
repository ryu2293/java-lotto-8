package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputParserTest {

    private final InputParser inputParser = new InputParser();

    @DisplayName("당첨 번호 파싱 시 숫자가 아니면 예외가 발생한다.")
    @Test
    void parseWinningNumbers_NotNumeric() {
        assertThatThrownBy(() -> inputParser.parseWinningNumbers("1,2,a,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 숫자여야 합니다.");
    }

    @DisplayName("보너스 번호 파싱 시 숫자가 아니면 예외가 발생한다.")
    @Test
    void parseBonusNumber_NotNumeric() {
        assertThatThrownBy(() -> inputParser.parseBonusNumber("7a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 숫자여야 합니다.");
    }

    @DisplayName("당첨 번호를 쉼표 기준으로 올바르게 파싱한다.")
    @Test
    void parseWinningNumbers_Success() {
        List<Integer> numbers = inputParser.parseWinningNumbers("1, 2, 3, 4, 5, 6");
        assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6);
    }
}