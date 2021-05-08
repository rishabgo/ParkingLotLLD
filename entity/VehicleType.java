package SystemDesign.ParkingLot.entity;

public enum VehicleType {

    TWO_WHEELER{
        @Override
        public double getPriceForParking(long duration) {
            return duration * 0.05;
        }
    },FOUR_WHEELER {
        @Override
        public double getPriceForParking(long duration) {
            return duration * 0.08;
        }
    };

    public abstract double getPriceForParking(long duration);


}
