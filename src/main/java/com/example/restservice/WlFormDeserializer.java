package com.example.restservice;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WlFormDeserializer extends JsonDeserializer {
  @Override
  public WlFormNode deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
    ObjectCodec oc = jsonParser.getCodec();
    JsonNode coreNode = oc.readTree(jsonParser);

    System.out.println("---------------------");
    System.out.println("node:" + coreNode);
    System.out.println("---------------------");

    try {

      String formTitle = coreNode.get("title").textValue();
      System.out.println("form title:" + formTitle);
      List<SectionNode> sectionList = new ArrayList<>();
      Iterator<JsonNode> sections = coreNode.get("sections").elements();
      sections.forEachRemaining(sNode -> {
        String sectionTitle = sNode.get("title").textValue();
        List<GenericFormNode> sectionInputNodes = new ArrayList<>();

        Iterator<JsonNode> sectionInputs = sNode.get("inputs").elements();
        sectionInputs.forEachRemaining(sInput -> {
          System.out.println("sectionInput:" + sInput);
          String sNodeType = sInput.get("type").textValue();
          String sNodeLabel = sInput.get("label").textValue();
          GenericFormNode subNode;
          switch (sNodeType) {
            case "text":
              String inputName = sInput.get("name").textValue();
              JsonNode iReq = sInput.get("required");
              boolean inputRequired = iReq == null ? true : iReq.booleanValue();
              subNode = new InputNode(sNodeType, sNodeLabel, inputName, inputRequired);
              sectionInputNodes.add(subNode);
              break;
            case "indent-group":
              String iTitle = sInput.get("title").textValue();
              Iterator<JsonNode> iInputs = sInput.get("inputs").elements();
              List<InputNode> indentInputList = new ArrayList<InputNode>();
              iInputs.forEachRemaining(iInput -> {
                String iiName = iInput.get("name").textValue();
                JsonNode iiReq = iInput.get("required");
                boolean iRequired = iiReq.isEmpty() ? true : iiReq.booleanValue();
                InputNode n = new InputNode(sNodeType, sNodeLabel, iiName, iRequired);
                indentInputList.add(n);
              });

              subNode = new IndentGroupNode(sNodeType, sNodeLabel, iTitle, indentInputList);
              sectionInputNodes.add(subNode);

              break;
            default:
              System.out.println("(error) invalid type:" + sNodeType);
          }
          SectionNode sectionNode = new SectionNode(sectionTitle, sectionInputNodes);
          sectionList.add(sectionNode);
        });

      });

      return new WlFormNode(formTitle, sectionList);
    } catch(Exception e) {
      e.printStackTrace();
    }

    return null;

  }
}