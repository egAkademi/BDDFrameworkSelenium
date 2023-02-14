package awesomecucumber.constants;

public enum Endpoint {
    STORE("/store"),
    ACCOUNT("/account"),
    CHECKOUT("/checkout"),
    ADDTOCART("/?wc-ajax=add_to_cart");

    public final String url;

    Endpoint(String url) {
        this.url=url;
    }
}
