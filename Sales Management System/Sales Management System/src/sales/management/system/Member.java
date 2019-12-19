/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sales.management.system;

/**
 *
 * @author aliim
 */
public class Member extends Customer {

    public Member(int CardID, int points, String ID, String Name, String Address, String Mobile, String PaymentMethod) {
        super(ID, Name, Address, Mobile, PaymentMethod);
        try {
            this.CardID = CardID;
            this.points = points;
        } catch (Exception e) {
        }
    }

    public int getCardID() {
        try {
            return CardID;
        } catch (Exception e) {
            return 0;
        }
    }

    public void setCardID(int CardID) {
        try {
            this.CardID = CardID;
        } catch (Exception e) {
        }
    }

    public int getPoints() {
        try {
            return points;
        } catch (Exception e) {
            return 0;
        }
    }

    public void setPoints(int points) {
        try {
            this.points = points;
        } catch (Exception e) {
        }
    }
    
    public void updatePoints(boolean add){
        try {
            if (add) {
                points += 10;
            } else {
                points -= 10;
            }
        } catch (Exception e) {
        }
    }
    
    private int CardID;
    private int points;
}
