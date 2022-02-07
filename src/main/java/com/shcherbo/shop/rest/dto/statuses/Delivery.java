package com.shcherbo.shop.rest.dto.statuses;

public enum Delivery {
    NEED("NEED", 1),
    NO("NO",2);
    private final String key;
    private final int value;
    Delivery(String key, int value) {
        this.key=key;
        this.value=value;
    }
    public String getValue(int key) {
        for (Delivery delivery: values()){
            if ((delivery.value)==key)
                return delivery.key;
        }
        return null;
    }
}
