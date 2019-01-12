import React, { Component } from 'react';
import './SearchComponent.css'

class SearchComponent extends Component{
    state ={
        shown : false,
    }
    constructor(props){
        super(props);
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
    onSearch = (e,props) =>{
        var index = document.getElementById('dept').value;
        var emp = this.props.emp;
        var dept = this.props.dept;
        var res="<table>";
        for(var i=0; i<emp.length; i++){
            if(index==emp[i].department)
                res+="<tr><td>"+emp[i].name+"</td><td>"+emp[i].lname+"</td><td>"+emp[i].age+"</td><td>"+emp[i].designation+"</td><td>"+emp[i].location+"</td><td>"+emp[i].department+"</td></tr>";
        }
        res+="</table>"
        document.getElementById('tableDept').innerHTML=res;
        console.log(res);
        console.log(emp, dept);
    }
    render(props){
        return (
            <div>
                 <h1></h1>
                 Which Department ?<br></br>
                 <button onClick={ this.onSearch }>Search By Dept</button>
                 <br/>
                 <select id="dept">
                    {this.props.dept && this.props.dept.map((dept,i) => {
                    return(
                        <option>{dept.name}</option>
                    );
                })
                }
              </select> 
                <div id="tableDept">
                </div>
            </div>
        );
    }
}

export default SearchComponent;