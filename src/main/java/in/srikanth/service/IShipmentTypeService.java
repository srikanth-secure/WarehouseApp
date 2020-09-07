package in.srikanth.service;

import java.util.List;

import in.srikanth.model.ShipmentType;

public interface IShipmentTypeService {
	public Integer createShipmentType(ShipmentType shipmenttype);
	public List<ShipmentType> getAllShipmentTypes();
}
