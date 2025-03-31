package uz.akramovxm.unknownback.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MeRequest {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String birthDate;

    public void setFirstName(String firstName) {
        this.firstName = firstName != null ? firstName.trim() : null;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName != null ? lastName.trim() : null;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber != null ? phoneNumber.trim() : null;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate != null ? birthDate.trim() : null;
    }
}
