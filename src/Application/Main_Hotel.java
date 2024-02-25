package Application;

import Model.Entities.Reserva;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main_Hotel {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Número do Quarto: ");
        int numero = sc.nextInt();
        System.out.print("Data do Check In (dd/mm/yyyy): ");
        Date CheckIn = sdf.parse(sc.next());
        System.out.print("Data do Check Out (dd/mm/yyyy): ");
        Date CheckOut = sdf.parse(sc.next());

        if (!CheckOut.after(CheckIn)) {
            System.out.println("Erro na reserva: A data de CheckOut deve ser posterior a de CheckIn");
        }else {
            Reserva reserva = new Reserva(numero, CheckIn, CheckOut);
            System.out.println("Reserva: " + reserva);

            System.out.println();
            System.out.print("Quais as datas para atualização? ");
            System.out.print("Data do Check In (dd/mm/yyyy): ");
            CheckIn = sdf.parse(sc.next());
            System.out.print("Data do Check Out (dd/mm/yyyy): ");
            CheckOut = sdf.parse(sc.next());

            String error = reserva.atualizacaoDatas(CheckIn, CheckOut);

            if ( error != null){
                System.out.println(error);
            }else{
                System.out.println("Reserva: " + reserva);
            }
        }
    }
}