package lk.ijse.pos.memory;

import lk.ijse.pos.model.ParkingSlot;

import java.util.ArrayList;

public class ParkingSlotArray {
    private static ParkingSlotArray arrays;
    private ArrayList<ParkingSlot> arraySlots;

    private ParkingSlotArray() {
        arraySlots=new ArrayList<>();
    }

    public static ParkingSlotArray getInstance() {
        if (arrays==null){
            arrays=new ParkingSlotArray();
        }
        return arrays;
    }


    public ArrayList<ParkingSlot> getArraySlots() {
        return arraySlots;
    }


    public boolean setArraySlots(ParkingSlot parkingSlot) {
        arraySlots.add(parkingSlot);
        return true;
    }

    public void removeArraySlots(ParkingSlot parkingSlot) {
        arraySlots.remove(parkingSlot);
    }

}
