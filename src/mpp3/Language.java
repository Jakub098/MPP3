package mpp3;

import java.util.List;

public class Language {


    private LanguageName langName;
    private String langText;

    public Language(String langText) {
        this.langText = langText;
    }
    public Language(LanguageName langName, String langText) {
        this.langName = langName;
        this.langText = langText;
    }

    public LanguageName getLangName() {
        return langName;
    }

    public void setLangName(LanguageName langName) {
        this.langName = langName;
    }

    public String getLangText() {
        return langText;
    }

    public void setLangText(String langText) {
        this.langText = langText;
    }

    @Override
    public String toString() {
        return "Language{" +
                "langName=" + langName +
                ", langText='" + langText + '\'' +
                '}';
    }
}