/*
 * Class: CMSC203 CRN 40539
 * Instructor: Prof. Grigoriy Grinberg
 * Description: (Give a brief description for each Class) Data class for patients.
 * Due: 06/30/2025
 * Platform/compiler: MacOS openjdk temurin 24.0.1
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Oguz Yilmazlar
*/

public class Patient {

    // name
    private String firstName;
    private String middleName;
    private String lastName;

    // address
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;

    // details
    private String phoneNumber;

    // emergency contact
    private String emergencyName;
    private String emergencyPhoneNumber;

    /**
     * Default no-argument constructor for the Patient class.
     * Initializes an empty Patient object with empty values.
     */
    public Patient() {
        this.firstName = "";
        this.middleName = "";
        this.lastName = "";
        this.streetAddress = "";
        this.city = "";
        this.state = "";
        this.zipCode = "";
        this.phoneNumber = "";
        this.emergencyName = "";
        this.emergencyPhoneNumber = "";
    }

    /**
     * Constructor that initializes the patient's name only.
     * Useful when only basic identity is needed initially.
     *
     * @param firstName First name of the patient
     * @param middleName Middle name of the patient
     * @param lastName Last name of the patient
     */
    public Patient(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    /**
     * Constructor that initializes all fields of the Patient object.
     * Provides complete detail including address, contact, and emergency info.
     *
     * @param firstName First name of the patient
     * @param middleName Middle name of the patient
     * @param lastName Last name of the patient
     * @param streetAddress Street address of the patient
     * @param city City the patient lives in
     * @param state State the patient lives in
     * @param zipCode Zip code of the patient's residence
     * @param phoneNumber Patient's phone number
     * @param emergencyName Emergency contact's name
     * @param emergencyPhoneNumber Emergency contact's phone number
     */
    public Patient(String firstName,
                   String middleName,
                   String lastName,
                   String streetAddress,
                   String city,
                   String state,
                   String zipCode,
                   String phoneNumber,
                   String emergencyName,
                   String emergencyPhoneNumber) {
        this(firstName, middleName, lastName);
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.emergencyName = emergencyName;
        this.emergencyPhoneNumber = emergencyPhoneNumber;
    }

    /**
     * Builds and returns the full name of the patient in a single string.
     * Combines first, middle, and last names with spaces.
     *
     * @return Full name of the patient
     */
    public String buildFullName() {
        return getFirstName() + " " + getMiddleName() + " " + getLastName();
    }

    /**
     * Builds and returns the full address of the patient.
     * Combines street address, city, state, and zip code in one string.
     *
     * @return Full address of the patient
     */
    public String buildAddress() {
        return getStreetAddress() + " " + getCity() + " " + getState() + " " + getZipCode();
    }

    /**
     * Builds and returns the full emergency contact as a readable string.
     * Combines emergency contact's name and phone number.
     *
     * @return Emergency contact details
     */
    public String buildEmergencyContact() {
        return getEmergencyName() + " " + getEmergencyPhoneNumber();
    }

    /**
     * Returns the patient's first name.
     *
     * @return First name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Updates the patient's first name with the provided value.
     *
     * @param firstName New first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the patient's middle name.
     *
     * @return Middle name
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Updates the patient's middle name with the provided value.
     *
     * @param middleName New middle name
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * Returns the patient's last name.
     *
     * @return Last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Updates the patient's last name with the provided value.
     *
     * @param lastName New last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the patient's street address.
     *
     * @return Street address
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * Updates the patient's street address with the provided value.
     *
     * @param streetAddress New street address
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    /**
     * Returns the city where the patient resides.
     *
     * @return City
     */
    public String getCity() {
        return city;
    }

    /**
     * Updates the patient's city with the provided value.
     *
     * @param city New city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Returns the state where the patient resides.
     *
     * @return State
     */
    public String getState() {
        return state;
    }

    /**
     * Updates the patient's state with the provided value.
     *
     * @param state New state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Returns the patient's zip code.
     *
     * @return Zip code
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Updates the patient's zip code with the provided value.
     *
     * @param zipCode New zip code
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Returns the patient's phone number.
     *
     * @return Phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Updates the patient's phone number with the provided value.
     *
     * @param phoneNumber New phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns the name of the patient's emergency contact.
     *
     * @return Emergency contact name
     */
    public String getEmergencyName() {
        return emergencyName;
    }

    /**
     * Updates the emergency contact's name with the provided value.
     *
     * @param emergencyName New emergency contact name
     */
    public void setEmergencyName(String emergencyName) {
        this.emergencyName = emergencyName;
    }

    /**
     * Returns the phone number of the patient's emergency contact.
     *
     * @return Emergency contact phone number
     */
    public String getEmergencyPhoneNumber() {
        return emergencyPhoneNumber;
    }

    /**
     * Updates the emergency contact's phone number with the provided value.
     *
     * @param emergencyPhoneNumber New emergency phone number
     */
    public void setEmergencyPhoneNumber(String emergencyPhoneNumber) {
        this.emergencyPhoneNumber = emergencyPhoneNumber;
    }

    /**
     * Returns a string summary of the patient including name, address, phone,
     * and emergency contact information in a readable format.
     *
     * @return Patient object as a formatted string
     */
    @Override
    public String toString() {
        return "Patient(" +
                "fullName=" + buildFullName() + "," +
                "address=" + buildAddress() + "," +
                "phoneNumber=" + getPhoneNumber() + "," +
                "emergency=" + buildEmergencyContact() + ")";
    }
}
