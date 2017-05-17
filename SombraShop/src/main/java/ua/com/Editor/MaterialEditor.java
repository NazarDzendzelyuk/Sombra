package ua.com.Editor;

import java.beans.PropertyEditorSupport;

import ua.com.Entities.Material;
import ua.com.Service.MaterialService;

public class MaterialEditor extends PropertyEditorSupport {

	private MaterialService materialService;

	public MaterialEditor(MaterialService materialService) {
		super();
		this.materialService = materialService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Material material=materialService.findOne(Integer.valueOf(text));
		setValue(material);
	}
	
	
}
