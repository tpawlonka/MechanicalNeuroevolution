package org.tpawlonka.mechevo.gui.fields.filters;

import com.badlogic.gdx.scenes.scene2d.ui.TextField;

import java.util.function.Function;

public class NumericRangeFilter<T extends Number> implements TextField.TextFieldFilter{
    private T lowerBound;
    private T upperBound;
    private Mode mode = Mode.Inclusive;
    private Class<T> type;
    private Function<String, Number> cast;
    private Function<Number[], Integer> comparison;

    public enum Mode {
        Inclusive, Exclusive
    }



    public NumericRangeFilter(T lowerBound, T upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.getCastFunction(lowerBound.getClass().getName());
    }

    public NumericRangeFilter(T lowerBound, T upperBound, Mode mode) {
        this(lowerBound, upperBound);
        this.mode = mode;
    }

    @Override
    public boolean acceptChar(TextField textField, char c) {
        String text = textField.getText()+c;
        if (mode == Mode.Inclusive) {
            return this.inclusiveAcceptChar(text);
        } else {
            return this.exclusiveAcceptChar(text);
        }
    }

    private void getCastFunction(String text) {
        switch (text) {
            case "java.lang.Double", "java.lang.double" -> {
                this.cast = Double::parseDouble;
                this.comparison = doubles -> Double.compare((doubles[0]).doubleValue(), (doubles[1]).doubleValue());
            }
            case "java.lang.Integer", "java.lang.integer" -> {
                this.cast = Integer::parseInt;
                this.comparison = integers -> Integer.compare((integers[0]).intValue(), (integers[1]).intValue());
            }
            case "java.lang.Long", "java.lang.long" -> {
                this.cast = Long::parseLong;
                this.comparison = longs -> Long.compare((longs[0]).longValue(), (longs[1]).longValue());
            }
            default -> throw new IllegalStateException("Unexpected value: " + text);
        }
    }

    private boolean inclusiveAcceptChar(String text) {
        Number parsed = this.cast.apply(text);
        return this.comparison.apply(new Number[]{parsed, this.lowerBound}) >= 0
            && this.comparison.apply(new Number[]{parsed, this.upperBound}) <= 0;
    }

    private boolean exclusiveAcceptChar(String text) {
        Number parsed = this.cast.apply(text);
        return this.comparison.apply(new Number[]{parsed, this.lowerBound}) > 0
            && this.comparison.apply(new Number[]{parsed, this.upperBound}) < 0;
    }
}
