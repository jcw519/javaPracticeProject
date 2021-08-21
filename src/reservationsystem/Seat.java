package reservationsystem;

public class Seat {
    private int seatNumber;
    private String seatGrade;
    private boolean isReservation = false;
    private User seatSubscriber;
    
    public Seat(String seatGrade, int seatNumber) {
        this.seatGrade = seatGrade;
        this.seatNumber = seatNumber;
    }
    
    public static Seat[] makeSeatList(int size, String seatGrade){
        Seat [] seat = new Seat[size];
        for(int i = 0; i < seat.length; i++){
            seat[i] = new Seat(seatGrade, i+1);
        }
        return seat;
    }
        
    public int getSeatNumber(){
        return seatNumber;
    }
    
    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
    
    public String getSeatGrade(){
        return seatGrade;
    }
    
    public boolean getIsReservation() {
        return isReservation;
    }
    
    public void setSeatSubscriber(String userName, int seatGradeIndex, String seatGrade, int seatNumber) {
        seatSubscriber = new User(userName, seatGradeIndex, seatGrade, seatNumber);
        isReservation = true;
    }
    
    public User getSeatSubscriber() {
        return seatSubscriber;
    }
}
