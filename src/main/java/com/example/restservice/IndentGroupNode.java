package com.example.restservice;

import java.util.List;

public class IndentGroupNode extends GenericFormNode{
  private final String type;
  private final String label;
  private final String title;
  private final List<InputNode> inputs;

  public IndentGroupNode(String type, String label, String title, List<InputNode> inputs) {
    this.type = type;
    this.label = label;
    this.title = title;
    this.inputs = inputs;
  }

  public String getType() {
    return type;
  }

  public String getLabel() {
    return label;
  }

  public String getTitle() {
    return title;
  }

  public List<InputNode> getInputs() {
    return inputs;
  }

  @Override
  public String toString() {
    return "IndentGroupNode: type [" + type + "] . label [" + label + "] . title [" + title + "] . inputs.size [" + inputs.size() + "]";
  }
}
