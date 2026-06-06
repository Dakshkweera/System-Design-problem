import java.time.LocalDateTime;

public class Recipt {
    private String reciptId;
    private int amt;
    private LocalDateTime entrytime;
    private LocalDateTime exittime;
    payment pay;

    public Recipt(String reciptId, int amt, LocalDateTime entrytime, LocalDateTime exittime, payment pay) {
        this.reciptId = reciptId;
        this.amt = amt;
        this.entrytime = entrytime;
        this.exittime = exittime;
        this.pay = pay;
    }

    public void generateRecipt(){
        System.out.println("Recipt ID: " + reciptId);
        System.out.println("Amount: " + amt);
        System.out.println("Entry Time: " + entrytime);
        System.out.println("Exit Time: " + exittime);
        pay.getpaymentmethod();
    }
}
