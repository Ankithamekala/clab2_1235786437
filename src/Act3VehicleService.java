public class Act3VehicleService {
    private static IEmissionsStrategy emissionsStrategy;
    private IVehicleInspector inspector;
    private static Act3VehicleService instance; // Singleton instance

    static {
        // Logic to read system property for the emissions strategy
        String emissionsStrategyType = System.getProperty("es", "null");
        switch (emissionsStrategyType) {
            case "one":
                emissionsStrategy = new OneEmissionsStrategy();
                break;
            case "two":
                emissionsStrategy = new TwoEmissionsStrategy();
                break;
            default:
                emissionsStrategy = new NullEmissionsStrategy();
                break;
        }
    }

    private Act3VehicleService() {
        // Logic to read the "vi" property to choose the correct inspector
        String vehicleInspectionType = System.getProperty("vi", "default");
        if ("alt".equalsIgnoreCase(vehicleInspectionType)) {
            inspector = new AltVehicleInspection();  // Use the AltVehicleInspection if "alt"
        } else {
            inspector = new VehicleInspection();  // Default one is VehicleInspection
        }
    }

    // Singleton getInstance method
    public static Act3VehicleService getInstance() {
        if (instance == null) {
            synchronized (Act3VehicleService.class) {
                if (instance == null) {
                    instance = new Act3VehicleService();
                }
            }
        }
        return instance;
    }

    public int calculateTotal(IVehicle[] vehicles) {
        int total = 0;
        for (IVehicle vehicle : vehicles) {
            total += emissionsStrategy.computeEmissionsFee(vehicle) + vehicle.accept(inspector);
        }
        return total;
    }
}
