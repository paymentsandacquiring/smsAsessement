import React, {Component} from 'react';
import { BrowserRouter as Router, Route, Link} from "react-router-dom";
import NavBar from '../NavBar/NavBar';


class WatchList extends Component{
    render(){
        const active = "list";
        return(
            <div class="mainHomeDiv">
                <div class="topnav">
                    <NavBar data={active}/>
                </div>
                <div class="watchListBody">
                    This is the watchList
                </div>
            </div>
        );
    }
}
export default WatchList;