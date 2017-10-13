package za.co.dvt.jhb.bddspock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockKeeper {
    private Map<Color, List<Garment>> garments = new HashMap<>();

    public void addToGarments(Garment garment) {
        if (!garments.containsKey(garment.getColor())) {
            garments.put(garment.getColor(), new ArrayList<>());
        }
        garments.get(garment.getColor()).add(garment);
    }

    public Garment removeGarmentFromStock(Color color) {
        List<Garment> colorGarments = garments.get(color);
        if (colorGarments.size() == 0) {
            return null;
        }
        return colorGarments.remove(0);
    }

    public void returnGarment(Garment garment) {
        addToGarments(garment);
    }

    public Garment exchangeGarment(Garment garmentToBeExchanged, Color color) {
        Garment garmentToReturn = removeGarmentFromStock(color);
        if (garmentToReturn != null) {
            addToGarments(garmentToBeExchanged);
        }
        return garmentToReturn;
    }

    public Map<Color, List<Garment>> getGarments() {
        return garments;
    }
}
