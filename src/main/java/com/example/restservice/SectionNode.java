package com.example.restservice;

import java.util.List;

public class SectionNode extends GenericFormNode{
  private final String title;
  private final List<GenericFormNode> inputs;

  public SectionNode(String title, List<GenericFormNode> inputs) {
    this.title = title;
    this.inputs = inputs;
  }

  public String getTitle() {
    return title;
  }

  public List<GenericFormNode> getInputs() {
    return inputs;
  }

  @Override
  public String toString() {
    String demoString = "SectionNode: title[" + title + "] . inputs.size() [" + inputs.size() + "]";
    for (int i = 0; i < this.inputs.size(); i++) {
      GenericFormNode node = this.inputs.get(i);
      demoString += node.toString();
    }
    return demoString;
  }
}
