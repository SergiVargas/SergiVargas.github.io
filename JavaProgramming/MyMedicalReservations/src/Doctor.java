import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User{


    //Attributes
    private String speciality;


    //Constructor

    Doctor(String name, String email){

        super(name, email);
        System.out.println("INTRODUCCION A NEW DOCTOR IN DATABASE");
        this.speciality = speciality;

    }

    ArrayList<AvailableReservations> AvailableReservations = new ArrayList<>();

    public void addAvailableReservation(Date date, String time){
        AvailableReservations.add(new AvailableReservations(date,time));
    }

    public ArrayList<AvailableReservations> getAvailableReservations(){
        return AvailableReservations;
    }



   public static class AvailableReservations{

        private int id;
        private Date date;
        private String time;

       public AvailableReservations(Date date, String time) {
           this.date = date;
           this.time = time;
       }

       public int getId() {
           return id;
       }

       public void setId(int id) {
           this.id = id;
       }

       public Date getDate() {
           return date;
       }

       public void setDate(Date date) {
           this.date = date;
       }

       public String getTime() {
           return time;
       }

       public void setTime(String time) {
           this.time = time;
       }
   }



}

