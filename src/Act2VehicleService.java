public class Act2VehicleService {

    private static Act2VehicleService instance;
    private IVehicleInspector inspector;

    // Singleton: Private constructor to prevent instantiation
    private Act2VehicleService() {
    }

    // added static initialization block to read the system property and inject the inspector
    static {
        String inspectorType = System.getProperty("vi");
        if ("alt".equals(inspectorType)) {
            instance = new Act2VehicleService(new AltVehicleInspection());
        } else {
            instance = new Act2VehicleService(new VehicleInspection());
        }
    }

    // Implemented private constructor for DI
    private Act2VehicleService(IVehicleInspector inspector) {
        this.inspector = inspector;
    }

    // Implemented teh static method to provide the single instance
    public static Act2VehicleService getInstance() {
        return instance;
    }

    public int calculateTotal(IVehicle[] vehicles) {
        int total = 0;
        for (IVehicle vehicle : vehicles) {
            total = total + vehicle.accept(inspector);
        }
        return total;
    }
}
