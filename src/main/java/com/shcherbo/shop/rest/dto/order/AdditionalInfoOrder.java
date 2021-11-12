package com.shcherbo.shop.rest.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shcherbo.shop.rest.dto.purchase.Purchase;
import com.shcherbo.shop.rest.dto.user.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Schema(description = "Full request for adding order")
@Validated
public class AdditionalInfoOrder {

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