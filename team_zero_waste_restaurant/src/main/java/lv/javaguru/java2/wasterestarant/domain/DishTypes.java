package lv.javaguru.java2.wasterestarant.domain;

public enum DishTypes {

    MAIN("main"), PASTA("pasta"), STARTER("starter"),
    SOUP ("soup"), DESERT ("desert");

    private final String type;

    DishTypes(String name) {
        type = name;
    }

    @Override
    public String toString() {
        return type;
    }
}
