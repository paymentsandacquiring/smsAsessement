import React, {Component} from 'react';
import { BrowserRouter as Router, Route, Link} from "react-router-dom";
import NavBar from '../NavBar/NavBar';


class Collection extends Component{
    render(){
        const active = "collection";
        return(
            <div class="mainHomeDiv">
                <div class="topnav">
                    <NavBar data={active} />
                </div>
                <div class="watchListBody">
                    This is the Collection Page
                </div>
            </div>
        );
    }
}
export default Collection;