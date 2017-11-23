package pl.lbu.selenium.driver;

public enum DriverType {
	CHROME("chrome"), IE("ie"), FIREFOX("firefox");

	private String driverName;

	private DriverType(String driverName) {
		this.driverName = driverName;
	}

	public String getDriverName() {
		return driverName;
	}

	public static DriverType getDriverTypes(String driverName) {
		for (DriverType types : DriverType.values()) {
			if (types.getDriverName().equals(driverName)) {
				return types;
			}
		}
		return null;

	}

}