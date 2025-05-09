package com.rjio.accelator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JSONUtils {
	private static final ObjectMapper objectMapper = new ObjectMapper();

	public static ArrayNode createArrayNode() {
		return objectMapper.createArrayNode();
	}

	public static ObjectNode createObjectNode() {
		return objectMapper.createObjectNode();
	}
}
