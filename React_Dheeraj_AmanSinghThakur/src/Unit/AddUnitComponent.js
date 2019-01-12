import React, { Component } from 'react';


class AddUnitComponent extends Component{
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
        arr.push(document.getElementById('name').value);
        arr.push(document.getElementById('lname').value);
        arr.push(document.getElementById('age').value);
        arr.push(document.getElementById('des').value);
        arr.push(document.getElementById('location').value);
        this.props.funAdd2(arr); 
    }
    render(){
        return (
            <div>
                Unit Component
                 <button onClick={ this.onClickAdd }>Add Unit</button>
            { this.state.shown && (
            <div>
            <form>
              Name <input type="text" id="name" /> <br></br>
              Last Name<input type="text" id="lname" /><br></br>
              Age <input type="number" id="age" /><br></br>
              Designation <input type="text" id="des" /><br></br>
              Location <input type="text" id="location" /><br></br> 
              <button onClick={this.addData}>Add</button>
              <button onClick={this.onClickCancel}> Cancel</button>
            </form>
            </div>
            )}
            </div>
        );
    }

}

export default AddUnitComponent;