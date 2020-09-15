package in.srikanth.service;

import java.util.List;

import in.srikanth.model.ShipmentType;

public interface IOrderMethodService {
	public Integer saveOrderMethod(ShipmentType shipmenttype);

	public void updateOrderMethod(ShipmentType shipmenttype);

	public void deleteOrderMethod(Integer id);

	public ShipmentType getOneOrderMethod(Integer id);

	public List<ShipmentType> getAllOrderMethods();
}
