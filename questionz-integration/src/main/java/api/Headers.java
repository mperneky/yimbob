package api;

public enum Headers {
    ACCEPT("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8"),
    ACCEPT_ENCODING("gzip, deflate, br"),
    ACCEPT_LANGUAGE("en-US,en;q=0.8"),
    CACHE_CONTROL("max-age=0"),
    CONNECTION("keep-alive"),
    USER_AGENT("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko)"
        + " Chrome/60.0.3112.101 Safari/537.36");

    private final String value;

    Headers(String value) {
        this.value = value;
    }

    public String toString() {
        return this.value;
    }
}
