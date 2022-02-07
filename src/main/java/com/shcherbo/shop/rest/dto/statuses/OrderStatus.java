package com.shcherbo.shop.rest.dto.statuses;

public enum OrderStatus {
    NEW("NEW", 0),
    CANCELED("CANCELED", 1),
    PERFORMED("PERFORMED", 2),
    FINISHED("FINISHED", 3);
    private final String key;
    private final int value;
    OrderStatus(String key, int value) {
        this.key=key;
        this.value=value;
    }
    public String getValue(int key) {
        for (OrderStatus orderStatus: values()){
            if ((orderStatus.value)==key)
                return orderStatus.key;
        }
        return null;
    }
}
