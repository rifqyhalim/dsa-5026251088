package lw01.unguided;

public class MotorcycleWash extends WashService {
    private static final int RATE_PER_DAY = 15000;
    private static final int SETUP_FEE = 5000;

    public MotorcycleWash(String id, int days) {
        super(id, days);
    }

    @Override
    public int calculateCharge() {
        return getDays() * RATE_PER_DAY + SETUP_FEE;
    }

    @Override
    public String label() {
        return "Motorcycle";
    }
}