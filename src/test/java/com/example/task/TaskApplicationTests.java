package com.example.task;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import okhttp3.*;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class TaskApplicationTests {

	private static final String BASE_URL = "http://localhost:8080/filter/getFilteringResult";

	@Test
	public void testMyApi() throws IOException {
		OkHttpClient client = new OkHttpClient();

		JSONObject requestBody = new JSONObject();
		requestBody.put("filterName", "by_event_name");
		requestBody.put("additionalParameter", "Creates a new entry");

		Request request = new Request.Builder()
				.url(BASE_URL)
				.post(RequestBody.create(MediaType.parse("application/json"), requestBody.toString()))
				.build();

		Response response = client.newCall(request).execute();
		String responseBody = response.body().string();
		long value;
		JsonElement json = JsonParser.parseString(responseBody);
		if (json.isJsonObject() && json.getAsJsonObject().has("responseValue")) {
			value = json.getAsJsonObject().get("responseValue").getAsLong();
		} else {
			value = Long.parseLong(responseBody);
		}
		
		System.out.println(value == 3);
	}
}
