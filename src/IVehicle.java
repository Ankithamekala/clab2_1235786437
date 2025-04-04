public interface IVehicle {

    int accept(IVehicleInspector vehicleInspector);

    float co2Emissions();
}
