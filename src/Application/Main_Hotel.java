package Application;

import Model.Entities.Reserva;
import Model.Exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main_Hotel {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Número do Quarto: ");
            int numero = sc.nextInt();
            System.out.print("Data do Check In (dd/mm/yyyy): ");
            Date CheckIn = sdf.parse(sc.next());
            System.out.print("Data do Check Out (dd/mm/yyyy): ");
            Date CheckOut = sdf.parse(sc.next());

            Reserva reserva = new Reserva(numero, CheckIn, CheckOut);
            System.out.println("Reserva: " + reserva);

            System.out.println();
            System.out.println("Quais as datas para atualização? ");
            System.out.print("Data do Check In (dd/mm/yyyy): ");
            CheckIn = sdf.parse(sc.next());
            System.out.print("Data do Check Out (dd/mm/yyyy): ");
            CheckOut = sdf.parse(sc.next());

            reserva.atualizacaoDatas(CheckIn, CheckOut);
            System.out.println("Reserva: " + reserva);
        }
        catch (ParseException e) {
            System.out.println("Formato de data inválido");
        }
        catch (DomainException e) {
            System.out.println("Erro na reserva: " + e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("Erro inesperado...");
        }

    }
}
