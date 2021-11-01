package demo.autotests.pages.components;

public enum MainNavBarItem {

    ALL_THREADS("Все потоки"),
    DEVELOPMENT("Разработка"),
    ADMINISTRATION("Администрирование"),
    DESIGN("Дизайн"),
    MANAGEMENT("Менеджмент"),
    MARKETING("Маркетинг"),
    POP_SCIENCE("Научпоп");

    private String title;

    MainNavBarItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
