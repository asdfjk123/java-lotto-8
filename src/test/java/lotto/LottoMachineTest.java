package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @DisplayName("구입 금액만큼 로또를 발행한다.")
    @Test
    void 구입_금액만큼_로또를_발행한다() {
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = lottoMachine.purchaseLottos(8000);
        assertThat(lottos).hasSize(8);
    }
}
