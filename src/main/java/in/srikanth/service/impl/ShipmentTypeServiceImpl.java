package in.srikanth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.srikanth.exception.ShipmentTypeNotFoundException;
import in.srikanth.model.ShipmentType;
import in.srikanth.repo.ShipmentTypeRepository;
import in.srikanth.service.IShipmentTypeService;

@Service
public class ShipmentTypeServiceImpl implements IShipmentTypeService {
	@Autowired
	private ShipmentTypeRepository repo;

	@Override
	public Integer saveShipmentType(ShipmentType shipmenttype) {
		shipmenttype = repo.save(shipmenttype);
		return shipmenttype.getId();
	}

	@Override
	public List<ShipmentType> getAllShipmentTypes() {
		return repo.findAll();
	}

	@Override
	public void updateShipmentType(ShipmentType shipmenttype) {
		repo.save(shipmenttype);
	}

	@Override
	public void deleteShipmentType(Integer id) {
		ShipmentType st = getOneShipmentType(id);
		repo.delete(st);
	}

	@Override
	public ShipmentType getOneShipmentType(Integer id) {
		ShipmentType st = repo.findById(id)
				.orElseThrow(() -> new ShipmentTypeNotFoundException("ShipmentType ' " + id + " ' Not Found"));

		return st;
	}

}