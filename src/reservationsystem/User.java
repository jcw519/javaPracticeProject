package reservationsystem;

public class User {
    
    private String userName;
    private int reservedSeatsGradeIndex;
    private String reservedSeatsGrade;
    private int reservedSeatsNumber;
    
    public User(String userName, int reservedSeatsGradeIndex, String reservedSeatsGrade, int reservedSeatsNumber){
        this.userName = userName;
        this.reservedSeatsGradeIndex = reservedSeatsGradeIndex;
        this.reservedSeatsGrade = reservedSeatsGrade;
        this.reservedSeatsNumber = reservedSeatsNumber;
    }
    
    public String getUserName(){
        return userName;
    }
    
    public int getReservedSeatsGradeIndex(){
        return reservedSeatsGradeIndex;
    }
    
    public int getReservedSeatsNumber() {
        return reservedSeatsNumber;
    }
    
    public String getReservedSeatsGrade() {
        return reservedSeatsGrade;
    }
    
    public void showUserInfo(){
        System.out.println("<<"+ userName + "님의 예약정보>>");
        System.out.println("좌석 구분 : " + reservedSeatsGrade);
        System.out.println("좌석 번호 : " + reservedSeatsNumber);
    }
    
    
    
}
