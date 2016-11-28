/**
 * Created by r0bert on 11/28/2016.
 */
import java.util.Date;

public class SkiPass {
    /**
     * initialization of new variables
     */
    private Date activated;
    private Date expired;
    private int card_id;
    private String type_of_card;
    private boolean blocked_card;


    public SkiPass(int card_id, String type){
        /**
         * the values are asigned to the variables
         */
        this.card_id = card_id;
        this.type_of_card = type;
    }

    public int getId() {
        /**
         * returns  the id of users card
         */
        return card_id;
    }

    public String getType() {
        /**
         * returns the type of users card
         */
        return type_of_card;
    }

    public Date getActivationDate() {
        /**
         * returns the activation date
         */
        return activated;
    }

    public Date getExpirationDate() {
        /**
         * returns the expiration date
         */
        return expired;
    }

    public boolean Blocked() {
        /**
         * returns the blocke dcard
         */
        return blocked_card;
    }

    public void blockedCard() {
        /**
         * the value is assigned to the variable
         */
        blocked_card = false;
    }
}