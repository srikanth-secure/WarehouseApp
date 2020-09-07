package in.srikanth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.srikanth.model.ShipmentType;
import in.srikanth.repo.ShipmentTypeRepository;
import in.srikanth.service.IShipmentTypeService;

@Service
public class ShipmentTypeServiceImpl implements IShipmentTypeService {
	@Autowired
	private ShipmentTypeRepository repo;

	@Override
	public Integer createShipmentType(ShipmentType shipmenttype) {
		shipmenttype = repo.save(shipmenttype);
		return shipmenttype.getId();
	}

	@Override
	public List<ShipmentType> getAllShipmentTypes() {
		return repo.findAll();
	}

}