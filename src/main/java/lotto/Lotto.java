package lotto;

import java.util.List;

public class Lotto {

  // 멤버 변수는 numbers 만 있어야 함
  private final List<Integer> numbers;

  public Lotto(List<Integer> numbers) {
    validate(numbers);
    this.numbers = numbers;
  }

  public List<Integer> getNumbers() {
    return numbers;
  }

  // 당첨 번호 유효성 검사
  private void validate(List<Integer> numbers) {
    validateNumberSize(numbers);
    validateNumberRange(numbers);
    validateNumberDuplication(numbers);
  }

  // 숫자 개수 검사
  private void validateNumberSize(List<Integer> numbers) {
    if (numbers.size() != 6) {
      throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
    }
  }

  // 숫자 범위 검사
  private void validateNumberRange(List<Integer> numbers) {
    for (int number : numbers) {
      if (number < 1 || number > 45) {
        throw new IllegalArgumentException("[ERROR] 로또 번호의 숫자 범위는 1~45 여야 합니다.");
      }
    }
  }

  // 숫자 중복 여부 검사
  private void validateNumberDuplication(List<Integer> numbers) {
    if (numbers.stream().distinct().count() != numbers.size()) {
      throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 존재합니다.");
    }
  }
}
