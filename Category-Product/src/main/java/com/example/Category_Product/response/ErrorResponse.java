package com.example.Category_Product.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(
        ignoreUnknown = true
)
@Data
@AllArgsConstructor
public class ErrorResponse {
    @JsonProperty("error-code")
    private Integer errorCode;
    @JsonProperty("error-message")
    private String errorMsg;
    @JsonProperty("error-auxiliary")
    public String errorAuxiliary;
}

