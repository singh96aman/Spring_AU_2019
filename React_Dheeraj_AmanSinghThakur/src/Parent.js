import React, {Component} from 'react';
import ChildComponent from './Child';

// Cannot show Parent and Component in one file beacuse React.createElement inly returns one value
// Re renders when property changes or state changes


//onUpdate passed as parameter

class Parent extends Component{
    state = {
        name : "NAME FOR CHILD"
    };
    constructor(){
        super();
        this.handleClick = this.handleClick.bind(this);
    }

    onUpdate = (data) => {
        console.log(data);
    }

    handleClick(){
        setTimeout(() =>{
            this.setState({
                name : "NEWWW NAME!"
            });
        }, 2000);
    }

    render(){
        return (
            <div>
                <button onClick={this.handleClick}>Change Name</button>
                 <span>Hello</span>
                <ChildComponent name={this.state.name} onUpdate={this.onUpdate}/>
            </div>
        );
    }
}

export default Parent;