package reservationsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    
    public static void reservationSystemRun(Scanner scanner, ArrayList<Seat[]> seatGradeList, ArrayList<User> subscriberInformationList) {
        System.out.println("명품콘서트홀 예약 시스템입니다.");
        
        while(true) {
            System.out.println();
            System.out.print("예약:1  좌석조회:2  예약자명단:3  예약취소:4  끝내기:5  >>");
            int input = scanner.nextInt();
            scanner.nextLine();
            if(input == 1){
                reservation(scanner, seatGradeList, subscriberInformationList);
            } else if(input == 2){
                inquiry(scanner, seatGradeList);
            } else if(input == 3){
                printSubscriberInformationList(scanner, seatGradeList, subscriberInformationList);
            } else if(input == 4){
                reservationCancellation(scanner, seatGradeList, subscriberInformationList);
            } else if(input == 5){
                System.out.println("예약 시스템을 종료하겠습니다.");
                return;
            } else {
                continue;
            }
        }
    }
    
    
    
    
    
    public static void reservation(Scanner scanner, ArrayList<Seat[]> seatGradeList, ArrayList<User> subscriberInformationList) {
        int seatGradeIndex;
        String seatSubscriber;
        int seatNumber;
        
        
        while(true) {
            System.out.print("좌석구분 :");
            for(int i = 0; i < seatGradeList.size(); i++){
                System.out.print(seatGradeList.get(i)[0].getSeatGrade() + "(" + (i+1) + ")  ");
            }
            System.out.print(">>");
        
        
        
            seatGradeIndex = scanner.nextInt() - 1;
            showSeatList(seatGradeIndex, seatGradeList);
            scanner.nextLine();

                    
            System.out.print("이름>> ");
            seatSubscriber = scanner.nextLine();

            System.out.print("좌석번호>> ");     
            seatNumber = scanner.nextInt() - 1;
            scanner.nextLine();
            
            String seatGrade = seatGradeList.get(seatGradeIndex)[seatNumber].getSeatGrade();
            
            if(seatGradeList.get(seatGradeIndex)[seatNumber].getIsReservation() == false) {
                seatGradeList.get(seatGradeIndex)[seatNumber].setSeatSubscriber(seatSubscriber, seatGradeIndex, seatGrade, seatNumber);
                subscriberInformationList.add(seatGradeList.get(seatGradeIndex)[seatNumber].getSeatSubscriber());
                break;
            } else {
                System.out.println("예약된 자리입니다. 다른 자리를 선택해 주십시오");
                continue;
            }
        }
        
    }
    
    
    
    
    
    public static void inquiry(Scanner scanner, ArrayList<Seat[]> seatGradeList) {
        for(int i = 0; i < seatGradeList.size(); i++){
            showSeatList(i, seatGradeList);
        }
        System.out.println("<<조회를 완료했습니다.>>");
    }
    
    
   
    
    public static void printSubscriberInformationList(Scanner scanner, ArrayList<Seat[]> seatGradeList, ArrayList<User> subscriberInformationList) {
        
        while(subscriberInformationList.size() > 0) {

            System.out.println("===============예약자 명단===============");
            for(int i = 0; i < subscriberInformationList.size(); i++) {
                subscriberInformationList.get(i).showUserInfo();
                System.out.println("등록번호 : " + i);
                System.out.println("======================");
                System.out.println();
            }

            System.out.print("예약 취소를 원하십니까? YES(1) / NO(2) >>");


            int yn = scanner.nextInt();

            if(yn == 1) {
                System.out.print("취소할 등록번호를 입력해주십시오 >>");
                int num = scanner.nextInt();
                System.out.println();
                int seatGradeIndex = subscriberInformationList.get(num).getReservedSeatsGradeIndex();
                int seatNumber = subscriberInformationList.get(num).getReservedSeatsNumber();
                subscriberInformationList.remove(num);

                cancellation(seatGradeIndex, seatNumber, seatGradeList);
                System.out.println("<<예약이 취소되었습니다>>");
                System.out.println();
                continue;

            } else if( yn == 2) {
                break;
            } else {
                System.out.println("입력이 잘못되었습니다.");
            }
            System.out.println("예약된 좌석이 없습니다.");
        } 
        
        
        
    }
    
    
    public static void reservationCancellation(Scanner scanner, ArrayList<Seat[]> seatGradeList, ArrayList<User> subscriberInformationList) {
        int seatGradeIndex;
        String seatSubscriber;
        System.out.println("===========예약 취소===========");
        System.out.print("좌석구분 :");
        for(int i = 0; i < seatGradeList.size(); i++){
            System.out.print(seatGradeList.get(i)[0].getSeatGrade() + "(" + (i+1) + ")  ");
        }
        System.out.print(">>");



        seatGradeIndex = scanner.nextInt() - 1;
        showSeatList(seatGradeIndex, seatGradeList);
        scanner.nextLine();


        System.out.print("이름>> ");
        seatSubscriber = scanner.nextLine();
        
        for(int i = 0; i < seatGradeList.get(seatGradeIndex).length; i++){
            if(seatGradeList.get(seatGradeIndex)[i].getIsReservation() == true || seatGradeList.get(seatGradeIndex)[i].getSeatSubscriber().getUserName() == seatSubscriber){
                subscriberInformationList.remove(seatGradeList.get(seatGradeIndex)[i].getSeatSubscriber());
                cancellation(seatGradeIndex, i, seatGradeList);  
            } 
        }
        
    }
    
    
    
    public static void cancellation(int seatGradeIndex, int seatNumber, ArrayList<Seat[]> seatGradeList) {
        System.out.println(seatGradeList.get(seatGradeIndex)[seatNumber].getIsReservation());
        System.out.println(seatGradeList.get(seatGradeIndex)[seatNumber].getSeatSubscriber());
    }
    
    
    
    
    
    public static void showSeatList(int seatGradeIndex, ArrayList<Seat[]> seatGradeList) {
        System.out.print(seatGradeList.get(seatGradeIndex)[0].getSeatGrade()+">> ");
        for(int i = 0; i < seatGradeList.get(seatGradeIndex).length; i++){
            if(seatGradeList.get(seatGradeIndex)[i].getSeatSubscriber() == null){
                System.out.print(" -(" + (i+1) + ")- ");
            } else {
                System.out.print(seatGradeList.get(seatGradeIndex)[i].getSeatSubscriber().getUserName() + " ");
            }
        }
        System.out.println();
    }
      
}
