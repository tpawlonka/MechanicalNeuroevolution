package org.tpawlonka.mechevo.gui.fields.filters;

import com.badlogic.gdx.scenes.scene2d.ui.TextField;

import java.util.HashSet;

public class DecimalsOnlyFilter implements TextField.TextFieldFilter{
    HashSet<Character> legalChars;

    public DecimalsOnlyFilter() {
        super();
        String chars = ".0123456789";
        this.legalChars = new HashSet<>();
        chars.chars().forEach(c -> legalChars.add((char) c));
    }

    @Override
    public boolean acceptChar(TextField textField, char c) {
        String text = textField.getText();
        if (text.isEmpty()) {
            return c != '.' && this.legalChars.contains(c);
        }
        if (text.contains(".") && c == '.') {
            return false;
        }
        return this.legalChars.contains(c) && text.charAt(0) != '.';
    }
}
