package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @Test
    @DisplayName("수익률을 정확하게 계산한다.")
    void 수익률_계산() {
        Result result = new Result();
        result.add(Rank.FIFTH);
        // 5000 / 8000 * 100 = 62.5
        assertThat(result.calculateRateOfReturn(8000)).isEqualTo(62.5);
    }
}
