package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoGame {

    public void start() {
        int purchaseAmount = getPurchaseAmount();

        LottoMachine lottoMachine = new LottoMachine();
        java.util.List<Lotto> purchasedLottos = lottoMachine.purchaseLottos(purchaseAmount);

        System.out.println("\n" + purchasedLottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : purchasedLottos) {
            System.out.println(lotto.getNumbers());
        }

        Lotto winningLotto = getWinningLotto();
        int bonusNumber = getBonusNumber(winningLotto);

        Result result = calculateResults(purchasedLottos, winningLotto, bonusNumber);
        printResults(result, purchaseAmount);
    }

    private Result calculateResults(java.util.List<Lotto> purchasedLottos, Lotto winningLotto, int bonusNumber) {
        Result result = new Result();
        for (Lotto lotto : purchasedLottos) {
            int matchCount = countMatches(lotto, winningLotto);
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);
            Rank rank = Rank.valueOf(matchCount, bonusMatch);
            result.add(rank);
        }
        return result;
    }

    private int countMatches(Lotto lotto, Lotto winningLotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningLotto.getNumbers()::contains)
                .count();
    }

    private void printResults(Result result, int purchaseAmount) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (%,d원) - %d개\n", Rank.FIFTH.getPrizeMoney(), result.getCount(Rank.FIFTH));
        System.out.printf("4개 일치 (%,d원) - %d개\n", Rank.FOURTH.getPrizeMoney(), result.getCount(Rank.FOURTH));
        System.out.printf("5개 일치 (%,d원) - %d개\n", Rank.THIRD.getPrizeMoney(), result.getCount(Rank.THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치 (%,d원) - %d개\n", Rank.SECOND.getPrizeMoney(), result.getCount(Rank.SECOND));
        System.out.printf("6개 일치 (%,d원) - %d개\n", Rank.FIRST.getPrizeMoney(), result.getCount(Rank.FIRST));
        System.out.printf("총 수익률은 %.1f%%입니다.\n", result.calculateRateOfReturn(purchaseAmount));
    }

    private int getBonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                System.out.println("\n보너스 번호를 입력해 주세요.");
                String input = Console.readLine();
                int bonus = Integer.parseInt(input);
                validateBonusNumber(bonus, winningLotto);
                return bonus;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateBonusNumber(int bonus, Lotto winningLotto) {
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winningLotto.getNumbers().contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private int getPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();
                int amount = Integer.parseInt(input);
                new Purchase(amount);
                return amount;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lotto getWinningLotto() {
        while (true) {
            try {
                System.out.println("\n당첨 번호를 입력해 주세요.");
                String input = Console.readLine();
                String[] numberStrings = input.split(",");
                java.util.List<Integer> numbers = new java.util.ArrayList<>();
                for (String numberString : numberStrings) {
                    numbers.add(Integer.parseInt(numberString.trim()));
                }
                return new Lotto(numbers);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자가 아닌 값이 포함되어 있습니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
