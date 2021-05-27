package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    public long id;
    public String key;
    public String name;
    public String username;
    public String photo;
    public String email;
    public String email_encoded;
    public boolean is_activated;
    public boolean is_new;
    public boolean isTrialUsed;
    public boolean email_verification_needed;
}
