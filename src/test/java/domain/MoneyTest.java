package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @DisplayName("금액 확인")
    @ParameterizedTest(name = "{index} {displayName}, input = {0}")
    @ValueSource(ints = {10_000, 20_000, 500_000})
    void createMoney(int input) {
        // given
        int amount = input;

        // when
        Money money = new Money(amount);

        // then
        assertNotNull(money);
        assertEquals(money.getAmount(), input);
    }

    @DisplayName("0원보다 적은 금액")
    @ParameterizedTest(name = "{index} = {displayName}, input = {0}")
    @ValueSource(ints = {-1000, -20_0000, -500_000})
    void amountSmallerThenZero(int input) {
        // given
        int amount = input;

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

    @Test
    @DisplayName("차액 확인")
    void subtractMoney() {
        // given
        Money tenDollars = new Money(10_000);
        Money twentyDollars = new Money(20_000);

        // when
        Money subtractedMoney = new Money(twentyDollars.getAmount() - tenDollars.getAmount());

        // then
        assertEquals(twentyDollars.subtractMoney(tenDollars), subtractedMoney);
    }

}