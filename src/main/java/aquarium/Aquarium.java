package aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    public final static double CAPACITY = 20;
    private final static double LIVING_REQUIREMENT_FOR_A_FISH = 5;

    private List<Fish> fishList = new ArrayList<>();

    public void addFish(Fish fish) {

        if (fishList.size() >= CAPACITY / LIVING_REQUIREMENT_FOR_A_FISH)
            throw new IllegalStateException("Can not add fish because there is no more space.");
        else fishList.add(fish);
    }

    public void feed() {
        for (Fish fishy : fishList
        ) {
            fishy.feed();
        }
    }

    public void removeFish(int maxWeight) {
        List<Fish> toRemove = new ArrayList<>();
        for (Fish fishy : fishList
        ) {
            if (fishy.getWeight() > maxWeight) {
                toRemove.add(fishy);
            }
        }
        fishList.removeAll(toRemove);
    }

    public List<String> getStatus() {
        List<String> status = new ArrayList<>();
        for (Fish fishy : fishList
        ) {
            status.add(fishy.getStatus());
        }
        return status;
    }

    public int getNumberOfFishWithMemoryLoss() {
        int dummyFishes = 0;

        for (Fish fishy : fishList
        ) {
            if (fishy.hasMemoryLoss() == true) {
                dummyFishes++;
            }
        }
        return dummyFishes;
    }

    public boolean isThereFishWithGivenColor(String color) {
        for (Fish fishy : fishList
        ) {
            if (fishy.getColor().equals(color)) {
                return true;
            }
        }
        return false;
    }

    public Fish getSmallestFish() {
        //nincs teszt az üres hal listára
        Fish smallFish = null;
        int snallestFishsWeight = Integer.MAX_VALUE;
        for (Fish fishy : fishList
        ) {
            if (smallFish == null || fishy.getWeight() < snallestFishsWeight) {
                smallFish = fishy;
                snallestFishsWeight = smallFish.getWeight();
            }
        }
        return smallFish;
    }
}
