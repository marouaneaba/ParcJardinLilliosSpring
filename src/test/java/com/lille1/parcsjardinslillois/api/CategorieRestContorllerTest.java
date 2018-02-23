package com.lille1.parcsjardinslillois.api;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class CategorieRestContorllerTest {

	@Test
	public void testTypeMedia() throws ClientProtocolException, IOException {
		String jsonMimeType = "application/json";
		HttpUriRequest request = new HttpGet("https://obscure-reef-42267.herokuapp.com/api/Categorie");

		// When
		HttpResponse response = HttpClientBuilder.create().build().execute(request);

		// Then
		String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();

		assertEquals(jsonMimeType, mimeType);
	}

	@Test
	public void testJsonCategorie() throws ClientProtocolException, IOException {
		// Given
		HttpUriRequest request = new HttpGet("https://obscure-reef-42267.herokuapp.com/api/Categorie");

		// When
		HttpResponse response = HttpClientBuilder.create().build().execute(request);

		// Then
		JsonNode resource = RetrieveUtil.retrieveResourceFromResponse(response, JsonNode.class);

		List<JsonNode> categorie = resource.findValues("categorie");
		Iterator iterator1 = resource.iterator();

		while (iterator1.hasNext()) {
			ObjectNode child1 = (ObjectNode) iterator1.next();

			String tagName = child1.get("nomcategorie").asText();// .toString();
			boolean assertTestTrue = tagName.equals("ETUDE") || tagName.equals("SPORT")
					|| tagName.equals("RESTAURATION") || tagName.equals("PROMENER") || tagName.equals("ECOUTER")
					|| tagName.equals("OBSERVER");

			assertTrue(assertTestTrue);

		}

	}
}
