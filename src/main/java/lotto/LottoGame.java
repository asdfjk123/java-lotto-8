package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoGame {

    public void start() {
        int purchaseAmount = getPurchaseAmount();
        Lotto winningLotto = getWinningLotto();
        int bonusNumber = getBonusNumber(winningLotto);
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
