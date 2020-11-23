
import java.util.Date;

import static InterfacesMenu.Menu.*;

public class Main {

    public static void main(String[] args) {

        showMenu();

        Doctor miMedico = new Doctor("jorgue", "cardiologia");
        miMedico.addAvailableReservation(new Date(), "4pm");
        miMedico.addAvailableReservation(new Date(), "18pm");

        for(Doctor.AvailableReservations listar: miMedico.getAvailableReservations()){
            System.out.println(listar.getDate() + "  " + listar.getTime());
        }


    }


}
