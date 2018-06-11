package com.ums.mbr.packer.gda.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Author: jcouyang@chinaums.com
 * Date: 2018/4/13 15:25
 */
public class GdaDcQueryRequestBody extends GdaBaseRequestBody {

    @JsonProperty("input_type")
    private String inputType;
    @JsonProperty("id_keyword")
    private String idKeyword;

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public String getIdKeyword() {
        return idKeyword;
    }

    public void setIdKeyword(String idKeyword) {
        this.idKeyword = idKeyword;
    }
}
