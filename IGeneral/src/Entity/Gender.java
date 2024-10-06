package Entity;

public enum Gender {
    M("Male"), F("Female"), O("Other");
    private final String genderLabel;

    Gender(String genderLabel) {
        this.genderLabel = genderLabel;
    }

    public String getGenderLabel() {
        return genderLabel;
    }
}
