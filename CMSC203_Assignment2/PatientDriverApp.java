import java.util.Scanner;

public class PatientDriverApp {

    /**
     * Entry point
     * @param args
     */
    public static void main(String[] args){

        Scanner keyboard = new Scanner(System.in);

        Patient patient = askForPatient(keyboard);

        Procedure procedureOne;
        do{
            System.out.println("Enter Procedure #1 Details:");
            procedureOne = askForProcedure(keyboard);
            // clear the buffer because of the nextDouble.
            keyboard.nextLine();
        }while(procedureOne.getCharges() <= 0.0);

        Procedure procedureTwo;
        do{
            System.out.println("Enter Procedure #2 Details:");
            procedureTwo = askForProcedure(keyboard);
            // clear the buffer because of the nextDouble.
            keyboard.nextLine();
        }while(procedureTwo.getCharges() <= 0.0);

        Procedure procedureThree;
        do{
            System.out.println("Enter Procedure #3 Details:");
            procedureThree = askForProcedure(keyboard);
            // clear the buffer because of the nextDouble.
            keyboard.nextLine();
        }while(procedureThree.getCharges() <= 0.0);

        displayPatient(patient);
        displayProcedure(procedureOne);
        displayProcedure(procedureTwo);
        displayProcedure(procedureThree);
        double charges = calculateTotalCharges(procedureOne, procedureTwo, procedureThree);
        System.out.println("Total Charges: $" + charges);

        System.out.println();

        System.out.println("Programmer: Oguz Can Yilmazlar");
        System.out.println("M Number: M21218065");
        System.out.println("Due Date: 06/30/2025");


    }

    /**
     * Builds a procedure from the scanner input.
     * @param keyboard input scanner.
     * @return new procedure from input
     */
    private static Procedure askForProcedure(Scanner keyboard){
        System.out.print("Name: ");
        String name = keyboard.nextLine();

        System.out.print("Date: ");
        String date = keyboard.nextLine();

        System.out.print("Practitioner: ");
        String practitioner = keyboard.nextLine();

        System.out.print("Charge: ");
        double charge = keyboard.nextDouble();

        return new Procedure(name, date, practitioner, charge);

    }

    /**
     * Builds a patient from the scanner input
     * @param keyboard scanner input
     * @return new patient
     */
    private static Patient askForPatient(Scanner keyboard){
        System.out.print("Enter Patient's First Name: ");
        String firstName = keyboard.nextLine();

        System.out.print("Enter Patient's Middle Name: ");
        String middleName = keyboard.nextLine();


        System.out.print("Enter Patient's Last Name: ");
        String lastName = keyboard.nextLine();

        System.out.print("Enter Patient's Address: ");
        String address = keyboard.nextLine();

        System.out.print("Enter Patient's City: ");
        String city = keyboard.nextLine();

        System.out.print("Enter Patient's State: ");
        String state = keyboard.nextLine();

        System.out.print("Enter Patient's ZIP Code: ");
        String zipCode = keyboard.nextLine();

        System.out.print("Enter Patient's Phone Number: ");
        String phoneNumber = keyboard.nextLine();


        System.out.print("Enter Emergency Contact's Name: ");
        String emergencyName = keyboard.nextLine();

        System.out.print("Enter Emergency Contact's Phone Number: ");
        String emergencyPhoneNumber = keyboard.nextLine();


        return new Patient(firstName, middleName, lastName,
                address, city, state,
                zipCode, phoneNumber,
                emergencyName, emergencyPhoneNumber);
    }

    /**
     * Displays the patient details as readable
     * @param patient the patient wanted to print.
     */
    private static void displayPatient(Patient patient){
        System.out.println("Patient: " + patient.buildFullName());
        System.out.println("Address: " + patient.buildAddress());
        System.out.println("Emergency Contact: " + patient.buildEmergencyContact());
    }

    /**
     * Displays the procedure details
     * @param procedure the procedure you want to dpsplay
     */
    private static void displayProcedure(Procedure procedure){
        System.out.println("Procedure: " + procedure.getName());
        System.out.println("Date: " + procedure.getDate());
        System.out.println("Charge: $" + procedure.getCharges());
    }

    // this can be simplified with the use of stream api or varargs or both.
    /**
     * Calculates the total charges of all procedures.
     * @param procedureOne First procedure
     * @param procedureTwo Second procedure
     * @param procedureThree Third procedure
     * @return total cost of all procedures.
     */
    private static double calculateTotalCharges(Procedure procedureOne, Procedure procedureTwo, Procedure procedureThree){
        return procedureOne.getCharges() + procedureTwo.getCharges() + procedureThree.getCharges();
    }

}
