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
import java.util.ArrayList;
import java.util.List;
import org.openapitools.client.model.Cake;

/**
 * Cakes
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-11-05T19:20:36.346104+02:00[Europe/Kaliningrad]")
public class Cakes {
  public static final String SERIALIZED_NAME_CAKE_LIST = "cake_list";
  @SerializedName(SERIALIZED_NAME_CAKE_LIST)
  private List<Cake> cakeList = new ArrayList<Cake>();


  public Cakes cakeList(List<Cake> cakeList) {
    
    this.cakeList = cakeList;
    return this;
  }

  public Cakes addCakeListItem(Cake cakeListItem) {
    this.cakeList.add(cakeListItem);
    return this;
  }

   /**
   * Name
   * @return cakeList
  **/
  @ApiModelProperty(required = true, value = "Name")

  public List<Cake> getCakeList() {
    return cakeList;
  }


  public void setCakeList(List<Cake> cakeList) {
    this.cakeList = cakeList;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Cakes cakes = (Cakes) o;
    return Objects.equals(this.cakeList, cakes.cakeList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cakeList);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Cakes {\n");
    sb.append("    cakeList: ").append(toIndentedString(cakeList)).append("\n");
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
