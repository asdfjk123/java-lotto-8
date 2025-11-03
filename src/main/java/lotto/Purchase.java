package lotto;


public class Purchase {

  private final int purchaseAmount;

  public Purchase(int purchaseAmount) {
    validate(purchaseAmount);
    this.purchaseAmount = purchaseAmount;
  }

  public int getPurchaseAmount() {
    return purchaseAmount;
  }

  public void validate(int purchaseAmount) {
    validatePurchaseAmountRange(purchaseAmount);
    validateAmountUnit(purchaseAmount);
  }

  // 구매 금액 범위 검사
  public void validatePurchaseAmountRange(int purchaseAmount) {
    if (purchaseAmount < 0) {
      throw new IllegalArgumentException("[ERROR] 양의 정수의 구매 금액을 입력해야 합니다.");
    }
  }

  // 구매 금액 단위 검사
  public void validateAmountUnit(int purchaseAmount) {
    if (purchaseAmount % 1000 != 0) {
      throw new IllegalArgumentException("[ERROR] 로또 구매 금액 단위가 적절하지 않습니다.");
    }
  }
}


