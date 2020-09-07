package in.srikanth.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.srikanth.model.Uom;

public interface UomRepository extends JpaRepository<Uom, Integer> {

}