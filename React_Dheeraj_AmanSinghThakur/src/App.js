import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import Parent from './Parent';
import ChildComponent from './Child';

class App extends Component {
  /*render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <p>
            Edit <code>src/App.js</code> and save to reload.
          </p>
          <a
            className="App-link"
            href="https://reactjs.org"
            target="_blank"
            rel="noopener noreferrer"
          >
            Learn React
          </a>
        </header>
      </div>
    );
  }*/
}

class ComponentName extends Component{
    render(){
      // 3 PARAMS : Element Name, No of Properties, Child Element
        /*return React.createElement("div", null, 
        React.createElement("div", null, "Second Para"));*/
        //return React.createElement("div", null, this.props.name);
        return React.createElement("div", null, <Parent name="This is a prop"/>);
      }
}

const FunctionComponent = (props) => {
  //return React.createElement("div", null, 
  //React.createElement("img", { src : "abcdefghijk" },null));
    return React.createElement("div", null, 
    React.createElement("span", null ,props.name+" "+props.last));
}

export default ComponentName;
//export default ComponentName
