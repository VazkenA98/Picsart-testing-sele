package helper;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.*;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class ApiHelper {
    private static String generatedText = UUID.randomUUID().toString();

    public static JsonObject createUser() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n\t\"email\": \"" + generatedText + "@gmail.com\",\n\t\"password\": \"Tumo!123456\"\n}");
        Request request = new Request.Builder()
                .url("https://picsart.com/sign-up")
                .method("POST", body)
                .addHeader("authority", "picsart.com")
                .addHeader("Content-Type", "application/json")
                .addHeader("Cookie", "UI=eyJpZCI6MzU5NTYzMzQ4MDM5MTAxLCJrZXkiOiIwNTkxZWQ2YS05NzMwLTQxZmItYTdmNS00YjA0ZWFkZTEwYzMiLCJuYW1lIjoiIiwidXNlcm5hbWUiOiJxYTE2MjE4NjczNDciLCJwaG90byI6Imh0dHBzOi8vY2RuMTkwLnBpY3NhcnQuY29tLzIzMjgwNDY2MTAwNzkwMC5wbmciLCJlbWFpbCI6InFhMTYyMTg2NzM0N0BnbWFpbC5jb20iLCJlbWFpbF9lbmNvZGVkIjoiZmM4NTI0OGNiMzU5ZGVlYTQ3ZjY3NmI1MzgwYWQxYmUyNDI5ZDMxNSIsImlzX2FjdGl2YXRlZCI6ZmFsc2UsImlzX25ldyI6ZmFsc2UsImlzVHJpYWxVc2VkIjpmYWxzZSwiZW1haWxfdmVyaWZpY2F0aW9uX25lZWRlZCI6dHJ1ZX0%3D; badges=j%3A%7B%22VIP%22%3A%22https%3A%2F%2Fcdn130.picsart.com%2F267273314017201.png%22%2C%22Master%20Storyteller%22%3A%22https%3A%2F%2Fpastatic.picsart.com%2Fmasterstoryteller.png%22%2C%22Master%20Contributor%22%3A%22https%3A%2F%2Fpastatic.picsart.com%2Fmastercontributor.png%22%2C%22Celebrity%22%3A%22https%3A%2F%2Fcdn130.picsart.com%2F267273314017201.png%22%2C%22Brands%22%3A%22https%3A%2F%2Fcdn130.picsart.com%2F267273314017201.png%22%2C%22subscribed%22%3A%22https%3A%2F%2Fcdn140.picsart.com%2F270126459015201.png%22%7D; gtm_user_id=359563348039101; sid=s%3A8-c7-bYwaA54axEqkWnXXbCvTGsgF3eo.YGVpDEqnqaLrFHtFLbDD9OyGMBqH7VMlaML2II2Zzqw; user_email=qa1621867347%40gmail.com; user_key=0591ed6a-9730-41fb-a7f5-4b04eade10c3")
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String jsonString = null;
        try {
            jsonString = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return JsonParser.parseString(jsonString).getAsJsonObject();

    }
    public static void removeUser(String userKey) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n\t\"key\": \"" + userKey +"}");
        Request request = new Request.Builder()
                .url("https://picsart.com/users/remove")
                .method("POST", body)
                .addHeader("authority", "picsart.com")
                .addHeader("Content-Type", "application/json")
                //.addHeader("Cookie", "UI=eyJpZCI6MzU5NTYzMzQ4MDM5MTAxLCJrZXkiOiIwNTkxZWQ2YS05NzMwLTQxZmItYTdmNS00YjA0ZWFkZTEwYzMiLCJuYW1lIjoiIiwidXNlcm5hbWUiOiJxYTE2MjE4NjczNDciLCJwaG90byI6Imh0dHBzOi8vY2RuMTkwLnBpY3NhcnQuY29tLzIzMjgwNDY2MTAwNzkwMC5wbmciLCJlbWFpbCI6InFhMTYyMTg2NzM0N0BnbWFpbC5jb20iLCJlbWFpbF9lbmNvZGVkIjoiZmM4NTI0OGNiMzU5ZGVlYTQ3ZjY3NmI1MzgwYWQxYmUyNDI5ZDMxNSIsImlzX2FjdGl2YXRlZCI6ZmFsc2UsImlzX25ldyI6ZmFsc2UsImlzVHJpYWxVc2VkIjpmYWxzZSwiZW1haWxfdmVyaWZpY2F0aW9uX25lZWRlZCI6dHJ1ZX0%3D; badges=j%3A%7B%22VIP%22%3A%22https%3A%2F%2Fcdn130.picsart.com%2F267273314017201.png%22%2C%22Master%20Storyteller%22%3A%22https%3A%2F%2Fpastatic.picsart.com%2Fmasterstoryteller.png%22%2C%22Master%20Contributor%22%3A%22https%3A%2F%2Fpastatic.picsart.com%2Fmastercontributor.png%22%2C%22Celebrity%22%3A%22https%3A%2F%2Fcdn130.picsart.com%2F267273314017201.png%22%2C%22Brands%22%3A%22https%3A%2F%2Fcdn130.picsart.com%2F267273314017201.png%22%2C%22subscribed%22%3A%22https%3A%2F%2Fcdn140.picsart.com%2F270126459015201.png%22%7D; gtm_user_id=359563348039101; sid=s%3A8-c7-bYwaA54axEqkWnXXbCvTGsgF3eo.YGVpDEqnqaLrFHtFLbDD9OyGMBqH7VMlaML2II2Zzqw; user_email=qa1621867347%40gmail.com; user_key=0591ed6a-9730-41fb-a7f5-4b04eade10c3")
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String jsonString = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static JsonObject uploadPhoto(String userKey, File file)  {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("type","photo")
                .addFormDataPart("file",file.getName(),
                        RequestBody.create(MediaType.parse("application/octet-stream"),
                                file))
                .addFormDataPart("is_public","1")
                .addFormDataPart("tags","#freetoedit")
                .build();
        Request request = new Request.Builder()
                .url("https://api.picsart.com/preproduction/photos/add.json?key="+userKey+"&is_public=1")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("is_public", "1")
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String jsonString = null;
        try {
            jsonString = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("API adding image........");
        return JsonParser.parseString(jsonString).getAsJsonObject();

    }

    public static JsonObject removePhoto(String imageId, String userKey)  {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("key",userKey)
                .build();
        Request request = new Request.Builder()
                .url("https://api.picsart.com/preproduction/photos/remove/"+imageId+".json")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String jsonString = null;
        try {
            jsonString = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("API removing image........");
        return JsonParser.parseString(jsonString).getAsJsonObject();

    }

    public static void addHashtag(String userKey, String imageId, String hashtag)  {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n\t\"tags\": \"" + hashtag + "\"\n}");
        Request request = new Request.Builder()
                .url("https://api.picsart.com/photos/update/" + imageId + ".json?key=" + userKey)
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("API adding Hashtag........");

    }

    public static JsonObject likePhoto(String userKey, String imageId)  {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://api.picsart.com/preproduction/photos/likes/add/"+imageId+".json?key=" +userKey)
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String jsonString = null;
        try {
            jsonString = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return JsonParser.parseString(jsonString).getAsJsonObject();
    }


    public static void main(String[] args) throws IOException {
        createUser();

    }

}
