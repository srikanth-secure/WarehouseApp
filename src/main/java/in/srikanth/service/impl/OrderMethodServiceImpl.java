package in.srikanth.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import in.srikanth.model.ShipmentType;
import in.srikanth.service.IOrderMethodService;

@Service
public class OrderMethodServiceImpl implements IOrderMethodService {

	@Override
	public Integer saveOrderMethod(ShipmentType shipmenttype) {
		return null;
	}

	@Override
	public void updateOrderMethod(ShipmentType shipmenttype) {
	}

	@Override
	public void deleteOrderMethod(Integer id) {
	}

	@Override
	public ShipmentType getOneOrderMethod(Integer id) {
		return null;
	}

	@Override
	public List<ShipmentType> getAllOrderMethods() {
		return null;
	}

}