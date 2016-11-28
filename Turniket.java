/**
 * Created by r0bert on 11/28/2016.
 */
import java.util.Date;

public class Turniket {

    private SkiPassTwo ski_pass_system;

    public void link(SkiPassTwo system) {
        this.ski_pass_system = system;
    }

    public boolean isExpiredCard(SkiPass SkPs) {
        Date currentDate = new Date(System.currentTimeMillis());

        return (currentDate.before(SkPs.getExpirationDate()));
    }

    public boolean isActivatedCard(SkiPass SkPs) {
        Date currentDate = new Date(System.currentTimeMillis());

        return (currentDate.before(SkPs.getActivationDate()));
    }

    public boolean pass (SkiPass SkPs) {
        if (SkPs.Blocked()) {
            return false;
        }

        if (isExpiredCard(SkPs)) {
            SkPs.blockedCard();
            return false;
        }

        if (!isActivatedCard(SkPs)) {
            return false;
        }

        if (!ski_pass_system.authentication(SkPs)) {
            SkPs.blockedCard();
            return false;
        }
        return false;
    }
}

