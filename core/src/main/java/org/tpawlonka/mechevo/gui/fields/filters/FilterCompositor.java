package org.tpawlonka.mechevo.gui.fields.filters;

import com.badlogic.gdx.scenes.scene2d.ui.TextField;

import java.util.Arrays;
import java.util.HashSet;

public class FilterCompositor implements TextField.TextFieldFilter {
    protected HashSet<TextField.TextFieldFilter> delegates;

    public FilterCompositor(TextField.TextFieldFilter... delegates) {
        this.delegates = new HashSet<>(delegates.length);
        this.delegates.addAll(Arrays.asList(delegates));
    }

    public void addFilter(TextField.TextFieldFilter delegate) {
        this.delegates.add(delegate);
    }

    public void removeFilter(TextField.TextFieldFilter delegate) {
        this.delegates.remove(delegate);
    }

    @Override
    public boolean acceptChar(TextField textField, char c) {
        return this.delegates.stream().allMatch(delegate -> delegate.acceptChar(textField, c));
    }
}
