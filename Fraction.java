import java.util.Objects;

public class Fraction implements FractionOperations {
    private int numerator;
    private int denominator;
    private Double cachedRealValue;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю.");
        }
        normalizeSign(numerator, denominator);
        this.cachedRealValue = null;
    }

    private void normalizeSign(int num, int den) {
        if (den < 0) {
            this.numerator = -num;
            this.denominator = -den;
        } else {
            this.numerator = num;
            this.denominator = den;
        }
        invalidateCache();
    }

    private void invalidateCache() {
        this.cachedRealValue = null;
    }

    @Override
    public double getRealValue() {
        if (cachedRealValue == null) {
            cachedRealValue = (double) numerator / denominator;
        }
        return cachedRealValue;
    }

    @Override
    public void setNumerator(int numerator) {
        this.numerator = numerator;
        normalizeSign(this.numerator, this.denominator);
    }

    @Override
    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю.");
        }
        this.denominator = denominator;
        normalizeSign(this.numerator, this.denominator);
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Fraction fraction = (Fraction) o;
        return numerator == fraction.numerator &&
                denominator == fraction.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }
}