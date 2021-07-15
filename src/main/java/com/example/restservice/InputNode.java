package com.example.restservice;

public class InputNode extends GenericFormNode{
  private final String type;
  private final String label;
  private final String name;
  private final boolean required;

  public InputNode(String type, String label, String name, boolean required) {
    this.type = type;
    this.label = label;
    this.name = name;
    this.required = required;
  }

  public String getType() {
    return type;
  }

  public String getLabel() {
    return label;
  }

  public String getName() {
    return name;
  }

  public boolean isRequired() {
    return required;
  }

  @Override
  public String toString() {
    return "InputNode: type [" + type + "] . label [" + label + "] . name [" + name + "] . required [" + required + "]";
  }

}
