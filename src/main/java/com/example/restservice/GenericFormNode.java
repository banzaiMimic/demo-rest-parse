package com.example.restservice;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = WlFormDeserializer.class)
public abstract class GenericFormNode {}