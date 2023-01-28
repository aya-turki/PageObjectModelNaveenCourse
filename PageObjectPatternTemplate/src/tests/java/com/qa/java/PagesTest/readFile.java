package com.qa.java.PagesTest;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.JsonParser;
import com.qa.java.base.SimpleTestCaseJsonPOJO;
import com.qa.java.util.ReadJsonFile;
import jdk.nashorn.internal.parser.JSONParser;
import org.openqa.selenium.json.Json;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class readFile {

    private final String jsonSource = "{ \"title\": \"Coder From Scratch\": \"author\": \"Aya Turki\" }";
    @Test
    void parse() throws IOException {

        JsonNode node = ReadJsonFile.parse(jsonSource);
        Assert.assertEquals(node.get("title").asText(), "Coder From Scratch");
    }
    @Test
    void fromJson() throws IOException {

        JsonNode node = ReadJsonFile.parse(jsonSource);
        SimpleTestCaseJsonPOJO pojo = ReadJsonFile.fromJson(node, SimpleTestCaseJsonPOJO.class);
        Assert.assertEquals(pojo.getTitle(), "Coder From Scratch");
        System.out.println(pojo.title);
    }
}