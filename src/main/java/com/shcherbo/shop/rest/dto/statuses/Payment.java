package com.shcherbo.shop.rest.dto.statuses;

public  enum Payment {
    ONLINE("ONLINE", 0),
    MONEY("MONEY", 1);
    private final String key;
    private final int value;
    Payment(String key, int value) {
        this.key=key;
        this.value=value;
    }
    public String getValue(int key) {
        for (Payment payment: values()){
            if ((payment.value)==key)
                return payment.key;
        }
        return null;
    }

}
