package base.module.beans;

public class Feature {

	private Boolean enabled;
	private String name;
	private String detail;
	
	public Feature() {}
	
	public Feature(Boolean enabled, String name, String detail) {
		super();
		this.enabled = enabled;
		this.name = name;
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "{enabled: " + enabled + ", name: " + name + ", detail: " + detail + "}";
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
}
