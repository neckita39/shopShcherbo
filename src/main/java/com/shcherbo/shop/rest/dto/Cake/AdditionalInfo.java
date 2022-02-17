package com.shcherbo.shop.rest.dto.Cake;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Schema(description = "Additional info about cakes")
@Validated
public class AdditionalInfo {
    @Schema(description = "id", required = false)
    @JsonProperty("id")
    private Long id;

    @NotNull
    @Schema(description = "Name", required = true)
    @JsonProperty("name")
    private String name;

    @NotNull
    @Schema(description = "Calories of cake", required = true)
    @JsonProperty("calories")
    private BigDecimal calories;

    @NotNull
    @Schema(description = "Relative url of cake image", required = true)
    @JsonProperty("image")
    private String image;

    @NotNull
    @Schema(description = "Price of cake", required = true)
    @JsonProperty("price")
    private BigDecimal price;

    @NotNull
    @Schema(description = "Cake weight", required = true)
    @JsonProperty("weight")
    private BigDecimal weight;

    @Schema(description = "Components of cake", required = false)
    @JsonProperty("components")
    private String components;

    @Schema(description = "Manufacturer of cake", required = false)
    @JsonProperty("manufacturer")
    private String manufacturer;

    @Schema(description = "Shelf life of cake", required = false)
    @JsonProperty("shelflife")
    private String shelflife;
}
