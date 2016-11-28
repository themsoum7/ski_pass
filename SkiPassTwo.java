/**
 * Created by r0bert on 11/28/2016.
 */
import java.util.Date;
import java.util.List;


public class SkiPassTwo {
    /**
     * initialization of variables
     */
    private static SkiPassTwo instance;
    private int counter;
    private final int turnikets_amount = 50;
    private List<Turniket> turnikets;

    private enum SkiPass_type {
        /**
         * enum class
         */
        SEASON, WORK_DAYS
    }

    private SkiPassTwo() {
    }

    public SkiPass createSki_Pass(String card_Type, Date activated, Date expired) {
        /**
         * creation of a new Ski-Pass
         */
        if (card_Type == null || activated == null || expired == null) {
            return null;
        }

        SkiPass_type skiPass_type = SkiPass_type.valueOf(card_Type);

        switch (skiPass_type) {
            case SEASON:
                return new SkiPass(counter++, card_Type);
            case WORK_DAYS:
                return new SkiPass(counter++, card_Type);
        }
        return null;
    }

    public boolean authentication(SkiPass SkPs) {
        /**
         * authentication of user
         */
        int id = SkPs.getId();

        if (id < 0 || id >= counter) {
            return false;
        }
        else {
            return true;
        }
    }

    public synchronized List<Turniket> init() {
        /**
         * synchronization
         */
        if (turnikets == null) {
            for (int i = 0; i < turnikets_amount; ++i) {
                Turniket turniket = new Turniket();
                turniket.link(this);
                turnikets.add(turniket);
            }
        }

        return turnikets;
    }

    public Turniket getTurniket(int id) {
        /**
         * returns the id
         */
        if (id < 0 || id >= turnikets.size()) {
            return null;
        }
        else {
            return turnikets.get(id);
        }
    }
}
