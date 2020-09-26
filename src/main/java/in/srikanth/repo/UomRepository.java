package in.srikanth.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.srikanth.model.Uom;

public interface UomRepository extends JpaRepository<Uom, Serializable> {

	@Query("SELECT COUNT(uomModel) FROM Uom WHERE uomModel=:uomModel")
	Integer getUomModelCount(String uomModel);

	@Query("SELECT uomType, COUNT(uomType) FROM Uom GROUP BY uomType")
	List<Object[]> getUomTypeAndCount();
}