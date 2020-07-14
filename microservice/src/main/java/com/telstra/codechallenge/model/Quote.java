package com.telstra.codechallenge.model;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Quote {

  private String type;
  
  private Value value;

public Quote() {
	super();
	// TODO Auto-generated constructor stub
}

public Quote(String type, Value value) {
	super();
	this.type = type;
	this.value = value;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public Value getValue() {
	return value;
}

public void setValue(Value value) {
	this.value = value;
}

@Override
public String toString() {
	return "Quote [type=" + type + ", value=" + value + "]";
}

}
