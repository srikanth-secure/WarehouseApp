package in.srikanth.service;

import java.util.List;

import in.srikanth.model.ShipmentType;

public interface IShipmentTypeService {
	public Integer saveShipmentType(ShipmentType shipmenttype);

	public void updateShipmentType(ShipmentType shipmenttype);

	public void deleteShipmentType(Integer id);

	public ShipmentType getOneShipmentType(Integer id);

	public List<ShipmentType> getAllShipmentTypes();
}
