package wind.junit.parameterizedtest;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2019-03-13 14:15
 **/
public class PrimeNumberChecker {

    public Boolean validate(final Integer primeNumber) {
        for (int i = 2; i < (primeNumber / 2); i++) {
            if (primeNumber % i == 0) {
                return false;
            }
        }
        return true;
    }

}
