package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    @DisplayName("6개 일치하면 1등이다.")
    void 여섯_개_일치() {
        assertThat(Rank.valueOf(6, false)).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("5개 일치하고 보너스 볼이 일치하면 2등이다.")
    void 다섯_개_일치_보너스_볼_일치() {
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("5개 일치하고 보너스 볼이 일치하지 않으면 3등이다.")
    void 다섯_개_일치_보너스_볼_불일치() {
        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("4개 일치하면 4등이다.")
    void 네_개_일치() {
        assertThat(Rank.valueOf(4, false)).isEqualTo(Rank.FOURTH);
    }

    @Test
    @DisplayName("3개 일치하면 5등이다.")
    void 세_개_일치() {
        assertThat(Rank.valueOf(3, false)).isEqualTo(Rank.FIFTH);
    }

    @Test
    @DisplayName("2개 이하로 일치하면 꽝이다.")
    void 두_개_이하_일치() {
        assertThat(Rank.valueOf(2, false)).isEqualTo(Rank.MISS);
        assertThat(Rank.valueOf(1, false)).isEqualTo(Rank.MISS);
        assertThat(Rank.valueOf(0, false)).isEqualTo(Rank.MISS);
    }
}
