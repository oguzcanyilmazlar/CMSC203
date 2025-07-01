/*
 * Class: CMSC203 CRN 40539
 * Instructor: Prof. Grigoriy Grinberg
 * Description: Data class that represents a medical procedure performed on a patient,
 *              including name, date, practitioner, and charge information.
 * Due: 06/30/2025
 * Platform/compiler: MacOS openjdk temurin 24.0.1
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Oguz Yilmazlar
*/

public class Procedure {

    // fields
    private String name;
    private String date;
    private String practitionerName;
    private double charges; // not ideal for currency, but acceptable for this context

    /**
     * No-argument constructor.
     * Initializes a Procedure object with default values.
     */
    public Procedure() {
        this.name = "";
        this.date = "";
        this.practitionerName = "";
        this.charges = 0.0;
    }

    /**
     * Constructor that initializes the name and date of the procedure.
     * Useful when only basic details of a procedure are known.
     *
     * @param name Name of the procedure
     * @param date Date when the procedure was performed
     */
    public Procedure(String name, String date) {
        this.name = name;
        this.date = date;
    }

    /**
     * Constructor that initializes all fields of the Procedure object.
     * Includes procedure name, date, practitioner name, and charges.
     *
     * @param name Name of the procedure
     * @param date Date the procedure was performed
     * @param practitionerName Name of the medical practitioner
     * @param charges Charges associated with the procedure
     */
    public Procedure(String name, String date, String practitionerName, double charges) {
        this(name, date);
        this.practitionerName = practitionerName;
        this.charges = charges;
    }

    /**
     * Gets the name of the procedure.
     *
     * @return Procedure name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the procedure.
     *
     * @param name New name of the procedure
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the date the procedure was performed.
     *
     * @return Date of the procedure
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the date the procedure was performed.
     *
     * @param date New date of the procedure
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Gets the name of the medical practitioner who performed the procedure.
     *
     * @return Practitioner's name
     */
    public String getPractitionerName() {
        return practitionerName;
    }

    /**
     * Sets the name of the medical practitioner.
     *
     * @param practitionerName New practitioner's name
     */
    public void setPractitionerName(String practitionerName) {
        this.practitionerName = practitionerName;
    }

    /**
     * Gets the charges for the procedure.
     *
     * @return Charge amount
     */
    public double getCharges() {
        return charges;
    }

    /**
     * Sets the charges for the procedure.
     *
     * @param charges New charge amount
     */
    public void setCharges(double charges) {
        this.charges = charges;
    }

    /**
     * Returns a string representation of the Procedure object.
     * Includes the name, date, practitioner, and charges in a readable format.
     *
     * @return String summary of the procedure
     */
    @Override
    public String toString() {
        return "Procedure{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", practitionerName='" + practitionerName + '\'' +
                ", charges=" + charges +
                '}';
    }
}
