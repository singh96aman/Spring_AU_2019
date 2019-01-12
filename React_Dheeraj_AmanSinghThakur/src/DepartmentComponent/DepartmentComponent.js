import React, { Component } from 'react';
import './DepartmentComponent.css'


class DepartmentComponent extends Component{
    state ={
        shown : false,
    }
    constructor(){
        super();
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
        e.preventDefault();
        var arr =[];
        arr.push(document.getElementById('dept').value);
        arr.push(document.getElementById('desc').value);
        this.props.funAdd2(arr); 
    }
    render(){
        return (
            <div>
                 <h1>Department</h1>
                 <button onClick={ this.onClickAdd }>Add Department</button>
            { this.state.shown && (
            <div>
            <form>
              Department<input type="text" id="dept" /><br></br> 
              Description<input type="text" id="desc" /><br></br> 
              <button onClick={this.addData}>Add</button>
              <button onClick={this.onClickCancel}> Cancel</button>
            </form>
            </div>
            )}
            </div>
        );
    }

}

export default DepartmentComponent;