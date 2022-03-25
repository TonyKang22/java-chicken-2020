package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    @DisplayName("금액 확인")
    void setMoney() {
        // given
        int amount = 16000;

        // when
        Money money = new Money(amount);

        // then
        assertNotNull(money);
        assertEquals(money.getAmount(), 16000);
    }

    @Test
    @DisplayName("0원보다 적은 금액")
    void amountSmallerThenZero() {
        // given
        int amount = -1000;

        // when
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> new Money(amount));

        // then
        assertEquals("돈은 0원 보다 커야합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("같은 금액 비교")
    void compareSameAmount() {
        // given
        Money twoDollars = new Money(2000);

        // when
        Money newMoney = new Money(2000);

        // then
        assertEquals(twoDollars, newMoney);
    }

    @Test
    @DisplayName("다른 금액 비교")
    void compareDifferentAmount() {
        // given
        Money twoDollars = new Money(2000);

        // when
        Money threeDollars = new Money(3000);

        // then
        assertNotEquals(twoDollars, threeDollars);
    }

}