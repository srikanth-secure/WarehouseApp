package in.srikanth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "shipment_type_tab")
public class ShipmentType {

	@SequenceGenerator(sequenceName = "SHIPMENT_ID_SEQ", name = "S_ID_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "S_ID_SEQ", strategy = GenerationType.SEQUENCE)

	@Id
	@Column(name = "shp_id_col")
	private Integer id;
	@Column(name = "shp_mode_col")
	private String shipmentMode;
	@Column(name = "shp_code_col")
	private String shipmentCode;
	@Column(name = "shp_enable_ship_col")
	private String enableShipment;
	@Column(name = "shp_grade_col")
	private String shipmentGrade;
	@Column(name = "shp_description_col")
	private String description;
}