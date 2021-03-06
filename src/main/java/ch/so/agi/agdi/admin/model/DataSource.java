package ch.so.agi.agdi.admin.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "data_source")
@Table(schema = "gdi_knoten")
public class DataSource implements Serializable {
	private static final long serialVersionUID = 1L;

	public enum ConnectionType {
        DATABASE, DIRECTORY, WMS;
    }
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gdi_oid")
	private Long gdiOid;

	@NotEmpty(message = "Mandatory field.")
	@Column(name = "name", unique=true, length = 500)
	private String name;

	@Column(name = "description", length = 10000)
	private String description;

	@NotEmpty(message = "Mandatory field.")
	@Column(name = "connection", length = 500)
	private String connection;
	
	@Column(name = "auser", length = 500)
	private String user;
	
	@Column(name = "password", length = 500)
	private String password;

	// @NotEmpty does not work with enum types.
	@NotNull(message = "Mandatory field.")
	@Column(name = "connection_type")
    @Enumerated(EnumType.STRING)
	private ConnectionType connectionType;

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

	public String getConnection() {
		return connection;
	}

	public void setConnection(String connection) {
		this.connection = connection;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ConnectionType getConnectionType() {
		return connectionType;
	}

	public void setConnectionType(ConnectionType connection_type) {
		this.connectionType = connection_type;
	}
	
	@OneToMany(mappedBy = "dataSource")
	private List<DataSet> dataSets = new ArrayList<DataSet>();

	public List<DataSet> getDataSets() {
		return dataSets;
	}
}
