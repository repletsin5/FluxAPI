package dev.crmodders.flux.api.v6.gui;

import dev.crmodders.flux.api.v6.gui.base.BaseButton;
import dev.crmodders.flux.localization.TranslationKey;

import java.util.List;

public class ComboBoxElement<T> extends BaseButton {

    private final List<T> elements;
    private int selected;

    public ComboBoxElement(List<T> elements, T defaultValue) {
        this.elements = elements;
        this.selected = elements.indexOf(defaultValue);
        updateText();
    }

    @Override
    public void onMouseReleased() {
        super.onMouseReleased();
        selected++;
        selected %= elements.size();
        updateText();
    }

    public String toString(T value) {
        return value.toString();
    }

    @Override
    public String updateTranslation(TranslationKey key) {
        T selected = getSelected();
        if(key == null) {
            return toString(selected);
        }
        return key.getTranslated().format(toString(selected));
    }

    public void setSelected(T t) {
        selected = elements.indexOf(t);
        updateText();
    }
    public T getSelected() {
        return elements.get(selected);
    }

}