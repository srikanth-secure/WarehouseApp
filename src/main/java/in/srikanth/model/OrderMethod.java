package in.srikanth.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
@Table(name = "ordermethod_tab")
public class OrderMethod {

	@SequenceGenerator(sequenceName = "ORD_ID_SEQ", name = "ORD_ID_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "ORD_ID_SEQ", strategy = GenerationType.SEQUENCE)

	@Id
	@Column(name = "ord_id_col")
	private Integer id;

	@Column(length = 50, name = "ord_mode_col")
	private String orderMode;

	@Column(name = "ord_code_col")
	private String orderCode;

	@Column(name = "ord_type_col")
	private String orderType;

	@ElementCollection

	@CollectionTable(name = "ord_acpt_tab", joinColumns = @JoinColumn(name = "ord_id_col"))

	@Column(name = "ord_acpt_col")
	private List<String> orderAcpt;

	@Column(name = "ord_description_col")
	private String description;
}