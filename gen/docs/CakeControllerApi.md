# CakeControllerApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**cakes**](CakeControllerApi.md#cakes) | **GET** /cakes | 
[**createCake**](CakeControllerApi.md#createCake) | **POST** /cakes | 
[**getCakeById**](CakeControllerApi.md#getCakeById) | **GET** /cake/{id} | 


<a name="cakes"></a>
# **cakes**
> Cakes cakes()



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.CakeControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    CakeControllerApi apiInstance = new CakeControllerApi(defaultClient);
    try {
      Cakes result = apiInstance.cakes();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CakeControllerApi#cakes");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Cakes**](Cakes.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**404** | Not Found |  -  |
**200** | OK |  -  |

<a name="createCake"></a>
# **createCake**
> Cake createCake(cake)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.CakeControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    CakeControllerApi apiInstance = new CakeControllerApi(defaultClient);
    Cake cake = new Cake(); // Cake | 
    try {
      Cake result = apiInstance.createCake(cake);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CakeControllerApi#createCake");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **cake** | [**Cake**](Cake.md)|  |

### Return type

[**Cake**](Cake.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**404** | Not Found |  -  |
**200** | OK |  -  |

<a name="getCakeById"></a>
# **getCakeById**
> Cake getCakeById(id)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.CakeControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    CakeControllerApi apiInstance = new CakeControllerApi(defaultClient);
    Long id = 56L; // Long | 
    try {
      Cake result = apiInstance.getCakeById(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CakeControllerApi#getCakeById");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**|  |

### Return type

[**Cake**](Cake.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**404** | Not Found |  -  |
**200** | OK |  -  |

