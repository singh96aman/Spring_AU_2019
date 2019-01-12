import React, { Component } from 'react';
import './AddEmployee.css';


class AddEmployeeComponent extends Component{

    state ={
        shown : false,
        checkNumber : false,
        checkName : false
    }
    constructor(props){
        super(props);
        //document.getElementById('addemp').disabled = false;
    }
    onClickAdd = () =>{
        this.setState({
            shown : true
        });
    }
    onClickCancel = () => {
        this.setState({
            shown : false
        });
    }
    addData = (e,props) =>{
        console.log("Added");
        /*var check=true;
        var name = document.getElementById('name').value;
        var age = document.getElementById('age').value;
        console.log(name, name.length);
        if(name.length>20){
            check=false;
            document.getElementById('nameerror').innerHTML = "Name should be less than 20";
        }
        if(parseInt(age)<18){
            check=false;
            document.getElementById('ageerror').innerHTML = "Age should be less than 18";
        }*/
        e.preventDefault();
        var arr =[];
        arr.push(document.getElementById('name').value);
        arr.push(document.getElementById('lname').value);
        arr.push(document.getElementById('age').value);
        arr.push(document.getElementById('des').value);
        arr.push(document.getElementById('location').value);
        arr.push(document.getElementById('dept').value);
        this.props.funAdd(arr);
    }
    validateName = (event) =>{
        event.preventDefault();
        var name = document.getElementById('name').value;
        if(name.length>20){
            this.checkName=false;
            this.setState({checkName : this.checkName});
            document.getElementById('nameerror').innerHTML = "Name should be less than 20";
        }else{
            this.checkName = true;
            this.setState({checkName : this.checkName});
            document.getElementById('nameerror').innerHTML = "";
        }
    }

    validateNumber = (event) =>{
        event.preventDefault();
        var age = document.getElementById('age').value;
        if(parseInt(age)<18){
            this.checkNumber = false;
            this.setState({checkNumber : this.checkNumber});
            document.getElementById('ageerror').innerHTML = "Age should be less than 18";
        }else{
            this.checkNumber = true;
            this.setState({checkNumber : this.checkNumber});
            document.getElementById('ageerror').innerHTML = "";
        }
    }

    render(props){
        return (
            <div>
                <h1>ADD EMPLOYEE</h1>
                 <button onClick={ this.onClickAdd }>Add Employee</button>
            { this.state.shown && (
            <div>
                <form>
              Name <input type="text" id="name" onChange={this.validateName}/> <p id="nameerror"></p> <br></br>
              Last Name<input type="text" id="lname" /><br></br>
              Age <input type="number" id="age" onChange={this.validateNumber}/> <p id="ageerror"></p> <br></br>
              Designation <input type="text" id="des" /><br></br>
              Location <input type="text" id="location" /><br></br>
              <select id="dept">
                {this.props.dept && this.props.dept.map((dept,i) => {
                    return(
                        <option>{dept.name}</option>
                    );
                })
                }
              </select> 
              <button onClick={this.addData} disabled={!(this.checkName && this.checkNumber)}>Add</button>
              <button onClick={this.onClickCancel}> Cancel</button>
              </form>
            </div>
            )}
            </div>
        );
    }

}

export default AddEmployeeComponent;