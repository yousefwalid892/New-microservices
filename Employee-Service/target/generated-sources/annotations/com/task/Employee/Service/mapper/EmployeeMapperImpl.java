package com.task.Employee.Service.mapper;

import com.task.Employee.Service.model.dto.EmployeeDto;
import com.task.Employee.Service.model.entity.Employee;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-15T21:57:02+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public EmployeeDto toDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setId( employee.getId() );
        employeeDto.setName( employee.getName() );
        employeeDto.setEmail( employee.getEmail() );
        employeeDto.setAge( employee.getAge() );
        employeeDto.setWorkflow_id( employee.getWorkflow_id() );
        employeeDto.setRole( employee.getRole() );

        return employeeDto;
    }

    @Override
    public Employee toEntity(EmployeeDto employeeDto) {
        if ( employeeDto == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setId( employeeDto.getId() );
        employee.setName( employeeDto.getName() );
        employee.setEmail( employeeDto.getEmail() );
        employee.setAge( employeeDto.getAge() );
        employee.setWorkflow_id( employeeDto.getWorkflow_id() );
        employee.setRole( employeeDto.getRole() );

        return employee;
    }
}
