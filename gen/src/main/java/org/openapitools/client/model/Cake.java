/*
 * OpenAPI definition
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: v0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * Short info about cakes
 */
@ApiModel(description = "Short info about cakes")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-11-05T19:20:36.346104+02:00[Europe/Kaliningrad]")
public class Cake {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private Long id;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_CALORIES = "calories";
  @SerializedName(SERIALIZED_NAME_CALORIES)
  private BigDecimal calories;

  public static final String SERIALIZED_NAME_IMAGE = "image";
  @SerializedName(SERIALIZED_NAME_IMAGE)
  private String image;

  public static final String SERIALIZED_NAME_PRICE = "price";
  @SerializedName(SERIALIZED_NAME_PRICE)
  private BigDecimal price;

  public static final String SERIALIZED_NAME_WEIGHT = "weight";
  @SerializedName(SERIALIZED_NAME_WEIGHT)
  private BigDecimal weight;


  public Cake id(Long id) {
    
    this.id = id;
    return this;
  }

   /**
   * id
   * @return id
  **/
  @ApiModelProperty(required = true, value = "id")

  public Long getId() {
    return id;
  }


  public void setId(Long id) {
    this.id = id;
  }


  public Cake name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * Name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "Name")

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public Cake calories(BigDecimal calories) {
    
    this.calories = calories;
    return this;
  }

   /**
   * Calories of cake
   * @return calories
  **/
  @ApiModelProperty(required = true, value = "Calories of cake")

  public BigDecimal getCalories() {
    return calories;
  }


  public void setCalories(BigDecimal calories) {
    this.calories = calories;
  }


  public Cake image(String image) {
    
    this.image = image;
    return this;
  }

   /**
   * Relative url of cake image
   * @return image
  **/
  @ApiModelProperty(required = true, value = "Relative url of cake image")

  public String getImage() {
    return image;
  }


  public void setImage(String image) {
    this.image = image;
  }


  public Cake price(BigDecimal price) {
    
    this.price = price;
    return this;
  }

   /**
   * Price of cake
   * @return price
  **/
  @ApiModelProperty(required = true, value = "Price of cake")

  public BigDecimal getPrice() {
    return price;
  }


  public void setPrice(BigDecimal price) {
    this.price = price;
  }


  public Cake weight(BigDecimal weight) {
    
    this.weight = weight;
    return this;
  }

   /**
   * Cake weight
   * @return weight
  **/
  @ApiModelProperty(required = true, value = "Cake weight")

  public BigDecimal getWeight() {
    return weight;
  }


  public void setWeight(BigDecimal weight) {
    this.weight = weight;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Cake cake = (Cake) o;
    return Objects.equals(this.id, cake.id) &&
        Objects.equals(this.name, cake.name) &&
        Objects.equals(this.calories, cake.calories) &&
        Objects.equals(this.image, cake.image) &&
        Objects.equals(this.price, cake.price) &&
        Objects.equals(this.weight, cake.weight);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, calories, image, price, weight);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Cake {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    calories: ").append(toIndentedString(calories)).append("\n");
    sb.append("    image: ").append(toIndentedString(image)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    weight: ").append(toIndentedString(weight)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

