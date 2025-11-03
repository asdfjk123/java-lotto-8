package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseTest {

    @DisplayName("구입 금액이 0보다 작으면 예외가 발생한다.")
    @Test
    void 구입_금액이_0보다_작으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Purchase(-1000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 구입_금액이_1000원_단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Purchase(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
