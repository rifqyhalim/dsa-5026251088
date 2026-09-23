package lw01.unguided;

public class CarWash extends WashService {
    private static final int BASE_DAYS = 3;
    private static final int BASE_RATE_PER_DAY = 35000;
    private static final int EXTRA_RATE_PER_DAY = 25000;
    private static final int SETUP_FEE = 15000;

    public CarWash(String id, int days) {
        super(id, days);
    }

    @Override
    public int calculateCharge() {
        int days = getDays();
        int baseDays = Math.min(days, BASE_DAYS);
        int extraDays = Math.max(days - BASE_DAYS, 0);
        return baseDays * BASE_RATE_PER_DAY + extraDays * EXTRA_RATE_PER_DAY + SETUP_FEE;
    }

    @Override
    public String label() {
        return "Car";
    }
}