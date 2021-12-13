package com.shcherbo.shop.rest.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shcherbo.shop.rest.dto.purchase.Purchase;
import com.shcherbo.shop.rest.dto.statuses.Delivery;
import com.shcherbo.shop.rest.dto.statuses.OrderStatus;
import com.shcherbo.shop.rest.dto.statuses.Payment;
import com.shcherbo.shop.rest.dto.user.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Schema(description = "Full request for adding order")
@Validated
public class AdditionalInfoOrder {
//
//    @Null
//    @Schema(description = "id", required = false)
//    @JsonProperty("id")
//    private Long id;
//
//    @NotNull
//    @Schema(description = "userID", required = true)
//    @JsonProperty("user_id")
//    private Long userID;
//
//    @NotNull
//    @Schema(description = "delivery need", required = true)
//    @JsonProperty("delivery")
//    private Delivery delivery;
//
//    @NotNull
//    @Schema(description = "order status", required = true)
//    @JsonProperty("orderStatus")
//    private OrderStatus orderStatus;
//
//    @NotNull
//    @Schema(description = "payment status", required = true)
//    @JsonProperty("payment")
//    private Payment payment;
//
//    @NotNull
//    @Schema(description = "delivery address", required = true)
//    @JsonProperty("deliveryAddress")
//    private String deliveryAddress;
//
//    @NotNull
//    @Schema(description = "delivery time", required = true)
//    @JsonProperty("deliveryTime")
//    private LocalDateTime deliveryTime;

    @NotNull
    @Schema(description = "user", required = true)
    @JsonProperty("user")
    private User user;

    @NotNull
    @Schema(description = "order", required = true)
    @JsonProperty("order")
    private Order order;

    @NotNull
    @Schema(description = "purchases", required = true)
    @JsonProperty("purchases")
    private List<Purchase> purchases;
}