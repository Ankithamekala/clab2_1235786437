public class AltVehicleInspection implements IVehicleInspector {
    @Override
    public int visit(Car car) {
        int serviceCharge = (car.getColor().equals("Black")) ? 120 : 60;
        System.out.println("Alt Service Charge for Car: " + serviceCharge);
        return serviceCharge;
    }

    @Override
    public int visit(Van van) {
        int serviceCharge = (van.getNumberOfDoors() > 4) ? 550 : 120;
        System.out.println("Alt Service Charge for Van: " + serviceCharge);
        return serviceCharge;
    }

    @Override
    public int visit(Motorbike motorbike) {
        int serviceCharge = (motorbike.getEngineCapacity() >= 200) ? 250 : 70;
        System.out.println("Alt Service Charge for Motorbike: " + serviceCharge);
        return serviceCharge;
    }
}
