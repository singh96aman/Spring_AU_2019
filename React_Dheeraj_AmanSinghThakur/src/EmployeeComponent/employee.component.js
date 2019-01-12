import React, { Component } from 'react';
import './employee.css';

import AddEmployeeComponent from '../AddEmployee/AddEmployee.component';
import DisplayEmployeeComponent from '../DisplayComponent/Display.component';
import Add from '../Unit/AddUnitComponent';
import DepartmentComponent from '../DepartmentComponent/DepartmentComponent';
import SearchComponent from '../SearchByDept/SearchComponent.js';

class EmployeeComponent extends Component{
    state = {
        employees : [{
            name : 'Raviteja',
            lname : 'V',
            age: 21,
            designation : 'Intern',
            location : 'Banglore,karnataka,India',
            department : 'IT' 
        },{
            name: "Devraj",
            lname: "M",
            age: 21,
            designation: "intern",
            location: "Bangalore,Karnataka,India, Asia, World, Earth",
            department : 'HR'
        },{
            name: "kumar",
            lname: "santanu",
            age: 26,
            designation: "intern",
            location: "Patna, Bihar,India, Asia, World, Earth",
            department : 'IT'
        }],
        department : [{
            name : 'IT',
            desc : 'good'
        },{
            name : 'HR',
            desc : 'very good'
        }]
    }
    
    constructor(){
        super();
    }
    addDataToEmployee = (newdata) =>{
    
        var x = {
         name : newdata[0],
         lname: newdata[1],
         age:  newdata[2],
         designation: newdata[3],
         location: newdata[4],
         department : newdata[5]
        };
        this.state.employees.push(x);
        this.setState({employees : this.state.employees});
        console.log(this.state.department);
    }

    addDataToDepartment = (newdata) =>{
        console.log(newdata);
        var y = {
            name : newdata[0],
            desc : newdata[1]
           };
           this.state.department.push(y);
           this.setState({department : this.state.department});
           console.log(this.state.department);
    }

    render(){
        return (
            <div>
                <React.Fragment>
                    <AddEmployeeComponent funAdd={ this.addDataToEmployee}  dept= {this.state.department}/>
                    <DisplayEmployeeComponent employees={this.state.employees} />
                    <DepartmentComponent funAdd2={this.addDataToDepartment} />
                    <SearchComponent emp = {this.state.employees} dept = {this.state.department}/>
                </React.Fragment>
            </div>
        );
    }
}

export default EmployeeComponent;