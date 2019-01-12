import React, {Component} from 'react';

const ChildComponent = (props) => {
    //return React.createElement("div", null, 
    //React.createElement("img", { src : "abcdefghijk" },null));

    let localFn = () => {
        props.onUpdate("INSIDE CHILD LOCAL FN");
    }

    return ( 
        <div>
            <button onClick={localFn}>
                Send Data Back
            </button>
        </div>
    )

      return React.createElement("div",null, props.name);
  }


export default ChildComponent;