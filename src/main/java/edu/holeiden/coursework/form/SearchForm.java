package edu.holeiden.coursework.form;

public class SearchForm {

    private String string;

    public SearchForm() {
    }

    public SearchForm(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return "SearchForm{" +
                "string='" + string + '\'' +
                '}';
    }

}
