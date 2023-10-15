package com.betting.bettinginfo.jsontojavaclass.custom;

import com.fasterxml.jackson.databind.JsonNode;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JFieldVar;
import org.jsonschema2pojo.AbstractAnnotator;

public class CustomAnnotator extends AbstractAnnotator {
  @Override
  public void propertyOrder(JDefinedClass clazz, JsonNode propertiesNode) {
    // Do not generate @JsonPropertyOrder annotation
  }

  @Override
  public void propertyInclusion(JDefinedClass clazz, JsonNode schema) {
    // Do not generate @JsonInclude annotation
  }

  @Override
  public void propertyField(JFieldVar field, JDefinedClass clazz, String propertyName, JsonNode propertyNode) {
    // Do not generate @JsonProperty annotation
  }
}
