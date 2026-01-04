package hu.ruander.employeeManagementSystem.view;

import java.util.List;

import javax.swing.DefaultComboBoxModel;

import hu.ruander.employeeManagementSystem.model.dto.EmployeeCategoryDto;

public class EmployeeCategoryComboBoxModel extends DefaultComboBoxModel<EmployeeCategoryDto>{

	private static final long serialVersionUID = -4638643159224635442L;

	// az EmployeeCategoryDto-ban a toString()-et átalakítjuk, csak a name-el térjen vissza
	public EmployeeCategoryComboBoxModel(List<EmployeeCategoryDto> employeeCategories) {
		for (EmployeeCategoryDto employeeCategoryDto : employeeCategories) {
			this.addElement(employeeCategoryDto);
		}
	}
}
