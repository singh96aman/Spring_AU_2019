import React, { Component } from 'react';
import './Display.css';


class DisplayEmployeeComponent extends Component{
    constructor(){
        super();
    }
    
    render(props){
        return (
            <div>
                 <h1>List Employee</h1>
                <table>
                    { this.props.employees && this.props.employees.map((employee,i)=>{
                        return(
                            <tr key={employee.name}>
                                <td>{ employee.name }</td>
                                <td>{ employee.lname }</td>
                                <td>{ employee.age }</td>
                                <td>{ employee.designation }</td>
                                <td>{ employee.location }</td>
                                <td>{ employee.department }</td>
                            </tr>
                        );
                    })
                    }
                </table>
            </div>
        );
    }

}

export default DisplayEmployeeComponent;