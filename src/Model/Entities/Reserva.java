package Model.Entities;

import Model.Exceptions.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

    private Integer NumeroQuarto;
    private Date CheckIn;
    private Date CheckOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reserva(Integer numeroQuarto, Date checkIn, Date checkOut){
        if (!CheckOut.after(checkIn)) {
            throw new DomainException("Erro na reserva: A data de CheckOut deve ser posterior a de CheckIn");
        }
        NumeroQuarto = numeroQuarto;
        CheckIn = checkIn;
        CheckOut = checkOut;
    }

    public Integer getNumeroQuarto() {
        return NumeroQuarto;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        NumeroQuarto = numeroQuarto;
    }

    public Date getCheckIn() {
        return CheckIn;
    }

    public Date getCheckOut() {
        return CheckOut;
    }

    private long duracao(){
        long diff = getCheckOut().getTime() - getCheckIn().getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void atualizacaoDatas (Date CheckIn, Date CheckOut){
        Date now = new Date();
        if (CheckIn.before(now) || CheckOut.before(now)){
            throw new DomainException("Erro na reserva: As datas de Reserva devem ser datas futuras");
        }if (!CheckOut.after(CheckIn)) {
            throw new DomainException("Erro na reserva: A data de CheckOut deve ser posterior a de CheckIn");
        }

        this.CheckIn = CheckIn;
        this.CheckOut = CheckOut;
    }

    @Override
    public String toString() {
        return "Quarto "
                + getNumeroQuarto()
                + ", Check In:"
                + sdf.format(CheckIn)
                + ", Check Out"
                + sdf.format(CheckOut)
                + ", Duração: "
                + duracao()
                + " noites";
    }
}