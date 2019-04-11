import React, {Component} from 'react';
import { BrowserRouter as Router, Route, Link} from "react-router-dom";
import NavBar from '../NavBar/NavBar';


class Ratings extends Component{
    render(){
        const active = "rating";
        return(
            <div class="mainHomeDiv">
                <div class="topnav">
                    <NavBar data={active}/>
                </div>
                <div class="watchListBody">
                    This is the Ratings Page
                </div>
            </div>
        );
    }
}
export default Ratings;