package dei.gps.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * <b>Plug</b> table representation object.
 * 
 * @author bernardino
 *
 */
@Table(name="Plugs")
public class Plug extends Model {
	@Column(name="name")
	private String name;
	@Column(name="deviceTypeId")
	private int deviceTypeId;
	@Column(name="isaId")
	private int isaId;
	@Column(name="tagId")
	private String tagId;
	@Column(name="isaIndex")
	private int isaIndex;
	@Column(name="interval")
	private int interval;
	@Column(name="state")
	private int state;
	@Column(name="unitId")
	private int unitId;
	@Column(name="localId")
	private int localId;
	@Column(name="tariffId")
	private int tariffId;
	@Column(name="fixedCostId")
	private int fixedCostId;
	
	public Plug() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDeviceTypeId() {
		return deviceTypeId;
	}

	public void setDeviceTypeId(int deviceTypeId) {
		this.deviceTypeId = deviceTypeId;
	}

	public int getIsaId() {
		return isaId;
	}

	public void setIsaId(int id) {
		this.isaId = id;
	}
	
	public String getTagId() {
		return tagId;
	}

	public void setTagId(String tagId) {
		this.tagId = tagId;
	}

	public int getIsaIndex() {
		return isaIndex;
	}

	public void setIsaIndex(int index) {
		this.isaIndex = index;
	}

	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getUnitId() {
		return unitId;
	}

	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}

	public int getLocalId() {
		return localId;
	}

	public void setLocalId(int localId) {
		this.localId = localId;
	}

	public int getTariffId() {
		return tariffId;
	}

	public void setTariffId(int tariffId) {
		this.tariffId = tariffId;
	}

	public int getFixedCostId() {
		return fixedCostId;
	}

	public void setFixedCostId(int fixedCostId) {
		this.fixedCostId = fixedCostId;
	}

}
