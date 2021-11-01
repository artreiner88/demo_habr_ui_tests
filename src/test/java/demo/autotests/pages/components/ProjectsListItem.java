package demo.autotests.pages.components;

public enum ProjectsListItem {

    HABR("Хабр"),
    QnA("Q&A"),
    CAREER("Карьера"),
    FREELANCE("Фриланс");

    private String title;
    ProjectsListItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
