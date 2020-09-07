package in.srikanth.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.srikanth.model.ShipmentType;

public interface ShipmentTypeRepository extends JpaRepository<ShipmentType, Integer> {

}
