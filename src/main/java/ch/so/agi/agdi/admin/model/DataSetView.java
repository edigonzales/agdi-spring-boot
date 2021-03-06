package ch.so.agi.agdi.admin.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "data_set_view")
@Table(schema = "gdi_knoten")
public class DataSetView implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gdi_oid")
	private Long gdiOid;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
		
	@Column(name = "geometry_column")
	private String geometryColumn;

	public Long getGdiOid() {
		return gdiOid;
	}

	public void setGdiOid(Long gdiOid) {
		this.gdiOid = gdiOid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGeometryColumn() {
		return geometryColumn;
	}

	public void setGeometryColumn(String geometryColumn) {
		this.geometryColumn = geometryColumn;
	}
	
	@ManyToOne
	@JoinColumn(name = "gdi_oid_data_set")
	private DataSet dataSet;

	public DataSet getDataSet() {
		return this.dataSet;
	}
	
	@OneToMany(mappedBy = "dataSetView")
	private List<DataSetViewAttribute> dataSetViewAttributes = new ArrayList<DataSetViewAttribute>();

	public List<DataSetViewAttribute> getDataSetViewAttributes() {
		return dataSetViewAttributes;
	}
}
