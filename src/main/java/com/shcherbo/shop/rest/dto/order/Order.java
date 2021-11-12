package com.shcherbo.shop.rest.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shcherbo.shop.rest.dto.statuses.Delivery;
import com.shcherbo.shop.rest.dto.statuses.OrderStatus;
import com.shcherbo.shop.rest.dto.statuses.Payment;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.LocalDateTime;

@Data
@Schema(description = "Info about purchase")
@Validated
public class Order {
    @Null
    @Schema(description = "id", required = false)
    @JsonProperty("id")
    private Long id;


    @NotNull
    @Schema(description = "userID", required = true)
    @JsonProperty("userID")
    private Long userID;

    @NotNull
    @Schema(description = "delivery need", required = true)
    @JsonProperty("delivery")
    private Delivery delivery;

    @NotNull
    @Schema(description = "order status", required = true)
    @JsonProperty("orderStatus")
    private OrderStatus orderStatus;

    @NotNull
    @Schema(description = "payment status", required = true)
    @JsonProperty("payment")
    private Payment payment;

    @NotNull
    @Schema(description = "delivery address", required = true)
    @JsonProperty("deliveryAddress")
    private String deliveryAddress;

    @NotNull
    @Schema(description = "delivery time", required = true)
    @JsonProperty("deliveryTime")
    private LocalDateTime deliveryTime;

}