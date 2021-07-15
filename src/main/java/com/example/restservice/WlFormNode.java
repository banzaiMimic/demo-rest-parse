package com.example.restservice;

import java.util.List;

public class WlFormNode extends GenericFormNode{
  private final String title;
  private final List<SectionNode> sections;

  public WlFormNode(String title, List<SectionNode> sections) {
    this.title = title;
    this.sections = sections;
  }

  public String getTitle() {
    return title;
  }

  public List<SectionNode> getSections() {
    return sections;
  }

  @Override
  public String toString() {
    String demoPrint = "WlFormNode: title [" + title + "] . sections.size() [" + sections.size() + "]";
    for (int i = 0; i < this.sections.size() ; i++) {
      SectionNode sNode = this.sections.get(i);
      demoPrint += sNode.toString();
    }
    return demoPrint;
  }
}
