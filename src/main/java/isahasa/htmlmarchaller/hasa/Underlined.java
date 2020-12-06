package isahasa.htmlmarchaller.hasa;

import isahasa.htmlmarchaller.TextSource;

public class Underlined extends TextDecorator {
    public Underlined(TextSource textSource) {
        this.textSource = textSource;
    }

    @Override
    public String getPlainText() {
        return "<u>" + textSource.getPlainText() + "</u>";
    }
}