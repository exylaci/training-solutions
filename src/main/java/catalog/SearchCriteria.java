package catalog;

import week06.d3.Series;

public class SearchCriteria {
    private final String contributor;
    private final String title;

    public static SearchCriteria createByBoth(String title, String contributor) {
        if (title == null | contributor == null) throw new IllegalArgumentException("Criteria is a must!");
        return new SearchCriteria(contributor, title);
    }

    public static SearchCriteria createByTitle(String title) {
        return createByBoth(title, "");
    }

    public static SearchCriteria createByContributor(String contributor) {
        return createByBoth("", contributor);
    }

    private SearchCriteria(String contributor, String title) {
        this.contributor = contributor;
        this.title = title;
    }

    public String getContributor() {
        return contributor;
    }

    public String getTitle() {
        return title;
    }

    public boolean hasContributor() {
        return contributor != "";
    }

    public boolean hasTitle() {
        return title != "";
    }

}