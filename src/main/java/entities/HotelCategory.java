package entities;

public enum HotelCategory {
    ONE_STAR("*"),
    TWO_STARS("**"),
    THREE_STARS("***"),
    FOUR_STARS("****"),
    FIVE_STARS("*****");

    private final String stars;

    HotelCategory(String stars) {
        this.stars = stars;
    }

    public String getStars() {
        return stars;
    }

    @Override
    public String toString() {
        return stars;
    }
}