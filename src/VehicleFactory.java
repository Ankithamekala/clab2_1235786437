public class VehicleFactory {
    // Private constructor to prevent instantiation
    private VehicleFactory() {}

    public static IVehicleInspector getVehicleInspector(String prop) {
        if ("alt".equalsIgnoreCase(prop)) {
            return new AltVehicleInspection();
        }
        return new VehicleInspection();
    }
}
