package in.srikanth.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.srikanth.model.OrderMethod;

public interface OrderMethodRepository extends JpaRepository<OrderMethod, Integer> {

}