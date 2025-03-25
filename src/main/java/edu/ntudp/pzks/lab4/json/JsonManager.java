package edu.ntudp.pzks.lab4.json;

import com.google.gson.*;
import edu.ntudp.pzks.lab4.model.*;
import java.io.*;
import java.lang.reflect.Type;

public class JsonManager {
    private static final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(Human.class, new HumanAdapter())
            .create();

    public static void writeToJsonFile(University university, String filename) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            gson.toJson(university, writer);
        }
    }

    public static University readFromJsonFile(String filename) throws IOException {
        try (FileReader reader = new FileReader(filename)) {
            return gson.fromJson(reader, University.class);
        }
    }

    private static class HumanAdapter implements JsonSerializer<Human>, JsonDeserializer<Human> {
        @Override
        public JsonElement serialize(Human src, Type typeOfSrc, JsonSerializationContext context) {
            JsonObject jsonObject = context.serialize(src).getAsJsonObject();
            jsonObject.addProperty("type", src.getClass().getSimpleName());
            return jsonObject;
        }

        @Override
        public Human deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonObject jsonObject = json.getAsJsonObject();
            String type = jsonObject.get("type").getAsString();
            Class<? extends Human> clazz = "Student".equals(type) ? Student.class : Human.class;
            return context.deserialize(json, clazz);
        }
    }
}