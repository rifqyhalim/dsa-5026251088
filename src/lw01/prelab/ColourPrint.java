package lw01.prelab;

public class ColourPrint extends PrintJob {
    
    public ColourPrint(String id, int pages) {
        super(id, pages);
    }

    @Override
    public int calculateCharge() {
        int charge = 2000; 
        int p = getPages();
        
        if (p > 10) {
            charge += (10 * 1500) + ((p - 10) * 1000);
        } else {
            charge += p * 1500;
        }
        
        return charge;
    }

    @Override
    public String label() {
        return "Colour";
    }
}