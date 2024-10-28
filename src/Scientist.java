class Scientist {
    String lastName;
    int birthYear;
    String gender;
    String field;


    public Scientist(String lastName, int birthYear, String gender, String field) {
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.gender = gender;
        this.field = field;
    }


    public String getLastName() {
        return lastName;
    }
    public int getBirthYear() {
        return birthYear;
    }
    public String getGender() {
        return gender;
    }
    public String getField() {
        return field;
    }
}