public class AltVehicleService {
    private IVehicleInspector inspector;

    public AltVehicleService(String viType) {
        this.inspector = VehicleFactory.getVehicleInspector(viType);
    }

    public int calculateTotal(IVehicle[] vehicles) {
        int total = 0;
        for (IVehicle vehicle : vehicles) {
            total += vehicle.accept(inspector);
        }
        return total;
    }
}
