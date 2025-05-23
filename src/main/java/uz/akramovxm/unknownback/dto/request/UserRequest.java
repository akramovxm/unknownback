package uz.akramovxm.unknownback.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String role;
    private String phoneNumber;
    private String birthDate;
    private Boolean locked;

    public void setFirstName(String firstName) {
        this.firstName = firstName != null ? firstName.trim() : null;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName != null ? lastName.trim() : null;
    }
    public void setEmail(String email) {
        this.email = email != null ? email.trim() : null;
    }
    public void setRole(String role) {
        this.role = role != null ? role.trim().toUpperCase() : null;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber != null ? phoneNumber.trim() : null;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate != null ? birthDate.trim() : null;
    }
}
